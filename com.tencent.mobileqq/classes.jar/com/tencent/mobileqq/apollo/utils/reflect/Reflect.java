package com.tencent.mobileqq.apollo.utils.reflect;

import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflect
{
  private static SparseArray<Class> a = new SparseArray();
  private static SparseArray<Method> b = new SparseArray();
  private static SparseArray<Constructor> c = new SparseArray();
  private static SparseArray<Field> d = new SparseArray();
  private final Object e;
  private final boolean f;
  
  private Reflect(Object paramObject)
  {
    this.e = paramObject;
    this.f = false;
  }
  
  public static Reflect a(Object paramObject)
  {
    return new Reflect(paramObject);
  }
  
  private static Reflect a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return a(paramObject);
      }
      paramMethod = a(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      throw new ReflectException(paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      throw new ReflectException(paramMethod.getTargetException());
    }
  }
  
  public static Class<?> a(Class<?> paramClass)
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
  
  public static <T extends AccessibleObject> T a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    if ((paramT instanceof Member))
    {
      Member localMember = (Member)paramT;
      if ((Modifier.isPublic(localMember.getModifiers())) && (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()))) {
        return paramT;
      }
    }
    if (!paramT.isAccessible()) {
      paramT.setAccessible(true);
    }
    return paramT;
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    Class localClass = b();
    label69:
    do
    {
      try
      {
        i = localClass.hashCode() + paramString.hashCode() + Arrays.hashCode(paramArrayOfClass);
        if (b.get(i) != null) {
          return (Method)b.get(i);
        }
        localMethod = localClass.getMethod(paramString, paramArrayOfClass);
        if (localMethod != null) {
          b.put(i, localMethod);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        int i;
        Method localMethod;
        break label69;
      }
      try
      {
        i = localClass.hashCode() + paramString.hashCode() + Arrays.hashCode(paramArrayOfClass);
        if (b.get(i) != null) {
          return (Method)b.get(i);
        }
        localMethod = (Method)a(localClass.getDeclaredMethod(paramString, paramArrayOfClass));
        if (localMethod != null)
        {
          b.put(i, localMethod);
          return localMethod;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Log.w("Reflect", "error, ", localNoSuchMethodException1);
        localClass = localClass.getSuperclass();
      }
    } while (localClass != null);
    paramString = new NoSuchMethodException();
    for (;;)
    {
      throw paramString;
    }
  }
  
  private boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    return (paramMethod.getName().equals(paramString)) && (a(paramMethod.getParameterTypes(), paramArrayOfClass));
  }
  
  private boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      while (i < paramArrayOfClass2.length) {
        if ((paramArrayOfClass2[i] == Reflect.NULL.class) || (a(paramArrayOfClass1[i]).isAssignableFrom(a(paramArrayOfClass2[i])))) {
          i += 1;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {
        localObject = Reflect.NULL.class;
      } else {
        localObject = localObject.getClass();
      }
      arrayOfClass[i] = localObject;
      i += 1;
    }
    return arrayOfClass;
  }
  
  private static String b(String paramString)
  {
    int i = paramString.length();
    if (i == 0) {
      return "";
    }
    if (i == 1) {
      return paramString.toLowerCase();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 1).toLowerCase());
    localStringBuilder.append(paramString.substring(1));
    return localStringBuilder.toString();
  }
  
  private Method b(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = b();
    Method[] arrayOfMethod = ((Class)localObject2).getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = arrayOfMethod[i];
      if (a((Method)localObject1, paramString, paramArrayOfClass)) {
        return localObject1;
      }
      i += 1;
    }
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredMethods();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        arrayOfMethod = localObject2[i];
        if (a(arrayOfMethod, paramString, paramArrayOfClass)) {
          return arrayOfMethod;
        }
        i += 1;
      }
      localObject1 = ((Class)localObject1).getSuperclass();
    } while (localObject1 != null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No similar method ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" with params ");
    ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfClass));
    ((StringBuilder)localObject1).append(" could be found on type ");
    ((StringBuilder)localObject1).append(b());
    ((StringBuilder)localObject1).append(".");
    paramString = new NoSuchMethodException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Reflect a(String paramString, Object... paramVarArgs)
  {
    Class[] arrayOfClass = a(paramVarArgs);
    for (;;)
    {
      try
      {
        Reflect localReflect = a(a(paramString, arrayOfClass), this.e, paramVarArgs);
        return localReflect;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        continue;
      }
      try
      {
        paramString = a((Method)a(b(paramString, arrayOfClass)), this.e, paramVarArgs);
        return paramString;
      }
      catch (NoSuchMethodException paramString)
      {
        throw new ReflectException(paramString);
      }
    }
  }
  
  public <T> T a()
  {
    return this.e;
  }
  
  public Class<?> b()
  {
    if (this.f) {
      return (Class)this.e;
    }
    return this.e.getClass();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Reflect)) {
      return this.e.equals(((Reflect)paramObject).a());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    return this.e.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.reflect.Reflect
 * JD-Core Version:    0.7.0.1
 */