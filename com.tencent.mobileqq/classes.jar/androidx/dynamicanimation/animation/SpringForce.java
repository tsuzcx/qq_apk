package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;

public final class SpringForce
  implements Force
{
  public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2F;
  public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75F;
  public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5F;
  public static final float DAMPING_RATIO_NO_BOUNCY = 1.0F;
  public static final float STIFFNESS_HIGH = 10000.0F;
  public static final float STIFFNESS_LOW = 200.0F;
  public static final float STIFFNESS_MEDIUM = 1500.0F;
  public static final float STIFFNESS_VERY_LOW = 50.0F;
  private static final double UNSET = 1.7976931348623157E+308D;
  private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5D;
  private double mDampedFreq;
  double mDampingRatio = 0.5D;
  private double mFinalPosition = 1.7976931348623157E+308D;
  private double mGammaMinus;
  private double mGammaPlus;
  private boolean mInitialized = false;
  private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
  double mNaturalFreq = Math.sqrt(1500.0D);
  private double mValueThreshold;
  private double mVelocityThreshold;
  
  public SpringForce() {}
  
  public SpringForce(float paramFloat)
  {
    this.mFinalPosition = paramFloat;
  }
  
  private void init()
  {
    if (this.mInitialized) {
      return;
    }
    if (this.mFinalPosition != 1.7976931348623157E+308D)
    {
      double d1 = this.mDampingRatio;
      if (d1 > 1.0D)
      {
        double d2 = -d1;
        double d3 = this.mNaturalFreq;
        this.mGammaPlus = (d2 * d3 + d3 * Math.sqrt(d1 * d1 - 1.0D));
        d1 = this.mDampingRatio;
        d2 = -d1;
        d3 = this.mNaturalFreq;
        this.mGammaMinus = (d2 * d3 - d3 * Math.sqrt(d1 * d1 - 1.0D));
      }
      else if ((d1 >= 0.0D) && (d1 < 1.0D))
      {
        this.mDampedFreq = (this.mNaturalFreq * Math.sqrt(1.0D - d1 * d1));
      }
      this.mInitialized = true;
      return;
    }
    throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public float getAcceleration(float paramFloat1, float paramFloat2)
  {
    float f = getFinalPosition();
    double d1 = this.mNaturalFreq;
    double d2 = this.mDampingRatio;
    double d3 = -(d1 * d1);
    double d4 = paramFloat1 - f;
    Double.isNaN(d4);
    double d5 = paramFloat2;
    Double.isNaN(d5);
    return (float)(d3 * d4 - d1 * 2.0D * d2 * d5);
  }
  
  public float getDampingRatio()
  {
    return (float)this.mDampingRatio;
  }
  
  public float getFinalPosition()
  {
    return (float)this.mFinalPosition;
  }
  
  public float getStiffness()
  {
    double d = this.mNaturalFreq;
    return (float)(d * d);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean isAtEquilibrium(float paramFloat1, float paramFloat2)
  {
    return (Math.abs(paramFloat2) < this.mVelocityThreshold) && (Math.abs(paramFloat1 - getFinalPosition()) < this.mValueThreshold);
  }
  
  public SpringForce setDampingRatio(@FloatRange(from=0.0D) float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.mDampingRatio = paramFloat;
      this.mInitialized = false;
      return this;
    }
    throw new IllegalArgumentException("Damping ratio must be non-negative");
  }
  
  public SpringForce setFinalPosition(float paramFloat)
  {
    this.mFinalPosition = paramFloat;
    return this;
  }
  
  public SpringForce setStiffness(@FloatRange(from=0.0D, fromInclusive=false) float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.mNaturalFreq = Math.sqrt(paramFloat);
      this.mInitialized = false;
      return this;
    }
    throw new IllegalArgumentException("Spring stiffness constant must be positive.");
  }
  
  void setValueThreshold(double paramDouble)
  {
    this.mValueThreshold = Math.abs(paramDouble);
    this.mVelocityThreshold = (this.mValueThreshold * 62.5D);
  }
  
  DynamicAnimation.MassState updateValues(double paramDouble1, double paramDouble2, long paramLong)
  {
    init();
    double d1 = paramLong;
    Double.isNaN(d1);
    d1 /= 1000.0D;
    double d2 = paramDouble1 - this.mFinalPosition;
    paramDouble1 = this.mDampingRatio;
    double d4;
    double d3;
    double d5;
    if (paramDouble1 > 1.0D)
    {
      paramDouble1 = this.mGammaMinus;
      d4 = this.mGammaPlus;
      d3 = d2 - (paramDouble1 * d2 - paramDouble2) / (paramDouble1 - d4);
      paramDouble2 = (d2 * paramDouble1 - paramDouble2) / (paramDouble1 - d4);
      paramDouble1 = Math.pow(2.718281828459045D, paramDouble1 * d1) * d3 + Math.pow(2.718281828459045D, this.mGammaPlus * d1) * paramDouble2;
      d2 = this.mGammaMinus;
      d4 = Math.pow(2.718281828459045D, d2 * d1);
      d5 = this.mGammaPlus;
      paramDouble2 = d3 * d2 * d4 + paramDouble2 * d5 * Math.pow(2.718281828459045D, d5 * d1);
    }
    else if (paramDouble1 == 1.0D)
    {
      paramDouble1 = this.mNaturalFreq;
      paramDouble2 += paramDouble1 * d2;
      d2 += paramDouble2 * d1;
      paramDouble1 = Math.pow(2.718281828459045D, -paramDouble1 * d1) * d2;
      d3 = Math.pow(2.718281828459045D, -this.mNaturalFreq * d1);
      d4 = this.mNaturalFreq;
      d5 = -d4;
      paramDouble2 = paramDouble2 * Math.pow(2.718281828459045D, -d4 * d1) + d2 * d3 * d5;
    }
    else
    {
      d4 = 1.0D / this.mDampedFreq;
      d3 = this.mNaturalFreq;
      paramDouble2 = d4 * (paramDouble1 * d3 * d2 + paramDouble2);
      paramDouble1 = Math.pow(2.718281828459045D, -paramDouble1 * d3 * d1) * (Math.cos(this.mDampedFreq * d1) * d2 + Math.sin(this.mDampedFreq * d1) * paramDouble2);
      d5 = this.mNaturalFreq;
      d3 = -d5;
      d4 = this.mDampingRatio;
      d5 = Math.pow(2.718281828459045D, -d4 * d5 * d1);
      double d7 = this.mDampedFreq;
      double d6 = -d7;
      d7 = Math.sin(d7 * d1);
      double d8 = this.mDampedFreq;
      paramDouble2 = d3 * paramDouble1 * d4 + d5 * (d6 * d2 * d7 + paramDouble2 * d8 * Math.cos(d8 * d1));
    }
    DynamicAnimation.MassState localMassState = this.mMassState;
    localMassState.mValue = ((float)(paramDouble1 + this.mFinalPosition));
    localMassState.mVelocity = ((float)paramDouble2);
    return localMassState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.SpringForce
 * JD-Core Version:    0.7.0.1
 */