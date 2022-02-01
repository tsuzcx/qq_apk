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
    if ((!this.this$0.mTerminated) && (AnimatorSet.access$2(this.this$0).size() == 0) && (this.this$0.mListeners != null))
    {
      int j = this.this$0.mListeners.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        ((Animator.AnimatorListener)this.this$0.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
        i += 1;
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.removeListener(this);
    AnimatorSet.access$2(this.this$0).remove(paramAnimator);
    paramAnimator = (AnimatorSet.Node)AnimatorSet.access$3(this.mAnimatorSet).get(paramAnimator);
    int j = 1;
    paramAnimator.done = true;
    if (!this.this$0.mTerminated)
    {
      paramAnimator = AnimatorSet.access$4(this.mAnimatorSet);
      int k = paramAnimator.size();
      int i = 0;
      for (;;)
      {
        if (i >= k)
        {
          i = j;
        }
        else
        {
          if (((AnimatorSet.Node)paramAnimator.get(i)).done) {
            break label168;
          }
          i = 0;
        }
        if (i == 0) {
          break;
        }
        if (this.this$0.mListeners != null)
        {
          paramAnimator = (ArrayList)this.this$0.mListeners.clone();
          j = paramAnimator.size();
          i = 0;
          while (i < j)
          {
            ((Animator.AnimatorListener)paramAnimator.get(i)).onAnimationEnd(this.mAnimatorSet);
            i += 1;
          }
        }
        AnimatorSet.access$5(this.mAnimatorSet, false);
        return;
        label168:
        i += 1;
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.AnimatorSetListener
 * JD-Core Version:    0.7.0.1
 */