package com.tencent.av.smallscreen.api.impl;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SmallScreenUtilsApiImpl$1
  implements Animation.AnimationListener
{
  SmallScreenUtilsApiImpl$1(SmallScreenUtilsApiImpl paramSmallScreenUtilsApiImpl, View paramView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    int i;
    if (this.b) {
      i = 0;
    } else {
      i = 8;
    }
    paramAnimation.setVisibility(i);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.impl.SmallScreenUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */