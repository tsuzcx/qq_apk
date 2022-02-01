package com.tencent.luggage.wxa.ai;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class b
{
  public final String a;
  public final String b;
  public final boolean c;
  public final long d;
  public final long e;
  public final e f;
  public final String g;
  private final String[] h;
  private final HashMap<String, Integer> i;
  private final HashMap<String, Integer> j;
  private List<b> k;
  
  private b(String paramString1, String paramString2, long paramLong1, long paramLong2, e parame, String[] paramArrayOfString, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.f = parame;
    this.h = paramArrayOfString;
    boolean bool;
    if (paramString2 != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramLong1;
    this.e = paramLong2;
    this.g = ((String)com.tencent.luggage.wxa.ao.a.a(paramString3));
    this.i = new HashMap();
    this.j = new HashMap();
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int m = paramSpannableStringBuilder.length();
    int i2 = 0;
    int n = 0;
    int i3;
    while (n < m)
    {
      i1 = m;
      if (paramSpannableStringBuilder.charAt(n) == ' ')
      {
        i3 = n + 1;
        i1 = i3;
        while ((i1 < paramSpannableStringBuilder.length()) && (paramSpannableStringBuilder.charAt(i1) == ' ')) {
          i1 += 1;
        }
        i3 = i1 - i3;
        i1 = m;
        if (i3 > 0)
        {
          paramSpannableStringBuilder.delete(n, n + i3);
          i1 = m - i3;
        }
      }
      n += 1;
      m = i1;
    }
    n = m;
    if (m > 0)
    {
      n = m;
      if (paramSpannableStringBuilder.charAt(0) == ' ')
      {
        paramSpannableStringBuilder.delete(0, 1);
        n = m - 1;
      }
    }
    int i1 = 0;
    m = n;
    n = i1;
    for (;;)
    {
      i3 = m - 1;
      if (n >= i3) {
        break;
      }
      i1 = m;
      if (paramSpannableStringBuilder.charAt(n) == '\n')
      {
        i3 = n + 1;
        i1 = m;
        if (paramSpannableStringBuilder.charAt(i3) == ' ')
        {
          paramSpannableStringBuilder.delete(i3, n + 2);
          i1 = m - 1;
        }
      }
      n += 1;
      m = i1;
    }
    i1 = i2;
    n = m;
    if (m > 0)
    {
      i1 = i2;
      n = m;
      if (paramSpannableStringBuilder.charAt(i3) == ' ')
      {
        paramSpannableStringBuilder.delete(i3, m);
        n = m - 1;
        i1 = i2;
      }
    }
    for (;;)
    {
      m = n - 1;
      if (i1 >= m) {
        break;
      }
      m = n;
      if (paramSpannableStringBuilder.charAt(i1) == ' ')
      {
        i2 = i1 + 1;
        m = n;
        if (paramSpannableStringBuilder.charAt(i2) == '\n')
        {
          paramSpannableStringBuilder.delete(i1, i2);
          m = n - 1;
        }
      }
      i1 += 1;
      n = m;
    }
    if ((n > 0) && (paramSpannableStringBuilder.charAt(m) == '\n')) {
      paramSpannableStringBuilder.delete(m, n);
    }
    return paramSpannableStringBuilder;
  }
  
  private static SpannableStringBuilder a(String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    if (!paramMap.containsKey(paramString)) {
      paramMap.put(paramString, new SpannableStringBuilder());
    }
    return (SpannableStringBuilder)paramMap.get(paramString);
  }
  
  public static b a(String paramString)
  {
    return new b(null, d.a(paramString), -9223372036854775807L, -9223372036854775807L, null, null, "");
  }
  
  public static b a(String paramString1, long paramLong1, long paramLong2, e parame, String[] paramArrayOfString, String paramString2)
  {
    return new b(paramString1, null, paramLong1, paramLong2, parame, paramArrayOfString, paramString2);
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    this.i.clear();
    this.j.clear();
    Object localObject = this.g;
    if (!"".equals(localObject)) {
      paramString = (String)localObject;
    }
    if ((this.c) && (paramBoolean))
    {
      a(paramString, paramMap).append(this.b);
      return;
    }
    if (("br".equals(this.a)) && (paramBoolean))
    {
      a(paramString, paramMap).append('\n');
      return;
    }
    if ("metadata".equals(this.a)) {
      return;
    }
    if (a(paramLong))
    {
      boolean bool2 = "p".equals(this.a);
      localObject = paramMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.i.put(localEntry.getKey(), Integer.valueOf(((SpannableStringBuilder)localEntry.getValue()).length()));
      }
      int m = 0;
      while (m < a())
      {
        localObject = a(m);
        boolean bool1;
        if ((!paramBoolean) && (!bool2)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        ((b)localObject).a(paramLong, bool1, paramString, paramMap);
        m += 1;
      }
      if (bool2) {
        d.a(a(paramString, paramMap));
      }
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        this.j.put(paramMap.getKey(), Integer.valueOf(((SpannableStringBuilder)paramMap.getValue()).length()));
      }
    }
  }
  
  private void a(Map<String, e> paramMap, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramMap = d.a(this.f, this.h, paramMap);
      if (paramMap != null) {
        d.a(paramSpannableStringBuilder, paramInt1, paramInt2, paramMap);
      }
    }
  }
  
  private void a(Map<String, e> paramMap, Map<String, SpannableStringBuilder> paramMap1)
  {
    Iterator localIterator = this.j.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      boolean bool = this.i.containsKey(str);
      int n = 0;
      if (bool) {
        m = ((Integer)this.i.get(str)).intValue();
      } else {
        m = 0;
      }
      a(paramMap, (SpannableStringBuilder)paramMap1.get(str), m, ((Integer)localEntry.getValue()).intValue());
      int m = n;
      while (m < a())
      {
        a(m).a(paramMap, paramMap1);
        m += 1;
      }
    }
  }
  
  private void a(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    boolean bool2 = "p".equals(this.a);
    if ((paramBoolean) || (bool2))
    {
      long l = this.d;
      if (l != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(l));
      }
      l = this.e;
      if (l != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(l));
      }
    }
    if (this.k == null) {
      return;
    }
    int m = 0;
    while (m < this.k.size())
    {
      b localb = (b)this.k.get(m);
      boolean bool1;
      if ((!paramBoolean) && (!bool2)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localb.a(paramTreeSet, bool1);
      m += 1;
    }
  }
  
  public int a()
  {
    List localList = this.k;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public b a(int paramInt)
  {
    List localList = this.k;
    if (localList != null) {
      return (b)localList.get(paramInt);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public List<com.tencent.luggage.wxa.ad.a> a(long paramLong, Map<String, e> paramMap, Map<String, c> paramMap1)
  {
    Object localObject = new TreeMap();
    a(paramLong, false, this.g, (Map)localObject);
    a(paramMap, (Map)localObject);
    paramMap = new ArrayList();
    localObject = ((TreeMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      c localc = (c)paramMap1.get(localEntry.getKey());
      paramMap.add(new com.tencent.luggage.wxa.ad.a(a((SpannableStringBuilder)localEntry.getValue()), null, localc.c, localc.d, localc.e, localc.b, -2147483648, localc.f));
    }
    return paramMap;
  }
  
  public void a(b paramb)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.add(paramb);
  }
  
  public boolean a(long paramLong)
  {
    return ((this.d == -9223372036854775807L) && (this.e == -9223372036854775807L)) || ((this.d <= paramLong) && (this.e == -9223372036854775807L)) || ((this.d == -9223372036854775807L) && (paramLong < this.e)) || ((this.d <= paramLong) && (paramLong < this.e));
  }
  
  public long[] b()
  {
    Object localObject = new TreeSet();
    int m = 0;
    a((TreeSet)localObject, false);
    long[] arrayOfLong = new long[((TreeSet)localObject).size()];
    localObject = ((TreeSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[m] = ((Long)((Iterator)localObject).next()).longValue();
      m += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ai.b
 * JD-Core Version:    0.7.0.1
 */