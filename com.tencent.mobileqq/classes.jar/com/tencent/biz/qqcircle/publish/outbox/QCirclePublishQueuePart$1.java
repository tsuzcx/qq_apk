package com.tencent.biz.qqcircle.publish.outbox;

import android.app.Activity;
import android.database.DataSetObserver;

class QCirclePublishQueuePart$1
  extends DataSetObserver
{
  QCirclePublishQueuePart$1(QCirclePublishQueuePart paramQCirclePublishQueuePart) {}
  
  public void onChanged()
  {
    if (QCirclePublishQueuePart.a(this.a).isEmpty()) {
      this.a.c().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.1
 * JD-Core Version:    0.7.0.1
 */