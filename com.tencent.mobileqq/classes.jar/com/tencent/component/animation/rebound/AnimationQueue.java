package com.tencent.component.animation.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnimationQueue
{
  private final Queue<Double> mAnimationQueue = new LinkedList();
  private final List<AnimationQueue.Callback> mCallbacks = new ArrayList();
  private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
  private final ChoreographerCompat.FrameCallback mChoreographerCallback = new AnimationQueue.1(this);
  private final Queue<Double> mPendingQueue = new LinkedList();
  private boolean mRunning;
  private final ArrayList<Double> mTempValues = new ArrayList();
  
  private void onFrame(long paramLong)
  {
    Double localDouble = (Double)this.mPendingQueue.poll();
    int i;
    if (localDouble != null)
    {
      this.mAnimationQueue.offer(localDouble);
      i = 0;
    }
    else
    {
      i = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
    }
    this.mTempValues.addAll(this.mAnimationQueue);
    int j = this.mTempValues.size() - 1;
    for (;;)
    {
      if (j <= -1)
      {
        this.mTempValues.clear();
        for (;;)
        {
          if (this.mAnimationQueue.size() + i < this.mCallbacks.size())
          {
            if ((this.mAnimationQueue.isEmpty()) && (this.mPendingQueue.isEmpty()))
            {
              this.mRunning = false;
              return;
            }
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
            return;
          }
          this.mAnimationQueue.poll();
        }
      }
      localDouble = (Double)this.mTempValues.get(j);
      int k = this.mTempValues.size() - 1 - j + i;
      if (this.mCallbacks.size() > k) {
        ((AnimationQueue.Callback)this.mCallbacks.get(k)).onFrame(localDouble);
      }
      j -= 1;
    }
  }
  
  private void runIfIdle()
  {
    if (!this.mRunning)
    {
      this.mRunning = true;
      this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
    }
  }
  
  public void addAllValues(Collection<Double> paramCollection)
  {
    this.mPendingQueue.addAll(paramCollection);
    runIfIdle();
  }
  
  public void addCallback(AnimationQueue.Callback paramCallback)
  {
    this.mCallbacks.add(paramCallback);
  }
  
  public void addValue(Double paramDouble)
  {
    this.mPendingQueue.add(paramDouble);
    runIfIdle();
  }
  
  public void clearCallbacks()
  {
    this.mCallbacks.clear();
  }
  
  public void clearValues()
  {
    this.mPendingQueue.clear();
  }
  
  public void removeCallback(AnimationQueue.Callback paramCallback)
  {
    this.mCallbacks.remove(paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AnimationQueue
 * JD-Core Version:    0.7.0.1
 */