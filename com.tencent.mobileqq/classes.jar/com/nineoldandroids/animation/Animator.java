package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
  implements Cloneable
{
  ArrayList<Animator.AnimatorListener> mListeners = null;
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramAnimatorListener);
  }
  
  public void cancel() {}
  
  public Animator clone()
  {
    try
    {
      localObject = (Animator)super.clone();
      if (this.mListeners == null) {
        break label67;
      }
      localArrayList = this.mListeners;
      ((Animator)localObject).mListeners = new ArrayList();
      j = localArrayList.size();
      i = 0;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      int j;
      int i;
      label67:
      label69:
      label89:
      do
      {
        Object localObject;
        ArrayList localArrayList;
        break label69;
      } while (i < j);
      return localCloneNotSupportedException;
    }
    ((Animator)localObject).mListeners.add((Animator.AnimatorListener)localArrayList.get(i));
    i += 1;
    break label89;
    return localObject;
    localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void end() {}
  
  public abstract long getDuration();
  
  public ArrayList<Animator.AnimatorListener> getListeners()
  {
    return this.mListeners;
  }
  
  public abstract long getStartDelay();
  
  public abstract boolean isRunning();
  
  public boolean isStarted()
  {
    return isRunning();
  }
  
  public void removeAllListeners()
  {
    ArrayList localArrayList = this.mListeners;
    if (localArrayList != null)
    {
      localArrayList.clear();
      this.mListeners = null;
    }
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ArrayList localArrayList = this.mListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAnimatorListener);
    if (this.mListeners.size() == 0) {
      this.mListeners = null;
    }
  }
  
  public abstract Animator setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public abstract void setStartDelay(long paramLong);
  
  public void setTarget(Object paramObject) {}
  
  public void setupEndValues() {}
  
  public void setupStartValues() {}
  
  public void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.Animator
 * JD-Core Version:    0.7.0.1
 */