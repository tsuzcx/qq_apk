package com.tencent.luggage.wxa.pc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h<K, V>
{
  private final Map<K, Set<V>> a = new ArrayMap();
  
  private Set<V> a(K paramK, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Set localSet = (Set)this.a.get(paramK);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = localSet;
        if (paramBoolean)
        {
          localObject = new HashSet();
          this.a.put(paramK, localObject);
        }
      }
      return localObject;
    }
  }
  
  @NonNull
  public Map<K, Set<V>> a()
  {
    synchronized (this.a)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
          synchronized ((Set)localEntry.getValue())
          {
            localHashMap.put(localEntry.getKey(), new HashSet((Collection)localEntry.getValue()));
          }
        }
      }
      return localMap1;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  @Nullable
  public Set<V> a(K paramK)
  {
    if (paramK == null) {
      return null;
    }
    paramK = a(paramK, false);
    if (paramK == null) {
      return Collections.emptySet();
    }
    try
    {
      HashSet localHashSet = new HashSet(paramK);
      return localHashSet;
    }
    finally {}
  }
  
  public void a(K paramK, Consumer<V> paramConsumer)
  {
    if (paramK != null)
    {
      if (paramConsumer == null) {
        return;
      }
      paramK = a(paramK).iterator();
      while (paramK.hasNext()) {
        paramConsumer.accept(paramK.next());
      }
    }
  }
  
  public boolean a(K arg1, V paramV)
  {
    if ((??? != null) && (paramV != null)) {
      synchronized (a(???, true))
      {
        boolean bool = ???.add(paramV);
        return bool;
      }
    }
    return false;
  }
  
  @Nullable
  public Set<V> b(K paramK)
  {
    if (paramK == null) {
      return null;
    }
    synchronized (this.a)
    {
      paramK = (Set)this.a.remove(paramK);
      return paramK;
    }
  }
  
  public boolean b(K paramK, V paramV)
  {
    if (paramV == null) {
      return false;
    }
    paramK = a(paramK, false);
    if (paramK != null) {
      try
      {
        boolean bool = paramK.remove(paramV);
        return bool;
      }
      finally {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.h
 * JD-Core Version:    0.7.0.1
 */