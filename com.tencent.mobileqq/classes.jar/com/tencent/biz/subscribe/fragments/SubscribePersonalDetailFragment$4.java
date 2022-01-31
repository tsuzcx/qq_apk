package com.tencent.biz.subscribe.fragments;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import urk;

class SubscribePersonalDetailFragment$4
  implements Runnable
{
  SubscribePersonalDetailFragment$4(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, PublishBoxStatusEvent paramPublishBoxStatusEvent) {}
  
  public void run()
  {
    if ((!SubscribePersonalDetailFragment.a(this.this$0)) || (this.a.taskCount <= 0))
    {
      SubscribePersonalDetailFragment.a(this.this$0).setVisibility(8);
      SubscribePersonalDetailFragment.a(this.this$0).setVisibility(8);
      urk.c("SubscribePersonalDetail", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    SubscribePersonalDetailFragment.a(this.this$0).setVisibility(0);
    SubscribePersonalDetailFragment.a(this.this$0).setVisibility(0);
    urk.c("SubscribePersonalDetail", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
    if (this.a.hasRunningTask)
    {
      SubscribePersonalDetailFragment.b(this.this$0);
      SubscribePersonalDetailFragment.a(this.this$0).setBackgroundResource(2130849057);
      SubscribePersonalDetailFragment.a(this.this$0).setText(String.valueOf(this.a.taskCount));
      return;
    }
    if (this.a.hasOfflineWaitingTask)
    {
      SubscribePersonalDetailFragment.c(this.this$0);
      SubscribePersonalDetailFragment.a(this.this$0).setBackgroundResource(2130847476);
      SubscribePersonalDetailFragment.a(this.this$0).setText("");
      return;
    }
    SubscribePersonalDetailFragment.c(this.this$0);
    SubscribePersonalDetailFragment.a(this.this$0).setBackgroundResource(2130847475);
    SubscribePersonalDetailFragment.a(this.this$0).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */