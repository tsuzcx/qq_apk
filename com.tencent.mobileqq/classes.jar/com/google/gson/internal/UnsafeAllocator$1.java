package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$1
  extends UnsafeAllocator
{
  UnsafeAllocator$1(Method paramMethod, Object paramObject) {}
  
  public <T> T newInstance(Class<T> paramClass)
  {
    assertInstantiable(paramClass);
    return this.val$allocateInstance.invoke(this.val$unsafe, new Object[] { paramClass });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.1
 * JD-Core Version:    0.7.0.1
 */