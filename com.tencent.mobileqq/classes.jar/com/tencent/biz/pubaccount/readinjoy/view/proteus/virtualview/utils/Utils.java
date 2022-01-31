package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Color;

public class Utils
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int = 375;
  private static int b;
  
  public static int a(double paramDouble)
  {
    return (int)(b * paramDouble / jdField_a_of_type_Int + 0.5D);
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.valueOf(Color.parseColor(paramString)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static Double a(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Double.valueOf(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static Integer a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        int i = (int)Double.parseDouble((String)paramObject);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static Long a(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return (Long)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Long.valueOf(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        long l = Double.parseDouble((String)paramObject);
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static void a(float paramFloat, int paramInt)
  {
    jdField_a_of_type_Float = paramFloat;
    b = paramInt;
  }
  
  public static int b(double paramDouble)
  {
    if (jdField_a_of_type_Float < 0.0F) {}
    for (float f = 1.0F; paramDouble >= 0.0D; f = jdField_a_of_type_Float) {
      return (int)(f * paramDouble + 0.5D);
    }
    paramDouble = -paramDouble;
    return -(int)(f * paramDouble + 0.5D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils
 * JD-Core Version:    0.7.0.1
 */