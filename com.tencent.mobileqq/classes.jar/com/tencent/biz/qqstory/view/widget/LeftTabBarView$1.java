package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LeftTabBarView$1
  implements View.OnClickListener
{
  LeftTabBarView$1(LeftTabBarView paramLeftTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - LeftTabBarView.a(this.b) >= 500L)
    {
      LeftTabBarView.a(this.b, l);
      this.b.setSelectedTab(this.a, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LeftTabBarView.1
 * JD-Core Version:    0.7.0.1
 */