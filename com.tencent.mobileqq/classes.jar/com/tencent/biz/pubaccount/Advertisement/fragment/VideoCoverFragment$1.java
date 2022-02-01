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
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.a;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.a;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    VideoCoverFragment.a(this.b, paramInt);
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.a;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(paramInt);
    }
    if (VideoCoverFragment.a(this.b) != null) {
      VideoCoverFragment.a(this.b).a(paramInt);
    }
    if (VideoCoverFragment.b(this.b) != null) {
      VideoCoverFragment.b(this.b).getSplitedProgressBar().setProgress(paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.1
 * JD-Core Version:    0.7.0.1
 */