package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PropertyValuesHolder
  implements Cloneable
{
  private static Class[] DOUBLE_VARIANTS;
  private static Class[] FLOAT_VARIANTS;
  private static Class[] INTEGER_VARIANTS;
  private static final TypeEvaluator sFloatEvaluator;
  private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap();
  private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
  private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap;
  private Object mAnimatedValue;
  private TypeEvaluator mEvaluator;
  private Method mGetter = null;
  KeyframeSet mKeyframeSet = null;
  protected Property mProperty;
  final ReentrantReadWriteLock mPropertyMapLock = new ReentrantReadWriteLock();
  String mPropertyName;
  Method mSetter = null;
  final Object[] mTmpValueArray = new Object[1];
  Class mValueType;
  
  static
  {
    sFloatEvaluator = new FloatEvaluator();
    FLOAT_VARIANTS = new Class[] { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
    INTEGER_VARIANTS = new Class[] { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
    DOUBLE_VARIANTS = new Class[] { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
    sSetterPropertyMap = new HashMap();
  }
  
  private PropertyValuesHolder(Property paramProperty)
  {
    this.mProperty = paramProperty;
    if (paramProperty != null) {
      this.mPropertyName = paramProperty.getName();
    }
  }
  
  private PropertyValuesHolder(String paramString)
  {
    this.mPropertyName = paramString;
  }
  
  static String getMethodName(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      return paramString1;
    }
    char c = Character.toUpperCase(paramString2.charAt(0));
    paramString2 = paramString2.substring(1);
    return paramString1 + c + paramString2;
  }
  
  private Method getPropertyFunction(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    String str = getMethodName(paramString, this.mPropertyName);
    if (paramClass2 == null) {
      try
      {
        paramString = paramClass1.getMethod(str, null);
        return paramString;
      }
      catch (NoSuchMethodException paramString) {}
    }
    try
    {
      paramClass1 = paramClass1.getDeclaredMethod(str, null);
      try
      {
        paramClass1.setAccessible(true);
        return paramClass1;
      }
      catch (NoSuchMethodException paramClass2) {}
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        Class[] arrayOfClass;
        int j;
        int i;
        paramClass1 = null;
      }
    }
    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.mPropertyName + ": " + paramString);
    return paramClass1;
    arrayOfClass = new Class[1];
    if (this.mValueType.equals(Float.class))
    {
      paramString = FLOAT_VARIANTS;
      j = paramString.length;
      i = 0;
      paramClass2 = localMethod1;
    }
    for (;;)
    {
      if (i >= j)
      {
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.mPropertyName + " with value type " + this.mValueType);
        return paramClass2;
        if (this.mValueType.equals(Integer.class))
        {
          paramString = INTEGER_VARIANTS;
          break;
        }
        if (this.mValueType.equals(Double.class))
        {
          paramString = DOUBLE_VARIANTS;
          break;
        }
        paramString = new Class[1];
        paramString[0] = this.mValueType;
        break;
      }
      Object localObject = paramString[i];
      arrayOfClass[0] = localObject;
      try
      {
        localMethod1 = paramClass1.getMethod(str, arrayOfClass);
        paramClass2 = localMethod1;
        this.mValueType = localObject;
        return localMethod1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          Method localMethod2 = paramClass1.getDeclaredMethod(str, arrayOfClass);
          paramClass2 = localMethod2;
          localMethod2.setAccessible(true);
          paramClass2 = localMethod2;
          this.mValueType = localObject;
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          i += 1;
        }
      }
    }
  }
  
  public static PropertyValuesHolder ofFloat(Property<?, Float> paramProperty, float... paramVarArgs)
  {
    return new PropertyValuesHolder.FloatPropertyValuesHolder(paramProperty, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofFloat(String paramString, float... paramVarArgs)
  {
    return new PropertyValuesHolder.FloatPropertyValuesHolder(paramString, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofInt(Property<?, Integer> paramProperty, int... paramVarArgs)
  {
    return new PropertyValuesHolder.IntPropertyValuesHolder(paramProperty, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofInt(String paramString, int... paramVarArgs)
  {
    return new PropertyValuesHolder.IntPropertyValuesHolder(paramString, paramVarArgs);
  }
  
  public static PropertyValuesHolder ofKeyframe(Property paramProperty, Keyframe... paramVarArgs)
  {
    KeyframeSet localKeyframeSet = KeyframeSet.ofKeyframe(paramVarArgs);
    if ((localKeyframeSet instanceof IntKeyframeSet)) {
      return new PropertyValuesHolder.IntPropertyValuesHolder(paramProperty, (IntKeyframeSet)localKeyframeSet);
    }
    if ((localKeyframeSet instanceof FloatKeyframeSet)) {
      return new PropertyValuesHolder.FloatPropertyValuesHolder(paramProperty, (FloatKeyframeSet)localKeyframeSet);
    }
    paramProperty = new PropertyValuesHolder(paramProperty);
    paramProperty.mKeyframeSet = localKeyframeSet;
    paramProperty.mValueType = paramVarArgs[0].getType();
    return paramProperty;
  }
  
  public static PropertyValuesHolder ofKeyframe(String paramString, Keyframe... paramVarArgs)
  {
    KeyframeSet localKeyframeSet = KeyframeSet.ofKeyframe(paramVarArgs);
    if ((localKeyframeSet instanceof IntKeyframeSet)) {
      return new PropertyValuesHolder.IntPropertyValuesHolder(paramString, (IntKeyframeSet)localKeyframeSet);
    }
    if ((localKeyframeSet instanceof FloatKeyframeSet)) {
      return new PropertyValuesHolder.FloatPropertyValuesHolder(paramString, (FloatKeyframeSet)localKeyframeSet);
    }
    paramString = new PropertyValuesHolder(paramString);
    paramString.mKeyframeSet = localKeyframeSet;
    paramString.mValueType = paramVarArgs[0].getType();
    return paramString;
  }
  
  public static <V> PropertyValuesHolder ofObject(Property paramProperty, TypeEvaluator<V> paramTypeEvaluator, V... paramVarArgs)
  {
    paramProperty = new PropertyValuesHolder(paramProperty);
    paramProperty.setObjectValues(paramVarArgs);
    paramProperty.setEvaluator(paramTypeEvaluator);
    return paramProperty;
  }
  
  public static PropertyValuesHolder ofObject(String paramString, TypeEvaluator paramTypeEvaluator, Object... paramVarArgs)
  {
    paramString = new PropertyValuesHolder(paramString);
    paramString.setObjectValues(paramVarArgs);
    paramString.setEvaluator(paramTypeEvaluator);
    return paramString;
  }
  
  private void setupGetter(Class paramClass)
  {
    this.mGetter = setupSetterOrGetter(paramClass, sGetterPropertyMap, "get", null);
  }
  
  private Method setupSetterOrGetter(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    Method localMethod = null;
    for (;;)
    {
      try
      {
        this.mPropertyMapLock.writeLock().lock();
        HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
        if (localHashMap != null) {
          localMethod = (Method)localHashMap.get(this.mPropertyName);
        }
        if (localMethod == null)
        {
          paramClass2 = getPropertyFunction(paramClass1, paramString, paramClass2);
          paramString = localHashMap;
          if (localHashMap == null)
          {
            paramString = new HashMap();
            paramHashMap.put(paramClass1, paramString);
          }
          paramString.put(this.mPropertyName, paramClass2);
          paramClass1 = paramClass2;
          return paramClass1;
        }
      }
      finally
      {
        this.mPropertyMapLock.writeLock().unlock();
      }
      paramClass1 = localMethod;
    }
  }
  
  private void setupValue(Object paramObject, Keyframe paramKeyframe)
  {
    if (this.mProperty != null) {
      paramKeyframe.setValue(this.mProperty.get(paramObject));
    }
    try
    {
      if (this.mGetter == null) {
        setupGetter(paramObject.getClass());
      }
      paramKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
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
  
  void calculateValue(float paramFloat)
  {
    this.mAnimatedValue = this.mKeyframeSet.getValue(paramFloat);
  }
  
  public PropertyValuesHolder clone()
  {
    try
    {
      PropertyValuesHolder localPropertyValuesHolder = (PropertyValuesHolder)super.clone();
      localPropertyValuesHolder.mPropertyName = this.mPropertyName;
      localPropertyValuesHolder.mProperty = this.mProperty;
      localPropertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
      localPropertyValuesHolder.mEvaluator = this.mEvaluator;
      return localPropertyValuesHolder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  Object getAnimatedValue()
  {
    return this.mAnimatedValue;
  }
  
  public String getPropertyName()
  {
    return this.mPropertyName;
  }
  
  void init()
  {
    TypeEvaluator localTypeEvaluator;
    if (this.mEvaluator == null)
    {
      if (this.mValueType != Integer.class) {
        break label44;
      }
      localTypeEvaluator = sIntEvaluator;
    }
    for (;;)
    {
      this.mEvaluator = localTypeEvaluator;
      if (this.mEvaluator != null) {
        this.mKeyframeSet.setEvaluator(this.mEvaluator);
      }
      return;
      label44:
      if (this.mValueType == Float.class) {
        localTypeEvaluator = sFloatEvaluator;
      } else {
        localTypeEvaluator = null;
      }
    }
  }
  
  void setAnimatedValue(Object paramObject)
  {
    if (this.mProperty != null) {
      this.mProperty.set(paramObject, getAnimatedValue());
    }
    if (this.mSetter != null) {}
    try
    {
      this.mTmpValueArray[0] = getAnimatedValue();
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
  
  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    this.mEvaluator = paramTypeEvaluator;
    this.mKeyframeSet.setEvaluator(paramTypeEvaluator);
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = KeyframeSet.ofFloat(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = KeyframeSet.ofInt(paramVarArgs);
  }
  
  public void setKeyframes(Keyframe... paramVarArgs)
  {
    int i = 0;
    int j = paramVarArgs.length;
    Keyframe[] arrayOfKeyframe = new Keyframe[Math.max(j, 2)];
    this.mValueType = paramVarArgs[0].getType();
    for (;;)
    {
      if (i >= j)
      {
        this.mKeyframeSet = new KeyframeSet(arrayOfKeyframe);
        return;
      }
      arrayOfKeyframe[i] = paramVarArgs[i];
      i += 1;
    }
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    this.mValueType = paramVarArgs[0].getClass();
    this.mKeyframeSet = KeyframeSet.ofObject(paramVarArgs);
  }
  
  public void setProperty(Property paramProperty)
  {
    this.mProperty = paramProperty;
  }
  
  public void setPropertyName(String paramString)
  {
    this.mPropertyName = paramString;
  }
  
  void setupEndValue(Object paramObject)
  {
    setupValue(paramObject, (Keyframe)this.mKeyframeSet.mKeyframes.get(this.mKeyframeSet.mKeyframes.size() - 1));
  }
  
  void setupSetter(Class paramClass)
  {
    this.mSetter = setupSetterOrGetter(paramClass, sSetterPropertyMap, "set", this.mValueType);
  }
  
  void setupSetterAndGetter(Object paramObject)
  {
    if (this.mProperty != null) {
      try
      {
        this.mProperty.get(paramObject);
        Iterator localIterator = this.mKeyframeSet.mKeyframes.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            return;
          }
          localObject = (Keyframe)localIterator.next();
          if (!((Keyframe)localObject).hasValue()) {
            ((Keyframe)localObject).setValue(this.mProperty.get(paramObject));
          }
        }
        localClass = paramObject.getClass();
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("PropertyValuesHolder", "No such property (" + this.mProperty.getName() + ") on target object " + paramObject + ". Trying reflection instead");
        this.mProperty = null;
      }
    }
    Class localClass;
    if (this.mSetter == null) {
      setupSetter(localClass);
    }
    Object localObject = this.mKeyframeSet.mKeyframes.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Keyframe localKeyframe = (Keyframe)((Iterator)localObject).next();
      if (!localKeyframe.hasValue())
      {
        if (this.mGetter == null) {
          setupGetter(localClass);
        }
        try
        {
          localKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
      }
    }
  }
  
  void setupStartValue(Object paramObject)
  {
    setupValue(paramObject, (Keyframe)this.mKeyframeSet.mKeyframes.get(0));
  }
  
  public String toString()
  {
    return this.mPropertyName + ": " + this.mKeyframeSet.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder
 * JD-Core Version:    0.7.0.1
 */