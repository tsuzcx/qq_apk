package com.peterlmeng.animate_image.support.log;

import android.util.Log;

public class LogUtils
{
  public static ILog a;
  
  public static void a(ILog paramILog)
  {
    if (a != null) {
      a.b("LogUtils", "changing logger!");
    }
    a = paramILog;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.a(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.b(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.c(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.e(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.log.LogUtils
 * JD-Core Version:    0.7.0.1
 */