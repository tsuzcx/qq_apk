package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationActivity$34
  implements View.OnClickListener
{
  NotificationActivity$34(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.exitApp();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.34
 * JD-Core Version:    0.7.0.1
 */