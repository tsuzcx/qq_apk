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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append("(");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append(") ");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      Log.d(paramString1, localStringBuilder.toString());
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (ao)
    {
      Object localObject = java.lang.Thread.currentThread().getStackTrace()[3];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append("(");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append(") ");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      Log.e(paramString1, localStringBuilder.toString());
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