package com.tencent.biz.qqcircle.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScrollMoreGuideView$1
  implements View.OnClickListener
{
  ScrollMoreGuideView$1(ScrollMoreGuideView paramScrollMoreGuideView) {}
  
  public void onClick(View paramView)
  {
    ScrollMoreGuideView.a(this.a, false);
    this.a.b();
    if (ScrollMoreGuideView.a(this.a) != null) {
      ScrollMoreGuideView.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.ScrollMoreGuideView.1
 * JD-Core Version:    0.7.0.1
 */