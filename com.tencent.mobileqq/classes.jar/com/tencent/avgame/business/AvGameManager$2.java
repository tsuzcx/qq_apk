package com.tencent.avgame.business;

import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class AvGameManager$2
  implements Runnable
{
  public AvGameManager$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    AVGameUtilService.a(this.a, false);
    long l2 = System.currentTimeMillis();
    QLog.d("AvGameManager", 2, "preloadAVGameProcess AvGameManagerCOST: " + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.2
 * JD-Core Version:    0.7.0.1
 */