package com.tencent.biz.pubaccount.readinjoy.view.widget;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabBar$updateUI$1
  implements Runnable
{
  RIJXTabBar$updateUI$1(RIJXTabBar paramRIJXTabBar, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager) {}
  
  public final void run()
  {
    int i = this.a.getCurrentItem();
    RIJXTabBar.a(this.this$0).onPageSelected(i);
    RIJXTabBar.a(this.this$0).onPageSelected(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar.updateUI.1
 * JD-Core Version:    0.7.0.1
 */