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
    if (paramString != null)
    {
      List localList;
      int n;
      try
      {
        localList = paramString.b;
        if ((localList == null) || (localList.size() <= 0)) {
          break label111;
        }
        n = localList.indexOf(parama);
        if (n == -1)
        {
          parama = (a)localList.get(0);
          return parama;
        }
        if (n == localList.size() - 1) {
          return null;
        }
      }
      finally {}
      parama = (a)localList.get(n + 1);
      return parama;
    }
    label111:
    return null;
  }
  
  private a b(a parama)
  {
    int n;
    synchronized (this.m)
    {
      if (this.m.size() <= 0) {
        break label97;
      }
      n = this.m.indexOf(parama);
      if (n == -1)
      {
        parama = (a)this.m.get(0);
        return parama;
      }
      if (n == this.m.size() - 1) {
        return null;
      }
    }
    parama = (a)this.m.get(n + 1);
    return parama;
    label97:
    return null;
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
      if ((paramInt == b.b) || (paramInt == b.a)) {
        return locald.c;
      }
      return locald.d;
    }
    return null;
  }
  
  public final a a(String paramString, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1 = null;
    if (paramBoolean4)
    {
      localObject1 = a(paramString, parama);
      if (localObject1 == null) {}
    }
    int n;
    do
    {
      do
      {
        return localObject1;
        if (!paramBoolean3) {
          break;
        }
        localObject2 = b(parama);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = localObject2;
      n = 0;
      if (parama == null) {
        break label222;
      }
      n = parama.b;
      if (!a.b(parama.b)) {
        break;
      }
      Object localObject2 = (d)this.e.get(paramString);
      if (localObject2 == null) {
        break;
      }
      parama = ((d)localObject2).a(parama);
      localObject1 = parama;
    } while (parama != null);
    for (;;)
    {
      b.a();
      int i1 = 10;
      if ((parama == null) && (i1 > 0))
      {
        n = a.a(n, paramBoolean1);
        if (a.a(n))
        {
          localObject1 = (d)this.e.get(paramString);
          if (localObject1 == null) {
            break label213;
          }
          parama = ((d)localObject1).a(n);
        }
      }
      label213:
      for (;;)
      {
        i1 -= 1;
        break;
        if (n == b.g)
        {
          parama = this.b;
        }
        else
        {
          parama = this.a;
          continue;
          paramString = parama;
          if (parama == null) {
            paramString = this.a;
          }
          return paramString;
        }
      }
      parama = (a)localObject1;
      continue;
      label222:
      parama = (a)localObject1;
    }
  }
  
  /* Error */
  public final a a(List<a> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/hlyyb/downloader/e/d/c:e	Ljava/util/Map;
    //   6: invokestatic 140	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   9: invokeinterface 93 2 0
    //   14: checkcast 95	com/tencent/hlyyb/downloader/e/d/d
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +125 -> 144
    //   22: aload_3
    //   23: invokevirtual 177	com/tencent/hlyyb/downloader/e/d/d:a	()Ljava/util/List;
    //   26: astore 4
    //   28: iload_2
    //   29: ifeq +61 -> 90
    //   32: aload 4
    //   34: invokeinterface 181 1 0
    //   39: astore 5
    //   41: aload 5
    //   43: invokeinterface 187 1 0
    //   48: ifeq +42 -> 90
    //   51: aload 5
    //   53: invokeinterface 191 1 0
    //   58: checkcast 70	com/tencent/hlyyb/downloader/e/d/a
    //   61: astore_3
    //   62: aload_3
    //   63: getfield 154	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   66: getstatic 193	com/tencent/hlyyb/downloader/e/d/b:j	I
    //   69: if_icmpne -28 -> 41
    //   72: aload_1
    //   73: aload_3
    //   74: invokeinterface 197 2 0
    //   79: istore_2
    //   80: iload_2
    //   81: ifne -40 -> 41
    //   84: aload_3
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: areturn
    //   90: aload 4
    //   92: invokeinterface 181 1 0
    //   97: astore 4
    //   99: aload 4
    //   101: invokeinterface 187 1 0
    //   106: ifeq +38 -> 144
    //   109: aload 4
    //   111: invokeinterface 191 1 0
    //   116: checkcast 70	com/tencent/hlyyb/downloader/e/d/a
    //   119: astore_3
    //   120: aload_1
    //   121: aload_3
    //   122: invokeinterface 197 2 0
    //   127: ifne -28 -> 99
    //   130: aload_3
    //   131: getfield 199	com/tencent/hlyyb/downloader/e/d/a:f	Z
    //   134: istore_2
    //   135: iload_2
    //   136: ifne -37 -> 99
    //   139: aload_3
    //   140: astore_1
    //   141: goto -55 -> 86
    //   144: aconst_null
    //   145: astore_1
    //   146: goto -60 -> 86
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	c
    //   0	154	1	paramList	List<a>
    //   0	154	2	paramBoolean	boolean
    //   17	123	3	localObject1	Object
    //   26	84	4	localObject2	Object
    //   39	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	18	149	finally
    //   22	28	149	finally
    //   32	41	149	finally
    //   41	80	149	finally
    //   90	99	149	finally
    //   99	135	149	finally
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = b(paramString1);
    } while (paramString1 == null);
    paramString1.a(paramString2);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = b(paramString1);
    } while (paramString1 == null);
    paramString1.a(paramString2, paramInt);
  }
  
  public final boolean a(boolean paramBoolean)
  {
    com.tencent.hlyyb.common.a.a.d();
    Object localObject = com.tencent.hlyyb.common.a.a.b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    localObject = (d)this.e.get(localObject);
    int n;
    if (localObject != null)
    {
      if (!paramBoolean) {
        break label58;
      }
      if (((d)localObject).e) {
        break label53;
      }
      n = 1;
    }
    while (n != 0)
    {
      return true;
      label53:
      n = 0;
      continue;
      label58:
      if (!((d)localObject).f) {
        n = 1;
      } else {
        n = 0;
      }
    }
    return false;
  }
  
  public final String b()
  {
    return this.h;
  }
  
  public final void b(int paramInt)
  {
    boolean bool = true;
    if (this.l == -1L) {
      this.l = SystemClock.elapsedRealtime();
    }
    if (!a(true)) {
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    e locale = new e(this, localCountDownLatch);
    if (!this.k) {}
    for (;;)
    {
      f.a(this.a.a, this.d, locale, 15000, bool);
      try
      {
        SystemClock.elapsedRealtime();
        localCountDownLatch.await(20000L, TimeUnit.MILLISECONDS);
        SystemClock.elapsedRealtime();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
      bool = false;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = b(paramString1);
    } while (paramString1 == null);
    paramString1.b(paramString2);
  }
  
  public final void b(boolean paramBoolean)
  {
    com.tencent.hlyyb.common.a.a.d();
    Object localObject = com.tencent.hlyyb.common.a.a.b();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      localObject = b((String)localObject);
    } while (localObject == null);
    if (paramBoolean)
    {
      ((d)localObject).e = true;
      return;
    }
    ((d)localObject).f = true;
  }
  
  public final String c()
  {
    return this.j;
  }
  
  public final List<com.tencent.hlyyb.downloader.d.a> d()
  {
    if (this.i == null) {
      return null;
    }
    synchronized (this.i)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.i.iterator();
      if (localIterator.hasNext())
      {
        com.tencent.hlyyb.downloader.d.a locala = (com.tencent.hlyyb.downloader.d.a)localIterator.next();
        localArrayList.add(new com.tencent.hlyyb.downloader.d.a(locala.a, locala.b));
      }
    }
    return localList1;
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
    boolean bool;
    if ((localList != null) && (localList.size() > 0))
    {
      bool = true;
      if (bool) {
        break label78;
      }
      localObject = ((d)localObject).b;
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label73;
      }
      bool = true;
    }
    label73:
    label78:
    for (;;)
    {
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public final String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null) {
      localStringBuilder.append("0,").append(this.a).append(";");
    }
    if (this.b != null) {
      localStringBuilder.append("1,").append(this.b).append(";");
    }
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (d)this.e.get(localObject);
      if (localObject != null) {
        localStringBuilder.append(localObject).append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.c
 * JD-Core Version:    0.7.0.1
 */