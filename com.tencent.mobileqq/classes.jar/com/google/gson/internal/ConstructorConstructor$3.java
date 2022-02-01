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
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to invoke ");
      localStringBuilder.append(this.val$constructor);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to invoke ");
      localStringBuilder.append(this.val$constructor);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.3
 * JD-Core Version:    0.7.0.1
 */