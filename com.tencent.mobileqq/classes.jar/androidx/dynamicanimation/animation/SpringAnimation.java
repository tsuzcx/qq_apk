package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

public final class SpringAnimation
  extends DynamicAnimation<SpringAnimation>
{
  private static final float UNSET = 3.4028235E+38F;
  private boolean mEndRequested = false;
  private float mPendingPosition = 3.4028235E+38F;
  private SpringForce mSpring = null;
  
  public SpringAnimation(FloatValueHolder paramFloatValueHolder)
  {
    super(paramFloatValueHolder);
  }
  
  public <K> SpringAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat)
  {
    super(paramK, paramFloatPropertyCompat);
  }
  
  public <K> SpringAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat, float paramFloat)
  {
    super(paramK, paramFloatPropertyCompat);
    this.mSpring = new SpringForce(paramFloat);
  }
  
  private void sanityCheck()
  {
    SpringForce localSpringForce = this.mSpring;
    if (localSpringForce != null)
    {
      double d = localSpringForce.getFinalPosition();
      if (d <= this.mMaxValue)
      {
        if (d >= this.mMinValue) {
          return;
        }
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
      }
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
  }
  
  public void animateToFinalPosition(float paramFloat)
  {
    if (isRunning())
    {
      this.mPendingPosition = paramFloat;
      return;
    }
    if (this.mSpring == null) {
      this.mSpring = new SpringForce(paramFloat);
    }
    this.mSpring.setFinalPosition(paramFloat);
    start();
  }
  
  public boolean canSkipToEnd()
  {
    return this.mSpring.mDampingRatio > 0.0D;
  }
  
  float getAcceleration(float paramFloat1, float paramFloat2)
  {
    return this.mSpring.getAcceleration(paramFloat1, paramFloat2);
  }
  
  public SpringForce getSpring()
  {
    return this.mSpring;
  }
  
  boolean isAtEquilibrium(float paramFloat1, float paramFloat2)
  {
    return this.mSpring.isAtEquilibrium(paramFloat1, paramFloat2);
  }
  
  public SpringAnimation setSpring(SpringForce paramSpringForce)
  {
    this.mSpring = paramSpringForce;
    return this;
  }
  
  void setValueThreshold(float paramFloat) {}
  
  public void skipToEnd()
  {
    if (canSkipToEnd())
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        if (this.mRunning) {
          this.mEndRequested = true;
        }
        return;
      }
      throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }
    throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
  }
  
  public void start()
  {
    sanityCheck();
    this.mSpring.setValueThreshold(getValueThreshold());
    super.start();
  }
  
  boolean updateValueAndVelocity(long paramLong)
  {
    if (this.mEndRequested)
    {
      float f = this.mPendingPosition;
      if (f != 3.4028235E+38F)
      {
        this.mSpring.setFinalPosition(f);
        this.mPendingPosition = 3.4028235E+38F;
      }
      this.mValue = this.mSpring.getFinalPosition();
      this.mVelocity = 0.0F;
      this.mEndRequested = false;
      return true;
    }
    Object localObject;
    if (this.mPendingPosition != 3.4028235E+38F)
    {
      this.mSpring.getFinalPosition();
      localObject = this.mSpring;
      double d1 = this.mValue;
      double d2 = this.mVelocity;
      paramLong /= 2L;
      localObject = ((SpringForce)localObject).updateValues(d1, d2, paramLong);
      this.mSpring.setFinalPosition(this.mPendingPosition);
      this.mPendingPosition = 3.4028235E+38F;
      localObject = this.mSpring.updateValues(((DynamicAnimation.MassState)localObject).mValue, ((DynamicAnimation.MassState)localObject).mVelocity, paramLong);
      this.mValue = ((DynamicAnimation.MassState)localObject).mValue;
      this.mVelocity = ((DynamicAnimation.MassState)localObject).mVelocity;
    }
    else
    {
      localObject = this.mSpring.updateValues(this.mValue, this.mVelocity, paramLong);
      this.mValue = ((DynamicAnimation.MassState)localObject).mValue;
      this.mVelocity = ((DynamicAnimation.MassState)localObject).mVelocity;
    }
    this.mValue = Math.max(this.mValue, this.mMinValue);
    this.mValue = Math.min(this.mValue, this.mMaxValue);
    if (isAtEquilibrium(this.mValue, this.mVelocity))
    {
      this.mValue = this.mSpring.getFinalPosition();
      this.mVelocity = 0.0F;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.SpringAnimation
 * JD-Core Version:    0.7.0.1
 */