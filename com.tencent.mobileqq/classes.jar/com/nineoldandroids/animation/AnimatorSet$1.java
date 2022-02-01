package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$1
  extends AnimatorListenerAdapter
{
  boolean canceled = false;
  
  AnimatorSet$1(AnimatorSet paramAnimatorSet, ArrayList paramArrayList) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.canceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.canceled)
    {
      int j = this.val$nodesToStart.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        paramAnimator = (AnimatorSet.Node)this.val$nodesToStart.get(i);
        paramAnimator.animation.start();
        AnimatorSet.access$2(this.this$0).add(paramAnimator.animation);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.1
 * JD-Core Version:    0.7.0.1
 */