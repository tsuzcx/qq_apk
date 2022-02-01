package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe
  implements Cloneable
{
  float mFraction;
  boolean mHasValue = false;
  private Interpolator mInterpolator = null;
  Class mValueType;
  
  public static Keyframe ofFloat(float paramFloat)
  {
    return new Keyframe.FloatKeyframe(paramFloat);
  }
  
  public static Keyframe ofFloat(float paramFloat1, float paramFloat2)
  {
    return new Keyframe.FloatKeyframe(paramFloat1, paramFloat2);
  }
  
  public static Keyframe ofInt(float paramFloat)
  {
    return new Keyframe.IntKeyframe(paramFloat);
  }
  
  public static Keyframe ofInt(float paramFloat, int paramInt)
  {
    return new Keyframe.IntKeyframe(paramFloat, paramInt);
  }
  
  public static Keyframe ofObject(float paramFloat)
  {
    return new Keyframe.ObjectKeyframe(paramFloat, null);
  }
  
  public static Keyframe ofObject(float paramFloat, Object paramObject)
  {
    return new Keyframe.ObjectKeyframe(paramFloat, paramObject);
  }
  
  public abstract Keyframe clone();
  
  public float getFraction()
  {
    return this.mFraction;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public Class getType()
  {
    return this.mValueType;
  }
  
  public abstract Object getValue();
  
  public boolean hasValue()
  {
    return this.mHasValue;
  }
  
  public void setFraction(float paramFloat)
  {
    this.mFraction = paramFloat;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public abstract void setValue(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe
 * JD-Core Version:    0.7.0.1
 */