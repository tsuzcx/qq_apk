package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class NavigateBarManager$2
  implements Animation.AnimationListener
{
  NavigateBarManager$2(NavigateBarManager paramNavigateBarManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NavigateBarManager.b(this.a) != null) {
      NavigateBarManager.b(this.a).setVisibility(8);
    }
    if (NavigateBarManager.a(this.a) != null) {
      NavigateBarManager.a(this.a).e();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager.2
 * JD-Core Version:    0.7.0.1
 */