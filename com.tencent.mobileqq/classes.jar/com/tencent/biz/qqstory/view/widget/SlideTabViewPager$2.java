package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SlideTabViewPager$2
  implements View.OnClickListener
{
  SlideTabViewPager$2(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    this.a.setTab(localInteger.intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager.2
 * JD-Core Version:    0.7.0.1
 */