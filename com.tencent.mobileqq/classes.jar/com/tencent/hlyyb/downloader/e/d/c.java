package com.tencent.hlyyb.downloader.e.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  public a a;
  public a b;
  public int c = 0;
  private long d = -1L;
  private Map<String, d> e = new ConcurrentHashMap();
  private AtomicInteger f = new AtomicInteger(0);
  private volatile long g = -1L;
  private String h = "";
  private List<com.tencent.hlyyb.downloader.d.a> i;
  private String j = "";
  private volatile boolean k = false;
  private long l = -1L;
  private final List<a> m = new ArrayList();
  
  public c(String paramString, long paramLong)
  {
    this.a = new a(paramString, b.b);
    this.a.c = this.f.getAndIncrement();
    this.d = paramLong;
  }
  
  private a a(String paramString, a parama)
  {
    paramString = (d)this.e.get(paramString);
    if (paramString != null) {
      try
      {
        List localList = paramString.b;
        if ((localList != null) && (localList.size() > 0))
        {
          int n = localList.indexOf(parama);
          if (n == -1)
          {
            parama = (a)localList.get(0);
            return parama;
          }
          if (n == localList.size() - 1) {
            return null;
          }
          parama = (a)localList.get(n + 1);
          return parama;
        }
        return null;
      }
      finally {}
    }
    return null;
  }
  
  private a b(a parama)
  {
    synchronized (this.m)
    {
      if (this.m.size() > 0)
      {
        int n = this.m.indexOf(parama);
        if (n == -1)
        {
          parama = (a)this.m.get(0);
          return parama;
        }
        if (n == this.m.size() - 1) {
          return null;
        }
        parama = (a)this.m.get(n + 1);
        return parama;
      }
      return null;
    }
  }
  
  private d b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.e)
    {
      d locald2 = (d)this.e.get(paramString);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(this, paramString);
        this.e.put(paramString, locald1);
      }
      return locald1;
    }
  }
  
  public final long a()
  {
    return this.g;
  }
  
  public final a a(int paramInt)
  {
    d locald = b(com.tencent.hlyyb.common.a.a.b());
    if (locald != null)
    {
      if ((paramInt != b.b) && (paramInt != b.a)) {
        return locald.d;
      }
      return locald.c;
    }
    return null;
  }
  
  public final a a(String paramString, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1;
    if (paramBoolean4)
    {
      localObject2 = a(paramString, parama);
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (paramBoolean3)
    {
      localObject2 = b(parama);
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    int n = 0;
    Object localObject2 = localObject1;
    if (parama != null)
    {
      i1 = parama.b;
      localObject2 = localObject1;
      n = i1;
      if (a.b(parama.b))
      {
        d locald = (d)this.e.get(paramString);
        localObject2 = localObject1;
        n = i1;
        if (locald != null)
        {
          parama = locald.a(parama);
          localObject2 = parama;
          n = i1;
          if (parama != null) {
            return parama;
          }
        }
      }
    }
    b.a();
    int i2 = 10;
    int i1 = n;
    parama = (a)localObject2;
    n = i2;
    while ((parama == null) && (n > 0))
    {
      i1 = a.a(i1, paramBoolean1);
      if (a.a(i1))
      {
        localObject1 = (d)this.e.get(paramString);
        if (localObject1 != null) {
          parama = ((d)localObject1).a(i1);
        }
      }
      else if (i1 == b.g)
      {
        parama = this.b;
      }
      else
      {
        parama = this.a;
      }
      n -= 1;
    }
    paramString = parama;
    if (parama == null) {
      paramString = this.a;
    }
    return paramString;
  }
  
  public final a a(List<a> paramList, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = (d)this.e.get(com.tencent.hlyyb.common.a.a.b());
      if (localObject1 != null)
      {
        localObject1 = ((d)localObject1).a();
        Object localObject2;
        if (paramBoolean)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            a locala = (a)((Iterator)localObject2).next();
            if (locala.b == b.j)
            {
              paramBoolean = paramList.contains(locala);
              if (!paramBoolean) {
                return locala;
              }
            }
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (!paramList.contains(localObject2))
          {
            paramBoolean = ((a)localObject2).f;
            if (!paramBoolean) {
              return localObject2;
            }
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public final void a(a parama)
  {
    synchronized (this.m)
    {
      parama.d = true;
      this.m.add(parama);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.b = new a(paramString, b.g);
    this.b.c = this.f.getAndIncrement();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = b(paramString1);
      if (paramString1 != null) {
        paramString1.a(paramString2);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = b(paramString1);
      if (paramString1 != null) {
        paramString1.a(paramString2, paramInt);
      }
    }
  }
  
  public final boolean a(boolean paramBoolean)
  {
    com.tencent.hlyyb.common.a.a.d();
    Object localObject = com.tencent.hlyyb.common.a.a.b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    localObject = (d)this.e.get(localObject);
    if (localObject != null)
    {
      int n;
      if (paramBoolean ? !((d)localObject).e : !((d)localObject).f) {
        n = 1;
      } else {
        n = 0;
      }
      return n != 0;
    }
    return true;
  }
  
  public final String b()
  {
    return this.h;
  }
  
  public final void b(int paramInt)
  {
    if (this.l == -1L) {
      this.l = SystemClock.elapsedRealtime();
    }
    if (!a(true)) {
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    e locale = new e(this, localCountDownLatch);
    boolean bool = this.k;
    f.a(this.a.a, this.d, locale, 15000, bool ^ true);
    try
    {
      SystemClock.elapsedRealtime();
      localCountDownLatch.await(20000L, TimeUnit.MILLISECONDS);
      SystemClock.elapsedRealtime();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString1 = b(paramString1);
      if (paramString1 != null) {
        paramString1.b(paramString2);
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    com.tencent.hlyyb.common.a.a.d();
    Object localObject = com.tencent.hlyyb.common.a.a.b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = b((String)localObject);
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((d)localObject).e = true;
        return;
      }
      ((d)localObject).f = true;
    }
  }
  
  public final String c()
  {
    return this.j;
  }
  
  public final List<com.tencent.hlyyb.downloader.d.a> d()
  {
    List localList = this.i;
    if (localList == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.hlyyb.downloader.d.a locala = (com.tencent.hlyyb.downloader.d.a)localIterator.next();
        localArrayList.add(new com.tencent.hlyyb.downloader.d.a(locala.a, locala.b));
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final int e()
  {
    synchronized (this.m)
    {
      int n = this.m.size();
      return n;
    }
  }
  
  public final boolean f()
  {
    Object localObject = (d)this.e.get(com.tencent.hlyyb.common.a.a.b());
    if (localObject == null) {
      return false;
    }
    List localList = ((d)localObject).a;
    boolean bool1;
    if ((localList != null) && (localList.size() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      localObject = ((d)localObject).b;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public final String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder.append("0,");
      localStringBuilder.append(this.a);
      localStringBuilder.append(";");
    }
    if (this.b != null)
    {
      localStringBuilder.append("1,");
      localStringBuilder.append(this.b);
      localStringBuilder.append(";");
    }
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (d)this.e.get(localObject);
      if (localObject != null)
      {
        localStringBuilder.append(localObject);
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.c
 * JD-Core Version:    0.7.0.1
 */