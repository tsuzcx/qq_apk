package com.tencent.biz.richframework.delegate.impl;

import android.util.Log;
import com.tencent.biz.richframework.delegate.ILogDelegate;

public class RFLog
{
  public static int CLR = 0;
  public static int DEV = 0;
  private static final String TAG = "QLog";
  public static int USR;
  private static ILogDelegate mLogImpl;
  private static volatile RFLog sLog;
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.d(paramString1, paramInt, paramString2);
      return;
    }
    Log.e("QLog", "d() get delegate is null!");
  }
  
  public static void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.d(paramString, paramInt, paramVarArgs);
      return;
    }
    Log.e("QLog", "d() get delegate is null!");
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.e(paramString1, paramInt, paramString2);
      return;
    }
    Log.e("QLog", "e() get delegate is null!");
  }
  
  public static void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.e(paramString, paramInt, paramVarArgs);
      return;
    }
    Log.e("QLog", "e() get delegate is null!");
  }
  
  private static ILogDelegate getLogDelegate()
  {
    if (mLogImpl == null) {
      try
      {
        mLogImpl = (ILogDelegate)RFApplication.getDelegateImpl(ILogDelegate.class).newInstance();
        DEV = mLogImpl.getDEVValue();
        CLR = mLogImpl.getCLRValue();
        USR = mLogImpl.getUSRValue();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return mLogImpl;
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.i(paramString1, paramInt, paramString2);
      return;
    }
    Log.e("QLog", "i() get delegate is null!");
  }
  
  public static boolean isColorLevel()
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null) {
      return localILogDelegate.isColorLevel();
    }
    Log.e("QLog", "isColorLevel() get delegate is null!");
    return true;
  }
  
  public static boolean isDevelopLevel()
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null) {
      return localILogDelegate.isDevelopLevel();
    }
    Log.e("QLog", "isDevelopLevel() get delegate is null!");
    return true;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    ILogDelegate localILogDelegate = getLogDelegate();
    if (localILogDelegate != null)
    {
      localILogDelegate.w(paramString1, paramInt, paramString2);
      return;
    }
    Log.e("QLog", "w() get delegate is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.impl.RFLog
 * JD-Core Version:    0.7.0.1
 */