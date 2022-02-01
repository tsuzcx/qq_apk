package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FontSettingActivity$3
  implements View.OnClickListener
{
  FontSettingActivity$3(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    FontSettingActivity localFontSettingActivity = this.a;
    if (FontSettingManager.setCustomDensity(localFontSettingActivity, FontSettingActivity.a(localFontSettingActivity), true)) {
      FontSettingManager.killProcess();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */