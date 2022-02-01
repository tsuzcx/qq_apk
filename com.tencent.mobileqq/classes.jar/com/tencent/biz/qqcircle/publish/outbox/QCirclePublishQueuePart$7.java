package com.tencent.biz.qqcircle.publish.outbox;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.QCircleQueueTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishQueuePart$7
  implements View.OnClickListener
{
  QCirclePublishQueuePart$7(QCirclePublishQueuePart paramQCirclePublishQueuePart) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof QCircleQueueTask)))
    {
      localObject = (QCircleQueueTask)localObject;
      if (!this.a.c().isFinishing()) {
        this.a.a((IQueueTask)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.7
 * JD-Core Version:    0.7.0.1
 */