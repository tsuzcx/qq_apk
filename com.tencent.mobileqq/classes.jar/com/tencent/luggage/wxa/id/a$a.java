package com.tencent.luggage.wxa.id;

import java.util.concurrent.ConcurrentHashMap;

class a$a<K, V>
  extends ConcurrentHashMap<K, V>
{
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return super.containsValue(paramObject);
  }
  
  public V get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return super.get(paramObject);
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK == null) {
      return null;
    }
    if (paramV == null) {
      return super.remove(paramK);
    }
    return super.put(paramK, paramV);
  }
  
  public V remove(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return super.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.id.a.a
 * JD-Core Version:    0.7.0.1
 */