package com.qq.android.dexposed.utility;

import android.util.Log;

public class Logger
{
  private static final boolean DEBUG = false;
  public static final String preFix = "epic.";
  
  public static void d(String paramString1, String paramString2) {}
  
  public static void e(String paramString1, String paramString2) {}
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void i(String paramString1, String paramString2) {}
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w("epic." + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Logger
 * JD-Core Version:    0.7.0.1
 */