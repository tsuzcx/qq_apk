package com.tencent.map.geolocation.sapp;

public class TencentLocationManagerOptions
{
  public static String mKey = "";
  public static boolean sLoadLibrary = true;
  
  public static String getKey()
  {
    return mKey;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return sLoadLibrary;
  }
  
  public static boolean setKey(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      mKey = paramString;
      return true;
    }
    return false;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    sLoadLibrary = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationManagerOptions
 * JD-Core Version:    0.7.0.1
 */