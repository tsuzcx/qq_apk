package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkFullScreenAppActivity$3
  implements View.OnClickListener
{
  ArkFullScreenAppActivity$3(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      ArkAppDataReport.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, ArkAppDataReport.c, 0, 0);
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.3
 * JD-Core Version:    0.7.0.1
 */