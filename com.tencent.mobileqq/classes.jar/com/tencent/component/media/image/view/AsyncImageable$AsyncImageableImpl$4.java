package com.tencent.component.media.image.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class AsyncImageable$AsyncImageableImpl$4
  implements Animation.AnimationListener
{
  AsyncImageable$AsyncImageableImpl$4(Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.val$postRunnable;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.4
 * JD-Core Version:    0.7.0.1
 */