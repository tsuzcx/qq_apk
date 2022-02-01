package com.samsung.android.sdk.camera.util;

import android.os.Build;

public class SsdkVendorCheck
{
  private static String strBrand = Build.BRAND;
  private static String strManufacturer = Build.MANUFACTURER;
  
  public static boolean isSamsungDevice()
  {
    String str = strBrand;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (strManufacturer != null) {
        if (str.compareToIgnoreCase("Samsung") != 0)
        {
          bool1 = bool2;
          if (strManufacturer.compareToIgnoreCase("Samsung") != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.util.SsdkVendorCheck
 * JD-Core Version:    0.7.0.1
 */