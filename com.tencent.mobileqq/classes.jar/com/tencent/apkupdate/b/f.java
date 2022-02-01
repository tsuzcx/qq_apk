package com.tencent.apkupdate.b;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class f
{
  private final Object a;
  private final boolean b;
  
  private f(Class paramClass)
  {
    this.a = paramClass;
    this.b = true;
  }
  
  private f(Object paramObject)
  {
    this.a = paramObject;
    this.b = false;
  }
  
  public static f a(String paramString)
  {
    return new f(b(paramString));
  }
  
  private static f a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    if (paramMethod != null) {}
    try
    {
      if ((paramMethod instanceof Member))
      {
        Member localMember = (Member)paramMethod;
        if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()))) {}
      }
      else if (!paramMethod.isAccessible())
      {
        paramMethod.setAccessible(true);
      }
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return new f(paramObject);
      }
      paramMethod = new f(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      throw new h(paramMethod);
    }
  }
  
  private static Class a(Class paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    Object localObject = paramClass;
    if (paramClass.isPrimitive())
    {
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localObject = paramClass;
      if (Void.TYPE == paramClass) {
        localObject = Void.class;
      }
    }
    return localObject;
  }
  
  private Method a(String paramString, Class[] paramArrayOfClass)
  {
    Class localClass;
    if (this.b) {
      localClass = (Class)this.a;
    } else {
      localClass = this.a.getClass();
    }
    label37:
    label48:
    do
    {
      try
      {
        localMethod = localClass.getMethod(paramString, paramArrayOfClass);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Method localMethod;
        break label37;
      }
      try
      {
        localMethod = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label48;
      }
      localClass = localClass.getSuperclass();
    } while (localClass != null);
    paramString = new NoSuchMethodException();
    for (;;)
    {
      throw paramString;
    }
  }
  
  private boolean a(Method paramMethod, String paramString, Class[] paramArrayOfClass)
  {
    if (paramMethod.getName().equals(paramString))
    {
      paramMethod = paramMethod.getParameterTypes();
      int i;
      if (paramMethod.length == paramArrayOfClass.length)
      {
        i = 0;
        while (i < paramArrayOfClass.length)
        {
          if ((paramArrayOfClass[i] != g.class) && (!a(paramMethod[i]).isAssignableFrom(a(paramArrayOfClass[i])))) {
            break label80;
          }
          i += 1;
        }
        i = 1;
      }
      else
      {
        label80:
        i = 0;
      }
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  private static Class b(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new h(paramString);
    }
  }
  
  public final f a(String paramString, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramVarArgs == null)
    {
      localObject2 = new Class[0];
    }
    else
    {
      localObject3 = new Class[paramVarArgs.length];
      i = 0;
      for (;;)
      {
        localObject2 = localObject3;
        if (i >= paramVarArgs.length) {
          break;
        }
        localObject1 = paramVarArgs[i];
        if (localObject1 == null) {
          localObject1 = g.class;
        } else {
          localObject1 = localObject1.getClass();
        }
        localObject3[i] = localObject1;
        i += 1;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = a(a(paramString, (Class[])localObject2), this.a, paramVarArgs);
        return localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Method[] arrayOfMethod;
        int j;
        continue;
        i += 1;
        continue;
        i += 1;
        continue;
      }
      try
      {
        if (this.b) {
          localObject1 = (Class)this.a;
        } else {
          localObject1 = this.a.getClass();
        }
        arrayOfMethod = ((Class)localObject1).getMethods();
        j = arrayOfMethod.length;
        i = 0;
        localObject3 = localObject1;
        if (i < j)
        {
          localObject3 = arrayOfMethod[i];
          if (!a((Method)localObject3, paramString, (Class[])localObject2)) {
            continue;
          }
          paramString = (String)localObject3;
        }
        else
        {
          arrayOfMethod = ((Class)localObject3).getDeclaredMethods();
          j = arrayOfMethod.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject1 = arrayOfMethod[i];
          if (!a((Method)localObject1, paramString, (Class[])localObject2)) {
            continue;
          }
          paramString = (String)localObject1;
        }
        return a(paramString, this.a, paramVarArgs);
        localObject1 = ((Class)localObject3).getSuperclass();
        localObject3 = localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramVarArgs = new StringBuilder("No similar method ");
        paramVarArgs.append(paramString);
        paramVarArgs.append(" with params ");
        paramVarArgs.append(Arrays.toString((Object[])localObject2));
        paramVarArgs.append(" could be found on type ");
        if (this.b) {
          paramString = (Class)this.a;
        } else {
          paramString = this.a.getClass();
        }
        paramVarArgs.append(paramString);
        paramVarArgs.append(".");
        throw new NoSuchMethodException(paramVarArgs.toString());
      }
      catch (NoSuchMethodException paramString)
      {
        paramString = new h(paramString);
        continue;
        throw paramString;
      }
    }
  }
  
  public final Object a()
  {
    return this.a;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      return this.a.equals(((f)paramObject).a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.f
 * JD-Core Version:    0.7.0.1
 */