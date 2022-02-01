package com.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$Node
  implements Cloneable
{
  public Animator animation;
  public ArrayList<AnimatorSet.Dependency> dependencies = null;
  public boolean done = false;
  public ArrayList<Node> nodeDependencies = null;
  public ArrayList<Node> nodeDependents = null;
  public ArrayList<AnimatorSet.Dependency> tmpDependencies = null;
  
  public AnimatorSet$Node(Animator paramAnimator)
  {
    this.animation = paramAnimator;
  }
  
  public void addDependency(AnimatorSet.Dependency paramDependency)
  {
    if (this.dependencies == null)
    {
      this.dependencies = new ArrayList();
      this.nodeDependencies = new ArrayList();
    }
    this.dependencies.add(paramDependency);
    if (!this.nodeDependencies.contains(paramDependency.node)) {
      this.nodeDependencies.add(paramDependency.node);
    }
    paramDependency = paramDependency.node;
    if (paramDependency.nodeDependents == null) {
      paramDependency.nodeDependents = new ArrayList();
    }
    paramDependency.nodeDependents.add(this);
  }
  
  public Node clone()
  {
    try
    {
      Node localNode = (Node)super.clone();
      localNode.animation = this.animation.clone();
      return localNode;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label21:
      break label21;
    }
    throw new AssertionError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.Node
 * JD-Core Version:    0.7.0.1
 */