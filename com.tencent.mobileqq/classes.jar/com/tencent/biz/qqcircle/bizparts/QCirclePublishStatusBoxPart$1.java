package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import uxx;
import vda;
import vrf;
import yqp;

public class QCirclePublishStatusBoxPart$1
  implements Runnable
{
  public QCirclePublishStatusBoxPart$1(vda paramvda, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    if (this.a.taskCount <= 0)
    {
      vda.a(this.this$0).setVisibility(8);
      yqp.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((vda.a(this.this$0) != null) && (uxx.a(vda.a(this.this$0))))
    {
      vrf.a("", 16, 1, 0, this.this$0.c());
      vda.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      yqp.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
      if (!this.a.hasRunningTask) {
        break;
      }
      vda.a(this.this$0).setBackgroundResource(2130844037);
      vda.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
      vda.a(this.this$0).setVisibility(8);
    }
    if (this.a.hasOfflineWaitingTask)
    {
      vda.a(this.this$0).setBackgroundResource(2130848639);
      vda.a(this.this$0, "");
      return;
    }
    vda.a(this.this$0).setBackgroundResource(2130848638);
    vda.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart.1
 * JD-Core Version:    0.7.0.1
 */