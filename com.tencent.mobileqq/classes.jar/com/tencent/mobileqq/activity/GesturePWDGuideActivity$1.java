package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GesturePWDGuideActivity$1
  implements View.OnClickListener
{
  GesturePWDGuideActivity$1(GesturePWDGuideActivity paramGesturePWDGuideActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(localIntent, 999);
    this.a.overridePendingTransition(2130772014, 2130772007);
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_Gesture_password", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDGuideActivity.1
 * JD-Core Version:    0.7.0.1
 */