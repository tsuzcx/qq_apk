package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.NearbyUsingTimeReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NearbyActivity$3
  implements ViewPager.OnPageChangeListener
{
  NearbyActivity$3(NearbyActivity paramNearbyActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(this.a.mResumeTabIndex), Integer.valueOf(this.a.mTabBarIndex), Integer.valueOf(paramInt) });
    }
    if (this.a.mNearbyUsingTimeReport != null) {
      this.a.mNearbyUsingTimeReport.a(paramInt, this.a.mResumeTabIndex);
    }
    Object localObject = this.a;
    int i = ((NearbyTabInfo)((NearbyActivity)localObject).mTabInfos.get(paramInt)).getTabIndex();
    ((NearbyActivity)localObject).mResumeTabIndex = i;
    NearbyBaseFragment.j = i;
    if ((this.a.mClickTime == 0L) && (this.a.mResumeTabIndex == 2))
    {
      this.a.mClickTime = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.mClickTime) });
      }
    }
    if ((this.a.mNowClickTime == 0L) && (this.a.mResumeTabIndex == 1))
    {
      this.a.mNowClickTime = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mNowClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.mNowClickTime) });
      }
    }
    if (this.a.mTabBarIndex != paramInt) {
      this.a.mBarView.setSelectedTab(paramInt, true);
    }
    if (this.a.mTabBarIndex != -1)
    {
      i = this.a.mTabBarIndex + 1;
      if (this.a.mTabBarIndex == this.a.mMsgBoxTabIndex) {
        i = 9;
      }
      if (TextUtils.equals(HardCodeUtil.a(2131904964), ((NearbyTabInfo)this.a.mTabInfos.get(paramInt)).getTabName())) {
        i = 11;
      }
      int j = ((NearbyTabInfo)this.a.mTabInfos.get(paramInt)).getReportId();
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("report_switch_tab", new Object[] { ((NearbyTabInfo)this.a.mTabInfos.get(paramInt)).getTabName(), Integer.valueOf(j) });
        }
        i = j;
      }
      NearbyUtils.b((AppInterface)this.a.app, "switch_tab", i);
    }
    localObject = this.a.getFragmentByIndex(paramInt);
    if (((NearbyTabInfo)this.a.mTabInfos.get(paramInt)).getTabType() == 7)
    {
      ((NearbyTabInfo)this.a.mTabInfos.get(paramInt)).setShowRedRot(false);
      NearbyActivity localNearbyActivity = this.a;
      NearbyActivity.access$000(localNearbyActivity, localNearbyActivity.mBarView.b(this.a.mTabBarIndex));
    }
    if (localObject != null) {
      ((NearbyBaseFragment)localObject).dw_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.3
 * JD-Core Version:    0.7.0.1
 */