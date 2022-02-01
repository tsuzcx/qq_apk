package com.tencent.mobileqq.ar;

import java.util.HashMap;

public class ReportUtil
{
  public static int a;
  public static String a;
  public static HashMap<String, GapDataCollector> a;
  private static boolean a;
  private static int jdField_b_of_type_Int;
  public static String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  public static String c;
  public static String d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Int = 5;
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    d = "";
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilHashMap.put("recogQ3", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("recogQ4", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("recogQ5", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ3", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ4", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("trackQ5", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("renderQ1", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("renderQ0", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("glRenderQ1", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("glRenderQ0", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("camRenderQ0", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("modelRenderQ1", new GapDataCollector(2147483647));
    jdField_a_of_type_JavaUtilHashMap.put("modelRenderQ0", new GapDataCollector(2147483647));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    jdField_a_of_type_JavaLangString = paramString1;
    jdField_b_of_type_JavaLangString = paramString2;
    jdField_c_of_type_JavaLangString = paramString3;
    d = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ReportUtil
 * JD-Core Version:    0.7.0.1
 */