package com.tencent.av;

import com.tencent.avcore.util.IAVLog;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class AVLogImpl
  implements IAVLog
{
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public long genDebugSeq()
  {
    return AudioHelper.b();
  }
  
  public String getVersion()
  {
    return "8.5.5";
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  public boolean isGrayVersion()
  {
    return false;
  }
  
  public void printAllUserLog(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void printColorLog(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void printDebugLog(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  public void printErrorLog(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void printInfoLog(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVLogImpl
 * JD-Core Version:    0.7.0.1
 */