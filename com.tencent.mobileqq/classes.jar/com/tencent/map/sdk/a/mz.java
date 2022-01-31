package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public abstract class mz<R extends nc.a>
  implements nc<R>
{
  public boolean a = false;
  public boolean b = true;
  private volatile R c;
  private boolean d = true;
  
  static NetResponse a(mz<R>.a parammz, Object... paramVarArgs)
  {
    NetResponse localNetResponse = new NetResponse();
    Object localObject2 = parammz.c;
    try
    {
      localObject3 = c(parammz, paramVarArgs);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = (String)localObject2 + "?" + (String)localObject3;
      }
      parammz.c = ((String)localObject1);
      switch (mz.1.a[parammz.i.ordinal()])
      {
      case 1: 
        if ((parammz.e != null) && (!parammz.e.isEmpty())) {
          return NetManager.getInstance().doGet((String)localObject1, parammz.g, parammz.h, parammz.e, null);
        }
        return NetManager.getInstance().doGet((String)localObject1, parammz.g, parammz.h);
      }
    }
    catch (Exception parammz)
    {
      Object localObject3;
      Object localObject1;
      int j;
      parammz.printStackTrace();
      return localNetResponse;
    }
    localObject3 = new byte[0];
    localObject2 = localObject3;
    int i;
    if (paramVarArgs.length > 0)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (i < j)
      {
        localObject2 = paramVarArgs[i];
        if ((localObject2 instanceof byte[])) {
          localObject2 = (byte[])localObject2;
        }
      }
      else
      {
        if ((parammz.e != null) && (!parammz.e.isEmpty())) {
          return NetManager.getInstance().doPost((String)localObject1, parammz.g, (byte[])localObject2, parammz.h, parammz.e, null);
        }
        parammz = NetManager.getInstance().doPost((String)localObject1, parammz.g, (byte[])localObject2, parammz.h);
        return parammz;
      }
      i += 1;
    }
  }
  
  private static String c(@NonNull mz<R>.a parammz, Object... paramVarArgs)
  {
    Object localObject2 = "";
    String[] arrayOfString = parammz.d;
    Object localObject1 = localObject2;
    if (arrayOfString != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length <= paramVarArgs.length)
        {
          localObject1 = new StringBuilder();
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject1).append(arrayOfString[i]).append("=%s&");
            i += 1;
          }
          parammz = parammz.f;
          if (!TextUtils.isEmpty(parammz))
          {
            parammz = parammz.split("&");
            j = parammz.length;
            i = 0;
            while (i < j)
            {
              localObject2 = parammz[i].split("=");
              if (localObject2.length == 2) {
                ((StringBuilder)localObject1).append(localObject2[0]).append("=").append(localObject2[1]).append("&");
              }
              i += 1;
            }
          }
          i = ((StringBuilder)localObject1).lastIndexOf("&");
          if ((i >= 0) && (i == ((StringBuilder)localObject1).length() - 1)) {
            ((StringBuilder)localObject1).deleteCharAt(i);
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return String.format((String)localObject1, paramVarArgs);
  }
  
  private String g()
  {
    String str = "http";
    if (this.d) {
      str = "https";
    }
    return str;
  }
  
  private R h()
  {
    Object localObject = getClass().getGenericSuperclass();
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments();
      if ((localObject.length > 0) && ((localObject[0] instanceof Class)))
      {
        localObject = (Class)localObject[0];
        ClassLoader localClassLoader = ((Class)localObject).getClassLoader();
        if (((Class)localObject).isInterface()) {}
        for (localObject = new Class[] { localObject };; localObject = ((Class)localObject).getInterfaces()) {
          return (nc.a)Proxy.newProxyInstance(localClassLoader, (Class[])localObject, new mz.b(this, getClass()));
        }
      }
    }
    return null;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    return null;
  }
  
  public final R c()
  {
    if (this.c != null) {
      return this.c;
    }
    this.c = h();
    return this.c;
  }
  
  public final String d()
  {
    String str = f();
    if (this.a) {
      str = b();
    }
    return str;
  }
  
  public final String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = g();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str).append("://");
    }
    str = d();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.mz
 * JD-Core Version:    0.7.0.1
 */