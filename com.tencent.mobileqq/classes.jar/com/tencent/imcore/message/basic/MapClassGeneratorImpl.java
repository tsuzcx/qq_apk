package com.tencent.imcore.message.basic;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class MapClassGeneratorImpl<K, T>
  implements MapClassGenerator<K, T>
{
  private Map<K, Class<? extends T>> a = new HashMap();
  private Map<K, T> b = new HashMap();
  
  private T a(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("MapClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  public T a(K paramK)
  {
    try
    {
      Object localObject = this.b.get(paramK);
      if (localObject != null) {
        return localObject;
      }
      localObject = (Class)this.a.get(paramK);
      if (localObject == null) {
        return null;
      }
      localObject = a((Class)localObject);
      if (localObject != null) {
        this.b.put(paramK, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public void a(K paramK, Class<? extends T> paramClass)
  {
    try
    {
      this.a.put(paramK, paramClass);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.basic.MapClassGeneratorImpl
 * JD-Core Version:    0.7.0.1
 */