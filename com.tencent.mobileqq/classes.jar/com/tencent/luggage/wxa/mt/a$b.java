package com.tencent.luggage.wxa.mt;

import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class a$b
  implements InvocationHandler
{
  a$b(a parama) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("Method:");
    paramObject.append(paramMethod);
    paramObject.append(" getName:");
    paramObject.append(paramMethod.getName());
    paramObject.append(" ,Args:");
    paramObject.append(paramArrayOfObject);
    o.d("MicroMsg.WiFiConnector", paramObject.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.a.b
 * JD-Core Version:    0.7.0.1
 */