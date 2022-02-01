package com.tencent.biz.richframework.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseWidgetView$1
  implements View.OnClickListener
{
  BaseWidgetView$1(BaseWidgetView paramBaseWidgetView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getOnClickLister() != null) && (!this.a.doubleClickCheck(paramView)))
    {
      BaseWidgetView localBaseWidgetView = this.a;
      localBaseWidgetView.hookPreClick(localBaseWidgetView.targetClickView());
      this.a.getOnClickLister().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseWidgetView.1
 * JD-Core Version:    0.7.0.1
 */