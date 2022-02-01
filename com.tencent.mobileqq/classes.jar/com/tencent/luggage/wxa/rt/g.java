package com.tencent.luggage.wxa.rt;

import android.os.Bundle;
import com.tencent.luggage.wxa.ry.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.luggage.wxa.rt.h;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class g
  implements h.c
{
  private static final d g = new f("");
  final Map<String, h> a;
  final Map<String, d> b;
  final SortedMap<String, String> c;
  final List<g.a> d;
  final Map<String, String> e;
  final d f;
  private Map<String, d> h = null;
  private List<h.b> i = null;
  private Map<String, String> j = null;
  
  g()
  {
    this.a = Collections.emptyMap();
    this.b = Collections.emptyMap();
    this.c = new TreeMap();
    this.d = Collections.emptyList();
    this.e = Collections.emptyMap();
    this.f = g;
  }
  
  private g(Map<String, h> paramMap, Map<String, d> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, d paramd)
  {
    this.a = paramMap;
    this.b = paramMap1;
    this.c = paramSortedMap;
    this.d = a(paramMap1, paramSortedMap, paramMap2);
    this.e = paramMap2;
    paramMap = paramd;
    if (paramd == null) {
      paramMap = g;
    }
    this.f = paramMap;
  }
  
  static g a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelableArrayList("sl");
    Object localObject2 = paramBundle.getBundle("sm");
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        int k = ((Bundle)localObject2).getInt((String)localObject4);
        if ((k >= 0) && (k < ((ArrayList)localObject1).size())) {
          localHashMap.put(localObject4, ((ArrayList)localObject1).get(k));
        }
      }
    }
    localObject2 = paramBundle.getBundle("fs");
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Bundle)localObject2).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((HashMap)localObject1).put(localObject4, ((Bundle)localObject2).getParcelable((String)localObject4));
      }
    }
    Object localObject3 = paramBundle.getBundle("mp");
    localObject2 = new TreeMap();
    Object localObject5;
    if (localObject3 != null)
    {
      ((Bundle)localObject3).setClassLoader(paramBundle.getClassLoader());
      localObject4 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        ((TreeMap)localObject2).put(localObject5, ((Bundle)localObject3).getString((String)localObject5));
      }
    }
    localObject3 = paramBundle.getBundle("env");
    Object localObject4 = new HashMap();
    if (localObject3 != null)
    {
      localObject5 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        ((HashMap)localObject4).put(str, ((Bundle)localObject3).getString(str));
      }
    }
    return new g(localHashMap, (Map)localObject1, (SortedMap)localObject2, (Map)localObject4, (d)paramBundle.getParcelable("root"));
  }
  
  private static List<g.a> a(Map<String, d> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      d locald = (d)paramMap.get(localObject);
      if (locald != null)
      {
        str = o.a(str, paramMap1);
        if (str != null) {
          localArrayList.add(new g.a(str, (String)localObject, locald, -1));
        }
      }
      else
      {
        paramMap = new StringBuilder();
        paramMap.append("FileSystem '");
        paramMap.append((String)localObject);
        paramMap.append("' for mount point '");
        paramMap.append(str);
        paramMap.append("' not exist.");
        throw new IllegalArgumentException(paramMap.toString());
      }
    }
    paramMap = (g.a[])localArrayList.toArray(new g.a[0]);
    Arrays.sort(paramMap, new g.1());
    int m = 1;
    while (m < paramMap.length)
    {
      paramSortedMap = paramMap[m];
      paramMap1 = paramSortedMap.b;
      int k = m - 1;
      localArrayList = paramMap[k];
      if (paramSortedMap.b.equals(localArrayList.b))
      {
        paramMap1 = new StringBuilder();
        paramMap1.append("Oops, duplicated mount point detected: ");
        paramMap1.append(paramSortedMap.toString());
        paramMap1.append(" <=> ");
        paramMap1.append(localArrayList.toString());
        b.b("VFS.ResolverState", paramMap1.toString());
        k = localArrayList.a;
      }
      else
      {
        int n;
        do
        {
          localArrayList = paramMap[k];
          if ((paramMap1.startsWith(localArrayList.b)) && (paramMap1.charAt(localArrayList.b.length()) == '/')) {
            break;
          }
          n = localArrayList.a;
          k = n;
        } while (n >= 0);
        k = n;
      }
      if (k >= 0) {
        paramMap[m] = new g.a(paramSortedMap.b, paramSortedMap.c, paramSortedMap.d, k);
      }
      m += 1;
    }
    return Arrays.asList(paramMap);
  }
  
  private static <K, V> void a(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      if (localEntry.getValue() == null) {
        paramMap1.remove(localEntry.getKey());
      } else {
        paramMap1.put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  g a(Map<String, h> paramMap, Map<String, d> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, d paramd)
  {
    Object localObject1;
    if (paramMap.isEmpty())
    {
      paramMap = this.a;
    }
    else
    {
      localObject1 = new HashMap(this.a);
      a((Map)localObject1, paramMap);
      paramMap = (Map<String, h>)localObject1;
    }
    if (paramMap1.isEmpty())
    {
      localObject1 = this.b;
    }
    else
    {
      localObject1 = new HashMap(this.b);
      a((Map)localObject1, paramMap1);
    }
    Object localObject2;
    if (paramSortedMap.isEmpty())
    {
      paramSortedMap = this.c;
    }
    else
    {
      localObject2 = new TreeMap(this.c);
      a((Map)localObject2, paramSortedMap);
      paramSortedMap = (SortedMap<String, String>)localObject2;
    }
    if (paramMap2.isEmpty())
    {
      localObject2 = this.e;
    }
    else
    {
      localObject2 = new HashMap(this.e);
      a((Map)localObject2, paramMap2);
    }
    d locald = paramd;
    if (paramd == null) {
      locald = this.f;
    }
    paramMap = new g(paramMap, (Map)localObject1, paramSortedMap, (Map)localObject2, locald);
    if (paramMap1.isEmpty()) {
      paramMap.h = this.h;
    }
    if (paramMap2.isEmpty()) {
      paramMap.j = this.j;
    }
    return paramMap;
  }
  
  public Map<String, String> a()
  {
    if (this.j == null) {
      this.j = Collections.unmodifiableMap(this.e);
    }
    return this.j;
  }
  
  public d b()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("schemes: ");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", fileSystems: ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(", mountPoints: ");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(" (");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" active), envVars: ");
    localStringBuilder.append(this.e.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.g
 * JD-Core Version:    0.7.0.1
 */