package com.tencent.luggage.wxa.id;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private static volatile a a;
  private Map<String, a.c> b = new a.a(null);
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionId@");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append(System.nanoTime());
    return localStringBuilder.toString();
  }
  
  private a.c d(String paramString)
  {
    a.c localc = new a.c();
    this.b.put(paramString, localc);
    return localc;
  }
  
  public a.b a(String paramString)
  {
    paramString = (a.c)this.b.get(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public a.b a(String paramString, boolean paramBoolean)
  {
    a.c localc2 = (a.c)this.b.get(paramString);
    a.c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean) {
        return null;
      }
      localc1 = d(paramString);
    }
    return localc1.a;
  }
  
  public a.b b(String paramString)
  {
    paramString = (a.c)this.b.remove(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public String toString()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataCenter \nDataStore size : ");
    localStringBuilder.append(this.b.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.b.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        a.c localc = (a.c)localEntry.getValue();
        if (localc != null)
        {
          localStringBuilder.append("\nDataStore id : ");
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append(", CT : ");
          localStringBuilder.append(localc.b);
          localStringBuilder.append("ms");
          localStringBuilder.append(", TTL : ");
          localStringBuilder.append((l - localc.b) / 1000L);
          localStringBuilder.append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.id.a
 * JD-Core Version:    0.7.0.1
 */