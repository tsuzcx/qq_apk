package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LazyHeaders
  implements Headers
{
  private final Map<String, List<LazyHeaderFactory>> c;
  private volatile Map<String, String> d;
  
  LazyHeaders(Map<String, List<LazyHeaderFactory>> paramMap)
  {
    this.c = Collections.unmodifiableMap(paramMap);
  }
  
  @NonNull
  private String a(@NonNull List<LazyHeaderFactory> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str = ((LazyHeaderFactory)paramList.get(i)).a();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (i != paramList.size() - 1) {
          localStringBuilder.append(',');
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = a((List)localEntry.getValue());
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(localEntry.getKey(), str);
      }
    }
    return localHashMap;
  }
  
  public Map<String, String> a()
  {
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = Collections.unmodifiableMap(b());
        }
      }
      finally {}
    }
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LazyHeaders))
    {
      paramObject = (LazyHeaders)paramObject;
      return this.c.equals(paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LazyHeaders{headers=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.LazyHeaders
 * JD-Core Version:    0.7.0.1
 */