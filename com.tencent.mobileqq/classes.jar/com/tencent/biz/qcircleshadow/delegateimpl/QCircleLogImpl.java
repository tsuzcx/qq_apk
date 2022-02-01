package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.qphone.base.util.QLog;

public class QCircleLogImpl
  implements com.tencent.biz.qcircleshadow.lib.delegate.ILogDelegate, com.tencent.biz.richframework.delegate.ILogDelegate
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void d(String paramString, int paramInt, Object... paramVarArgs)
  {
    QLog.d(paramString, paramInt, paramVarArgs);
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public void e(String paramString, int paramInt, Object... paramVarArgs)
  {
    QLog.e(paramString, paramInt, paramVarArgs);
  }
  
  public int getCLRValue()
  {
    return 2;
  }
  
  public int getDEVValue()
  {
    return 4;
  }
  
  public int getUSRValue()
  {
    return 1;
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleLogImpl
 * JD-Core Version:    0.7.0.1
 */