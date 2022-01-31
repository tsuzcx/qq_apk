package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator
  implements ValueAnimatorCompat
{
  private long mDuration = 200L;
  private boolean mEnded = false;
  private float mFraction = 0.0F;
  List<AnimatorListenerCompat> mListeners = new ArrayList();
  private Runnable mLoopRunnable = new DonutAnimatorCompatProvider.DonutFloatValueAnimator.1(this);
  private long mStartTime;
  private boolean mStarted = false;
  View mTarget;
  List<AnimatorUpdateListenerCompat> mUpdateListeners = new ArrayList();
  
  private void dispatchCancel()
  {
    int i = this.mListeners.size() - 1;
    while (i >= 0)
    {
      ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationCancel(this);
      i -= 1;
    }
  }
  
  private void dispatchEnd()
  {
    int i = this.mListeners.size() - 1;
    while (i >= 0)
    {
      ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationEnd(this);
      i -= 1;
    }
  }
  
  private void dispatchStart()
  {
    int i = this.mListeners.size() - 1;
    while (i >= 0)
    {
      ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationStart(this);
      i -= 1;
    }
  }
  
  private long getTime()
  {
    return this.mTarget.getDrawingTime();
  }
  
  private void notifyUpdateListeners()
  {
    int i = this.mUpdateListeners.size() - 1;
    while (i >= 0)
    {
      ((AnimatorUpdateListenerCompat)this.mUpdateListeners.get(i)).onAnimationUpdate(this);
      i -= 1;
    }
  }
  
  public void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
  {
    this.mListeners.add(paramAnimatorListenerCompat);
  }
  
  public void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
  {
    this.mUpdateListeners.add(paramAnimatorUpdateListenerCompat);
  }
  
  public void cancel()
  {
    if (this.mEnded) {
      return;
    }
    this.mEnded = true;
    if (this.mStarted) {
      dispatchCancel();
    }
    dispatchEnd();
  }
  
  public float getAnimatedFraction()
  {
    return this.mFraction;
  }
  
  public void setDuration(long paramLong)
  {
    if (!this.mStarted) {
      this.mDuration = paramLong;
    }
  }
  
  public void setTarget(View paramView)
  {
    this.mTarget = paramView;
  }
  
  public void start()
  {
    if (this.mStarted) {
      return;
    }
    this.mStarted = true;
    dispatchStart();
    this.mFraction = 0.0F;
    this.mStartTime = getTime();
    this.mTarget.postDelayed(this.mLoopRunnable, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.animation.DonutAnimatorCompatProvider.DonutFloatValueAnimator
 * JD-Core Version:    0.7.0.1
 */