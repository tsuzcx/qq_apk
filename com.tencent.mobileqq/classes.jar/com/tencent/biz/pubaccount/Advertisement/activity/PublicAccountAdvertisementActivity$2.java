package com.tencent.biz.pubaccount.Advertisement.activity;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class PublicAccountAdvertisementActivity$2
  implements ViewPager.OnPageChangeListener
{
  PublicAccountAdvertisementActivity$2(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    PublicAccountAdvertisementActivity localPublicAccountAdvertisementActivity = this.a;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    PublicAccountAdvertisementActivity.a(localPublicAccountAdvertisementActivity, bool);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    PublicAccountAdvertisementActivity localPublicAccountAdvertisementActivity = this.a;
    boolean bool;
    if (paramInt2 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    PublicAccountAdvertisementActivity.a(localPublicAccountAdvertisementActivity, bool);
  }
  
  public void onPageSelected(int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.2
 * JD-Core Version:    0.7.0.1
 */