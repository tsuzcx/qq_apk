package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

public class b
{
  private static final String TAG = "SecurityComp10105302: ";
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(i(paramString1), paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Log.v(i(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2)
  {
    Log.i(i(paramString1), paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.w(i(paramString1), paramString2);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    Log.e(i(paramString1), paramString2);
  }
  
  private static String i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SecurityComp10105302: ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.b
 * JD-Core Version:    0.7.0.1
 */