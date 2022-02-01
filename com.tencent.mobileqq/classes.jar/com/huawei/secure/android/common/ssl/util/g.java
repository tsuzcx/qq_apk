package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class g
{
  private static final String TAG = "SecurityComp115301: ";
  
  public static void a(String paramString1, String paramString2)
  {
    Log.v(f(paramString1), paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(f(paramString1), paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2) {}
  
  public static void c(String paramString1, String paramString2)
  {
    Log.i(f(paramString1), paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Log.w(f(paramString1), paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(f(paramString1), paramString2);
  }
  
  private static String f(String paramString)
  {
    return "SecurityComp115301: " + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.g
 * JD-Core Version:    0.7.0.1
 */