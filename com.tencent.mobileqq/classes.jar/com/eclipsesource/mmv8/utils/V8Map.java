package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Value;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8Map<V>
  implements Releasable, Map<V8Value, V>
{
  private Map<V8Value, V> map = new HashMap();
  private Map<V8Value, V8Value> twinMap = new HashMap();
  
  public void clear()
  {
    this.map.clear();
    Iterator localIterator = this.twinMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((V8Value)localIterator.next()).release();
    }
    this.twinMap.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.map.containsValue(paramObject);
  }
  
  public Set<Map.Entry<V8Value, V>> entrySet()
  {
    return this.map.entrySet();
  }
  
  public V get(Object paramObject)
  {
    return this.map.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public Set<V8Value> keySet()
  {
    return this.map.keySet();
  }
  
  public V put(V8Value paramV8Value, V paramV)
  {
    remove(paramV8Value);
    paramV8Value = paramV8Value.twin();
    this.twinMap.put(paramV8Value, paramV8Value);
    return this.map.put(paramV8Value, paramV);
  }
  
  public void putAll(Map<? extends V8Value, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((V8Value)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void release()
  {
    clear();
  }
  
  public V remove(Object paramObject)
  {
    Object localObject = this.map.remove(paramObject);
    paramObject = (V8Value)this.twinMap.remove(paramObject);
    if (paramObject != null) {
      paramObject.release();
    }
    return localObject;
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public Collection<V> values()
  {
    return this.map.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8Map
 * JD-Core Version:    0.7.0.1
 */