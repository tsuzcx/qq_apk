package com.tencent.mobileqq.ark.multiproc;

import com.tencent.ark.ArkEnvironmentManager.Log;
import com.tencent.qphone.base.util.QLog;

final class ArkMultiProcUtil$2
  implements ArkEnvironmentManager.Log
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.2
 * JD-Core Version:    0.7.0.1
 */