package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

public class AEFilterLogger
  implements ILightLogger
{
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString());
    }
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString(), paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 2, paramString2.toString());
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 2, paramString2.toString(), paramThrowable);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString());
    }
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString(), paramThrowable);
    }
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("i: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", s:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", s1: ");
      localStringBuilder.append(paramString2);
      QLog.i("AEFilterLogger", 4, localStringBuilder.toString());
    }
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("i: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", s:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", s1: ");
      localStringBuilder.append(paramString2);
      QLog.i("AEFilterLogger", 4, localStringBuilder.toString(), paramThrowable);
    }
  }
  
  public void v(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString());
    }
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString(), paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString());
    }
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("s: ");
      paramString2.append(paramString1);
      paramString2.append(", s1");
      QLog.i("AEFilterLogger", 4, paramString2.toString(), paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AEFilterLogger
 * JD-Core Version:    0.7.0.1
 */