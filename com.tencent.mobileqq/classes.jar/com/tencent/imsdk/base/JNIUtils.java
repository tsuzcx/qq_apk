package com.tencent.imsdk.base;

import com.tencent.imsdk.base.annotations.CalledByNative;
import com.tencent.imsdk.base.annotations.MainDex;

@MainDex
public class JNIUtils
{
  private static ClassLoader sJniClassLoader;
  private static Boolean sSelectiveJniRegistrationEnabled;
  
  public static void enableSelectiveJniRegistration()
  {
    sSelectiveJniRegistrationEnabled = Boolean.valueOf(true);
  }
  
  @CalledByNative
  public static Object getClassLoader()
  {
    ClassLoader localClassLoader2 = sJniClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = JNIUtils.class.getClassLoader();
    }
    return localClassLoader1;
  }
  
  @CalledByNative
  public static boolean isSelectiveJniRegistrationEnabled()
  {
    if (sSelectiveJniRegistrationEnabled == null) {
      sSelectiveJniRegistrationEnabled = Boolean.valueOf(false);
    }
    return sSelectiveJniRegistrationEnabled.booleanValue();
  }
  
  public static void setClassLoader(ClassLoader paramClassLoader)
  {
    sJniClassLoader = paramClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.base.JNIUtils
 * JD-Core Version:    0.7.0.1
 */