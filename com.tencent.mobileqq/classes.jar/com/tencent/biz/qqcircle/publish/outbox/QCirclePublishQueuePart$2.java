package com.tencent.biz.qqcircle.publish.outbox;

import android.os.Handler;
import com.tencent.biz.qqcircle.publish.queue.IPublishQueueListener;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;

class QCirclePublishQueuePart$2
  implements IPublishQueueListener
{
  QCirclePublishQueuePart$2(QCirclePublishQueuePart paramQCirclePublishQueuePart) {}
  
  public void a()
  {
    RFThreadManager.getUIHandler().post(new QCirclePublishQueuePart.2.1(this));
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    RFThreadManager.getUIHandler().post(new QCirclePublishQueuePart.2.2(this, paramIQueueTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.2
 * JD-Core Version:    0.7.0.1
 */