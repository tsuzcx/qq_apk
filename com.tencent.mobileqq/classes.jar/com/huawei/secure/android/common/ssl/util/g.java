package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class g
{
  private static final String a = "SecurityComp10105306: ";
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SecurityComp10105306: ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(a(paramString1), paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Log.e(a(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Log.i(a(paramString1), paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Log.v(a(paramString1), paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.w(a(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.g
 * JD-Core Version:    0.7.0.1
 */