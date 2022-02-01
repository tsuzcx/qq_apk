package com.tencent.luggage.wxa.pd;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class g
  implements InvocationHandler
{
  public static <I> I a(@NonNull String paramString, @NonNull Class<I> paramClass)
  {
    paramString = new g.1(paramString);
    return paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramString));
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getReturnType();
    boolean bool = paramObject.equals(Integer.TYPE);
    paramMethod = Boolean.valueOf(false);
    paramArrayOfObject = Integer.valueOf(0);
    if (bool) {
      return paramArrayOfObject;
    }
    if (paramObject.equals(Long.TYPE)) {
      return Long.valueOf(0L);
    }
    if (paramObject.equals(Double.TYPE)) {
      return Double.valueOf(0.0D);
    }
    if (paramObject.equals(Float.TYPE)) {
      return Float.valueOf(0.0F);
    }
    if (paramObject.equals(Short.TYPE)) {
      return paramArrayOfObject;
    }
    if (paramObject.equals(Byte.TYPE)) {
      return paramArrayOfObject;
    }
    if (paramObject.equals(Character.TYPE)) {
      return paramArrayOfObject;
    }
    if (paramObject.equals(Boolean.TYPE)) {
      return paramMethod;
    }
    if (paramObject.equals(Boolean.class)) {
      return paramMethod;
    }
    if (paramObject.isInterface()) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.g
 * JD-Core Version:    0.7.0.1
 */