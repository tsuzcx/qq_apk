package com.tencent.common.app;

import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.qphone.base.util.QLog;

class BaseApplicationImpl$1
  implements ILogger
{
  BaseApplicationImpl$1(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void debug(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 4, paramString2);
  }
  
  public void info(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public void warning(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void warning(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.1
 * JD-Core Version:    0.7.0.1
 */