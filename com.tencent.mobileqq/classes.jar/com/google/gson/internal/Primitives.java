package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives
{
  private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
  private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
  
  static
  {
    HashMap localHashMap1 = new HashMap(16);
    HashMap localHashMap2 = new HashMap(16);
    add(localHashMap1, localHashMap2, Boolean.TYPE, Boolean.class);
    add(localHashMap1, localHashMap2, Byte.TYPE, Byte.class);
    add(localHashMap1, localHashMap2, Character.TYPE, Character.class);
    add(localHashMap1, localHashMap2, Double.TYPE, Double.class);
    add(localHashMap1, localHashMap2, Float.TYPE, Float.class);
    add(localHashMap1, localHashMap2, Integer.TYPE, Integer.class);
    add(localHashMap1, localHashMap2, Long.TYPE, Long.class);
    add(localHashMap1, localHashMap2, Short.TYPE, Short.class);
    add(localHashMap1, localHashMap2, Void.TYPE, Void.class);
    PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(localHashMap1);
    WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(localHashMap2);
  }
  
  private Primitives()
  {
    throw new UnsupportedOperationException();
  }
  
  private static void add(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2)
  {
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
  }
  
  public static boolean isPrimitive(Type paramType)
  {
    return PRIMITIVE_TO_WRAPPER_TYPE.containsKey(paramType);
  }
  
  public static boolean isWrapperType(Type paramType)
  {
    return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(.Gson.Preconditions.checkNotNull(paramType));
  }
  
  public static <T> Class<T> unwrap(Class<T> paramClass)
  {
    Class localClass = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(.Gson.Preconditions.checkNotNull(paramClass));
    if (localClass == null) {
      return paramClass;
    }
    return localClass;
  }
  
  public static <T> Class<T> wrap(Class<T> paramClass)
  {
    Class localClass = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(.Gson.Preconditions.checkNotNull(paramClass));
    if (localClass == null) {
      return paramClass;
    }
    return localClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.Primitives
 * JD-Core Version:    0.7.0.1
 */