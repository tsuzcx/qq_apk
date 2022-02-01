package com.google.protobuf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapField$MutatabilityAwareMap<K, V>
  implements Map<K, V>
{
  private final MutabilityOracle a;
  private final Map<K, V> b;
  
  MapField$MutatabilityAwareMap(MutabilityOracle paramMutabilityOracle, Map<K, V> paramMap)
  {
    this.a = paramMutabilityOracle;
    this.b = paramMap;
  }
  
  public void clear()
  {
    this.a.j();
    this.b.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.b.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.b.containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return new MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.a, this.b.entrySet());
  }
  
  public boolean equals(Object paramObject)
  {
    return this.b.equals(paramObject);
  }
  
  public V get(Object paramObject)
  {
    return this.b.get(paramObject);
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return new MapField.MutatabilityAwareMap.MutatabilityAwareSet(this.a, this.b.keySet());
  }
  
  public V put(K paramK, V paramV)
  {
    this.a.j();
    Internal.a(paramK);
    Internal.a(paramV);
    return this.b.put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    this.a.j();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Internal.a(localObject);
      Internal.a(paramMap.get(localObject));
    }
    this.b.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    this.a.j();
    return this.b.remove(paramObject);
  }
  
  public int size()
  {
    return this.b.size();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  public Collection<V> values()
  {
    return new MapField.MutatabilityAwareMap.MutatabilityAwareCollection(this.a, this.b.values());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField.MutatabilityAwareMap
 * JD-Core Version:    0.7.0.1
 */