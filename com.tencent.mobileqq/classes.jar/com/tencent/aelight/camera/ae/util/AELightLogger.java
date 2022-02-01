package com.tencent.aelight.camera.ae.util;

import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

public class AELightLogger
  implements ILightLogger
{
  public void d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.d(localStringBuilder.toString(), 4, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.d(localStringBuilder.toString(), 4, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          e(paramString1, paramString2);
          return;
        }
        w(paramString1, paramString2);
        return;
      }
      i(paramString1, paramString2);
      return;
    }
    d(paramString1, paramString2);
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          e(paramString1, paramString2, paramThrowable);
          return;
        }
        w(paramString1, paramString2, paramThrowable);
        return;
      }
      i(paramString1, paramString2, paramThrowable);
      return;
    }
    d(paramString1, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void w(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AELightLog_");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AELightLogger
 * JD-Core Version:    0.7.0.1
 */