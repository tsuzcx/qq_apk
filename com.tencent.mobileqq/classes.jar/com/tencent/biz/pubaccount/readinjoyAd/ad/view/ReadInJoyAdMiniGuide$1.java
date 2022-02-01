package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ReadInJoyAdMiniGuide$1
  implements Animation.AnimationListener
{
  ReadInJoyAdMiniGuide$1(ReadInJoyAdMiniGuide paramReadInJoyAdMiniGuide, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = this.a;
    if (i == 1)
    {
      this.b.a();
      return;
    }
    if (i == 3) {
      this.b.b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide.1
 * JD-Core Version:    0.7.0.1
 */