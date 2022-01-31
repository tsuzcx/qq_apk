package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$3
  extends UnsafeAllocator
{
  UnsafeAllocator$3(Method paramMethod) {}
  
  public <T> T newInstance(Class<T> paramClass)
  {
    assertInstantiable(paramClass);
    return this.val$newInstance.invoke(null, new Object[] { paramClass, Object.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.3
 * JD-Core Version:    0.7.0.1
 */