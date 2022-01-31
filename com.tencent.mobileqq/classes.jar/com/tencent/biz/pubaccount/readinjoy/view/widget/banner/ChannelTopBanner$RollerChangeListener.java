package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;

public class ChannelTopBanner$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected ChannelTopBanner$RollerChangeListener(ChannelTopBanner paramChannelTopBanner) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    int j = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    ChannelTopBanner localChannelTopBanner = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      localChannelTopBanner.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_Boolean) {
        break label60;
      }
    }
    label60:
    label198:
    for (;;)
    {
      return;
      bool = false;
      break;
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_Int = i;
      int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.getCount();
      if (k > 1)
      {
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.instantiateItem(null, k - 2);
          if (i != 0) {
            break label185;
          }
          paramInt = k - 2;
        }
        for (;;)
        {
          if (i == paramInt) {
            break label198;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_Int = paramInt;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setCurrentItem(paramInt, false);
          ChannelTopBanner.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner, paramInt);
          return;
          if (i != k - 2) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.instantiateItem(null, 1);
          break;
          paramInt = j;
          if (i != k - 1) {
            paramInt = i;
          }
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a(paramInt);
    if ((i >= 0) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView.length > i) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView.length > this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_Int].setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b);
      this.jdField_a_of_type_Int = i;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */