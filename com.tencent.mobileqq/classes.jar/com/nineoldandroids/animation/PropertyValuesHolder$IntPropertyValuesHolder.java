package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PropertyValuesHolder$IntPropertyValuesHolder
  extends PropertyValuesHolder
{
  int mIntAnimatedValue;
  IntKeyframeSet mIntKeyframeSet;
  private IntProperty mIntProperty;
  
  public PropertyValuesHolder$IntPropertyValuesHolder(Property paramProperty, IntKeyframeSet paramIntKeyframeSet)
  {
    super(paramProperty, null);
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = paramIntKeyframeSet;
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
    if ((paramProperty instanceof IntProperty)) {
      this.mIntProperty = ((IntProperty)this.mProperty);
    }
  }
  
  public PropertyValuesHolder$IntPropertyValuesHolder(Property paramProperty, int... paramVarArgs)
  {
    super(paramProperty, null);
    setIntValues(paramVarArgs);
    if ((paramProperty instanceof IntProperty)) {
      this.mIntProperty = ((IntProperty)this.mProperty);
    }
  }
  
  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, IntKeyframeSet paramIntKeyframeSet)
  {
    super(paramString, null);
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = paramIntKeyframeSet;
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
  }
  
  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, int... paramVarArgs)
  {
    super(paramString, null);
    setIntValues(paramVarArgs);
  }
  
  void calculateValue(float paramFloat)
  {
    this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(paramFloat);
  }
  
  public IntPropertyValuesHolder clone()
  {
    IntPropertyValuesHolder localIntPropertyValuesHolder = (IntPropertyValuesHolder)super.clone();
    localIntPropertyValuesHolder.mIntKeyframeSet = ((IntKeyframeSet)localIntPropertyValuesHolder.mKeyframeSet);
    return localIntPropertyValuesHolder;
  }
  
  Object getAnimatedValue()
  {
    return Integer.valueOf(this.mIntAnimatedValue);
  }
  
  void setAnimatedValue(Object paramObject)
  {
    if (this.mIntProperty != null) {
      this.mIntProperty.setValue(paramObject, this.mIntAnimatedValue);
    }
    do
    {
      return;
      if (this.mProperty != null)
      {
        this.mProperty.set(paramObject, Integer.valueOf(this.mIntAnimatedValue));
        return;
      }
    } while (this.mSetter == null);
    try
    {
      this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
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
  
  public void setIntValues(int... paramVarArgs)
  {
    super.setIntValues(paramVarArgs);
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
  }
  
  void setupSetter(Class paramClass)
  {
    if (this.mProperty != null) {
      return;
    }
    super.setupSetter(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder
 * JD-Core Version:    0.7.0.1
 */