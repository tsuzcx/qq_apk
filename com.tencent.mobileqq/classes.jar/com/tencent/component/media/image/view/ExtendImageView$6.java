package com.tencent.component.media.image.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ExtendImageView$6
  implements Animation.AnimationListener
{
  ExtendImageView$6(ExtendImageView paramExtendImageView, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$postRunnable != null) {
      this.val$postRunnable.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.view.ExtendImageView.6
 * JD-Core Version:    0.7.0.1
 */