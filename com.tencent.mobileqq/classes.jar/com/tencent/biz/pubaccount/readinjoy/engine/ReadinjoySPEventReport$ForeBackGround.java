package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.HashMap;
import java.util.Map;
import lpl;
import lpm;
import lpn;
import lpo;
import lpp;

public class ReadinjoySPEventReport$ForeBackGround
{
  public static int a;
  public static long a;
  private static Map a;
  private static int b;
  public static long b;
  public static long c;
  public static long d;
  
  static
  {
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Int = 1;
    d();
  }
  
  public static void a()
  {
    jdField_b_of_type_Int = -1;
  }
  
  public static void a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    case 3: 
      jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    case 25: 
      c = System.currentTimeMillis();
      return;
    }
    d = System.currentTimeMillis();
  }
  
  private static boolean a()
  {
    if (jdField_b_of_type_Int > 0) {}
    switch (jdField_b_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = 1;
    if (a())
    {
      lpp locallpp = (lpp)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
      if (locallpp != null) {
        locallpp.a();
      }
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_Int = 2;
    if (a())
    {
      lpp locallpp = (lpp)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(jdField_b_of_type_Int));
      if (locallpp != null) {
        locallpp.b();
      }
    }
  }
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new lpl());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), new lpm());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(25), new lpn());
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), new lpo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround
 * JD-Core Version:    0.7.0.1
 */