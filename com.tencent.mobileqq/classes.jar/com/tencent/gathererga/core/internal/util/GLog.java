package com.tencent.gathererga.core.internal.util;

import android.util.Log;
import com.tencent.gathererga.core.ILog;

public class GLog
{
  private static String a = "Gatherer";
  private static ILog b;
  
  public static void a(ILog paramILog)
  {
    b = paramILog;
  }
  
  public static void a(String paramString)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.b(a, paramString);
      return;
    }
    Log.i(a, paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.a(a, paramString, paramThrowable);
      return;
    }
    Log.w(a, paramString, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    a("", paramThrowable);
  }
  
  public static void b(String paramString)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.a(a, paramString);
      return;
    }
    Log.d(a, paramString);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.b(a, paramString, paramThrowable);
      return;
    }
    Log.e(a, paramString, paramThrowable);
  }
  
  public static void c(String paramString)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.c(a, paramString);
      return;
    }
    Log.w(a, paramString);
  }
  
  public static void d(String paramString)
  {
    ILog localILog = b;
    if (localILog != null)
    {
      localILog.d(a, paramString);
      return;
    }
    Log.e(a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.GLog
 * JD-Core Version:    0.7.0.1
 */