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
    Object localObject1 = paramString.substring(1);
    Object localObject2 = new StringBuilder(String.valueOf(c));
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder("get");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      this.mGetter = paramClass.getMethod((String)localObject2, null);
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      label92:
      label114:
      break label92;
    }
    try
    {
      this.mGetter = paramClass.getDeclaredMethod((String)localObject2, null);
      this.mGetter.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label114;
    }
    localObject2 = new StringBuilder("is");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      this.mGetter = paramClass.getMethod((String)localObject2, null);
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      label154:
      break label154;
    }
    try
    {
      this.mGetter = paramClass.getDeclaredMethod((String)localObject2, null);
      this.mGetter.setAccessible(true);
      paramString = this.mGetter.getReturnType();
      if (typesMatch(paramClass1, paramString))
      {
        paramClass1 = new StringBuilder("set");
        paramClass1.append((String)localObject1);
        paramClass1 = paramClass1.toString();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      break label293;
    }
    try
    {
      this.mSetter = paramClass.getDeclaredMethod(paramClass1, new Class[] { paramString });
      this.mSetter.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      return;
    }
    paramClass = new StringBuilder("Underlying type (");
    paramClass.append(paramString);
    paramClass.append(") ");
    paramClass.append("does not match Property type (");
    paramClass.append(paramClass1);
    paramClass.append(")");
    throw new NoSuchPropertyException(paramClass.toString());
    try
    {
      label293:
      this.mField = paramClass.getField(paramString);
      paramClass = this.mField.getType();
      if (typesMatch(paramClass1, paramClass)) {
        return;
      }
      localObject1 = new StringBuilder("Underlying type (");
      ((StringBuilder)localObject1).append(paramClass);
      ((StringBuilder)localObject1).append(") ");
      ((StringBuilder)localObject1).append("does not match Property type (");
      ((StringBuilder)localObject1).append(paramClass1);
      ((StringBuilder)localObject1).append(")");
      throw new NoSuchPropertyException(((StringBuilder)localObject1).toString());
    }
    catch (NoSuchFieldException paramClass)
    {
      label382:
      break label382;
    }
    paramClass = new StringBuilder("No accessor method or field found for property with name ");
    paramClass.append(paramString);
    throw new NoSuchPropertyException(paramClass.toString());
  }
  
  private boolean typesMatch(Class<V> paramClass, Class paramClass1)
  {
    if (paramClass1 != paramClass)
    {
      if (paramClass1.isPrimitive())
      {
        if (((paramClass1 != Float.TYPE) || (paramClass != Float.class)) && ((paramClass1 != Integer.TYPE) || (paramClass != Integer.class)) && ((paramClass1 != Boolean.TYPE) || (paramClass != Boolean.class)) && ((paramClass1 != Long.TYPE) || (paramClass != Long.class)) && ((paramClass1 != Double.TYPE) || (paramClass != Double.class)) && ((paramClass1 != Short.TYPE) || (paramClass != Short.class)) && ((paramClass1 != Byte.TYPE) || (paramClass != Byte.class)))
        {
          if (paramClass1 != Character.TYPE) {
            break label120;
          }
          if (paramClass != Character.class) {
            return false;
          }
        }
        return true;
      }
      label120:
      return false;
    }
    return true;
  }
  
  public V get(T paramT)
  {
    Object localObject = this.mGetter;
    if (localObject != null) {}
    try
    {
      paramT = ((Method)localObject).invoke(paramT, null);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      throw new RuntimeException(paramT.getCause());
      throw new AssertionError();
      localObject = this.mField;
      if (localObject != null) {}
      try
      {
        paramT = ((Field)localObject).get(paramT);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        break label56;
      }
      throw new AssertionError();
      throw new AssertionError();
    }
    catch (IllegalAccessException paramT)
    {
      label31:
      label56:
      break label31;
    }
  }
  
  public boolean isReadOnly()
  {
    return (this.mSetter == null) && (this.mField == null);
  }
  
  public void set(T paramT, V paramV)
  {
    Object localObject = this.mSetter;
    if (localObject != null) {}
    try
    {
      ((Method)localObject).invoke(paramT, new Object[] { paramV });
      return;
    }
    catch (InvocationTargetException paramT)
    {
      throw new RuntimeException(paramT.getCause());
      throw new AssertionError();
      localObject = this.mField;
      if (localObject != null) {}
      try
      {
        ((Field)localObject).set(paramT, paramV);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        break label61;
      }
      throw new AssertionError();
      paramT = new StringBuilder("Property ");
      paramT.append(getName());
      paramT.append(" is read-only");
      throw new UnsupportedOperationException(paramT.toString());
    }
    catch (IllegalAccessException paramT)
    {
      label37:
      label61:
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.util.ReflectiveProperty
 * JD-Core Version:    0.7.0.1
 */