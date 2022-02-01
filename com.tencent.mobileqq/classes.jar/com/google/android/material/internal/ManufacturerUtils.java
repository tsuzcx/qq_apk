package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ManufacturerUtils
{
  public static boolean a()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
  }
  
  public static boolean b()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
  }
  
  public static boolean c()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
  }
  
  public static boolean d()
  {
    return (b()) || (c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ManufacturerUtils
 * JD-Core Version:    0.7.0.1
 */