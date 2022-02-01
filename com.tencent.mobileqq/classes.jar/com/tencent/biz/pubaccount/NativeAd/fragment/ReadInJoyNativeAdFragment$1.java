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
    ((AdModuleBase)ReadInJoyNativeAdFragment.a(this.a).get(paramInt)).a();
    if (j < ReadInJoyNativeAdFragment.a(this.a).size()) {
      ((AdModuleBase)ReadInJoyNativeAdFragment.a(this.a).get(j)).b();
    }
    if ((ReadInJoyNativeAdFragment.a(this.a) != null) && (ReadInJoyNativeAdFragment.a(this.a).a == 1) && ((ReadInJoyNativeAdFragment.b(this.a) == 1) || (ReadInJoyNativeAdFragment.b(this.a) == 2))) {
      if (paramInt == ReadInJoyNativeAdFragment.a(this.a).size() - 1) {
        ReadInJoyNativeAdFragment.a(this.a).setVisibility(8);
      } else {
        ReadInJoyNativeAdFragment.a(this.a).setVisibility(0);
      }
    }
    ReadInJoyNativeAdFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.1
 * JD-Core Version:    0.7.0.1
 */