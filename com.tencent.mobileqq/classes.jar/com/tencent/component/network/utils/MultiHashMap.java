package com.tencent.component.network.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MultiHashMap
  extends HashMap
{
  public boolean add(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      return false;
    }
    HashSet localHashSet2 = (HashSet)get(paramObject1);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      put(paramObject1, localHashSet1);
    }
    return localHashSet1.add(paramObject2);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    if (paramObject2 == null) {
      return remove(paramObject1) != null;
    }
    Collection localCollection = (Collection)get(paramObject1);
    if ((localCollection != null) && (localCollection.remove(paramObject2))) {}
    for (;;)
    {
      if ((localCollection != null) && (localCollection.isEmpty())) {
        remove(paramObject1);
      }
      return bool;
      bool = false;
    }
  }
  
  public int sizeOf(Object paramObject)
  {
    paramObject = (Collection)get(paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */