package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import java.util.ArrayList;

class ReadInJoyNativeAdFragment$1
  implements ViewPager.OnPageChangeListener
{
  ReadInJoyNativeAdFragment$1(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReadInJoyNativeAdFragment localReadInJoyNativeAdFragment = this.a;
    int i = ReadInJoyNativeAdFragment.a(localReadInJoyNativeAdFragment);
    int j = paramInt + 1;
    ReadInJoyNativeAdFragment.a(localReadInJoyNativeAdFragment, Math.max(i, j));
    ((AdModuleBase)ReadInJoyNativeAdFragment.b(this.a).get(paramInt)).a();
    if (j < ReadInJoyNativeAdFragment.b(this.a).size()) {
      ((AdModuleBase)ReadInJoyNativeAdFragment.b(this.a).get(j)).b();
    }
    if ((ReadInJoyNativeAdFragment.c(this.a) != null) && (ReadInJoyNativeAdFragment.c(this.a).a == 1) && ((ReadInJoyNativeAdFragment.d(this.a) == 1) || (ReadInJoyNativeAdFragment.d(this.a) == 2))) {
      if (paramInt == ReadInJoyNativeAdFragment.b(this.a).size() - 1) {
        ReadInJoyNativeAdFragment.e(this.a).setVisibility(8);
      } else {
        ReadInJoyNativeAdFragment.e(this.a).setVisibility(0);
      }
    }
    ReadInJoyNativeAdFragment.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.1
 * JD-Core Version:    0.7.0.1
 */