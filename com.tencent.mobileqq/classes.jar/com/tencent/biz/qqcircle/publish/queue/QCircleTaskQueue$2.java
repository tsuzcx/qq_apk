package com.tencent.biz.qqcircle.publish.queue;

import com.tencent.qphone.base.util.QLog;

class QCircleTaskQueue$2
  implements Runnable
{
  QCircleTaskQueue$2(QCircleTaskQueue paramQCircleTaskQueue) {}
  
  public void run()
  {
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, "checkRetryForOffline");
    QCircleTaskQueue.a(this.this$0);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */