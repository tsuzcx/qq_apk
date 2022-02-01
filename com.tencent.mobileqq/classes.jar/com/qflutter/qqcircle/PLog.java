package com.qflutter.qqcircle;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class PLog
{
  private static boolean isQLogExists;
  
  static
  {
    try
    {
      if (Class.forName("com.tencent.qphone.base.util.QLog") == null) {
        break label62;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label24:
        StringBuilder localStringBuilder;
        continue;
        label62:
        boolean bool = false;
      }
    }
    isQLogExists = bool;
    break label24;
    isQLogExists = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isQLogExists=");
    localStringBuilder.append(isQLogExists);
    Log.d("PLog", localStringBuilder.toString());
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (isQLogExists)
    {
      QLog.d(paramString1, 1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (isQLogExists)
    {
      QLog.e(paramString1, 1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (isQLogExists)
    {
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean isColorLevel()
  {
    if (isQLogExists) {
      return QLog.isColorLevel();
    }
    return true;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (isQLogExists)
    {
      QLog.w(paramString1, 1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (isQLogExists)
    {
      QLog.w(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.PLog
 * JD-Core Version:    0.7.0.1
 */