package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstructorConstructor$3
  implements ObjectConstructor<T>
{
  ConstructorConstructor$3(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor) {}
  
  public T construct()
  {
    try
    {
      Object localObject = this.val$constructor.newInstance(null);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.3
 * JD-Core Version:    0.7.0.1
 */