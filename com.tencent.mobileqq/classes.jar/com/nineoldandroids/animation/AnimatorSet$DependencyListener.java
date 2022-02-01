package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$DependencyListener
  implements Animator.AnimatorListener
{
  private AnimatorSet mAnimatorSet;
  private AnimatorSet.Node mNode;
  private int mRule;
  
  public AnimatorSet$DependencyListener(AnimatorSet paramAnimatorSet, AnimatorSet.Node paramNode, int paramInt)
  {
    this.mAnimatorSet = paramAnimatorSet;
    this.mNode = paramNode;
    this.mRule = paramInt;
  }
  
  private void startIfReady(Animator paramAnimator)
  {
    if (this.mAnimatorSet.mTerminated) {
      return;
    }
    Object localObject = null;
    int j = this.mNode.tmpDependencies.size();
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramAnimator = localObject;
      }
      else
      {
        AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)this.mNode.tmpDependencies.get(i);
        if ((localDependency.rule != this.mRule) || (localDependency.node.animation != paramAnimator)) {
          break label140;
        }
        paramAnimator.removeListener(this);
        paramAnimator = localDependency;
      }
      this.mNode.tmpDependencies.remove(paramAnimator);
      if (this.mNode.tmpDependencies.size() == 0)
      {
        this.mNode.animation.start();
        AnimatorSet.access$2(this.mAnimatorSet).add(this.mNode.animation);
      }
      return;
      label140:
      i += 1;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mRule == 1) {
      startIfReady(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.mRule == 0) {
      startIfReady(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.DependencyListener
 * JD-Core Version:    0.7.0.1
 */