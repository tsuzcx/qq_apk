package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import tra;
import tsu;
import tyj;
import wsv;

public class QCirclePushFeedPart$1
  implements Runnable
{
  public QCirclePushFeedPart$1(tsu paramtsu, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    if (this.a.taskCount <= 0)
    {
      tsu.a(this.this$0).setVisibility(8);
      wsv.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((tsu.a(this.this$0) != null) && (tra.a(tsu.a(this.this$0))))
    {
      tyj.a("", 16, 1L);
      tsu.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      wsv.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
      if (!this.a.hasRunningTask) {
        break;
      }
      tsu.a(this.this$0).setBackgroundResource(2130843610);
      tsu.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
      tsu.a(this.this$0).setVisibility(8);
    }
    if (this.a.hasOfflineWaitingTask)
    {
      tsu.a(this.this$0).setBackgroundResource(2130848090);
      tsu.a(this.this$0, "");
      return;
    }
    tsu.a(this.this$0).setBackgroundResource(2130848089);
    tsu.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePushFeedPart.1
 * JD-Core Version:    0.7.0.1
 */