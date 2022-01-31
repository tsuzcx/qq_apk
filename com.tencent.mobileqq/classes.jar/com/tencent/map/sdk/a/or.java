package com.tencent.map.sdk.a;

import android.util.Log;

public final class or
{
  public static boolean a;
  public static long b;
  public static int c;
  
  public static void a(String paramString)
  {
    if (a()) {
      c("TencentMapSDK", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a()) {
      Log.v(paramString1, paramString2);
    }
  }
  
  private static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a()) {
      a("TencentMapSDK", paramString, paramThrowable);
    }
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(String paramString)
  {
    if (a()) {
      d("TencentMapSDK", paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a()) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (a()) {
      Log.e("TencentMapSDK", paramString, paramThrowable);
    }
  }
  
  private static void c(String paramString1, String paramString2)
  {
    if (a()) {
      Log.i(paramString1, paramString2);
    }
  }
  
  private static void d(String paramString1, String paramString2)
  {
    if (a()) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.or
 * JD-Core Version:    0.7.0.1
 */