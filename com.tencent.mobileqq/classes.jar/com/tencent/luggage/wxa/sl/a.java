package com.tencent.luggage.wxa.sl;

import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.a;
import java.lang.reflect.Field;

public class a<Type>
{
  private Class<?> a;
  private String b;
  private boolean c;
  private Field d;
  
  public a(Class<?> paramClass, String paramString)
  {
    if ((paramClass != null) && (paramString != null) && (paramString.length() != 0))
    {
      this.a = paramClass;
      this.b = paramString;
      return;
    }
    throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        localClass = this.a;
        if (localClass == null) {
          break;
        }
      }
      finally
      {
        Class localClass;
        Field localField;
        continue;
        throw localObject;
        continue;
      }
      try
      {
        localField = localClass.getDeclaredField(this.b);
        localField.setAccessible(true);
        this.d = localField;
      }
      catch (Exception localException)
      {
        continue;
      }
      localClass = localClass.getSuperclass();
    }
    this.c = true;
  }
  
  public Type a()
  {
    try
    {
      Object localObject1 = a(false);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public Type a(boolean paramBoolean)
  {
    Object localObject1;
    label72:
    try
    {
      b();
      if (this.d == null)
      {
        if (paramBoolean)
        {
          c.c.b("ReflectFiled", String.format("Field %s is no exists.", new Object[] { this.b }), new Object[0]);
          return null;
        }
        throw new NoSuchFieldException();
      }
    }
    finally {}
    try
    {
      localObject1 = this.d.get(null);
      return localObject1;
    }
    catch (ClassCastException localClassCastException)
    {
      break label72;
    }
    throw new IllegalArgumentException("unable to cast object");
  }
  
  public boolean a(Type paramType)
  {
    try
    {
      boolean bool = a(null, paramType, false);
      return bool;
    }
    finally
    {
      paramType = finally;
      throw paramType;
    }
  }
  
  public boolean a(Object paramObject, Type paramType)
  {
    try
    {
      boolean bool = a(paramObject, paramType, false);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public boolean a(Object paramObject, Type paramType, boolean paramBoolean)
  {
    try
    {
      b();
      if (this.d == null)
      {
        if (paramBoolean)
        {
          c.c.b("ReflectFiled", String.format("Field %s is no exists.", new Object[] { this.b }), new Object[0]);
          return false;
        }
        paramObject = new StringBuilder();
        paramObject.append("Method ");
        paramObject.append(this.b);
        paramObject.append(" is not exists.");
        throw new NoSuchFieldException(paramObject.toString());
      }
      this.d.set(paramObject, paramType);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sl.a
 * JD-Core Version:    0.7.0.1
 */