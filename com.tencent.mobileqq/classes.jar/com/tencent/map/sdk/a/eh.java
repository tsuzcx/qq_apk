package com.tencent.map.sdk.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class eh
{
  static final Type[] a = new Type[0];
  
  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
      i += 1;
    }
    paramArrayOfObject = new NoSuchElementException();
    for (;;)
    {
      throw paramArrayOfObject;
    }
  }
  
  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {
      return (Class)paramTypeVariable;
    }
    return null;
  }
  
  private static ParameterizedType a(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new eh.b(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type a(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      paramType = localClass;
      if (localClass.isArray()) {
        paramType = new eh.a(a(localClass.getComponentType()));
      }
      return (Type)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new eh.b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new eh.a(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new eh.c(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    paramClass = b(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments()[0];
    }
    return Object.class;
  }
  
  private static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      Class[] arrayOfClass = paramClass1.getInterfaces();
      int i = 0;
      int j = arrayOfClass.length;
      while (i < j)
      {
        if (arrayOfClass[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(arrayOfClass[i]))
        {
          paramType = paramClass1.getGenericInterfaces()[i];
          paramClass1 = arrayOfClass[i];
          break label124;
        }
        i += 1;
      }
    }
    if (!paramClass1.isInterface()) {
      for (paramType = paramClass1;; paramType = paramClass1)
      {
        if (paramType == Object.class) {
          return paramClass2;
        }
        paramClass1 = paramType.getSuperclass();
        if (paramClass1 == paramClass2) {
          return paramType.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramClass1))
        {
          paramType = paramType.getGenericSuperclass();
          label124:
          break;
        }
      }
    }
    return paramClass2;
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    while ((paramType2 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)paramType2;
      paramType2 = a(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 == localObject1) {
        return paramType2;
      }
    }
    if ((paramType2 instanceof Class))
    {
      localObject1 = (Class)paramType2;
      if (((Class)localObject1).isArray())
      {
        paramType2 = ((Class)localObject1).getComponentType();
        paramType1 = a(paramType1, paramClass, paramType2);
        if (paramType2 == paramType1) {
          return localObject1;
        }
        return f(paramType1);
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject1 = paramType2.getGenericComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject1);
      if (localObject1 == paramType1) {
        return paramType2;
      }
      return f(paramType1);
    }
    boolean bool = paramType2 instanceof ParameterizedType;
    int k = 0;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject2 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject2).getOwnerType();
      localObject3 = a(paramType1, paramClass, paramType2);
      int i;
      if (localObject3 != paramType2) {
        i = 1;
      } else {
        i = 0;
      }
      paramType2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      int m = paramType2.length;
      while (k < m)
      {
        Type localType = a(paramType1, paramClass, paramType2[k]);
        int j = i;
        localObject1 = paramType2;
        if (localType != paramType2[k])
        {
          j = i;
          localObject1 = paramType2;
          if (i == 0)
          {
            localObject1 = (Type[])paramType2.clone();
            j = 1;
          }
          localObject1[k] = localType;
        }
        k += 1;
        i = j;
        paramType2 = (Type)localObject1;
      }
      if (i != 0) {
        return a((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), paramType2);
      }
      return localObject2;
    }
    Object localObject1 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject2 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = a(paramType1, paramClass, localObject3[0]);
        localObject1 = paramType2;
        if (paramType1 != localObject3[0]) {
          return h(paramType1);
        }
      }
      else
      {
        localObject1 = paramType2;
        if (localObject2.length == 1) {
          localObject1 = localObject2[0];
        }
      }
    }
    try
    {
      paramType1 = a(paramType1, paramClass, (Type)localObject1);
      localObject1 = paramType2;
      if (paramType1 != localObject2[0]) {
        return g(paramType1);
      }
      return localObject1;
    }
    catch (Throwable paramType1) {}
    for (;;)
    {
      throw paramType1;
    }
  }
  
  private static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = a(paramTypeVariable);
    if (localClass == null) {
      return paramTypeVariable;
    }
    paramType = a(paramType, paramClass, localClass);
    if ((paramType instanceof ParameterizedType))
    {
      int i = a(localClass.getTypeParameters(), paramTypeVariable);
      return ((ParameterizedType)paramType).getActualTypeArguments()[i];
    }
    return paramTypeVariable;
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    for (;;)
    {
      if (paramType1 == paramType2) {
        return true;
      }
      if ((paramType1 instanceof Class)) {
        return paramType1.equals(paramType2);
      }
      if ((paramType1 instanceof ParameterizedType))
      {
        if (!(paramType2 instanceof ParameterizedType)) {
          return false;
        }
        paramType1 = (ParameterizedType)paramType1;
        paramType2 = (ParameterizedType)paramType2;
        Type localType1 = paramType1.getOwnerType();
        Type localType2 = paramType2.getOwnerType();
        int i;
        if ((localType1 != localType2) && ((localType1 == null) || (!localType1.equals(localType2)))) {
          i = 0;
        } else {
          i = 1;
        }
        return (i != 0) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()));
      }
      if (!(paramType1 instanceof GenericArrayType)) {
        break;
      }
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      paramType1 = paramType1.getGenericComponentType();
      paramType2 = paramType2.getGenericComponentType();
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      return (Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()));
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  public static Class<?> b(Type paramType)
  {
    for (;;)
    {
      if ((paramType instanceof Class)) {
        return (Class)paramType;
      }
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        eg.a(paramType instanceof Class);
        return (Class)paramType;
      }
      if ((paramType instanceof GenericArrayType)) {
        return Array.newInstance(b(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
      }
      if ((paramType instanceof TypeVariable)) {
        return Object.class;
      }
      if (!(paramType instanceof WildcardType)) {
        break;
      }
      paramType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    paramType = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramType;
    }
  }
  
  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    eg.a(paramClass2.isAssignableFrom(paramClass1));
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class) {
      return new Type[] { String.class, String.class };
    }
    paramType = b(paramType, paramClass, Map.class);
    if ((paramType instanceof ParameterizedType)) {
      return ((ParameterizedType)paramType).getActualTypeArguments();
    }
    return new Type[] { Object.class, Object.class };
  }
  
  public static String c(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return ((Class)paramType).getName();
    }
    return paramType.toString();
  }
  
  public static Type d(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {
      return ((GenericArrayType)paramType).getGenericComponentType();
    }
    return ((Class)paramType).getComponentType();
  }
  
  private static GenericArrayType f(Type paramType)
  {
    return new eh.a(paramType);
  }
  
  private static WildcardType g(Type paramType)
  {
    Type[] arrayOfType = a;
    return new eh.c(new Type[] { paramType }, arrayOfType);
  }
  
  private static WildcardType h(Type paramType)
  {
    return new eh.c(new Type[] { Object.class }, new Type[] { paramType });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh
 * JD-Core Version:    0.7.0.1
 */