package com.nineoldandroids.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator
  extends Animator
{
  static final int ANIMATION_FRAME = 1;
  static final int ANIMATION_START = 0;
  private static final long DEFAULT_FRAME_DELAY = 10L;
  public static final int INFINITE = -1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  static final int RUNNING = 1;
  static final int SEEKED = 2;
  static final int STOPPED = 0;
  private static ThreadLocal<ValueAnimator.AnimationHandler> sAnimationHandler = new ThreadLocal();
  private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ValueAnimator.1();
  private static final Interpolator sDefaultInterpolator;
  private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims;
  private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims;
  private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
  private static long sFrameDelay = 10L;
  private static final TypeEvaluator sIntEvaluator;
  private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ValueAnimator.2();
  private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims;
  private float mCurrentFraction = 0.0F;
  private int mCurrentIteration = 0;
  private long mDelayStartTime;
  private long mDuration = 300L;
  boolean mInitialized = false;
  private Interpolator mInterpolator = sDefaultInterpolator;
  private boolean mPlayingBackwards = false;
  int mPlayingState = 0;
  private int mRepeatCount = 0;
  private int mRepeatMode = 1;
  private boolean mRunning = false;
  long mSeekTime = -1L;
  private long mStartDelay = 0L;
  long mStartTime;
  private boolean mStarted = false;
  private boolean mStartedDelay = false;
  private ArrayList<ValueAnimator.AnimatorUpdateListener> mUpdateListeners = null;
  PropertyValuesHolder[] mValues;
  HashMap<String, PropertyValuesHolder> mValuesMap;
  
  static
  {
    sDelayedAnims = new ValueAnimator.3();
    sEndingAnims = new ValueAnimator.4();
    sReadyAnims = new ValueAnimator.5();
    sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    sIntEvaluator = new IntEvaluator();
  }
  
  public static void clearAllAnimations()
  {
    ((ArrayList)sAnimations.get()).clear();
    ((ArrayList)sPendingAnimations.get()).clear();
    ((ArrayList)sDelayedAnims.get()).clear();
  }
  
  private boolean delayedAnimationFrame(long paramLong)
  {
    if (!this.mStartedDelay)
    {
      this.mStartedDelay = true;
      this.mDelayStartTime = paramLong;
    }
    else
    {
      long l1 = paramLong - this.mDelayStartTime;
      long l2 = this.mStartDelay;
      if (l1 > l2)
      {
        this.mStartTime = (paramLong - (l1 - l2));
        this.mPlayingState = 1;
        return true;
      }
    }
    return false;
  }
  
  private void endAnimation()
  {
    ((ArrayList)sAnimations.get()).remove(this);
    ((ArrayList)sPendingAnimations.get()).remove(this);
    ((ArrayList)sDelayedAnims.get()).remove(this);
    this.mPlayingState = 0;
    if ((this.mRunning) && (this.mListeners != null))
    {
      ArrayList localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Animator.AnimatorListener)localArrayList.get(i)).onAnimationEnd(this);
        i += 1;
      }
    }
    this.mRunning = false;
    this.mStarted = false;
  }
  
  public static int getCurrentAnimationsCount()
  {
    return ((ArrayList)sAnimations.get()).size();
  }
  
  public static long getFrameDelay()
  {
    return sFrameDelay;
  }
  
  public static ValueAnimator ofFloat(float... paramVarArgs)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(paramVarArgs);
    return localValueAnimator;
  }
  
  public static ValueAnimator ofInt(int... paramVarArgs)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(paramVarArgs);
    return localValueAnimator;
  }
  
  public static ValueAnimator ofObject(TypeEvaluator paramTypeEvaluator, Object... paramVarArgs)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(paramVarArgs);
    localValueAnimator.setEvaluator(paramTypeEvaluator);
    return localValueAnimator;
  }
  
  public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... paramVarArgs)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setValues(paramVarArgs);
    return localValueAnimator;
  }
  
  public static void setFrameDelay(long paramLong)
  {
    sFrameDelay = paramLong;
  }
  
  private void start(boolean paramBoolean)
  {
    if (Looper.myLooper() != null)
    {
      this.mPlayingBackwards = paramBoolean;
      this.mCurrentIteration = 0;
      this.mPlayingState = 0;
      this.mStarted = true;
      this.mStartedDelay = false;
      ((ArrayList)sPendingAnimations.get()).add(this);
      if (this.mStartDelay == 0L)
      {
        setCurrentPlayTime(getCurrentPlayTime());
        this.mPlayingState = 0;
        this.mRunning = true;
        if (this.mListeners != null)
        {
          localObject = (ArrayList)this.mListeners.clone();
          int j = ((ArrayList)localObject).size();
          int i = 0;
          while (i < j)
          {
            ((Animator.AnimatorListener)((ArrayList)localObject).get(i)).onAnimationStart(this);
            i += 1;
          }
        }
      }
      ValueAnimator.AnimationHandler localAnimationHandler = (ValueAnimator.AnimationHandler)sAnimationHandler.get();
      localObject = localAnimationHandler;
      if (localAnimationHandler == null)
      {
        localObject = new ValueAnimator.AnimationHandler(null);
        sAnimationHandler.set(localObject);
      }
      ((ValueAnimator.AnimationHandler)localObject).sendEmptyMessage(0);
      return;
    }
    Object localObject = new AndroidRuntimeException("Animators may only be run on Looper threads");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void startAnimation()
  {
    initAnimation();
    ((ArrayList)sAnimations.get()).add(this);
    if ((this.mStartDelay > 0L) && (this.mListeners != null))
    {
      ArrayList localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        ((Animator.AnimatorListener)localArrayList.get(i)).onAnimationStart(this);
        i += 1;
      }
    }
  }
  
  public void addUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.mUpdateListeners == null) {
      this.mUpdateListeners = new ArrayList();
    }
    this.mUpdateListeners.add(paramAnimatorUpdateListener);
  }
  
  void animateValue(float paramFloat)
  {
    paramFloat = this.mInterpolator.getInterpolation(paramFloat);
    this.mCurrentFraction = paramFloat;
    int k = this.mValues.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= k)
      {
        ArrayList localArrayList = this.mUpdateListeners;
        if (localArrayList != null)
        {
          k = localArrayList.size();
          i = j;
          for (;;)
          {
            if (i >= k) {
              return;
            }
            ((ValueAnimator.AnimatorUpdateListener)this.mUpdateListeners.get(i)).onAnimationUpdate(this);
            i += 1;
          }
        }
        return;
      }
      this.mValues[i].calculateValue(paramFloat);
      i += 1;
    }
  }
  
  boolean animationFrame(long paramLong)
  {
    if (this.mPlayingState == 0)
    {
      this.mPlayingState = 1;
      l = this.mSeekTime;
      if (l < 0L)
      {
        this.mStartTime = paramLong;
      }
      else
      {
        this.mStartTime = (paramLong - l);
        this.mSeekTime = -1L;
      }
    }
    int i = this.mPlayingState;
    boolean bool2 = false;
    if ((i != 1) && (i != 2)) {
      return false;
    }
    long l = this.mDuration;
    if (l > 0L) {
      f2 = (float)(paramLong - this.mStartTime) / (float)l;
    } else {
      f2 = 1.0F;
    }
    boolean bool1 = bool2;
    float f1 = f2;
    if (f2 >= 1.0F)
    {
      i = this.mCurrentIteration;
      int j = this.mRepeatCount;
      if ((i >= j) && (j != -1))
      {
        f1 = Math.min(f2, 1.0F);
        bool1 = true;
      }
      else
      {
        if (this.mListeners != null)
        {
          j = this.mListeners.size();
          i = 0;
          while (i < j)
          {
            ((Animator.AnimatorListener)this.mListeners.get(i)).onAnimationRepeat(this);
            i += 1;
          }
        }
        if (this.mRepeatMode == 2) {
          this.mPlayingBackwards ^= true;
        }
        this.mCurrentIteration += (int)f2;
        f1 = f2 % 1.0F;
        this.mStartTime += this.mDuration;
        bool1 = bool2;
      }
    }
    float f2 = f1;
    if (this.mPlayingBackwards) {
      f2 = 1.0F - f1;
    }
    animateValue(f2);
    return bool1;
  }
  
  public void cancel()
  {
    if ((this.mPlayingState != 0) || (((ArrayList)sPendingAnimations.get()).contains(this)) || (((ArrayList)sDelayedAnims.get()).contains(this)))
    {
      if ((this.mRunning) && (this.mListeners != null))
      {
        Iterator localIterator = ((ArrayList)this.mListeners.clone()).iterator();
        while (localIterator.hasNext()) {
          ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
        }
      }
      endAnimation();
    }
  }
  
  public ValueAnimator clone()
  {
    ValueAnimator localValueAnimator = (ValueAnimator)super.clone();
    Object localObject = this.mUpdateListeners;
    int j = 0;
    int k;
    int i;
    if (localObject != null)
    {
      localValueAnimator.mUpdateListeners = new ArrayList();
      k = ((ArrayList)localObject).size();
      i = 0;
      while (i < k)
      {
        localValueAnimator.mUpdateListeners.add((ValueAnimator.AnimatorUpdateListener)((ArrayList)localObject).get(i));
        i += 1;
      }
    }
    localValueAnimator.mSeekTime = -1L;
    localValueAnimator.mPlayingBackwards = false;
    localValueAnimator.mCurrentIteration = 0;
    localValueAnimator.mInitialized = false;
    localValueAnimator.mPlayingState = 0;
    localValueAnimator.mStartedDelay = false;
    localObject = this.mValues;
    if (localObject != null)
    {
      k = localObject.length;
      localValueAnimator.mValues = new PropertyValuesHolder[k];
      localValueAnimator.mValuesMap = new HashMap(k);
      i = j;
      for (;;)
      {
        if (i >= k) {
          return localValueAnimator;
        }
        PropertyValuesHolder localPropertyValuesHolder = localObject[i].clone();
        localValueAnimator.mValues[i] = localPropertyValuesHolder;
        localValueAnimator.mValuesMap.put(localPropertyValuesHolder.getPropertyName(), localPropertyValuesHolder);
        i += 1;
      }
    }
    return localValueAnimator;
  }
  
  public void end()
  {
    if ((!((ArrayList)sAnimations.get()).contains(this)) && (!((ArrayList)sPendingAnimations.get()).contains(this)))
    {
      this.mStartedDelay = false;
      startAnimation();
    }
    else if (!this.mInitialized)
    {
      initAnimation();
    }
    int i = this.mRepeatCount;
    if ((i > 0) && ((i & 0x1) == 1)) {
      animateValue(0.0F);
    } else {
      animateValue(1.0F);
    }
    endAnimation();
  }
  
  public float getAnimatedFraction()
  {
    return this.mCurrentFraction;
  }
  
  public Object getAnimatedValue()
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.mValues;
    if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length > 0)) {
      return arrayOfPropertyValuesHolder[0].getAnimatedValue();
    }
    return null;
  }
  
  public Object getAnimatedValue(String paramString)
  {
    paramString = (PropertyValuesHolder)this.mValuesMap.get(paramString);
    if (paramString != null) {
      return paramString.getAnimatedValue();
    }
    return null;
  }
  
  public long getCurrentPlayTime()
  {
    if ((this.mInitialized) && (this.mPlayingState != 0)) {
      return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }
    return 0L;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public int getRepeatCount()
  {
    return this.mRepeatCount;
  }
  
  public int getRepeatMode()
  {
    return this.mRepeatMode;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  public PropertyValuesHolder[] getValues()
  {
    return this.mValues;
  }
  
  void initAnimation()
  {
    if (!this.mInitialized)
    {
      int j = this.mValues.length;
      int i = 0;
      for (;;)
      {
        if (i >= j)
        {
          this.mInitialized = true;
          return;
        }
        this.mValues[i].init();
        i += 1;
      }
    }
  }
  
  public boolean isRunning()
  {
    return (this.mPlayingState == 1) || (this.mRunning);
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public void removeAllUpdateListeners()
  {
    ArrayList localArrayList = this.mUpdateListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList.clear();
    this.mUpdateListeners = null;
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    ArrayList localArrayList = this.mUpdateListeners;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAnimatorUpdateListener);
    if (this.mUpdateListeners.size() == 0) {
      this.mUpdateListeners = null;
    }
  }
  
  public void reverse()
  {
    this.mPlayingBackwards ^= true;
    if (this.mPlayingState == 1)
    {
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.mStartTime;
      this.mStartTime = (l1 - (this.mDuration - (l1 - l2)));
      return;
    }
    start(true);
  }
  
  public void setCurrentPlayTime(long paramLong)
  {
    initAnimation();
    long l = AnimationUtils.currentAnimationTimeMillis();
    if (this.mPlayingState != 1)
    {
      this.mSeekTime = paramLong;
      this.mPlayingState = 2;
    }
    this.mStartTime = (l - paramLong);
    animationFrame(l);
  }
  
  public ValueAnimator setDuration(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.mDuration = paramLong;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Animators cannot have negative duration: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    if (paramTypeEvaluator != null)
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.mValues;
      if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length > 0)) {
        arrayOfPropertyValuesHolder[0].setEvaluator(paramTypeEvaluator);
      }
    }
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.mValues;
      if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length != 0)) {
        arrayOfPropertyValuesHolder[0].setFloatValues(paramVarArgs);
      } else {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("", paramVarArgs) });
      }
      this.mInitialized = false;
    }
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.mValues;
      if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length != 0)) {
        arrayOfPropertyValuesHolder[0].setIntValues(paramVarArgs);
      } else {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("", paramVarArgs) });
      }
      this.mInitialized = false;
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null)
    {
      this.mInterpolator = paramInterpolator;
      return;
    }
    this.mInterpolator = new LinearInterpolator();
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = this.mValues;
      if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length != 0)) {
        arrayOfPropertyValuesHolder[0].setObjectValues(paramVarArgs);
      } else {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("", null, paramVarArgs) });
      }
      this.mInitialized = false;
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.mRepeatCount = paramInt;
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.mRepeatMode = paramInt;
  }
  
  public void setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
  }
  
  public void setValues(PropertyValuesHolder... paramVarArgs)
  {
    int j = paramVarArgs.length;
    this.mValues = paramVarArgs;
    this.mValuesMap = new HashMap(j);
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        this.mInitialized = false;
        return;
      }
      PropertyValuesHolder localPropertyValuesHolder = paramVarArgs[i];
      this.mValuesMap.put(localPropertyValuesHolder.getPropertyName(), localPropertyValuesHolder);
      i += 1;
    }
  }
  
  public void start()
  {
    start(false);
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder("ValueAnimator@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    localObject = ((StringBuilder)localObject).toString();
    if (this.mValues != null)
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.mValues.length) {
          return localObject;
        }
        localObject = new StringBuilder(String.valueOf(localObject));
        ((StringBuilder)localObject).append("\n    ");
        ((StringBuilder)localObject).append(this.mValues[i].toString());
        localObject = ((StringBuilder)localObject).toString();
        i += 1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator
 * JD-Core Version:    0.7.0.1
 */