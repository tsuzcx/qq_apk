package com.tencent.map.sdk.a;

import android.content.ContentValues;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class fn
  implements Serializable
{
  protected final ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap();
  
  public fn()
  {
    this((byte)0);
  }
  
  private fn(byte paramByte) {}
  
  private List<ContentValues> a(String paramString, Object paramObject)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramObject instanceof Map))
    {
      localObject1 = (Map)paramObject;
      paramObject = new ArrayList(((Map)localObject1).keySet());
      if ((paramObject.size() > 0) && ((paramObject.get(0) instanceof Comparable))) {
        Collections.sort(paramObject);
      }
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        if ((paramObject instanceof String))
        {
          Object localObject2 = ((Map)localObject1).get(paramObject);
          if (localObject2 != null)
          {
            if (paramString == null) {
              paramObject = (String)paramObject;
            } else {
              paramObject = String.format("%s[%s]", new Object[] { paramString, paramObject });
            }
            localLinkedList.addAll(a(paramObject, localObject2));
          }
        }
      }
    }
    int j;
    int i;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      j = paramObject.size();
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject.get(i)));
        i += 1;
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof Set))
    {
      paramObject = ((Set)paramObject).iterator();
      while (paramObject.hasNext()) {
        localLinkedList.addAll(a(paramString, paramObject.next()));
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put(paramString, paramObject.toString());
    localLinkedList.add(localObject1);
    return localLinkedList;
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.a.put(paramString, String.valueOf(paramInt));
  }
  
  public final void a(String paramString, long paramLong)
  {
    this.a.put(paramString, String.valueOf(paramLong));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      this.a.put(paramString1, paramString2);
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Object localObject2 = this.b.get(paramString1);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        this.b.put(paramString1, localObject1);
      }
      if ((localObject1 instanceof List))
      {
        ((List)localObject1).add(paramString2);
        return;
      }
      if ((localObject1 instanceof Set)) {
        ((Set)localObject1).add(paramString2);
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)((Map.Entry)localObject).getValue());
    }
    localIterator = a(null, this.b).iterator();
    while (localIterator.hasNext())
    {
      localObject = (ContentValues)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localObject = ((ContentValues)localObject).valueSet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(localEntry.getValue().toString());
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fn
 * JD-Core Version:    0.7.0.1
 */