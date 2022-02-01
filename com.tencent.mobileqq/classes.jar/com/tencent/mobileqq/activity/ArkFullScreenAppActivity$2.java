package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkFullScreenAppActivity$2
  implements View.OnClickListener
{
  ArkFullScreenAppActivity$2(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      ArkAppDataReport.a(this.a.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.a).a, null, ArkAppDataReport.b, 0, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "click to close");
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.2
 * JD-Core Version:    0.7.0.1
 */