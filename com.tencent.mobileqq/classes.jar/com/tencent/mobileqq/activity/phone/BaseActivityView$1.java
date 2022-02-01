package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseActivityView$1
  implements View.OnClickListener
{
  BaseActivityView$1(BaseActivityView paramBaseActivityView) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView.1
 * JD-Core Version:    0.7.0.1
 */