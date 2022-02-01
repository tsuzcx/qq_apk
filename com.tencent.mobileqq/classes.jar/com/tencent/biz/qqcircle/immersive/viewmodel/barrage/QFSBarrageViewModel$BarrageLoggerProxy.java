package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig.ILogger;

class QFSBarrageViewModel$BarrageLoggerProxy
  implements RFWVideoBarrageConfig.ILogger
{
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DM-");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public void a(String paramString, Object... paramVarArgs) {}
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if (RFApplication.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DM-");
      localStringBuilder.append(paramString);
      QLog.d(localStringBuilder.toString(), 1, paramVarArgs);
    }
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    if (RFApplication.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DM-");
      localStringBuilder.append(paramString);
      QLog.d(localStringBuilder.toString(), 1, paramVarArgs);
    }
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    if (RFApplication.isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DM-");
      localStringBuilder.append(paramString);
      QLog.e(localStringBuilder.toString(), 1, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.BarrageLoggerProxy
 * JD-Core Version:    0.7.0.1
 */