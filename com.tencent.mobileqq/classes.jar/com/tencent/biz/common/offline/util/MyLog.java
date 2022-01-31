package com.tencent.biz.common.offline.util;

import com.tencent.qphone.base.util.QLog;

public class MyLog
  implements ILog
{
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public boolean a()
  {
    return QLog.isColorLevel();
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public boolean b()
  {
    return QLog.isDevelopLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.MyLog
 * JD-Core Version:    0.7.0.1
 */