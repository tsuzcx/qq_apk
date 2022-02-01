package com.tencent.mobileqq.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
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
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.f), Integer.valueOf(paramInt) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.a(paramInt, this.a.b);
    }
    Object localObject = this.a;
    int i = ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabIndex;
    ((NearbyActivity)localObject).b = i;
    NearbyBaseFragment.b = i;
    if ((this.a.i == 0L) && (this.a.b == 2))
    {
      this.a.i = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.i) });
      }
    }
    if ((this.a.jdField_a_of_type_Long == 0L) && (this.a.b == 1))
    {
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mNowClickTime", new Object[] { "onPageSelected", Long.valueOf(this.a.jdField_a_of_type_Long) });
      }
    }
    if (this.a.f != paramInt) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    }
    if (this.a.f != -1)
    {
      i = this.a.f;
      if (this.a.f != this.a.c) {
        break label503;
      }
      i = 9;
    }
    for (;;)
    {
      if (TextUtils.equals(HardCodeUtil.a(2131707104), ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName)) {
        i = 11;
      }
      int j = ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).reportId;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("report_switch_tab", new Object[] { ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabName, Integer.valueOf(j) });
        }
        i = j;
      }
      NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "switch_tab", i);
      localObject = this.a.a(paramInt);
      if (((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).tabType == 7)
      {
        ((NearbyTabInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).showRedRot = false;
        NearbyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(this.a.f));
      }
      if (localObject != null) {
        ((NearbyBaseFragment)localObject).aE_();
      }
      return;
      label503:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.3
 * JD-Core Version:    0.7.0.1
 */