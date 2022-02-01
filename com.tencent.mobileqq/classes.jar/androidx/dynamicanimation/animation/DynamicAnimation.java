package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>>
  implements AnimationHandler.AnimationFrameCallback
{
  public static final DynamicAnimation.ViewProperty ALPHA = new DynamicAnimation.12("alpha");
  public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.0039063F;
  public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0F;
  public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1F;
  public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002F;
  public static final DynamicAnimation.ViewProperty ROTATION;
  public static final DynamicAnimation.ViewProperty ROTATION_X;
  public static final DynamicAnimation.ViewProperty ROTATION_Y;
  public static final DynamicAnimation.ViewProperty SCALE_X;
  public static final DynamicAnimation.ViewProperty SCALE_Y;
  public static final DynamicAnimation.ViewProperty SCROLL_X = new DynamicAnimation.13("scrollX");
  public static final DynamicAnimation.ViewProperty SCROLL_Y = new DynamicAnimation.14("scrollY");
  private static final float THRESHOLD_MULTIPLIER = 0.75F;
  public static final DynamicAnimation.ViewProperty TRANSLATION_X = new DynamicAnimation.1("translationX");
  public static final DynamicAnimation.ViewProperty TRANSLATION_Y = new DynamicAnimation.2("translationY");
  public static final DynamicAnimation.ViewProperty TRANSLATION_Z = new DynamicAnimation.3("translationZ");
  private static final float UNSET = 3.4028235E+38F;
  public static final DynamicAnimation.ViewProperty X;
  public static final DynamicAnimation.ViewProperty Y;
  public static final DynamicAnimation.ViewProperty Z;
  private final ArrayList<DynamicAnimation.OnAnimationEndListener> mEndListeners = new ArrayList();
  private long mLastFrameTime = 0L;
  float mMaxValue = 3.4028235E+38F;
  float mMinValue = -this.mMaxValue;
  private float mMinVisibleChange;
  final FloatPropertyCompat mProperty;
  boolean mRunning = false;
  boolean mStartValueIsSet = false;
  final Object mTarget;
  private final ArrayList<DynamicAnimation.OnAnimationUpdateListener> mUpdateListeners = new ArrayList();
  float mValue = 3.4028235E+38F;
  float mVelocity = 0.0F;
  
  static
  {
    SCALE_X = new DynamicAnimation.4("scaleX");
    SCALE_Y = new DynamicAnimation.5("scaleY");
    ROTATION = new DynamicAnimation.6("rotation");
    ROTATION_X = new DynamicAnimation.7("rotationX");
    ROTATION_Y = new DynamicAnimation.8("rotationY");
    X = new DynamicAnimation.9("x");
    Y = new DynamicAnimation.10("y");
    Z = new DynamicAnimation.11("z");
  }
  
  DynamicAnimation(FloatValueHolder paramFloatValueHolder)
  {
    this.mTarget = null;
    this.mProperty = new DynamicAnimation.15(this, "FloatValueHolder", paramFloatValueHolder);
    this.mMinVisibleChange = 1.0F;
  }
  
  <K> DynamicAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat)
  {
    this.mTarget = paramK;
    this.mProperty = paramFloatPropertyCompat;
    paramK = this.mProperty;
    if ((paramK != ROTATION) && (paramK != ROTATION_X) && (paramK != ROTATION_Y))
    {
      if (paramK == ALPHA)
      {
        this.mMinVisibleChange = 0.0039063F;
        return;
      }
      if ((paramK != SCALE_X) && (paramK != SCALE_Y))
      {
        this.mMinVisibleChange = 1.0F;
        return;
      }
      this.mMinVisibleChange = 0.0039063F;
      return;
    }
    this.mMinVisibleChange = 0.1F;
  }
  
  private void endAnimationInternal(boolean paramBoolean)
  {
    int i = 0;
    this.mRunning = false;
    AnimationHandler.getInstance().removeCallback(this);
    this.mLastFrameTime = 0L;
    this.mStartValueIsSet = false;
    while (i < this.mEndListeners.size())
    {
      if (this.mEndListeners.get(i) != null) {
        ((DynamicAnimation.OnAnimationEndListener)this.mEndListeners.get(i)).onAnimationEnd(this, paramBoolean, this.mValue, this.mVelocity);
      }
      i += 1;
    }
    removeNullEntries(this.mEndListeners);
  }
  
  private float getPropertyValue()
  {
    return this.mProperty.getValue(this.mTarget);
  }
  
  private static <T> void removeEntry(ArrayList<T> paramArrayList, T paramT)
  {
    int i = paramArrayList.indexOf(paramT);
    if (i >= 0) {
      paramArrayList.set(i, null);
    }
  }
  
  private static <T> void removeNullEntries(ArrayList<T> paramArrayList)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (paramArrayList.get(i) == null) {
        paramArrayList.remove(i);
      }
      i -= 1;
    }
  }
  
  private void startAnimationInternal()
  {
    if (!this.mRunning)
    {
      this.mRunning = true;
      if (!this.mStartValueIsSet) {
        this.mValue = getPropertyValue();
      }
      float f = this.mValue;
      if ((f <= this.mMaxValue) && (f >= this.mMinValue))
      {
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
        return;
      }
      throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }
  }
  
  public T addEndListener(DynamicAnimation.OnAnimationEndListener paramOnAnimationEndListener)
  {
    if (!this.mEndListeners.contains(paramOnAnimationEndListener)) {
      this.mEndListeners.add(paramOnAnimationEndListener);
    }
    return this;
  }
  
  public T addUpdateListener(DynamicAnimation.OnAnimationUpdateListener paramOnAnimationUpdateListener)
  {
    if (!isRunning())
    {
      if (!this.mUpdateListeners.contains(paramOnAnimationUpdateListener)) {
        this.mUpdateListeners.add(paramOnAnimationUpdateListener);
      }
      return this;
    }
    throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
  }
  
  public void cancel()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.mRunning) {
        endAnimationInternal(true);
      }
      return;
    }
    throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean doAnimationFrame(long paramLong)
  {
    long l = this.mLastFrameTime;
    if (l == 0L)
    {
      this.mLastFrameTime = paramLong;
      setPropertyValue(this.mValue);
      return false;
    }
    this.mLastFrameTime = paramLong;
    boolean bool = updateValueAndVelocity(paramLong - l);
    this.mValue = Math.min(this.mValue, this.mMaxValue);
    this.mValue = Math.max(this.mValue, this.mMinValue);
    setPropertyValue(this.mValue);
    if (bool) {
      endAnimationInternal(false);
    }
    return bool;
  }
  
  abstract float getAcceleration(float paramFloat1, float paramFloat2);
  
  public float getMinimumVisibleChange()
  {
    return this.mMinVisibleChange;
  }
  
  float getValueThreshold()
  {
    return this.mMinVisibleChange * 0.75F;
  }
  
  abstract boolean isAtEquilibrium(float paramFloat1, float paramFloat2);
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  public void removeEndListener(DynamicAnimation.OnAnimationEndListener paramOnAnimationEndListener)
  {
    removeEntry(this.mEndListeners, paramOnAnimationEndListener);
  }
  
  public void removeUpdateListener(DynamicAnimation.OnAnimationUpdateListener paramOnAnimationUpdateListener)
  {
    removeEntry(this.mUpdateListeners, paramOnAnimationUpdateListener);
  }
  
  public T setMaxValue(float paramFloat)
  {
    this.mMaxValue = paramFloat;
    return this;
  }
  
  public T setMinValue(float paramFloat)
  {
    this.mMinValue = paramFloat;
    return this;
  }
  
  public T setMinimumVisibleChange(@FloatRange(from=0.0D, fromInclusive=false) float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.mMinVisibleChange = paramFloat;
      setValueThreshold(paramFloat * 0.75F);
      return this;
    }
    throw new IllegalArgumentException("Minimum visible change must be positive.");
  }
  
  void setPropertyValue(float paramFloat)
  {
    this.mProperty.setValue(this.mTarget, paramFloat);
    int i = 0;
    while (i < this.mUpdateListeners.size())
    {
      if (this.mUpdateListeners.get(i) != null) {
        ((DynamicAnimation.OnAnimationUpdateListener)this.mUpdateListeners.get(i)).onAnimationUpdate(this, this.mValue, this.mVelocity);
      }
      i += 1;
    }
    removeNullEntries(this.mUpdateListeners);
  }
  
  public T setStartValue(float paramFloat)
  {
    this.mValue = paramFloat;
    this.mStartValueIsSet = true;
    return this;
  }
  
  public T setStartVelocity(float paramFloat)
  {
    this.mVelocity = paramFloat;
    return this;
  }
  
  abstract void setValueThreshold(float paramFloat);
  
  public void start()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (!this.mRunning) {
        startAnimationInternal();
      }
      return;
    }
    throw new AndroidRuntimeException("Animations may only be started on the main thread");
  }
  
  abstract boolean updateValueAndVelocity(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation
 * JD-Core Version:    0.7.0.1
 */