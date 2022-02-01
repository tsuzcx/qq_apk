package com.tencent.map.geolocation;

public class TencentLocationManagerOptions
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static boolean isGpsFilterEnabled()
  {
    return b;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return a;
  }
  
  public static void setGpsFilterEnabled(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManagerOptions
 * JD-Core Version:    0.7.0.1
 */