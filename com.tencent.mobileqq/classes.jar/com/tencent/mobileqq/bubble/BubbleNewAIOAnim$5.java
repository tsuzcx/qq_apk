package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

class BubbleNewAIOAnim$5
  extends AnimatorListenerAdapter
{
  BubbleNewAIOAnim$5(BubbleNewAIOAnim paramBubbleNewAIOAnim, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.b.t != null) {
      this.b.t.setVisibility(0);
    }
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.5
 * JD-Core Version:    0.7.0.1
 */