package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VideofeedsUserGuideController$3
  implements Animation.AnimationListener
{
  VideofeedsUserGuideController$3(VideofeedsUserGuideController paramVideofeedsUserGuideController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)VideofeedsUserGuideController.a(this.a).findViewById(2131381047);
    ImageView localImageView = (ImageView)VideofeedsUserGuideController.a(this.a).findViewById(2131381048);
    VideofeedsUserGuideController.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.3
 * JD-Core Version:    0.7.0.1
 */