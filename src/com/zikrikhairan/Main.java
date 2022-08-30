package com.zikrikhairan;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("file.log")){
            int[] intArray = {1,2,3,4};
            printWriter.println(convertIntArrayToIntegerList(intArray));
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            integerList.add(2);
            integerList.add(3);
            integerList.add(4);
            printWriter.println(Arrays.toString(convertIntegerListToIntArray(integerList)));
            printWriter.println();

            String[] stringArray = {"A","B","C","D"};
            printWriter.println(convertStringArrayToStringList(stringArray));
            List<String> stringList = new ArrayList<>();
            stringList.add("A");
            stringList.add("B");
            stringList.add("C");
            stringList.add("D");
            printWriter.println(Arrays.toString(convertStringListToStringArray(stringList)));
            printWriter.println();

            printWriter.println(convertStringListToStringBooleanMap(stringList));
            Map<String, Boolean> alphabetMap = new HashMap<>();
            alphabetMap.put("A", Boolean.TRUE);
            alphabetMap.put("B", Boolean.TRUE);
            alphabetMap.put("C", Boolean.TRUE);
            alphabetMap.put("D", Boolean.TRUE);
            printWriter.println(convertStringBooleanMapToStringList(alphabetMap));
            printWriter.println();

            Car teslaCar = new Car(1, "Tesla", 200000);
            Car hyundaiCar = new Car(2, "Hyundai", 150000);
            List<Car> carList = new ArrayList<>();
            Collections.addAll(carList, teslaCar, hyundaiCar);
            Map<Integer, Car> carMap = convertCarListToIntegerCarMap(carList);
            printWriter.println(carMap);
            printWriter.println(convertIntegerCarMapToCarList(carMap));
            printWriter.println();
        }
    }

    private static List<Integer> convertIntArrayToIntegerList(int[] array){
        return Arrays.stream(array).boxed().toList();
    }

    private static int[] convertIntegerListToIntArray(List<Integer> integerList){
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static List<String> convertStringArrayToStringList(String[] stringArray){
        return Arrays.stream(stringArray).toList();
    }

    private static String[] convertStringListToStringArray(List<String> stringList){
        return stringList.toArray(String[]::new);
    }

    private static Map<String, Boolean> convertStringListToStringBooleanMap(List<String> stringList){
        return stringList.stream().collect(Collectors.toMap(Function.identity(), value -> Boolean.TRUE));
    }

    private static List<String> convertStringBooleanMapToStringList(Map<String, Boolean> map){
        return  new ArrayList<>(map.keySet());
    }

    private static Map<Integer, Car> convertCarListToIntegerCarMap(List<Car> carList){
        return carList.stream().collect(Collectors.toMap(Car::getId, car -> car));
    }

    private static List<Car> convertIntegerCarMapToCarList(Map<Integer, Car> carMap){
        return  new ArrayList<>(carMap.values());
    }
}

class Car {
    final int id;
    String brand;
    double price;

    public Car(int id,String brand, double price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public int getId() { return id;}
}
