package com.samskivert.mustache;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultCollector
  extends BasicCollector
{
  private final boolean _allowAccessCoercion;
  
  public DefaultCollector()
  {
    this(true);
  }
  
  public DefaultCollector(boolean paramBoolean)
  {
    this._allowAccessCoercion = paramBoolean;
  }
  
  private void addIfaces(Set<Class<?>> paramSet, Class<?> paramClass, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramSet.add(paramClass);
    }
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      addIfaces(paramSet, paramClass[i], true);
      i += 1;
    }
  }
  
  private Method makeAccessible(Method paramMethod)
  {
    if (paramMethod.isAccessible()) {
      return paramMethod;
    }
    if (!this._allowAccessCoercion) {
      return null;
    }
    paramMethod.setAccessible(true);
    return paramMethod;
  }
  
  public Mustache.VariableFetcher createFetcher(Object paramObject, String paramString)
  {
    Object localObject = super.createFetcher(paramObject, paramString);
    if (localObject != null) {
      return localObject;
    }
    paramObject = paramObject.getClass();
    localObject = getMethod(paramObject, paramString);
    if (localObject != null) {
      return new DefaultCollector.1(this, (Method)localObject);
    }
    localObject = getField(paramObject, paramString);
    if (localObject != null) {
      return new DefaultCollector.2(this, (Field)localObject);
    }
    paramObject = getIfaceMethod(paramObject, paramString);
    if (paramObject != null) {
      return new DefaultCollector.3(this, paramObject);
    }
    return null;
  }
  
  public <K, V> Map<K, V> createFetcherCache()
  {
    return new ConcurrentHashMap();
  }
  
  protected Field getField(Class<?> paramClass, String paramString)
  {
    Object localObject2 = null;
    if (!this._allowAccessCoercion) {}
    for (;;)
    {
      Field localField;
      Class localClass;
      Object localObject1;
      try
      {
        localField = paramClass.getField(paramString);
        return localField;
      }
      catch (Exception paramClass) {}
      try
      {
        localField = paramClass.getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (Exception localException)
      {
        localClass = paramClass.getSuperclass();
        localObject1 = localObject2;
      }
      if (localClass != Object.class)
      {
        localObject1 = localObject2;
        if (localClass != null) {
          return getField(paramClass.getSuperclass(), paramString);
        }
      }
    }
    return null;
  }
  
  protected Method getIfaceMethod(Class<?> paramClass, String paramString)
  {
    Object localObject = new LinkedHashSet();
    while ((paramClass != null) && (paramClass != Object.class))
    {
      addIfaces((Set)localObject, paramClass, false);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = ((Set)localObject).iterator();
    while (paramClass.hasNext())
    {
      localObject = getMethodOn((Class)paramClass.next(), paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  protected Method getMethod(Class<?> paramClass, String paramString)
  {
    if (this._allowAccessCoercion) {
      while ((paramClass != null) && (paramClass != Object.class))
      {
        Method localMethod = getMethodOn(paramClass, paramString);
        if (localMethod != null) {
          return localMethod;
        }
        paramClass = paramClass.getSuperclass();
      }
    }
    try
    {
      paramClass = paramClass.getMethod(paramString, new Class[0]);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  protected Method getMethodOn(Class<?> paramClass, String paramString)
  {
    try
    {
      Method localMethod1 = paramClass.getDeclaredMethod(paramString, new Class[0]);
      if (!localMethod1.getReturnType().equals(Void.TYPE))
      {
        localMethod1 = makeAccessible(localMethod1);
        return localMethod1;
      }
    }
    catch (Exception localException1)
    {
      paramString = Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1);
      try
      {
        Method localMethod2 = paramClass.getDeclaredMethod("get" + paramString, new Class[0]);
        if (!localMethod2.getReturnType().equals(Void.TYPE))
        {
          localMethod2 = makeAccessible(localMethod2);
          return localMethod2;
        }
      }
      catch (Exception localException2)
      {
        try
        {
          paramClass = paramClass.getDeclaredMethod("is" + paramString, new Class[0]);
          if ((paramClass.getReturnType().equals(Boolean.TYPE)) || (paramClass.getReturnType().equals(Boolean.class)))
          {
            paramClass = makeAccessible(paramClass);
            return paramClass;
          }
        }
        catch (Exception paramClass) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.DefaultCollector
 * JD-Core Version:    0.7.0.1
 */