package com.mojitox.mxflutter.framework.utils;

import android.util.Log;

public class MxLog
{
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=======message:");
    localStringBuilder.append(paramString2);
    Log.d("MXFlutter", localStringBuilder.toString(), paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=======message:");
    localStringBuilder.append(paramString2);
    Log.w("MXFlutter", localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.utils.MxLog
 * JD-Core Version:    0.7.0.1
 */