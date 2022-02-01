package com.tencent.mobileqq.ark.test;

public class LocationSimulator
{
  private static double jdField_a_of_type_Double = 0.0D;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = false;
  private static double b;
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static double[] a()
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return new double[] { jdField_a_of_type_Double, b };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.test.LocationSimulator
 * JD-Core Version:    0.7.0.1
 */