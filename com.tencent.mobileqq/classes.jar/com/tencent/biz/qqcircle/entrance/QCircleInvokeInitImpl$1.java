package com.tencent.biz.qqcircle.entrance;

import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;

class QCircleInvokeInitImpl$1
  implements Runnable
{
  QCircleInvokeInitImpl$1(QCircleInvokeInitImpl paramQCircleInvokeInitImpl) {}
  
  public void run()
  {
    QCircleReportOutboxTaskQueue.getInstance();
    QCircleOutboxTaskQueue.b();
    QCircleGlobalBroadcastHelper.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.entrance.QCircleInvokeInitImpl.1
 * JD-Core Version:    0.7.0.1
 */