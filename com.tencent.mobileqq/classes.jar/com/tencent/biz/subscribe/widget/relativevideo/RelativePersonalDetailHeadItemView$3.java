package com.tencent.biz.subscribe.widget.relativevideo;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import veg;

class RelativePersonalDetailHeadItemView$3
  implements Runnable
{
  RelativePersonalDetailHeadItemView$3(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, PublishBoxStatusEvent paramPublishBoxStatusEvent) {}
  
  public void run()
  {
    if ((!RelativePersonalDetailHeadItemView.a(this.this$0)) || (this.a.taskCount <= 0))
    {
      RelativePersonalDetailHeadItemView.a(this.this$0).setVisibility(8);
      RelativePersonalDetailHeadItemView.b(this.this$0).setVisibility(8);
      veg.c("RelativePersonalDetailH", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    RelativePersonalDetailHeadItemView.a(this.this$0).setVisibility(0);
    RelativePersonalDetailHeadItemView.b(this.this$0).setVisibility(0);
    veg.c("RelativePersonalDetailH", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
    if (this.a.hasRunningTask)
    {
      RelativePersonalDetailHeadItemView.a(this.this$0);
      RelativePersonalDetailHeadItemView.b(this.this$0).setBackgroundResource(2130849292);
      RelativePersonalDetailHeadItemView.b(this.this$0).setText(String.valueOf(this.a.taskCount));
      return;
    }
    if (this.a.hasOfflineWaitingTask)
    {
      RelativePersonalDetailHeadItemView.b(this.this$0);
      RelativePersonalDetailHeadItemView.b(this.this$0).setBackgroundResource(2130847702);
      RelativePersonalDetailHeadItemView.b(this.this$0).setText("");
      return;
    }
    RelativePersonalDetailHeadItemView.b(this.this$0);
    RelativePersonalDetailHeadItemView.b(this.this$0).setBackgroundResource(2130847701);
    RelativePersonalDetailHeadItemView.b(this.this$0).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.3
 * JD-Core Version:    0.7.0.1
 */