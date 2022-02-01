package com.tencent.biz.pubaccount.Advertisement.fragment;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;

class VideoCoverFragment$1
  implements ViewPager.OnPageChangeListener
{
  VideoCoverFragment$1(VideoCoverFragment paramVideoCoverFragment, ViewPager.OnPageChangeListener paramOnPageChangeListener) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment, paramInt);
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(paramInt);
    }
    if (VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment) != null) {
      VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).a(paramInt);
    }
    if (VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment) != null) {
      VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).a().setProgress(paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.1
 * JD-Core Version:    0.7.0.1
 */