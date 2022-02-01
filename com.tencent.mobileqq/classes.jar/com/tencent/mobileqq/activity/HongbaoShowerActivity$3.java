package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HongbaoShowerActivity$3
  implements View.OnClickListener
{
  HongbaoShowerActivity$3(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = HongbaoShowerActivity.b(this.a).isChecked();
    HongbaoShowerActivity.b(this.a).setChecked(bool ^ true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity.3
 * JD-Core Version:    0.7.0.1
 */