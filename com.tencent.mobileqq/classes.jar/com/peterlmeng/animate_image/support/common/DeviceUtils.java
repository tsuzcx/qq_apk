package com.peterlmeng.animate_image.support.common;

public class DeviceUtils
{
  public static float sDensity = 1.0F;
  
  public static float getDensity()
  {
    return sDensity;
  }
  
  public static int pixelOf(int paramInt)
  {
    return (int)(sDensity * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */