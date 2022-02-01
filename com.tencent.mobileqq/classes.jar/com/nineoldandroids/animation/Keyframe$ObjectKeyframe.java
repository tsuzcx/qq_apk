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
    if (paramObject != null)
    {
      bool = true;
      this.mHasValue = bool;
      if (!this.mHasValue) {
        break label48;
      }
    }
    label48:
    for (paramObject = paramObject.getClass();; paramObject = Object.class)
    {
      this.mValueType = paramObject;
      return;
      bool = false;
      break;
    }
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
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasValue = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe.ObjectKeyframe
 * JD-Core Version:    0.7.0.1
 */