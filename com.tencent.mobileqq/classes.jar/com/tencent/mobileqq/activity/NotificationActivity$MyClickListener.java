package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationActivity$MyClickListener
  implements View.OnClickListener
{
  NotificationActivity$MyClickListener(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364703) {
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.MyClickListener
 * JD-Core Version:    0.7.0.1
 */