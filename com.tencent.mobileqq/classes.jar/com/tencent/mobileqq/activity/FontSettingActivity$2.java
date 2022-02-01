package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FontSettingActivity$2
  implements View.OnClickListener
{
  FontSettingActivity$2(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    FontSettingActivity.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */