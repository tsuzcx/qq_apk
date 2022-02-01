package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

class TabLayoutCompat$AdapterChangeListener
  implements ViewPagerCompat.OnAdapterChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  TabLayoutCompat$AdapterChangeListener(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void a(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a == paramViewPager) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(paramPagerAdapter2, this.jdField_a_of_type_Boolean);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.AdapterChangeListener
 * JD-Core Version:    0.7.0.1
 */