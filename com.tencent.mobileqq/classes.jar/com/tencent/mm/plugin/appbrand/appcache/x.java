package com.tencent.mm.plugin.appbrand.appcache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class x
  implements InvocationHandler
{
  private final Map<String, Method> a = new ConcurrentHashMap();
  private final x.b b;
  
  private x(@NonNull h paramh)
  {
    this.b = new x.b(paramh, null);
  }
  
  public static IWxaFileSystemWithModularizing a(@NonNull d paramd)
  {
    try
    {
      paramd = new x(ad.b(paramd));
      paramd = (IWxaFileSystemWithModularizing)Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[] { IWxaFileSystemWithModularizing.class }, paramd);
      return paramd;
    }
    catch (Exception paramd)
    {
      o.b("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[] { paramd });
    }
    return new x.a(null);
  }
  
  private static Object a(@NonNull Method paramMethod, j paramj)
  {
    if (paramMethod.getReturnType().equals(j.class)) {
      return paramj;
    }
    return null;
  }
  
  @Nullable
  private Method a(@NonNull Method paramMethod)
  {
    String str = paramMethod.toGenericString();
    Method localMethod2 = (Method)this.a.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = y.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.a.put(str, paramMethod);
        localMethod1 = paramMethod;
      }
    }
    return localMethod1;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getReturnType().equals(Boolean.TYPE)) {
      return Boolean.TRUE;
    }
    if (Modifier.isStatic(paramMethod.getModifiers())) {
      return null;
    }
    if (paramMethod.getReturnType().equals(v.a.class)) {
      try
      {
        paramObject = x.b.a(this.b).c((String)paramArrayOfObject[0]);
        if (paramObject != null)
        {
          paramObject = paramObject.a();
          return paramObject;
        }
        return null;
      }
      catch (Throwable paramObject)
      {
        o.b("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), call openReadPartialInfo get exception(%s)", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject), paramObject });
        return null;
      }
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof String)))
    {
      paramObject = this.b.a((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        o.b("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
        return a(paramMethod, j.g);
      }
      if (paramMethod.getReturnType().equals(v.class)) {
        return paramObject.d();
      }
      Method localMethod = a(paramMethod);
      if (localMethod != null) {
        return localMethod.invoke(paramObject, paramArrayOfObject);
      }
    }
    else if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramObject = this.b.a();
      if (paramObject != null)
      {
        paramMethod = a(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((y)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      return null;
    }
    o.b("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), fallback return access denied", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
    return a(paramMethod, j.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */