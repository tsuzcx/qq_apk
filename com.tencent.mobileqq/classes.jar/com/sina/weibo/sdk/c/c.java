package com.sina.weibo.sdk.c;

import android.util.Log;

public final class c
{
  private static boolean ao = false;
  
  public static void a(String paramString1, String paramString2)
  {
    if (ao)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      localObject = ((StackTraceElement)localObject).getFileName() + "(" + ((StackTraceElement)localObject).getLineNumber() + ") " + ((StackTraceElement)localObject).getMethodName();
      Log.d(paramString1, (String)localObject + ": " + paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (ao)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      localObject = ((StackTraceElement)localObject).getFileName() + "(" + ((StackTraceElement)localObject).getLineNumber() + ") " + ((StackTraceElement)localObject).getMethodName();
      Log.e(paramString1, (String)localObject + ": " + paramString2);
    }
  }
  
  public static void setLoggerEnable(boolean paramBoolean)
  {
    ao = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.c.c
 * JD-Core Version:    0.7.0.1
 */