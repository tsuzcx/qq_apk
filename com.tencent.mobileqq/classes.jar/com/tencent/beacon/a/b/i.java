package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.a.h.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  extends com.tencent.beacon.a.f.a
{
  private List<g> f = null;
  private Context g;
  private Long[] h = null;
  private boolean i = false;
  
  public i(Context paramContext, List<g> paramList)
  {
    super(paramContext, 1, 2);
    this.f = paramList;
    this.g = paramContext;
    this.e = this.f.size();
    if ((this.f.size() == 1) && ("rqd_heartbeat".equals(((g)this.f.get(0)).d()))) {
      this.i = true;
    }
    this.d = com.tencent.beacon.a.a.b(paramContext, 2);
  }
  
  private static com.tencent.beacon.a.d.a.b a(int paramInt, List<g> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        paramList = a(paramList);
        if (paramList != null)
        {
          com.tencent.beacon.a.h.b localb = new com.tencent.beacon.a.h.b();
          paramList.a(localb);
          paramList = a(paramInt, localb.b());
          return paramList;
        }
      }
      catch (Throwable paramList)
      {
        com.tencent.beacon.a.g.a.a(paramList);
        com.tencent.beacon.a.g.a.d("[event] encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private static com.tencent.beacon.a.d.b.b a(List<g> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    com.tencent.beacon.a.d.b.b localb;
    try
    {
      localb = new com.tencent.beacon.a.d.b.b();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tencent.beacon.a.d.b.a locala = com.tencent.beacon.a.a.a((g)paramList.next());
        if (locala != null) {
          localArrayList.add(locala);
        }
      }
      localb.a = localArrayList;
    }
    catch (Throwable paramList)
    {
      com.tencent.beacon.a.g.a.a(paramList);
      return null;
    }
    return localb;
  }
  
  /* Error */
  public final com.tencent.beacon.a.d.a.b a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/beacon/a/b/i:f	Ljava/util/List;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 20	com/tencent/beacon/a/b/i:f	Ljava/util/List;
    //   13: invokeinterface 32 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: getfield 135	com/tencent/beacon/a/b/i:a	I
    //   33: aload_0
    //   34: getfield 20	com/tencent/beacon/a/b/i:f	Ljava/util/List;
    //   37: invokestatic 137	com/tencent/beacon/a/b/i:a	(ILjava/util/List;)Lcom/tencent/beacon/a/d/a/b;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: ifnonnull -19 -> 25
    //   47: aconst_null
    //   48: astore_2
    //   49: goto -24 -> 25
    //   52: astore_2
    //   53: aload_2
    //   54: invokestatic 94	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   57: ldc 139
    //   59: iconst_0
    //   60: anewarray 98	java/lang/Object
    //   63: invokestatic 101	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: goto -19 -> 47
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	i
    //   18	2	1	j	int
    //   24	25	2	localObject1	Object
    //   52	2	2	localThrowable	Throwable
    //   69	4	2	localObject2	Object
    //   40	4	3	localb	com.tencent.beacon.a.d.a.b
    // Exception table:
    //   from	to	target	type
    //   29	41	52	java/lang/Throwable
    //   2	19	69	finally
    //   29	41	69	finally
    //   53	66	69	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      if ((this.f != null) && (!paramBoolean))
      {
        com.tencent.beacon.a.g.a.f("[event] upload failed, save to db", new Object[0]);
        if (!this.i)
        {
          this.h = com.tencent.beacon.a.a.a(this.g, this.f);
          if (this.h != null)
          {
            Iterator localIterator = h.a(this.g).c().iterator();
            while (localIterator.hasNext()) {
              ((com.tencent.beacon.a.f.i)localIterator.next()).b(this.h.length);
            }
          }
          this.f = null;
        }
      }
    }
    finally {}
    if ((paramBoolean) && (this.i)) {
      e.a(this.g);
    }
    Object localObject2;
    Long[] arrayOfLong;
    if ((paramBoolean) && (this.h != null))
    {
      localObject2 = this.g;
      arrayOfLong = this.h;
      if (localObject2 != null) {
        break label218;
      }
      com.tencent.beacon.a.g.a.d("[db] have null args!", new Object[0]);
    }
    while ((paramBoolean) && (this.f != null))
    {
      localObject2 = h.a(this.g).c().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((com.tencent.beacon.a.f.i)((Iterator)localObject2).next()).c(this.f.size());
      }
      label218:
      com.tencent.beacon.a.a.a.a.a((Context)localObject2, arrayOfLong);
    }
    if ((paramBoolean) && (this.h == null) && (this.f != null)) {
      this.f = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.i
 * JD-Core Version:    0.7.0.1
 */