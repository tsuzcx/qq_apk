package com.nineoldandroids.animation;

class Keyframe$FloatKeyframe
  extends Keyframe
{
  float mValue;
  
  Keyframe$FloatKeyframe(float paramFloat)
  {
    this.mFraction = paramFloat;
    this.mValueType = Float.TYPE;
  }
  
  Keyframe$FloatKeyframe(float paramFloat1, float paramFloat2)
  {
    this.mFraction = paramFloat1;
    this.mValue = paramFloat2;
    this.mValueType = Float.TYPE;
    this.mHasValue = true;
  }
  
  public FloatKeyframe clone()
  {
    FloatKeyframe localFloatKeyframe = new FloatKeyframe(getFraction(), this.mValue);
    localFloatKeyframe.setInterpolator(getInterpolator());
    return localFloatKeyframe;
  }
  
  public float getFloatValue()
  {
    return this.mValue;
  }
  
  public Object getValue()
  {
    return Float.valueOf(this.mValue);
  }
  
  public void setValue(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Float.class))
    {
      this.mValue = ((Float)paramObject).floatValue();
      this.mHasValue = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.FloatKeyframe
 * JD-Core Version:    0.7.0.1
 */