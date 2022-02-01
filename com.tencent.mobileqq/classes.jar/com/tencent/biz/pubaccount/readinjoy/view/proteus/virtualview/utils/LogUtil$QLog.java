package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.util.Log;

public class LogUtil$QLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final int USR = 1;
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.d(paramString1, paramInt, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.d(paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.e(paramString1, paramInt, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.e(paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.i(paramString1, paramInt, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.i(paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean isColorLevel()
  {
    if (LogUtil.proteusLog != null) {
      return LogUtil.proteusLog.isColorLevel();
    }
    return false;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.w(paramString1, paramInt, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (LogUtil.proteusLog != null)
    {
      LogUtil.proteusLog.w(paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog
 * JD-Core Version:    0.7.0.1
 */