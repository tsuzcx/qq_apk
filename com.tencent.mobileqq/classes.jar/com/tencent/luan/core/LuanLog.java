package com.tencent.luan.core;

import java.util.concurrent.atomic.AtomicBoolean;

public class LuanLog
{
  private static final AtomicBoolean INIT = new AtomicBoolean(false);
  private static volatile LuanLog.LuanLogInterface sLogInf;
  
  public static void d(String paramString1, String paramString2)
  {
    if (sLogInf != null) {
      sLogInf.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sLogInf != null) {
      sLogInf.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogInf != null) {
      sLogInf.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sLogInf != null) {
      sLogInf.i(paramString1, paramString2);
    }
  }
  
  public static void init(LuanLog.LuanLogInterface paramLuanLogInterface)
  {
    if (paramLuanLogInterface != null)
    {
      if (!INIT.compareAndSet(false, true)) {
        return;
      }
      sLogInf = paramLuanLogInterface;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (sLogInf != null) {
      sLogInf.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sLogInf != null) {
      sLogInf.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogInf != null) {
      sLogInf.w(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.core.LuanLog
 * JD-Core Version:    0.7.0.1
 */