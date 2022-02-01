package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class QQAppInterface$21
  implements Runnable
{
  QQAppInterface$21(QQAppInterface paramQQAppInterface, long paramLong, Intent paramIntent) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "runNext, ThreadManager.excute, cost=" + (l1 - l2));
    }
    QQAppInterface.b(this.this$0, this.jdField_a_of_type_AndroidContentIntent);
    this.this$0.a.decrementAndGet();
    QQAppInterface.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.21
 * JD-Core Version:    0.7.0.1
 */