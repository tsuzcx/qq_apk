package com.tencent.biz.qqstory.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PollWidgetUtils$WidgetElement$1
  implements View.OnClickListener
{
  PollWidgetUtils$WidgetElement$1(PollWidgetUtils.WidgetElement paramWidgetElement) {}
  
  public void onClick(View paramView)
  {
    PollWidgetUtils.OnWidgetElementClickListener localOnWidgetElementClickListener = this.a.k;
    if (localOnWidgetElementClickListener != null) {
      localOnWidgetElementClickListener.a(this.a.i, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement.1
 * JD-Core Version:    0.7.0.1
 */