package com.tencent.map.sdk.a;

import java.lang.reflect.Type;

final class ei$3
  implements en<T>
{
  private final eq d = eq.a();
  
  ei$3(ei paramei, Class paramClass, Type paramType) {}
  
  public final T a()
  {
    try
    {
      Object localObject = this.d.a(this.a);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Unable to invoke no-args constructor for ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(". Register an InstanceCreator with Gson for this type may fix this problem.");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ei.3
 * JD-Core Version:    0.7.0.1
 */