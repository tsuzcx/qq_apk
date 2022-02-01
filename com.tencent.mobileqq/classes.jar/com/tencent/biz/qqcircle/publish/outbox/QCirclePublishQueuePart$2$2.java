package com.tencent.biz.qqcircle.publish.outbox;

import android.view.View;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView;

class QCirclePublishQueuePart$2$2
  implements Runnable
{
  QCirclePublishQueuePart$2$2(QCirclePublishQueuePart.2 param2, IQueueTask paramIQueueTask) {}
  
  public void run()
  {
    Object localObject = QCirclePublishQueuePart.c(this.b.a).findViewWithTag(this.a);
    if ((localObject != null) && (((View)localObject).getTag(2131446821) != null))
    {
      localObject = (QCirclePublishQueuePart.ViewHolder)((View)localObject).getTag(2131446821);
      QCirclePublishQueuePart.UploadingListAdapter.a(QCirclePublishQueuePart.a(this.b.a), (QCirclePublishQueuePart.ViewHolder)localObject, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.2.2
 * JD-Core Version:    0.7.0.1
 */