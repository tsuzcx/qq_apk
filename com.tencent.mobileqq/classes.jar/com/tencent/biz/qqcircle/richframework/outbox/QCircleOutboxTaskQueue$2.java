package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleNetDetectHelper;
import cooperation.qqcircle.utils.NetworkState;

class QCircleOutboxTaskQueue$2
  implements Runnable
{
  QCircleOutboxTaskQueue$2(QCircleOutboxTaskQueue paramQCircleOutboxTaskQueue) {}
  
  public void run()
  {
    if (!NetworkState.isNetSupport()) {
      return;
    }
    if (QCircleOutboxTaskQueue.b(this.this$0) > 0)
    {
      QCircleNetDetectHelper.detectQCircleNetConnection(new QCircleOutboxTaskQueue.2.1(this));
      return;
    }
    QLog.d("QCircleOutboxTaskQueue", 1, "no outbox tasks left,direct return!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue.2
 * JD-Core Version:    0.7.0.1
 */