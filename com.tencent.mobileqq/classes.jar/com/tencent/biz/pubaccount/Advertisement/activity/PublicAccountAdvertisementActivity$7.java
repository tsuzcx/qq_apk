package com.tencent.biz.pubaccount.Advertisement.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PublicAccountAdvertisementActivity$7
  implements Animation.AnimationListener
{
  PublicAccountAdvertisementActivity$7(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setResult(-1);
    PublicAccountAdvertisementActivity.g(this.a);
    PublicAccountAdvertisementActivity.a(this.a, 0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.7
 * JD-Core Version:    0.7.0.1
 */