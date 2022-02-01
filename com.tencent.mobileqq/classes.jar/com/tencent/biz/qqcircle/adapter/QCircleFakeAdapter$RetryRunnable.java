package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.qphone.base.util.QLog;

public class QCircleFakeAdapter$RetryRunnable
  implements Runnable
{
  private QCircleFakeAdapter a;
  private QCircleFeedEvent b;
  
  public QCircleFakeAdapter$RetryRunnable(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent)
  {
    this.a = paramQCircleFakeAdapter;
    this.b = paramQCircleFeedEvent;
  }
  
  public void run()
  {
    QCircleFakeAdapter localQCircleFakeAdapter = this.a;
    if (localQCircleFakeAdapter != null)
    {
      QCircleFeedEvent localQCircleFeedEvent = this.b;
      if (localQCircleFeedEvent != null)
      {
        localQCircleFakeAdapter.a(localQCircleFeedEvent, true);
        return;
      }
    }
    QLog.d("QCircleFakeAdapter", 1, "adapter or event is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.RetryRunnable
 * JD-Core Version:    0.7.0.1
 */