package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingActivity$22
  implements View.OnClickListener
{
  NotifyPushSettingActivity$22(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getActivity(), SoundAndVibrateActivity.class);
    this.a.startActivity(localIntent);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800403C", "0X800403C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.22
 * JD-Core Version:    0.7.0.1
 */