package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$15
  implements View.OnClickListener
{
  SoundAndVibrateActivity$15(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 4, 0, "", "", "", "");
    VasWebviewUtil.a(this.a.app.getCurrentAccountUin(), "bell", "click", "", 1, 0, 0, "", "", "");
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", IndividuationUrlHelper.a("specialCareRingUrl").replace("[uid]", "").replace("[lType]", "1"));
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.15
 * JD-Core Version:    0.7.0.1
 */