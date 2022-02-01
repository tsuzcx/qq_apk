package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ReadInJoyAdMiniGuide$2
  implements Animation.AnimationListener
{
  ReadInJoyAdMiniGuide$2(ReadInJoyAdMiniGuide paramReadInJoyAdMiniGuide, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
    if (this.b == 0) {
      ReadInJoyAdMiniGuide.a(this.c);
    }
    if (this.b == 2) {
      ReadInJoyAdMiniGuide.b(this.c);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide.2
 * JD-Core Version:    0.7.0.1
 */