package com.tencent.hippy.qq.tuwen.util;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class ReflectWrapper
{
  private static final Map<Class<?>, Class<?>> PRIMARY_MAP = new ArrayMap(7);
  private static final int TYPE_CONSTRUCTOR = 0;
  private static final int TYPE_FIELD = 3;
  private static final int TYPE_METHOD = 1;
  private static final int TYPE_STATIC_FIELD = 4;
  private static final int TYPE_STATIC_METHOD = 2;
  private final Map<String, AccessibleObject> objMap = new ArrayMap();
  
  static
  {
    PRIMARY_MAP.put(Integer.class, Integer.TYPE);
    PRIMARY_MAP.put(Long.class, Long.TYPE);
    PRIMARY_MAP.put(Float.class, Float.TYPE);
    PRIMARY_MAP.put(Double.class, Double.TYPE);
    PRIMARY_MAP.put(Boolean.class, Boolean.TYPE);
    PRIMARY_MAP.put(Byte.class, Byte.TYPE);
    PRIMARY_MAP.put(Character.class, Character.TYPE);
  }
  
  private static void buildKeyWithParamTypes(StringBuilder paramStringBuilder, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfClass[i].getName();
        paramStringBuilder.append('_').append(str);
        i += 1;
      }
    }
  }
  
  @Nullable
  private static Field findField(Class<?> paramClass, String paramString)
  {
    while (paramClass != null) {
      try
      {
        Field localField = paramClass.getDeclaredField(paramString);
        localField.setAccessible(true);
        return localField;
      }
      catch (Exception localException)
      {
        paramClass = paramClass.getSuperclass();
      }
    }
    return null;
  }
  
  @Nullable
  private static Method findMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    while (paramClass != null) {
      try
      {
        Method localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
        localMethod.setAccessible(true);
        return localMethod;
      }
      catch (Exception localException)
      {
        paramClass = paramClass.getSuperclass();
      }
    }
    return null;
  }
  
  @Nullable
  private <T> Constructor<T> getConstructor(Class<T> paramClass, Class<?>... paramVarArgs)
  {
    String str = getKey(paramClass, null, 0, paramVarArgs);
    Constructor localConstructor2 = (Constructor)this.objMap.get(str);
    Constructor localConstructor1 = localConstructor2;
    if (localConstructor2 == null)
    {
      localConstructor1 = paramClass.getConstructor(paramVarArgs);
      localConstructor1.setAccessible(true);
      this.objMap.put(str, localConstructor1);
    }
    return localConstructor1;
  }
  
  @Nullable
  private Field getField(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      String str = getKey(paramClass, paramString, i, new Class[0]);
      Field localField = (Field)this.objMap.get(str);
      Object localObject = localField;
      if (localField == null)
      {
        paramClass = findField(paramClass, paramString);
        localObject = paramClass;
        if (paramClass != null)
        {
          this.objMap.put(str, paramClass);
          localObject = paramClass;
        }
      }
      return localObject;
    }
  }
  
  @Nullable
  private <T> T getFieldValueInner(Class<?> paramClass, Object paramObject, String paramString, boolean paramBoolean)
  {
    paramClass = getField(paramClass, paramString, paramBoolean);
    try
    {
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  private static String getKey(Class paramClass, String paramString, int paramInt, Class<?>... paramVarArgs)
  {
    String str = "";
    if (paramClass != null) {
      str = paramClass.getName();
    }
    paramClass = new StringBuilder().append(str).append('_').append(paramString).append('_').append(paramInt);
    if ((paramInt >= 0) && (paramInt <= 2)) {
      buildKeyWithParamTypes(paramClass, paramVarArgs);
    }
    return paramClass.toString();
  }
  
  @Nullable
  private Method getMethod(Class<?> paramClass, String paramString, boolean paramBoolean, Class<?>... paramVarArgs)
  {
    if (paramBoolean) {}
    String str;
    for (int i = 2;; i = 1)
    {
      str = getKey(paramClass, paramString, i, paramVarArgs);
      Method localMethod2 = (Method)this.objMap.get(str);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        paramClass = findMethod(paramClass, paramString, paramVarArgs);
        if (paramClass != null) {
          break;
        }
        localMethod1 = null;
      }
      return localMethod1;
    }
    this.objMap.put(str, paramClass);
    return paramClass;
  }
  
  private <T> T invokeMethodInner(Class<?> paramClass, Object paramObject, String paramString, boolean paramBoolean, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    paramClass = getMethod(paramClass, paramString, paramBoolean, paramArrayOfClass);
    try
    {
      paramClass = paramClass.invoke(paramObject, paramVarArgs);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  @Nullable
  private static Class<?>[] parsePrimaryClass(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    int j = paramVarArgs.length;
    Class[] arrayOfClass = new Class[j];
    int i = 0;
    while (i < j)
    {
      Class localClass2 = paramVarArgs[i].getClass();
      Class localClass1 = localClass2;
      if (PRIMARY_MAP.containsKey(localClass2)) {
        localClass1 = (Class)PRIMARY_MAP.get(localClass2);
      }
      arrayOfClass[i] = localClass1;
      i += 1;
    }
    return arrayOfClass;
  }
  
  private void setFieldValueInner(Class<?> paramClass, Object paramObject1, String paramString, boolean paramBoolean, Object paramObject2)
  {
    paramClass = getField(paramClass, paramString, paramBoolean);
    try
    {
      paramClass.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramClass) {}
  }
  
  @Nullable
  public <T> T getFieldValue(Object paramObject, String paramString)
  {
    return getFieldValueInner(paramObject.getClass(), paramObject, paramString, false);
  }
  
  @Nullable
  public <T> T getStaticFieldValue(Class<?> paramClass, String paramString)
  {
    return getFieldValueInner(paramClass, null, paramString, true);
  }
  
  @Nullable
  public <T> T invokeMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    return invokeMethodInner(paramObject.getClass(), paramObject, paramString, false, paramArrayOfClass, paramVarArgs);
  }
  
  @Nullable
  public <T> T invokeMethodWithPrimaryType(Object paramObject, String paramString, Object... paramVarArgs)
  {
    return invokeMethod(paramObject, paramString, parsePrimaryClass(paramVarArgs), paramVarArgs);
  }
  
  @Nullable
  public <T> T invokeStaticMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    return invokeMethodInner(paramClass, null, paramString, true, paramArrayOfClass, paramVarArgs);
  }
  
  @Nullable
  public <T> T newInstance(Class<T> paramClass, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = getConstructor(paramClass, paramArrayOfClass).newInstance(paramVarArgs);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public void setFieldValue(Object paramObject1, String paramString, Object paramObject2)
  {
    setFieldValueInner(paramObject1.getClass(), paramObject1, paramString, false, paramObject2);
  }
  
  public void setStaticFieldValue(Class<?> paramClass, String paramString, Object paramObject)
  {
    setFieldValueInner(paramClass, null, paramString, true, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.util.ReflectWrapper
 * JD-Core Version:    0.7.0.1
 */