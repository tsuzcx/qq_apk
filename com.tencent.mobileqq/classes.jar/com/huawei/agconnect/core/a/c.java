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

public final class c
{
  private Map<Class<?>, Service> a = new HashMap();
  private Map<Class<?>, Object> b = new HashMap();
  
  c(List<Service> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Service localService = (Service)paramList.next();
        this.a.put(localService.getInterface(), localService);
      }
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
    catch (InstantiationException paramAGConnectInstance)
    {
      Log.e("ServiceRepository", "Instantiate service exception " + paramAGConnectInstance.getLocalizedMessage());
      return null;
    }
    catch (InvocationTargetException paramAGConnectInstance)
    {
      Log.e("ServiceRepository", "Instantiate service exception " + paramAGConnectInstance.getLocalizedMessage());
      return null;
    }
    catch (IllegalAccessException paramAGConnectInstance)
    {
      Log.e("ServiceRepository", "Instantiate service exception " + paramAGConnectInstance.getLocalizedMessage());
    }
    return null;
  }
  
  private static Constructor a(Class paramClass, Class... paramVarArgs)
  {
    paramClass = paramClass.getDeclaredConstructors();
    int m = paramClass.length;
    int k = 0;
    int j;
    for (int i = 0; k < m; i = j)
    {
      Constructor localConstructor = paramClass[k];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      if (arrayOfClass.length == paramVarArgs.length)
      {
        j = 0;
        if (j < paramVarArgs.length)
        {
          if (arrayOfClass[j] == paramVarArgs[j]) {}
          for (i = 1;; i = 0)
          {
            j += 1;
            break;
          }
        }
        j = i;
        if (i != 0) {
          return localConstructor;
        }
      }
      else
      {
        j = i;
      }
      k += 1;
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
 * Qualified Name:     com.huawei.agconnect.core.a.c
 * JD-Core Version:    0.7.0.1
 */