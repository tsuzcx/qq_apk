package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import uzg;
import vfe;
import vtq;
import yuk;

public class QCirclePublishStatusBoxPart$1
  implements Runnable
{
  public QCirclePublishStatusBoxPart$1(vfe paramvfe, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    if (this.a.taskCount <= 0)
    {
      vfe.a(this.this$0).setVisibility(8);
      yuk.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((vfe.a(this.this$0) != null) && (uzg.a(vfe.a(this.this$0))))
    {
      vtq.a("", 16, 1, 0, this.this$0.c());
      vfe.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      yuk.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
      if (!this.a.hasRunningTask) {
        break;
      }
      vfe.a(this.this$0).setBackgroundResource(2130844056);
      vfe.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
      vfe.a(this.this$0).setVisibility(8);
    }
    if (this.a.hasOfflineWaitingTask)
    {
      vfe.a(this.this$0).setBackgroundResource(2130848658);
      vfe.a(this.this$0, "");
      return;
    }
    vfe.a(this.this$0).setBackgroundResource(2130848657);
    vfe.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart.1
 * JD-Core Version:    0.7.0.1
 */