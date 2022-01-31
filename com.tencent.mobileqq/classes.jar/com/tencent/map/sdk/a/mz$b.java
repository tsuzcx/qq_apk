package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.net.annotation.NetHead;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.sdk.service.protocol.ServiceProtocol;
import com.tencent.map.tools.net.NetMethod;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

final class mz$b
  implements InvocationHandler
{
  private Class<? extends mz> b;
  
  mz$b(Class<? extends mz> paramClass)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int i = 0;
    mz.a locala = new mz.a(this.a, (byte)0);
    paramObject = (NetRequest)paramMethod.getAnnotation(NetRequest.class);
    if (paramObject != null)
    {
      locala.a = this.b.getSimpleName();
      locala.i = paramObject.method();
      locala.b = paramMethod.getName();
      locala.g = paramObject.userAgent();
      locala.d = paramObject.queryKeys();
      locala.h = paramObject.retry();
      Object localObject = paramObject.head();
      paramMethod = ((NetHead)localObject).keys();
      localObject = ((NetHead)localObject).values();
      if ((paramMethod.length > 0) && (paramMethod.length == localObject.length))
      {
        locala.e = new HashMap();
        while (i < paramMethod.length)
        {
          locala.e.put(paramMethod[i], localObject[i]);
          i += 1;
        }
      }
      paramMethod = new StringBuilder();
      paramMethod.append(this.a.e());
      localObject = paramObject.path();
      if (((String)localObject).length() != 0) {
        paramMethod.append("/").append((String)localObject);
      }
      locala.f = paramObject.constQuery();
      locala.c = paramMethod.toString();
    }
    if (!ServiceProtocol.allow(this.b)) {
      return null;
    }
    if (locala.i == NetMethod.URL)
    {
      paramMethod = locala.c;
      paramArrayOfObject = mz.b(locala, paramArrayOfObject);
      paramObject = paramMethod;
      if (paramArrayOfObject.length() != 0) {
        paramObject = paramMethod + "?" + paramArrayOfObject;
      }
      locala.c = paramObject;
      return paramObject;
    }
    return mz.a(locala, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.mz.b
 * JD-Core Version:    0.7.0.1
 */