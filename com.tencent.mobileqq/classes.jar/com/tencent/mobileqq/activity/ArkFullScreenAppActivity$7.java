package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkFullScreenAppActivity$7
  implements View.OnClickListener
{
  ArkFullScreenAppActivity$7(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(2130771999, 2130772003);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.7
 * JD-Core Version:    0.7.0.1
 */