package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@TargetApi(14)
public class TakeVideoUtils
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  private static int b;
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float a(Resources paramResources)
  {
    if ((b == 0) || (jdField_a_of_type_Int == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Float;
  }
  
  public static int a(Resources paramResources)
  {
    if (jdField_a_of_type_Int == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.TakeVideoUtils
 * JD-Core Version:    0.7.0.1
 */