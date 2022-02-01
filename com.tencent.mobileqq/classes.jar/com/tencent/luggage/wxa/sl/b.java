package com.tencent.luggage.wxa.sl;

import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.a;
import java.lang.reflect.Method;

public class b
{
  private Class<?> a;
  private String b;
  private boolean c;
  private Method d;
  private Class[] e;
  
  public b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if ((paramClass != null) && (paramString != null) && (paramString.length() != 0))
    {
      this.a = paramClass;
      this.b = paramString;
      this.e = paramVarArgs;
      return;
    }
    throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
  }
  
  private void a()
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
        Method localMethod;
        continue;
        throw localObject;
        continue;
      }
      try
      {
        localMethod = localClass.getDeclaredMethod(this.b, this.e);
        localMethod.setAccessible(true);
        this.d = localMethod;
      }
      catch (Exception localException)
      {
        continue;
      }
      localClass = localClass.getSuperclass();
    }
    this.c = true;
  }
  
  public <T> T a(Object paramObject, boolean paramBoolean, Object... paramVarArgs)
  {
    try
    {
      a();
      if (this.d == null)
      {
        if (paramBoolean)
        {
          c.c.b("ReflectFiled", "Field %s is no exists", new Object[] { this.b });
          return null;
        }
        paramObject = new StringBuilder();
        paramObject.append("Method ");
        paramObject.append(this.b);
        paramObject.append(" is not exists.");
        throw new NoSuchFieldException(paramObject.toString());
      }
      paramObject = this.d.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    finally {}
  }
  
  public <T> T a(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramObject = a(paramObject, false, paramVarArgs);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sl.b
 * JD-Core Version:    0.7.0.1
 */