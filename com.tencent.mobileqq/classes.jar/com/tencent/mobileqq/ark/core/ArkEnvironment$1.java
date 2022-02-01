package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkEnvironmentManager.ILog;
import com.tencent.qphone.base.util.QLog;

final class ArkEnvironment$1
  implements ArkEnvironmentManager.ILog
{
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkEnvironment.1
 * JD-Core Version:    0.7.0.1
 */