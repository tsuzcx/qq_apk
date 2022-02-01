package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SimpleFeedbackPopupWindow$1
  implements View.OnClickListener
{
  SimpleFeedbackPopupWindow$1(SimpleFeedbackPopupWindow paramSimpleFeedbackPopupWindow) {}
  
  public void onClick(View paramView)
  {
    SimpleFeedbackPopupWindow.a(this.a).a(SimpleFeedbackPopupWindow.a(this.a), SimpleFeedbackPopupWindow.a(this.a));
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.SimpleFeedbackPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */