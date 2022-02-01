package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g
{
  private Map<Class<?>, Service> a = new HashMap();
  private Map<Class<?>, Object> b = new HashMap();
  
  g(List<Service> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Service localService = (Service)paramList.next();
      this.a.put(localService.getInterface(), localService);
    }
  }
  
  private Object a(AGConnectInstance paramAGConnectInstance, Service paramService)
  {
    paramService = paramService.getType();
    if (paramService == null) {
      return null;
    }
    try
    {
      Constructor localConstructor = a(paramService, new Class[] { Context.class, AGConnectInstance.class });
      if (localConstructor != null) {
        return localConstructor.newInstance(new Object[] { paramAGConnectInstance.getContext(), paramAGConnectInstance });
      }
      localConstructor = a(paramService, new Class[] { Context.class });
      if (localConstructor != null) {
        return localConstructor.newInstance(new Object[] { paramAGConnectInstance.getContext() });
      }
      paramAGConnectInstance = paramService.newInstance();
      return paramAGConnectInstance;
    }
    catch (IllegalAccessException paramAGConnectInstance)
    {
      paramService = new StringBuilder();
      paramService.append("Instantiate service exception ");
      paramAGConnectInstance = paramAGConnectInstance.getLocalizedMessage();
    }
    catch (InvocationTargetException paramAGConnectInstance)
    {
      paramService = new StringBuilder();
      paramService.append("Instantiate service exception ");
      paramAGConnectInstance = paramAGConnectInstance.getLocalizedMessage();
    }
    catch (InstantiationException paramAGConnectInstance)
    {
      paramService = new StringBuilder();
      paramService.append("Instantiate service exception ");
      paramAGConnectInstance = paramAGConnectInstance.getLocalizedMessage();
    }
    paramService.append(paramAGConnectInstance);
    Log.e("ServiceRepository", paramService.toString());
    return null;
  }
  
  private static Constructor a(Class paramClass, Class... paramVarArgs)
  {
    paramClass = paramClass.getDeclaredConstructors();
    int m = paramClass.length;
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      Constructor localConstructor = paramClass[j];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      k = i;
      if (arrayOfClass.length == paramVarArgs.length)
      {
        k = 0;
        while (k < paramVarArgs.length)
        {
          if (arrayOfClass[k] == paramVarArgs[k]) {
            i = 1;
          } else {
            i = 0;
          }
          k += 1;
        }
        if (i != 0) {
          return localConstructor;
        }
        k = i;
      }
      j += 1;
    }
    return null;
  }
  
  public <T> T a(AGConnectInstance paramAGConnectInstance, Class<?> paramClass)
  {
    Service localService = (Service)this.a.get(paramClass);
    if (localService == null) {
      return null;
    }
    if (localService.isSingleton())
    {
      Object localObject = this.b.get(paramClass);
      if (localObject != null) {
        return localObject;
      }
    }
    paramAGConnectInstance = a(paramAGConnectInstance, localService);
    if ((paramAGConnectInstance != null) && (localService.isSingleton())) {
      this.b.put(paramClass, paramAGConnectInstance);
    }
    return paramAGConnectInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.g
 * JD-Core Version:    0.7.0.1
 */