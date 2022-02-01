package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class GenericTypeReflector
{
  public static Class<?> getType(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramType).getRawType();
    }
    if ((paramType instanceof TypeVariable))
    {
      paramType = (TypeVariable)paramType;
      if (paramType.getBounds().length == 0) {
        return Object.class;
      }
      return getType(paramType.getBounds()[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not supported: ");
    localStringBuilder.append(paramType.getClass());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.gentyref.GenericTypeReflector
 * JD-Core Version:    0.7.0.1
 */