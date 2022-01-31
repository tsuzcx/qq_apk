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
    if (paramMethod == null) {}
    for (;;)
    {
      try
      {
        if (paramMethod.getReturnType() != Void.TYPE) {
          break;
        }
        paramMethod.invoke(paramObject, paramVarArgs);
        return new f(paramObject);
      }
      catch (Exception paramMethod)
      {
        Member localMember;
        throw new h(paramMethod);
      }
      if ((paramMethod instanceof Member))
      {
        localMember = (Member)paramMethod;
        if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()))) {}
      }
      else if (!paramMethod.isAccessible())
      {
        paramMethod.setAccessible(true);
      }
    }
    paramMethod = new f(paramMethod.invoke(paramObject, paramVarArgs));
    return paramMethod;
  }
  
  private static Class a(Class paramClass)
  {
    Class localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
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
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
  }
  
  private Method a(String paramString, Class[] paramArrayOfClass)
  {
    if (this.b) {}
    for (localObject = (Class)this.a;; localObject = this.a.getClass()) {
      try
      {
        Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
        return localMethod1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Class localClass;
        do
        {
          try
          {
            Method localMethod2 = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
            return localMethod2;
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            localClass = ((Class)localObject).getSuperclass();
            localObject = localClass;
          }
        } while (localClass != null);
        throw new NoSuchMethodException();
      }
    }
  }
  
  private boolean a(Method paramMethod, String paramString, Class[] paramArrayOfClass)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramMethod.getName().equals(paramString))
    {
      paramMethod = paramMethod.getParameterTypes();
      if (paramMethod.length != paramArrayOfClass.length) {
        break label102;
      }
      i = 0;
      if (i >= paramArrayOfClass.length) {
        break label96;
      }
      if ((paramArrayOfClass[i] == g.class) || (a(paramMethod[i]).isAssignableFrom(a(paramArrayOfClass[i])))) {
        break label87;
      }
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      label87:
      i += 1;
      break;
      label96:
      i = 1;
      continue;
      label102:
      i = 0;
    }
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
    Class[] arrayOfClass;
    if (paramVarArgs == null) {
      arrayOfClass = new Class[0];
    }
    int i;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = a(a(paramString, arrayOfClass), this.a, paramVarArgs);
        return localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
      arrayOfClass = new Class[paramVarArgs.length];
      i = 0;
      if (i < paramVarArgs.length)
      {
        localObject1 = paramVarArgs[i];
        if (localObject1 == null)
        {
          localObject1 = g.class;
          arrayOfClass[i] = localObject1;
          i += 1;
        }
        else
        {
          localObject1 = localObject1.getClass();
        }
      }
    }
    label318:
    label325:
    label332:
    for (;;)
    {
      Object localObject2;
      try
      {
        Method[] arrayOfMethod1;
        if (this.b)
        {
          localObject2 = (Class)this.a;
          arrayOfMethod1 = ((Class)localObject2).getMethods();
          j = arrayOfMethod1.length;
          i = 0;
          if (i >= j) {
            break label318;
          }
          localObject3 = arrayOfMethod1[i];
          if (!a((Method)localObject3, paramString, arrayOfClass)) {
            break label325;
          }
          localObject2 = localObject3;
          return a((Method)localObject2, this.a, paramVarArgs);
        }
        localObject2 = this.a.getClass();
        continue;
        Method[] arrayOfMethod2 = ((Class)localObject3).getDeclaredMethods();
        int j = arrayOfMethod2.length;
        i = 0;
        if (i < j)
        {
          arrayOfMethod1 = arrayOfMethod2[i];
          localObject2 = arrayOfMethod1;
          if (a(arrayOfMethod1, paramString, arrayOfClass)) {
            continue;
          }
          i += 1;
          continue;
        }
        localObject3 = ((Class)localObject3).getSuperclass();
        if (localObject3 != null) {
          break label332;
        }
        paramVarArgs = new StringBuilder("No similar method ").append(paramString).append(" with params ").append(Arrays.toString(arrayOfClass)).append(" could be found on type ");
        if (this.b)
        {
          paramString = (Class)this.a;
          throw new NoSuchMethodException(paramString + ".");
        }
      }
      catch (NoSuchMethodException paramString)
      {
        throw new h(paramString);
      }
      paramString = this.a.getClass();
      continue;
      Object localObject3 = localObject2;
      continue;
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.apkupdate.b.f
 * JD-Core Version:    0.7.0.1
 */