package com.tencent.mobileqq.app;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

final class BabyQHandler$1
  implements Animation.AnimationListener
{
  BabyQHandler$1(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a != null) && (this.a.getVisibility() == 0))
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.getContext(), 2130772245);
      paramAnimation.setAnimationListener(this);
      this.a.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQHandler.1
 * JD-Core Version:    0.7.0.1
 */