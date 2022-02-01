package com.tencent.avgame.business.api.impl;

import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class AvGameManagerImpl$2
  implements Runnable
{
  AvGameManagerImpl$2(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    AVGameUtilService.a(this.a, false);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadAVGameProcess AvGameManagerCOST: ");
    localStringBuilder.append(l2 - l1);
    QLog.d("AvGameManager", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */