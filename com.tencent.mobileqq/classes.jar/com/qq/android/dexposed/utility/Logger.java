package com.qq.android.dexposed.utility;

import android.util.Log;

public class Logger
{
  public static void a(String paramString1, String paramString2) {}
  
  public static void b(String paramString1, String paramString2) {}
  
  public static void c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("epic.");
    localStringBuilder.append(paramString1);
    Log.w(localStringBuilder.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Logger
 * JD-Core Version:    0.7.0.1
 */