package com.tencent.mobileqq.activity.qwallet.redpacket.widget;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViewPagerTabLayout$1
  implements View.OnClickListener
{
  ViewPagerTabLayout$1(ViewPagerTabLayout paramViewPagerTabLayout) {}
  
  public void onClick(View paramView)
  {
    int i = ViewPagerTabLayout.a(this.a).indexOfChild(paramView);
    if (i != -1)
    {
      if (ViewPagerTabLayout.a(this.a).getCurrentItem() == i) {
        break label92;
      }
      if (ViewPagerTabLayout.a(this.a)) {
        break label81;
      }
      this.a.setCurrentTab(i, false);
      if (ViewPagerTabLayout.a(this.a) != null) {
        ViewPagerTabLayout.a(this.a).a(i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label81:
      this.a.setCurrentTab(i);
      break;
      label92:
      if (ViewPagerTabLayout.a(this.a) != null) {
        ViewPagerTabLayout.a(this.a).b(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout.1
 * JD-Core Version:    0.7.0.1
 */