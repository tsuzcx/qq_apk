package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FontSettingActivity$1
  implements View.OnClickListener
{
  FontSettingActivity$1(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */