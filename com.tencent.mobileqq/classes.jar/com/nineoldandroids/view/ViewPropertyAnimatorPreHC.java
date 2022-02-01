package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ViewPropertyAnimatorPreHC
  extends ViewPropertyAnimator
{
  private static final int ALPHA = 512;
  private static final int NONE = 0;
  private static final int ROTATION = 16;
  private static final int ROTATION_X = 32;
  private static final int ROTATION_Y = 64;
  private static final int SCALE_X = 4;
  private static final int SCALE_Y = 8;
  private static final int TRANSFORM_MASK = 511;
  private static final int TRANSLATION_X = 1;
  private static final int TRANSLATION_Y = 2;
  private static final int X = 128;
  private static final int Y = 256;
  private Runnable mAnimationStarter = new ViewPropertyAnimatorPreHC.1(this);
  private ViewPropertyAnimatorPreHC.AnimatorEventListener mAnimatorEventListener = new ViewPropertyAnimatorPreHC.AnimatorEventListener(this, null);
  private HashMap<Animator, ViewPropertyAnimatorPreHC.PropertyBundle> mAnimatorMap = new HashMap();
  private long mDuration;
  private boolean mDurationSet = false;
  private Interpolator mInterpolator;
  private boolean mInterpolatorSet = false;
  private Animator.AnimatorListener mListener = null;
  ArrayList<ViewPropertyAnimatorPreHC.NameValuesHolder> mPendingAnimations = new ArrayList();
  private final AnimatorProxy mProxy;
  private long mStartDelay = 0L;
  private boolean mStartDelaySet = false;
  private final WeakReference<View> mView;
  
  ViewPropertyAnimatorPreHC(View paramView)
  {
    this.mView = new WeakReference(paramView);
    this.mProxy = AnimatorProxy.wrap(paramView);
  }
  
  private void animateProperty(int paramInt, float paramFloat)
  {
    float f = getValue(paramInt);
    animatePropertyBy(paramInt, f, paramFloat - f);
  }
  
  private void animatePropertyBy(int paramInt, float paramFloat)
  {
    animatePropertyBy(paramInt, getValue(paramInt), paramFloat);
  }
  
  private void animatePropertyBy(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.mAnimatorMap.size() > 0)
    {
      localObject = null;
      Iterator localIterator = this.mAnimatorMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Animator localAnimator = (Animator)localIterator.next();
        ViewPropertyAnimatorPreHC.PropertyBundle localPropertyBundle = (ViewPropertyAnimatorPreHC.PropertyBundle)this.mAnimatorMap.get(localAnimator);
        if ((localPropertyBundle.cancel(paramInt)) && (localPropertyBundle.mPropertyMask == 0)) {
          localObject = localAnimator;
        }
      }
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
    }
    Object localObject = new ViewPropertyAnimatorPreHC.NameValuesHolder(paramInt, paramFloat1, paramFloat2);
    this.mPendingAnimations.add(localObject);
    localObject = (View)this.mView.get();
    if (localObject != null)
    {
      ((View)localObject).removeCallbacks(this.mAnimationStarter);
      ((View)localObject).post(this.mAnimationStarter);
    }
  }
  
  private float getValue(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32)
              {
                if (paramInt != 64)
                {
                  if (paramInt != 128)
                  {
                    if (paramInt != 256)
                    {
                      if (paramInt != 512) {
                        return 0.0F;
                      }
                      return this.mProxy.getAlpha();
                    }
                    return this.mProxy.getY();
                  }
                  return this.mProxy.getX();
                }
                return this.mProxy.getRotationY();
              }
              return this.mProxy.getRotationX();
            }
            return this.mProxy.getRotation();
          }
          return this.mProxy.getScaleY();
        }
        return this.mProxy.getScaleX();
      }
      return this.mProxy.getTranslationY();
    }
    return this.mProxy.getTranslationX();
  }
  
  private void setValue(int paramInt, float paramFloat)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8)
          {
            if (paramInt != 16)
            {
              if (paramInt != 32)
              {
                if (paramInt != 64)
                {
                  if (paramInt != 128)
                  {
                    if (paramInt != 256)
                    {
                      if (paramInt != 512) {
                        return;
                      }
                      this.mProxy.setAlpha(paramFloat);
                      return;
                    }
                    this.mProxy.setY(paramFloat);
                    return;
                  }
                  this.mProxy.setX(paramFloat);
                  return;
                }
                this.mProxy.setRotationY(paramFloat);
                return;
              }
              this.mProxy.setRotationX(paramFloat);
              return;
            }
            this.mProxy.setRotation(paramFloat);
            return;
          }
          this.mProxy.setScaleY(paramFloat);
          return;
        }
        this.mProxy.setScaleX(paramFloat);
        return;
      }
      this.mProxy.setTranslationY(paramFloat);
      return;
    }
    this.mProxy.setTranslationX(paramFloat);
  }
  
  private void startAnimation()
  {
    int i = 0;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.mPendingAnimations.clone();
    this.mPendingAnimations.clear();
    int k = localArrayList.size();
    int j = 0;
    for (;;)
    {
      if (i >= k)
      {
        this.mAnimatorMap.put(localValueAnimator, new ViewPropertyAnimatorPreHC.PropertyBundle(j, localArrayList));
        localValueAnimator.addUpdateListener(this.mAnimatorEventListener);
        localValueAnimator.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
          localValueAnimator.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
          localValueAnimator.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
          localValueAnimator.setInterpolator(this.mInterpolator);
        }
        localValueAnimator.start();
        return;
      }
      j |= ((ViewPropertyAnimatorPreHC.NameValuesHolder)localArrayList.get(i)).mNameConstant;
      i += 1;
    }
  }
  
  public ViewPropertyAnimator alpha(float paramFloat)
  {
    animateProperty(512, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator alphaBy(float paramFloat)
  {
    animatePropertyBy(512, paramFloat);
    return this;
  }
  
  public void cancel()
  {
    if (this.mAnimatorMap.size() > 0)
    {
      localObject = ((HashMap)this.mAnimatorMap.clone()).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animator)((Iterator)localObject).next()).cancel();
      }
    }
    this.mPendingAnimations.clear();
    Object localObject = (View)this.mView.get();
    if (localObject != null) {
      ((View)localObject).removeCallbacks(this.mAnimationStarter);
    }
  }
  
  public long getDuration()
  {
    if (this.mDurationSet) {
      return this.mDuration;
    }
    return new ValueAnimator().getDuration();
  }
  
  public long getStartDelay()
  {
    if (this.mStartDelaySet) {
      return this.mStartDelay;
    }
    return 0L;
  }
  
  public ViewPropertyAnimator rotation(float paramFloat)
  {
    animateProperty(16, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationBy(float paramFloat)
  {
    animatePropertyBy(16, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationX(float paramFloat)
  {
    animateProperty(32, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    animatePropertyBy(32, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationY(float paramFloat)
  {
    animateProperty(64, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    animatePropertyBy(64, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleX(float paramFloat)
  {
    animateProperty(4, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    animatePropertyBy(4, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleY(float paramFloat)
  {
    animateProperty(8, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    animatePropertyBy(8, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator setDuration(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.mDurationSet = true;
      this.mDuration = paramLong;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Animators cannot have negative duration: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolatorSet = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }
  
  public ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mListener = paramAnimatorListener;
    return this;
  }
  
  public ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.mStartDelaySet = true;
      this.mStartDelay = paramLong;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Animators cannot have negative duration: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void start()
  {
    startAnimation();
  }
  
  public ViewPropertyAnimator translationX(float paramFloat)
  {
    animateProperty(1, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationXBy(float paramFloat)
  {
    animatePropertyBy(1, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationY(float paramFloat)
  {
    animateProperty(2, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator translationYBy(float paramFloat)
  {
    animatePropertyBy(2, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator x(float paramFloat)
  {
    animateProperty(128, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator xBy(float paramFloat)
  {
    animatePropertyBy(128, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator y(float paramFloat)
  {
    animateProperty(256, paramFloat);
    return this;
  }
  
  public ViewPropertyAnimator yBy(float paramFloat)
  {
    animatePropertyBy(256, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC
 * JD-Core Version:    0.7.0.1
 */