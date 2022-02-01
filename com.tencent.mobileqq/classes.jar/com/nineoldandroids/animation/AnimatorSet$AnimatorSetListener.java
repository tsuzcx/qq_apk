package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

class AnimatorSet$AnimatorSetListener
  implements Animator.AnimatorListener
{
  private AnimatorSet mAnimatorSet;
  
  AnimatorSet$AnimatorSetListener(AnimatorSet paramAnimatorSet1, AnimatorSet paramAnimatorSet2)
  {
    this.mAnimatorSet = paramAnimatorSet2;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    int j;
    int i;
    if ((!this.this$0.mTerminated) && (AnimatorSet.access$2(this.this$0).size() == 0) && (this.this$0.mListeners != null))
    {
      j = this.this$0.mListeners.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ((Animator.AnimatorListener)this.this$0.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
      i += 1;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.removeListener(this);
    AnimatorSet.access$2(this.this$0).remove(paramAnimator);
    ((AnimatorSet.Node)AnimatorSet.access$3(this.mAnimatorSet).get(paramAnimator)).done = true;
    int j;
    int i;
    if (!this.this$0.mTerminated)
    {
      paramAnimator = AnimatorSet.access$4(this.mAnimatorSet);
      j = paramAnimator.size();
      i = 0;
      if (i < j) {
        break label116;
      }
      i = 1;
      label67:
      if (i != 0) {
        if (this.this$0.mListeners != null)
        {
          paramAnimator = (ArrayList)this.this$0.mListeners.clone();
          j = paramAnimator.size();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        AnimatorSet.access$5(this.mAnimatorSet, false);
        return;
        label116:
        if (!((AnimatorSet.Node)paramAnimator.get(i)).done)
        {
          i = 0;
          break label67;
        }
        i += 1;
        break;
      }
      ((Animator.AnimatorListener)paramAnimator.get(i)).onAnimationEnd(this.mAnimatorSet);
      i += 1;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.AnimatorSetListener
 * JD-Core Version:    0.7.0.1
 */