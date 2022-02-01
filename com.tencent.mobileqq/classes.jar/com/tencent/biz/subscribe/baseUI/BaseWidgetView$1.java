package com.tencent.biz.subscribe.baseUI;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseWidgetView$1
  implements View.OnClickListener
{
  BaseWidgetView$1(BaseWidgetView paramBaseWidgetView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!this.a.a(paramView)))
    {
      this.a.a(this.a.a());
      this.a.a().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView.1
 * JD-Core Version:    0.7.0.1
 */