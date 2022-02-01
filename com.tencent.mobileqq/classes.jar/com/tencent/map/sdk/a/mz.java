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
    for (;;)
    {
      int i;
      try
      {
        String str = c(parammz, paramVarArgs);
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("?");
          ((StringBuilder)localObject1).append(str);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        parammz.c = ((String)localObject1);
        i = mz.1.a[parammz.i.ordinal()];
        if (i != 1)
        {
          if (i != 2) {
            return localNetResponse;
          }
          i = 0;
          if (paramVarArgs.length <= 0) {
            break label276;
          }
          int j = paramVarArgs.length;
          if (i >= j) {
            break label276;
          }
          localObject2 = paramVarArgs[i];
          if ((localObject2 instanceof byte[]))
          {
            paramVarArgs = (byte[])localObject2;
            if ((parammz.e != null) && (!parammz.e.isEmpty())) {
              return NetManager.getInstance().doPost((String)localObject1, parammz.g, paramVarArgs, parammz.h, parammz.e, null);
            }
            return NetManager.getInstance().doPost((String)localObject1, parammz.g, paramVarArgs, parammz.h);
          }
        }
        else
        {
          if ((parammz.e != null) && (!parammz.e.isEmpty())) {
            return NetManager.getInstance().doGet((String)localObject1, parammz.g, parammz.h, parammz.e, null);
          }
          parammz = NetManager.getInstance().doGet((String)localObject1, parammz.g, parammz.h);
          return parammz;
        }
      }
      catch (Exception parammz)
      {
        parammz.printStackTrace();
        return localNetResponse;
      }
      i += 1;
      continue;
      label276:
      paramVarArgs = new byte[0];
    }
  }
  
  private static String c(@NonNull mz<R>.a parammz, Object... paramVarArgs)
  {
    String[] arrayOfString = parammz.d;
    if ((arrayOfString != null) && (paramVarArgs != null) && (arrayOfString.length <= paramVarArgs.length))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append("=%s&");
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
          arrayOfString = parammz[i].split("=");
          if (arrayOfString.length == 2)
          {
            localStringBuilder.append(arrayOfString[0]);
            localStringBuilder.append("=");
            localStringBuilder.append(arrayOfString[1]);
            localStringBuilder.append("&");
          }
          i += 1;
        }
      }
      i = localStringBuilder.lastIndexOf("&");
      if ((i >= 0) && (i == localStringBuilder.length() - 1)) {
        localStringBuilder.deleteCharAt(i);
      }
      parammz = localStringBuilder.toString();
    }
    else
    {
      parammz = "";
    }
    return String.format(parammz, paramVarArgs);
  }
  
  private String g()
  {
    if (this.d) {
      return "https";
    }
    return "http";
  }
  
  private R h()
  {
    Object localObject = getClass().getGenericSuperclass();
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments();
      if ((localObject.length > 0) && ((localObject[0] instanceof Class)))
      {
        Class localClass = (Class)localObject[0];
        ClassLoader localClassLoader = localClass.getClassLoader();
        localObject = new Class[1];
        if (localClass.isInterface()) {
          localObject[0] = localClass;
        } else {
          localObject = localClass.getInterfaces();
        }
        return (nc.a)Proxy.newProxyInstance(localClassLoader, (Class[])localObject, new mz.b(this, getClass()));
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
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(str);
      localStringBuilder.append("://");
    }
    str = d();
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mz
 * JD-Core Version:    0.7.0.1
 */