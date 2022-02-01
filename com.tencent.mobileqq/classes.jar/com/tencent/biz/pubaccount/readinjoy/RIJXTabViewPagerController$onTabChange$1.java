package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabViewPagerController$onTabChange$1
  implements Runnable
{
  RIJXTabViewPagerController$onTabChange$1(RIJXTabViewPagerController paramRIJXTabViewPagerController) {}
  
  public final void run()
  {
    int i = RIJXTabViewPagerController.a(this.this$0).getCurrentItem();
    RIJXTabViewPagerController.a(this.this$0).onPageSelected(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController.onTabChange.1
 * JD-Core Version:    0.7.0.1
 */