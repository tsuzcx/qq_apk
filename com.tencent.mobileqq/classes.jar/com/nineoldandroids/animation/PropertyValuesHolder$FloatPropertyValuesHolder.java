package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PropertyValuesHolder$FloatPropertyValuesHolder
  extends PropertyValuesHolder
{
  float mFloatAnimatedValue;
  FloatKeyframeSet mFloatKeyframeSet;
  private FloatProperty mFloatProperty;
  
  public PropertyValuesHolder$FloatPropertyValuesHolder(Property paramProperty, FloatKeyframeSet paramFloatKeyframeSet)
  {
    super(paramProperty, null);
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = paramFloatKeyframeSet;
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
    if ((paramProperty instanceof FloatProperty)) {
      this.mFloatProperty = ((FloatProperty)this.mProperty);
    }
  }
  
  public PropertyValuesHolder$FloatPropertyValuesHolder(Property paramProperty, float... paramVarArgs)
  {
    super(paramProperty, null);
    setFloatValues(paramVarArgs);
    if ((paramProperty instanceof FloatProperty)) {
      this.mFloatProperty = ((FloatProperty)this.mProperty);
    }
  }
  
  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, FloatKeyframeSet paramFloatKeyframeSet)
  {
    super(paramString, null);
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = paramFloatKeyframeSet;
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
  }
  
  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, float... paramVarArgs)
  {
    super(paramString, null);
    setFloatValues(paramVarArgs);
  }
  
  void calculateValue(float paramFloat)
  {
    this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(paramFloat);
  }
  
  public FloatPropertyValuesHolder clone()
  {
    FloatPropertyValuesHolder localFloatPropertyValuesHolder = (FloatPropertyValuesHolder)super.clone();
    localFloatPropertyValuesHolder.mFloatKeyframeSet = ((FloatKeyframeSet)localFloatPropertyValuesHolder.mKeyframeSet);
    return localFloatPropertyValuesHolder;
  }
  
  Object getAnimatedValue()
  {
    return Float.valueOf(this.mFloatAnimatedValue);
  }
  
  void setAnimatedValue(Object paramObject)
  {
    if (this.mFloatProperty != null) {
      this.mFloatProperty.setValue(paramObject, this.mFloatAnimatedValue);
    }
    do
    {
      return;
      if (this.mProperty != null)
      {
        this.mProperty.set(paramObject, Float.valueOf(this.mFloatAnimatedValue));
        return;
      }
    } while (this.mSetter == null);
    try
    {
      this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
      this.mSetter.invoke(paramObject, this.mTmpValueArray);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Log.e("PropertyValuesHolder", paramObject.toString());
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", paramObject.toString());
    }
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    super.setFloatValues(paramVarArgs);
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
  }
  
  void setupSetter(Class paramClass)
  {
    if (this.mProperty != null) {
      return;
    }
    super.setupSetter(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder
 * JD-Core Version:    0.7.0.1
 */