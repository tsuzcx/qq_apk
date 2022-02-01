package com.tencent.biz.pubaccount.readinjoy;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotStore;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/RIJXTabViewPagerController$onPageChangeListener$1", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "index", "offset", "", "positionOffsetPixels", "onPageSelected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController$onPageChangeListener$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a(paramInt);
    if (localTabChannelCoverInfo != null)
    {
      int i = localTabChannelCoverInfo.mChannelCoverId;
      Fragment localFragment = this.a.a(paramInt);
      Object localObject = localFragment;
      if (!(localFragment instanceof ReadInJoyBaseFragment)) {
        localObject = null;
      }
      localObject = (ReadInJoyBaseFragment)localObject;
      if (localObject != null)
      {
        RIJChannelStayTimeMonitor.a.a(localTabChannelCoverInfo, this.a.a());
        if (RIJXTabNormalRedDotStore.a.a(i) != null)
        {
          ((ReadInJoyBaseFragment)localObject).a(3);
          ThreadManager.getUIHandler().postDelayed((Runnable)new RIJXTabViewPagerController.onPageChangeListener.1.onPageSelected.1(this, i), 500L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController.onPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */