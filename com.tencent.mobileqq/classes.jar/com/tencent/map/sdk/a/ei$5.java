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
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ei.5
 * JD-Core Version:    0.7.0.1
 */