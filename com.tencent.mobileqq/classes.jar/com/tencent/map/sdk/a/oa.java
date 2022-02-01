package com.tencent.map.sdk.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class oa
{
  oy a = new oy();
  private ConcurrentHashMap<String, Map<String, ny>> b = new ConcurrentHashMap();
  
  final <D extends nz, C extends ny<D>> C a(Class<D> paramClass, ny.a parama, Class<C> paramClass1)
  {
    Map localMap = (Map)this.b.get(paramClass1.getName());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append(parama.toString());
    String str1 = oc.a(((StringBuilder)localObject).toString());
    String str2 = paramClass1.getName();
    if (localMap != null)
    {
      localObject = (ny)localMap.get(str1);
      paramClass = (Class<D>)localObject;
      if (localObject != null) {
        return localObject;
      }
    }
    else
    {
      paramClass = null;
    }
    Constructor[] arrayOfConstructor = paramClass1.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    paramClass1 = null;
    int i = 0;
    while (i < j)
    {
      Constructor localConstructor = arrayOfConstructor[i];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      localObject = paramClass1;
      if (arrayOfClass.length == 1)
      {
        localObject = paramClass1;
        if (arrayOfClass[0] == parama.getClass()) {
          localObject = localConstructor;
        }
      }
      i += 1;
      paramClass1 = (Class<C>)localObject;
    }
    if (paramClass1 != null) {
      try
      {
        parama = (ny)paramClass1.newInstance(new Object[] { parama });
        paramClass = parama;
      }
      catch (InvocationTargetException parama)
      {
        parama.printStackTrace();
      }
      catch (InstantiationException parama)
      {
        parama.printStackTrace();
      }
      catch (IllegalAccessException parama)
      {
        parama.printStackTrace();
      }
    }
    if (paramClass != null)
    {
      parama = localMap;
      if (localMap == null) {
        parama = new HashMap();
      }
      parama.put(str1, paramClass);
      this.b.put(str2, parama);
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.oa
 * JD-Core Version:    0.7.0.1
 */