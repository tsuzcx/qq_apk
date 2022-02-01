package com.tencent.map.sdk.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

final class ei$5
  implements en<T>
{
  ei$5(ei paramei, Constructor paramConstructor) {}
  
  public final T a()
  {
    try
    {
      Object localObject = this.a.newInstance(null);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder("Failed to invoke ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to invoke ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ei.5
 * JD-Core Version:    0.7.0.1
 */