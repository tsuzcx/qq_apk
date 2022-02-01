package com.tencent.biz.subscribe.widget;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.ArrayList;

class SubscribeBannerView$1
  implements ViewPager.OnPageChangeListener
{
  SubscribeBannerView$1(SubscribeBannerView paramSubscribeBannerView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((SubscribeBannerView.a(this.a) != null) && (SubscribeBannerView.b(this.a) != null)) {
      SubscribeBannerView.a(this.a).setDotsSelected(paramInt % SubscribeBannerView.b(this.a).a().size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView.1
 * JD-Core Version:    0.7.0.1
 */