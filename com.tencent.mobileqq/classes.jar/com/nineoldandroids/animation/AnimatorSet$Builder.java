package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimatorSet$Builder
{
  private AnimatorSet.Node mCurrentNode;
  
  AnimatorSet$Builder(AnimatorSet paramAnimatorSet, Animator paramAnimator)
  {
    this.mCurrentNode = ((AnimatorSet.Node)AnimatorSet.access$3(paramAnimatorSet).get(paramAnimator));
    if (this.mCurrentNode == null)
    {
      this.mCurrentNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$3(paramAnimatorSet).put(paramAnimator, this.mCurrentNode);
      AnimatorSet.access$6(paramAnimatorSet).add(this.mCurrentNode);
    }
  }
  
  public Builder after(long paramLong)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramLong);
    after(localValueAnimator);
    return this;
  }
  
  public Builder after(Animator paramAnimator)
  {
    AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.access$3(this.this$0).get(paramAnimator);
    AnimatorSet.Node localNode1 = localNode2;
    if (localNode2 == null)
    {
      localNode1 = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$3(this.this$0).put(paramAnimator, localNode1);
      AnimatorSet.access$6(this.this$0).add(localNode1);
    }
    paramAnimator = new AnimatorSet.Dependency(localNode1, 1);
    this.mCurrentNode.addDependency(paramAnimator);
    return this;
  }
  
  public Builder before(Animator paramAnimator)
  {
    AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.access$3(this.this$0).get(paramAnimator);
    AnimatorSet.Node localNode1 = localNode2;
    if (localNode2 == null)
    {
      localNode1 = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$3(this.this$0).put(paramAnimator, localNode1);
      AnimatorSet.access$6(this.this$0).add(localNode1);
    }
    localNode1.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 1));
    return this;
  }
  
  public Builder with(Animator paramAnimator)
  {
    AnimatorSet.Node localNode2 = (AnimatorSet.Node)AnimatorSet.access$3(this.this$0).get(paramAnimator);
    AnimatorSet.Node localNode1 = localNode2;
    if (localNode2 == null)
    {
      localNode1 = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$3(this.this$0).put(paramAnimator, localNode1);
      AnimatorSet.access$6(this.this$0).add(localNode1);
    }
    localNode1.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 0));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.Builder
 * JD-Core Version:    0.7.0.1
 */