package com.nineoldandroids.animation;

class Keyframe$ObjectKeyframe
  extends Keyframe
{
  Object mValue;
  
  Keyframe$ObjectKeyframe(float paramFloat, Object paramObject)
  {
    this.mFraction = paramFloat;
    this.mValue = paramObject;
    boolean bool;
    if (paramObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasValue = bool;
    if (this.mHasValue) {
      paramObject = paramObject.getClass();
    } else {
      paramObject = Object.class;
    }
    this.mValueType = paramObject;
  }
  
  public ObjectKeyframe clone()
  {
    ObjectKeyframe localObjectKeyframe = new ObjectKeyframe(getFraction(), this.mValue);
    localObjectKeyframe.setInterpolator(getInterpolator());
    return localObjectKeyframe;
  }
  
  public Object getValue()
  {
    return this.mValue;
  }
  
  public void setValue(Object paramObject)
  {
    this.mValue = paramObject;
    boolean bool;
    if (paramObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasValue = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.ObjectKeyframe
 * JD-Core Version:    0.7.0.1
 */