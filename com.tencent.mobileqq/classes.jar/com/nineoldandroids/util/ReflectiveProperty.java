package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V>
  extends Property<T, V>
{
  private static final String PREFIX_GET = "get";
  private static final String PREFIX_IS = "is";
  private static final String PREFIX_SET = "set";
  private Field mField;
  private Method mGetter;
  private Method mSetter;
  
  public ReflectiveProperty(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    super(paramClass1, paramString);
    char c = Character.toUpperCase(paramString.charAt(0));
    String str1 = paramString.substring(1);
    str1 = c + str1;
    String str2 = "get" + str1;
    try
    {
      this.mGetter = paramClass.getMethod(str2, null);
      paramString = this.mGetter.getReturnType();
      if (!typesMatch(paramClass1, paramString)) {
        throw new NoSuchPropertyException("Underlying type (" + paramString + ") " + "does not match Property type (" + paramClass1 + ")");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      try
      {
        this.mGetter = paramClass.getDeclaredMethod(str2, null);
        this.mGetter.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          String str3 = "is" + str1;
          try
          {
            this.mGetter = paramClass.getMethod(str3, null);
          }
          catch (NoSuchMethodException localNoSuchMethodException4)
          {
            try
            {
              this.mGetter = paramClass.getDeclaredMethod(str3, null);
              this.mGetter.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              try
              {
                this.mField = paramClass.getField(paramString);
                paramClass = this.mField.getType();
                if (typesMatch(paramClass1, paramClass)) {
                  break label357;
                }
                throw new NoSuchPropertyException("Underlying type (" + paramClass + ") " + "does not match Property type (" + paramClass1 + ")");
              }
              catch (NoSuchFieldException paramClass)
              {
                throw new NoSuchPropertyException("No accessor method or field found for property with name " + paramString);
              }
            }
          }
        }
      }
      paramClass1 = "set" + localNoSuchMethodException1;
      try
      {
        this.mSetter = paramClass.getDeclaredMethod(paramClass1, new Class[] { paramString });
        this.mSetter.setAccessible(true);
        label357:
        return;
      }
      catch (NoSuchMethodException paramClass) {}
    }
  }
  
  private boolean typesMatch(Class<V> paramClass, Class paramClass1)
  {
    if (paramClass1 != paramClass) {
      return (paramClass1.isPrimitive()) && (((paramClass1 == Float.TYPE) && (paramClass == Float.class)) || ((paramClass1 == Integer.TYPE) && (paramClass == Integer.class)) || ((paramClass1 == Boolean.TYPE) && (paramClass == Boolean.class)) || ((paramClass1 == Long.TYPE) && (paramClass == Long.class)) || ((paramClass1 == Double.TYPE) && (paramClass == Double.class)) || ((paramClass1 == Short.TYPE) && (paramClass == Short.class)) || ((paramClass1 == Byte.TYPE) && (paramClass == Byte.class)) || ((paramClass1 == Character.TYPE) && (paramClass == Character.class)));
    }
    return true;
  }
  
  public V get(T paramT)
  {
    if (this.mGetter != null) {
      try
      {
        paramT = this.mGetter.invoke(paramT, null);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.mField != null) {
      try
      {
        paramT = this.mField.get(paramT);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new AssertionError();
  }
  
  public boolean isReadOnly()
  {
    return (this.mSetter == null) && (this.mField == null);
  }
  
  public void set(T paramT, V paramV)
  {
    if (this.mSetter != null) {
      try
      {
        this.mSetter.invoke(paramT, new Object[] { paramV });
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.mField != null) {
      try
      {
        this.mField.set(paramT, paramV);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.util.ReflectiveProperty
 * JD-Core Version:    0.7.0.1
 */