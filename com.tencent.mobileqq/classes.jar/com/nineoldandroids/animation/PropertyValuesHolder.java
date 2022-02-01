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
    String str = paramString1;
    if (paramString2 != null)
    {
      if (paramString2.length() == 0) {
        return paramString1;
      }
      char c = Character.toUpperCase(paramString2.charAt(0));
      paramString2 = paramString2.substring(1);
      paramString1 = new StringBuilder(String.valueOf(paramString1));
      paramString1.append(c);
      paramString1.append(paramString2);
      str = paramString1.toString();
    }
    return str;
  }
  
  private Method getPropertyFunction(Class paramClass1, String paramString, Class paramClass2)
  {
    String str = getMethodName(paramString, this.mPropertyName);
    paramString = null;
    if (paramClass2 == null) {
      try
      {
        paramClass2 = paramClass1.getMethod(str, null);
        return paramClass2;
      }
      catch (NoSuchMethodException paramClass2) {}
    }
    try
    {
      paramClass1 = paramClass1.getDeclaredMethod(str, null);
      paramString = paramClass1;
      paramClass1.setAccessible(true);
      return paramClass1;
    }
    catch (NoSuchMethodException paramClass1)
    {
      label44:
      Class[] arrayOfClass;
      int j;
      int i;
      break label44;
    }
    paramClass1 = new StringBuilder("Couldn't find no-arg method for property ");
    paramClass1.append(this.mPropertyName);
    paramClass1.append(": ");
    paramClass1.append(paramClass2);
    Log.e("PropertyValuesHolder", paramClass1.toString());
    return paramString;
    arrayOfClass = new Class[1];
    if (this.mValueType.equals(Float.class))
    {
      paramString = FLOAT_VARIANTS;
    }
    else if (this.mValueType.equals(Integer.class))
    {
      paramString = INTEGER_VARIANTS;
    }
    else if (this.mValueType.equals(Double.class))
    {
      paramString = DOUBLE_VARIANTS;
    }
    else
    {
      paramString = new Class[1];
      paramString[0] = this.mValueType;
    }
    j = paramString.length;
    paramClass2 = null;
    i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramClass1 = new StringBuilder("Couldn't find setter/getter for property ");
        paramClass1.append(this.mPropertyName);
        paramClass1.append(" with value type ");
        paramClass1.append(this.mValueType);
        Log.e("PropertyValuesHolder", paramClass1.toString());
        return paramClass2;
      }
      Object localObject = paramString[i];
      arrayOfClass[0] = localObject;
      try
      {
        localMethod = paramClass1.getMethod(str, arrayOfClass);
        paramClass2 = localMethod;
        this.mValueType = localObject;
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Method localMethod;
        label260:
        label291:
        break label260;
      }
      try
      {
        localMethod = paramClass1.getDeclaredMethod(str, arrayOfClass);
        paramClass2 = localMethod;
        localMethod.setAccessible(true);
        paramClass2 = localMethod;
        this.mValueType = localObject;
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label291;
      }
      i += 1;
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
    for (;;)
    {
      try
      {
        this.mPropertyMapLock.writeLock().lock();
        HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
        if (localHashMap != null)
        {
          localMethod1 = (Method)localHashMap.get(this.mPropertyName);
          Method localMethod2 = localMethod1;
          if (localMethod1 == null)
          {
            localMethod2 = getPropertyFunction(paramClass1, paramString, paramClass2);
            paramString = localHashMap;
            if (localHashMap == null)
            {
              paramString = new HashMap();
              paramHashMap.put(paramClass1, paramString);
            }
            paramString.put(this.mPropertyName, localMethod2);
          }
          return localMethod2;
        }
      }
      finally
      {
        this.mPropertyMapLock.writeLock().unlock();
      }
      Method localMethod1 = null;
    }
  }
  
  private void setupValue(Object paramObject, Keyframe paramKeyframe)
  {
    Property localProperty = this.mProperty;
    if (localProperty != null) {
      paramKeyframe.setValue(localProperty.get(paramObject));
    }
    try
    {
      if (this.mGetter == null) {
        setupGetter(paramObject.getClass());
      }
      paramKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", paramObject.toString());
      return;
    }
    catch (InvocationTargetException paramObject)
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
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label45:
      break label45;
    }
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
    if (this.mEvaluator == null)
    {
      localObject = this.mValueType;
      if (localObject == Integer.class) {
        localObject = sIntEvaluator;
      } else if (localObject == Float.class) {
        localObject = sFloatEvaluator;
      } else {
        localObject = null;
      }
      this.mEvaluator = ((TypeEvaluator)localObject);
    }
    Object localObject = this.mEvaluator;
    if (localObject != null) {
      this.mKeyframeSet.setEvaluator((TypeEvaluator)localObject);
    }
  }
  
  void setAnimatedValue(Object paramObject)
  {
    Property localProperty = this.mProperty;
    if (localProperty != null) {
      localProperty.set(paramObject, getAnimatedValue());
    }
    if (this.mSetter != null) {
      try
      {
        this.mTmpValueArray[0] = getAnimatedValue();
        this.mSetter.invoke(paramObject, this.mTmpValueArray);
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        Log.e("PropertyValuesHolder", paramObject.toString());
        return;
      }
      catch (InvocationTargetException paramObject)
      {
        Log.e("PropertyValuesHolder", paramObject.toString());
      }
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
    int j = paramVarArgs.length;
    Keyframe[] arrayOfKeyframe = new Keyframe[Math.max(j, 2)];
    int i = 0;
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
    Object localObject1 = this.mProperty;
    if (localObject1 != null) {}
    try
    {
      ((Property)localObject1).get(paramObject);
      localObject1 = this.mKeyframeSet.mKeyframes.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          return;
        }
        localObject2 = (Keyframe)((Iterator)localObject1).next();
        if (!((Keyframe)localObject2).hasValue()) {
          ((Keyframe)localObject2).setValue(this.mProperty.get(paramObject));
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      label68:
      break label68;
    }
    localObject1 = new StringBuilder("No such property (");
    ((StringBuilder)localObject1).append(this.mProperty.getName());
    ((StringBuilder)localObject1).append(") on target object ");
    ((StringBuilder)localObject1).append(paramObject);
    ((StringBuilder)localObject1).append(". Trying reflection instead");
    Log.e("PropertyValuesHolder", ((StringBuilder)localObject1).toString());
    this.mProperty = null;
    localObject1 = paramObject.getClass();
    if (this.mSetter == null) {
      setupSetter((Class)localObject1);
    }
    localObject2 = this.mKeyframeSet.mKeyframes.iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        return;
      }
      Keyframe localKeyframe = (Keyframe)((Iterator)localObject2).next();
      if (!localKeyframe.hasValue())
      {
        if (this.mGetter == null) {
          setupGetter((Class)localObject1);
        }
        try
        {
          localKeyframe.setValue(this.mGetter.invoke(paramObject, new Object[0]));
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
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
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.mPropertyName));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.mKeyframeSet.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder
 * JD-Core Version:    0.7.0.1
 */