package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$12
  implements View.OnClickListener
{
  SoundAndVibrateActivity$12(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    SoundAndVibrateActivity.a(this.a, "CHANNEL_ID_GROUP_MSG");
    ReportController.b(null, "CliOper", "", "", "0X800AC8A", "0X800AC8A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.12
 * JD-Core Version:    0.7.0.1
 */