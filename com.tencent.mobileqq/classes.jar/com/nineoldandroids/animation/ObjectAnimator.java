package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator
  extends ValueAnimator
{
  private static final boolean DBG = false;
  private static final Map<String, Property> PROXY_PROPERTIES = new HashMap();
  private Property mProperty;
  private String mPropertyName;
  private Object mTarget;
  
  static
  {
    PROXY_PROPERTIES.put("alpha", PreHoneycombCompat.ALPHA);
    PROXY_PROPERTIES.put("pivotX", PreHoneycombCompat.PIVOT_X);
    PROXY_PROPERTIES.put("pivotY", PreHoneycombCompat.PIVOT_Y);
    PROXY_PROPERTIES.put("translationX", PreHoneycombCompat.TRANSLATION_X);
    PROXY_PROPERTIES.put("translationY", PreHoneycombCompat.TRANSLATION_Y);
    PROXY_PROPERTIES.put("rotation", PreHoneycombCompat.ROTATION);
    PROXY_PROPERTIES.put("rotationX", PreHoneycombCompat.ROTATION_X);
    PROXY_PROPERTIES.put("rotationY", PreHoneycombCompat.ROTATION_Y);
    PROXY_PROPERTIES.put("scaleX", PreHoneycombCompat.SCALE_X);
    PROXY_PROPERTIES.put("scaleY", PreHoneycombCompat.SCALE_Y);
    PROXY_PROPERTIES.put("scrollX", PreHoneycombCompat.SCROLL_X);
    PROXY_PROPERTIES.put("scrollY", PreHoneycombCompat.SCROLL_Y);
    PROXY_PROPERTIES.put("x", PreHoneycombCompat.X);
    PROXY_PROPERTIES.put("y", PreHoneycombCompat.Y);
  }
  
  public ObjectAnimator() {}
  
  private <T> ObjectAnimator(T paramT, Property<T, ?> paramProperty)
  {
    this.mTarget = paramT;
    setProperty(paramProperty);
  }
  
  private ObjectAnimator(Object paramObject, String paramString)
  {
    this.mTarget = paramObject;
    setPropertyName(paramString);
  }
  
  public static <T> ObjectAnimator ofFloat(T paramT, Property<T, Float> paramProperty, float... paramVarArgs)
  {
    paramT = new ObjectAnimator(paramT, paramProperty);
    paramT.setFloatValues(paramVarArgs);
    return paramT;
  }
  
  public static ObjectAnimator ofFloat(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    paramObject.setFloatValues(paramVarArgs);
    return paramObject;
  }
  
  public static <T> ObjectAnimator ofInt(T paramT, Property<T, Integer> paramProperty, int... paramVarArgs)
  {
    paramT = new ObjectAnimator(paramT, paramProperty);
    paramT.setIntValues(paramVarArgs);
    return paramT;
  }
  
  public static ObjectAnimator ofInt(Object paramObject, String paramString, int... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    paramObject.setIntValues(paramVarArgs);
    return paramObject;
  }
  
  public static <T, V> ObjectAnimator ofObject(T paramT, Property<T, V> paramProperty, TypeEvaluator<V> paramTypeEvaluator, V... paramVarArgs)
  {
    paramT = new ObjectAnimator(paramT, paramProperty);
    paramT.setObjectValues(paramVarArgs);
    paramT.setEvaluator(paramTypeEvaluator);
    return paramT;
  }
  
  public static ObjectAnimator ofObject(Object paramObject, String paramString, TypeEvaluator paramTypeEvaluator, Object... paramVarArgs)
  {
    paramObject = new ObjectAnimator(paramObject, paramString);
    paramObject.setObjectValues(paramVarArgs);
    paramObject.setEvaluator(paramTypeEvaluator);
    return paramObject;
  }
  
  public static ObjectAnimator ofPropertyValuesHolder(Object paramObject, PropertyValuesHolder... paramVarArgs)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.mTarget = paramObject;
    localObjectAnimator.setValues(paramVarArgs);
    return localObjectAnimator;
  }
  
  void animateValue(float paramFloat)
  {
    super.animateValue(paramFloat);
    int j = this.mValues.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      this.mValues[i].setAnimatedValue(this.mTarget);
      i += 1;
    }
  }
  
  public ObjectAnimator clone()
  {
    return (ObjectAnimator)super.clone();
  }
  
  public String getPropertyName()
  {
    return this.mPropertyName;
  }
  
  public Object getTarget()
  {
    return this.mTarget;
  }
  
  void initAnimation()
  {
    int j;
    int i;
    if (!this.mInitialized)
    {
      if ((this.mProperty == null) && (AnimatorProxy.NEEDS_PROXY) && ((this.mTarget instanceof View)) && (PROXY_PROPERTIES.containsKey(this.mPropertyName))) {
        setProperty((Property)PROXY_PROPERTIES.get(this.mPropertyName));
      }
      j = this.mValues.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        super.initAnimation();
        return;
      }
      this.mValues[i].setupSetterAndGetter(this.mTarget);
      i += 1;
    }
  }
  
  public ObjectAnimator setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    return this;
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      if (this.mProperty != null)
      {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.mProperty, paramVarArgs) });
        return;
      }
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.mPropertyName, paramVarArgs) });
      return;
    }
    super.setFloatValues(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      if (this.mProperty != null)
      {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.mProperty, paramVarArgs) });
        return;
      }
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.mPropertyName, paramVarArgs) });
      return;
    }
    super.setIntValues(paramVarArgs);
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    if ((this.mValues == null) || (this.mValues.length == 0))
    {
      if (this.mProperty != null)
      {
        setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject(this.mProperty, null, paramVarArgs) });
        return;
      }
      setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject(this.mPropertyName, null, paramVarArgs) });
      return;
    }
    super.setObjectValues(paramVarArgs);
  }
  
  public void setProperty(Property paramProperty)
  {
    if (this.mValues != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.mValues[0];
      String str = localPropertyValuesHolder.getPropertyName();
      localPropertyValuesHolder.setProperty(paramProperty);
      this.mValuesMap.remove(str);
      this.mValuesMap.put(this.mPropertyName, localPropertyValuesHolder);
    }
    if (this.mProperty != null) {
      this.mPropertyName = paramProperty.getName();
    }
    this.mProperty = paramProperty;
    this.mInitialized = false;
  }
  
  public void setPropertyName(String paramString)
  {
    if (this.mValues != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.mValues[0];
      String str = localPropertyValuesHolder.getPropertyName();
      localPropertyValuesHolder.setPropertyName(paramString);
      this.mValuesMap.remove(str);
      this.mValuesMap.put(paramString, localPropertyValuesHolder);
    }
    this.mPropertyName = paramString;
    this.mInitialized = false;
  }
  
  public void setTarget(Object paramObject)
  {
    if (this.mTarget != paramObject)
    {
      Object localObject = this.mTarget;
      this.mTarget = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass())) {}
    }
    else
    {
      return;
    }
    this.mInitialized = false;
  }
  
  public void setupEndValues()
  {
    initAnimation();
    int j = this.mValues.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      this.mValues[i].setupEndValue(this.mTarget);
      i += 1;
    }
  }
  
  public void setupStartValues()
  {
    initAnimation();
    int j = this.mValues.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      this.mValues[i].setupStartValue(this.mTarget);
      i += 1;
    }
  }
  
  public void start()
  {
    super.start();
  }
  
  public String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
    String str2 = str1;
    int i;
    if (this.mValues != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mValues.length)
      {
        str2 = str1;
        return str2;
      }
      str1 = str1 + "\n    " + this.mValues[i].toString();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.animation.ObjectAnimator
 * JD-Core Version:    0.7.0.1
 */