package com.taobao.android.dexposed.utility;

import android.util.Log;

public class Logger
{
  private static final boolean DEBUG = true;
  public static final String preFix = "galileo.";
  
  public static void d(String paramString1, String paramString2)
  {
    Log.d("galileo." + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e("galileo." + paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e("galileo." + paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Log.i("galileo." + paramString1, paramString2);
  }
  
  public static void log(String paramString1, String paramString2)
  {
    try
    {
      Log.i(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void log(String paramString, Throwable paramThrowable)
  {
    try
    {
      log(paramString, Log.getStackTraceString(paramThrowable));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w("galileo." + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.utility.Logger
 * JD-Core Version:    0.7.0.1
 */