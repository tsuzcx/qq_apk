package com.tencent.biz.pubaccount.readinjoy.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$initViewPagerListener$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$initViewPagerListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a().a(paramInt);
    RIJXTabFrame.a(this.a, localTabChannelCoverInfo);
    RIJKanDianTabReport.a(localTabChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame.initViewPagerListener.1
 * JD-Core Version:    0.7.0.1
 */