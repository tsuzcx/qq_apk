package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

public final class FlingAnimation
  extends DynamicAnimation<FlingAnimation>
{
  private final FlingAnimation.DragForce mFlingForce = new FlingAnimation.DragForce();
  
  public FlingAnimation(FloatValueHolder paramFloatValueHolder)
  {
    super(paramFloatValueHolder);
    this.mFlingForce.setValueThreshold(getValueThreshold());
  }
  
  public <K> FlingAnimation(K paramK, FloatPropertyCompat<K> paramFloatPropertyCompat)
  {
    super(paramK, paramFloatPropertyCompat);
    this.mFlingForce.setValueThreshold(getValueThreshold());
  }
  
  float getAcceleration(float paramFloat1, float paramFloat2)
  {
    return this.mFlingForce.getAcceleration(paramFloat1, paramFloat2);
  }
  
  public float getFriction()
  {
    return this.mFlingForce.getFrictionScalar();
  }
  
  boolean isAtEquilibrium(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= this.mMaxValue) || (paramFloat1 <= this.mMinValue) || (this.mFlingForce.isAtEquilibrium(paramFloat1, paramFloat2));
  }
  
  public FlingAnimation setFriction(@FloatRange(from=0.0D, fromInclusive=false) float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.mFlingForce.setFrictionScalar(paramFloat);
      return this;
    }
    throw new IllegalArgumentException("Friction must be positive");
  }
  
  public FlingAnimation setMaxValue(float paramFloat)
  {
    super.setMaxValue(paramFloat);
    return this;
  }
  
  public FlingAnimation setMinValue(float paramFloat)
  {
    super.setMinValue(paramFloat);
    return this;
  }
  
  public FlingAnimation setStartVelocity(float paramFloat)
  {
    super.setStartVelocity(paramFloat);
    return this;
  }
  
  void setValueThreshold(float paramFloat)
  {
    this.mFlingForce.setValueThreshold(paramFloat);
  }
  
  boolean updateValueAndVelocity(long paramLong)
  {
    DynamicAnimation.MassState localMassState = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, paramLong);
    this.mValue = localMassState.mValue;
    this.mVelocity = localMassState.mVelocity;
    if (this.mValue < this.mMinValue)
    {
      this.mValue = this.mMinValue;
      return true;
    }
    if (this.mValue > this.mMaxValue)
    {
      this.mValue = this.mMaxValue;
      return true;
    }
    return isAtEquilibrium(this.mValue, this.mVelocity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FlingAnimation
 * JD-Core Version:    0.7.0.1
 */