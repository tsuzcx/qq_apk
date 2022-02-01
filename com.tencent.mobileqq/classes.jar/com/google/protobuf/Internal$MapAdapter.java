package com.google.protobuf;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Internal$MapAdapter<K, V, RealValue>
  extends AbstractMap<K, V>
{
  private final Map<K, RealValue> a;
  private final Internal.MapAdapter.Converter<RealValue, V> b;
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return new Internal.MapAdapter.SetAdapter(this, this.a.entrySet());
  }
  
  public V get(Object paramObject)
  {
    paramObject = this.a.get(paramObject);
    if (paramObject == null) {
      return null;
    }
    return this.b.b(paramObject);
  }
  
  public V put(K paramK, V paramV)
  {
    paramK = this.a.put(paramK, this.b.a(paramV));
    if (paramK == null) {
      return null;
    }
    return this.b.b(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.MapAdapter
 * JD-Core Version:    0.7.0.1
 */