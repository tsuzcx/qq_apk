package com.tencent.biz.pubaccount.readinjoy.viola;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonSuspensionGestureLayout$10
  implements View.OnClickListener
{
  CommonSuspensionGestureLayout$10(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    CommonSuspensionGestureLayout.a(this.a).a(true, 0, 5);
    CommonSuspensionGestureLayout.a(this.a, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.10
 * JD-Core Version:    0.7.0.1
 */