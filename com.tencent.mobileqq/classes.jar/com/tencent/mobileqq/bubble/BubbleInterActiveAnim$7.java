package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

class BubbleInterActiveAnim$7
  extends AnimatorListenerAdapter
{
  BubbleInterActiveAnim$7(BubbleInterActiveAnim paramBubbleInterActiveAnim, BubbleInterActiveAnim.AnimHolder paramAnimHolder, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.e.setVisibility(0);
    }
    this.b.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.7
 * JD-Core Version:    0.7.0.1
 */