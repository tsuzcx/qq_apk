package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingActivity$5
  implements View.OnClickListener
{
  NotifyPushSettingActivity$5(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    CustomizeGrayTipsManager.a(this.a.app, this.a, "2", -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */