package com.tencent.av.ui.redbag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuideTip2$1
  implements View.OnClickListener
{
  GuideTip2$1(GuideTip2 paramGuideTip2) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2.1
 * JD-Core Version:    0.7.0.1
 */