package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import tra;
import ttk;
import tzv;
import wxe;

public class QCirclePushFeedPart$1
  implements Runnable
{
  public QCirclePushFeedPart$1(ttk paramttk, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    if (this.a.taskCount <= 0)
    {
      ttk.a(this.this$0).setVisibility(8);
      wxe.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((ttk.a(this.this$0) != null) && (tra.a(ttk.a(this.this$0))))
    {
      tzv.a("", 16, 1L);
      ttk.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      wxe.c("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
      if (!this.a.hasRunningTask) {
        break;
      }
      ttk.a(this.this$0).setBackgroundResource(2130843661);
      ttk.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
      ttk.a(this.this$0).setVisibility(8);
    }
    if (this.a.hasOfflineWaitingTask)
    {
      ttk.a(this.this$0).setBackgroundResource(2130848163);
      ttk.a(this.this$0, "");
      return;
    }
    ttk.a(this.this$0).setBackgroundResource(2130848162);
    ttk.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePushFeedPart.1
 * JD-Core Version:    0.7.0.1
 */