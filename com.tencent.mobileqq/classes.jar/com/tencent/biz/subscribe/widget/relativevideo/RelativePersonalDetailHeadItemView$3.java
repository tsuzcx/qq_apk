package com.tencent.biz.subscribe.widget.relativevideo;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;

class RelativePersonalDetailHeadItemView$3
  implements Runnable
{
  RelativePersonalDetailHeadItemView$3(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, PublishBoxStatusEvent paramPublishBoxStatusEvent) {}
  
  public void run()
  {
    if ((RelativePersonalDetailHeadItemView.c(this.this$0)) && (this.a.taskCount > 0))
    {
      RelativePersonalDetailHeadItemView.d(this.this$0).setVisibility(0);
      RelativePersonalDetailHeadItemView.e(this.this$0).setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = ");
      localStringBuilder.append(this.a.taskCount);
      localStringBuilder.append("  hasRunningTask:");
      localStringBuilder.append(this.a.hasRunningTask);
      localStringBuilder.append("  hasOfflineWaitingTask:");
      localStringBuilder.append(this.a.hasOfflineWaitingTask);
      SLog.c("RelativePersonalDetailH", localStringBuilder.toString());
      if (this.a.hasRunningTask)
      {
        RelativePersonalDetailHeadItemView.f(this.this$0);
        RelativePersonalDetailHeadItemView.e(this.this$0).setBackgroundResource(2130852592);
        RelativePersonalDetailHeadItemView.e(this.this$0).setText(String.valueOf(this.a.taskCount));
        return;
      }
      if (this.a.hasOfflineWaitingTask)
      {
        RelativePersonalDetailHeadItemView.g(this.this$0);
        RelativePersonalDetailHeadItemView.e(this.this$0).setBackgroundResource(2130850604);
        RelativePersonalDetailHeadItemView.e(this.this$0).setText("");
        return;
      }
      RelativePersonalDetailHeadItemView.g(this.this$0);
      RelativePersonalDetailHeadItemView.e(this.this$0).setBackgroundResource(2130850603);
      RelativePersonalDetailHeadItemView.e(this.this$0).setText("");
      return;
    }
    RelativePersonalDetailHeadItemView.d(this.this$0).setVisibility(8);
    RelativePersonalDetailHeadItemView.e(this.this$0).setVisibility(8);
    SLog.c("RelativePersonalDetailH", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.3
 * JD-Core Version:    0.7.0.1
 */