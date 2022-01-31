package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.a.b;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.a.f.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements f
{
  private Context a;
  private boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private Object e = new Object();
  private List<g> f;
  private long g = 60000L;
  private Runnable h = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.a.g.a.f("[event] -> do sync db and upload task.", new Object[0]);
      a.this.a();
    }
  };
  private Runnable i = new Runnable()
  {
    public final void run()
    {
      a.this.b();
    }
  };
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.a.g.a.f("[event] -> do max size upload task.", new Object[0]);
      try
      {
        j.c(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
      }
    }
  };
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.f = new ArrayList(25);
  }
  
  /* Error */
  private List<g> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/beacon/a/b/a:f	Ljava/util/List;
    //   6: invokeinterface 74 1 0
    //   11: ifle +12 -> 23
    //   14: aload_0
    //   15: invokespecial 77	com/tencent/beacon/a/b/a:e	()Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 61	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 78	java/util/ArrayList:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 66	com/tencent/beacon/a/b/a:f	Ljava/util/List;
    //   42: invokeinterface 82 2 0
    //   47: pop
    //   48: aload_0
    //   49: getfield 66	com/tencent/beacon/a/b/a:f	Ljava/util/List;
    //   52: invokeinterface 85 1 0
    //   57: goto -32 -> 25
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   18	2	1	bool	boolean
    //   24	14	2	localObject1	Object
    //   60	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	60	finally
    //   29	57	60	finally
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    int k = 0;
    synchronized (this.d)
    {
      if (!e())
      {
        com.tencent.beacon.a.g.a.d("[event] err disable.", new Object[0]);
        return;
      }
      Object localObject2 = d();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label268;
      }
      localObject2 = com.tencent.beacon.a.a.a(this.a, (List)localObject2);
      if (localObject2 != null)
      {
        localObject4 = h.a(this.a).c().iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((i)((Iterator)localObject4).next()).a(localObject2.length);
        }
      }
    }
    Object localObject4 = h.a(this.a);
    if (localObject3 != null)
    {
      long l2 = d.a().f();
      long l1 = l2;
      if (com.tencent.beacon.a.a.g(this.a))
      {
        com.tencent.beacon.a.g.a.e("[event] on wifi, so half mSZ " + l2, new Object[0]);
        l1 = l2 / 2L;
      }
      if (com.tencent.beacon.a.a.c(this.a) >= l1) {
        k = 1;
      }
      if ((k != 0) && (((h)localObject4).a()) && (((h)localObject4).b()))
      {
        if (!d.a().g())
        {
          com.tencent.beacon.a.g.a.e("[event] max but not up(zeroPeak)!", new Object[0]);
          return;
        }
        this.j.run();
        com.tencent.beacon.a.g.a.e("[event] max then up", new Object[0]);
      }
    }
    label268:
    label315:
    for (;;)
    {
      return;
      d locald = d.a();
      if (locald != null) {}
      for (boolean bool = locald.h();; bool = false)
      {
        if (!bool) {
          break label315;
        }
        this.j.run();
        com.tencent.beacon.a.g.a.e("[event] polling then up", new Object[0]);
        break;
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/beacon/a/b/a:b	Z
    //   6: iload_1
    //   7: if_icmpeq +47 -> 54
    //   10: iload_1
    //   11: ifeq +46 -> 57
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 36	com/tencent/beacon/a/b/a:b	Z
    //   19: aload_0
    //   20: invokestatic 131	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   23: invokevirtual 180	com/tencent/beacon/a/b/d:e	()I
    //   26: sipush 1000
    //   29: imul
    //   30: i2l
    //   31: putfield 46	com/tencent/beacon/a/b/a:g	J
    //   34: invokestatic 185	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   37: bipush 102
    //   39: aload_0
    //   40: getfield 51	com/tencent/beacon/a/b/a:h	Ljava/lang/Runnable;
    //   43: aload_0
    //   44: getfield 46	com/tencent/beacon/a/b/a:g	J
    //   47: aload_0
    //   48: getfield 46	com/tencent/beacon/a/b/a:g	J
    //   51: invokevirtual 188	com/tencent/beacon/a/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: invokestatic 185	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   60: bipush 102
    //   62: invokevirtual 189	com/tencent/beacon/a/a/b:a	(I)V
    //   65: invokestatic 185	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   68: bipush 112
    //   70: invokevirtual 189	com/tencent/beacon/a/a/b:a	(I)V
    //   73: aload_0
    //   74: iconst_1
    //   75: invokevirtual 191	com/tencent/beacon/a/b/a:b	(Z)V
    //   78: aload_0
    //   79: iload_1
    //   80: putfield 36	com/tencent/beacon/a/b/a:b	Z
    //   83: goto -29 -> 54
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   0	91	1	paramBoolean	boolean
    //   86	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	86	finally
    //   14	54	86	finally
    //   57	83	86	finally
  }
  
  public final boolean a(g paramg)
  {
    Object localObject2 = this.c;
    if (paramg == null) {
      localObject1 = "null";
    }
    try
    {
      for (;;)
      {
        com.tencent.beacon.a.g.a.f("[event] eN:%s", new Object[] { localObject1 });
        if ((this.a != null) && (paramg != null) && (this.b)) {
          break;
        }
        com.tencent.beacon.a.g.a.d("[event] err return.", new Object[0]);
        return false;
        localObject1 = paramg.d();
      }
      if (!e())
      {
        com.tencent.beacon.a.g.a.d("[event] return false, isEnable is false !", new Object[0]);
        return false;
      }
    }
    finally {}
    Object localObject1 = d.a();
    int k = ((d)localObject1).d();
    this.g = (((d)localObject1).e() * 1000);
    int m = this.f.size();
    if (m >= k)
    {
      com.tencent.beacon.a.g.a.f("[event] max num.", new Object[0]);
      b.a().a(this.h);
      b.a().a(102, this.h, this.g, this.g);
    }
    this.f.add(paramg);
    if (this.f.size() >= k) {
      com.tencent.beacon.a.g.a.c("[event] err BF 3R! list size:" + m, new Object[0]);
    }
    paramg = h.a(this.a).c().iterator();
    while (paramg.hasNext()) {
      ((i)paramg.next()).a();
    }
    com.tencent.beacon.a.g.a.a("[event] process UA:true!", new Object[0]);
    return true;
  }
  
  protected final void b()
  {
    synchronized (this.e)
    {
      if (!e())
      {
        com.tencent.beacon.a.g.a.d("[event] err disable.", new Object[0]);
        return;
      }
      Object localObject2 = d();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = com.tencent.beacon.a.a.a(this.a, (List)localObject2);
        if (localObject2 != null)
        {
          Iterator localIterator = h.a(this.a).c().iterator();
          if (localIterator.hasNext()) {
            ((i)localIterator.next()).a(localObject2.length);
          }
        }
      }
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 232
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 153	com/tencent/beacon/a/g/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 234	com/tencent/beacon/a/b/a:b	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 185	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   25: aload_0
    //   26: getfield 54	com/tencent/beacon/a/b/a:i	Ljava/lang/Runnable;
    //   29: invokevirtual 213	com/tencent/beacon/a/a/b:a	(Ljava/lang/Runnable;)V
    //   32: goto -13 -> 19
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	a
    //   0	40	1	paramBoolean	boolean
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
    //   15	19	35	finally
    //   22	32	35	finally
  }
  
  public final void c()
  {
    try
    {
      this.g = (d.a().e() * 1000);
      b.a().a(102, this.h, this.g, this.g);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.a
 * JD-Core Version:    0.7.0.1
 */