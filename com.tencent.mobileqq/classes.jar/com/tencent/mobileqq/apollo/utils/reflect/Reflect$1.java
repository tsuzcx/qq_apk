package com.tencent.mobileqq.apollo.utils.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class Reflect$1
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    try
    {
      paramMethod = Reflect.a(Reflect.a(this.b)).a(paramObject, paramArrayOfObject).a();
      return paramMethod;
    }
    catch (ReflectException paramMethod)
    {
      if (this.a)
      {
        Map localMap = (Map)Reflect.a(this.b);
        int i;
        if (paramArrayOfObject == null) {
          i = 0;
        } else {
          i = paramArrayOfObject.length;
        }
        if ((i == 0) && (paramObject.startsWith("get"))) {
          return localMap.get(Reflect.a(paramObject.substring(3)));
        }
        if ((i == 0) && (paramObject.startsWith("is"))) {
          return localMap.get(Reflect.a(paramObject.substring(2)));
        }
        if ((i == 1) && (paramObject.startsWith("set")))
        {
          localMap.put(Reflect.a(paramObject.substring(3)), paramArrayOfObject[0]);
          return null;
        }
      }
      throw paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.reflect.Reflect.1
 * JD-Core Version:    0.7.0.1
 */