package com.tencent.biz.qqcircle.publish.outbox;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.QCircleQueueTask;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishQueuePart$6
  implements View.OnClickListener
{
  QCirclePublishQueuePart$6(QCirclePublishQueuePart paramQCirclePublishQueuePart) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (Button)paramView.findViewById(2131431684);
    if (((Button)localObject).getTag() != null)
    {
      int i = ((Integer)((Button)localObject).getTag()).intValue();
      if (QCirclePublishQueuePart.a(this.a) != null)
      {
        localObject = (QCircleQueueTask)QCirclePublishQueuePart.a(this.a).a(i);
        if (QCirclePublishQueuePart.a(this.a, (IQueueTask)localObject))
        {
          if (QCirclePublishQueuePart.c(this.a) != null) {
            QCirclePublishQueuePart.c(this.a).a();
          }
          QCirclePublishQueuePart.a(this.a).a("");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.6
 * JD-Core Version:    0.7.0.1
 */