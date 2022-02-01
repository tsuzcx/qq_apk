package com.tencent.biz.pubaccount.readinjoy.viola;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonSuspensionGestureLayout$1
  implements View.OnClickListener
{
  CommonSuspensionGestureLayout$1(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    this.a.a(0, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.1
 * JD-Core Version:    0.7.0.1
 */