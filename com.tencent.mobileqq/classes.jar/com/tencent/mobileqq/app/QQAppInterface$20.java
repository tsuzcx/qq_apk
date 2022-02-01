package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class QQAppInterface$20
  implements Runnable
{
  QQAppInterface$20(QQAppInterface paramQQAppInterface, long paramLong, Intent paramIntent) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.val$startTime;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runNext, ThreadManager.excute, cost=");
      localStringBuilder.append(l1 - l2);
      QLog.i("Q.qqhead.broadcast", 2, localStringBuilder.toString());
    }
    QQAppInterface.access$2800(this.this$0, this.val$intent);
    this.this$0.mRunningTaskNum.decrementAndGet();
    QQAppInterface.access$2900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.20
 * JD-Core Version:    0.7.0.1
 */