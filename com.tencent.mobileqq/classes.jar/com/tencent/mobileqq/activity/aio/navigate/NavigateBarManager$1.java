package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class NavigateBarManager$1
  implements Animation.AnimationListener
{
  NavigateBarManager$1(NavigateBarManager paramNavigateBarManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NavigateBarManager.a(this.a) != null) {
      NavigateBarManager.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager.1
 * JD-Core Version:    0.7.0.1
 */