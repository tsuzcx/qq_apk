package androidx.dynamicanimation.animation;

final class FlingAnimation$DragForce
  implements Force
{
  private static final float DEFAULT_FRICTION = -4.2F;
  private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5F;
  private float mFriction = -4.2F;
  private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
  private float mVelocityThreshold;
  
  public float getAcceleration(float paramFloat1, float paramFloat2)
  {
    return paramFloat2 * this.mFriction;
  }
  
  float getFrictionScalar()
  {
    return this.mFriction / -4.2F;
  }
  
  public boolean isAtEquilibrium(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) < this.mVelocityThreshold;
  }
  
  void setFrictionScalar(float paramFloat)
  {
    this.mFriction = (paramFloat * -4.2F);
  }
  
  void setValueThreshold(float paramFloat)
  {
    this.mVelocityThreshold = (paramFloat * 62.5F);
  }
  
  DynamicAnimation.MassState updateValueAndVelocity(float paramFloat1, float paramFloat2, long paramLong)
  {
    DynamicAnimation.MassState localMassState = this.mMassState;
    double d1 = paramFloat2;
    float f1 = (float)paramLong;
    double d2 = Math.exp(f1 / 1000.0F * this.mFriction);
    Double.isNaN(d1);
    localMassState.mVelocity = ((float)(d1 * d2));
    localMassState = this.mMassState;
    float f2 = this.mFriction;
    d1 = paramFloat1 - paramFloat2 / f2;
    d2 = paramFloat2 / f2;
    double d3 = Math.exp(f2 * f1 / 1000.0F);
    Double.isNaN(d2);
    Double.isNaN(d1);
    localMassState.mValue = ((float)(d1 + d2 * d3));
    if (isAtEquilibrium(this.mMassState.mValue, this.mMassState.mVelocity)) {
      this.mMassState.mVelocity = 0.0F;
    }
    return this.mMassState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FlingAnimation.DragForce
 * JD-Core Version:    0.7.0.1
 */