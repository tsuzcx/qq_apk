package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h
  implements f
{
  private boolean a = false;
  private List<g> b;
  private Context c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.a.g.a.f("[event] -> do sync upload task.", new Object[0]);
      try
      {
        h.this.b();
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
      }
    }
  };
  private Runnable e = new Runnable()
  {
    public final void run()
    {
      h.this.a();
    }
  };
  
  public h(Context paramContext)
  {
    this.c = paramContext;
    this.b = Collections.synchronizedList(new ArrayList(25));
  }
  
  /* Error */
  private List<g> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/tencent/beacon/a/b/h:b	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 50	com/tencent/beacon/a/b/h:b	Ljava/util/List;
    //   13: invokeinterface 58 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 61	com/tencent/beacon/a/b/h:e	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 39	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 62	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 50	com/tencent/beacon/a/b/h:b	Ljava/util/List;
    //   49: invokeinterface 66 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 50	com/tencent/beacon/a/b/h:b	Ljava/util/List;
    //   59: invokeinterface 69 1 0
    //   64: goto -32 -> 32
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	h
    //   25	2	1	bool	boolean
    //   31	14	2	localObject1	Object
    //   67	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	67	finally
    //   36	64	67	finally
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.a;
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
    Object localObject = d();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      com.tencent.beacon.a.g.a.f("[event] sync real events 2 db", new Object[0]);
      localObject = com.tencent.beacon.a.a.a(this.c, (List)localObject);
      if (localObject != null)
      {
        Iterator localIterator = com.tencent.beacon.a.f.h.a(this.c).c().iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.beacon.a.f.i)localIterator.next()).b(localObject.length);
        }
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
    //   3: getfield 27	com/tencent/beacon/a/b/h:a	Z
    //   6: iload_1
    //   7: if_icmpeq +40 -> 47
    //   10: iload_1
    //   11: ifeq +39 -> 50
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 27	com/tencent/beacon/a/b/h:a	Z
    //   19: invokestatic 117	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   22: invokevirtual 119	com/tencent/beacon/a/b/d:c	()I
    //   25: sipush 1000
    //   28: imul
    //   29: i2l
    //   30: lstore_2
    //   31: invokestatic 124	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   34: bipush 103
    //   36: aload_0
    //   37: getfield 32	com/tencent/beacon/a/b/h:d	Ljava/lang/Runnable;
    //   40: ldc2_w 125
    //   43: lload_2
    //   44: invokevirtual 129	com/tencent/beacon/a/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: invokestatic 124	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   53: bipush 103
    //   55: invokevirtual 131	com/tencent/beacon/a/a/b:a	(I)V
    //   58: aload_0
    //   59: iconst_1
    //   60: invokevirtual 133	com/tencent/beacon/a/b/h:b	(Z)V
    //   63: aload_0
    //   64: iload_1
    //   65: putfield 27	com/tencent/beacon/a/b/h:a	Z
    //   68: goto -21 -> 47
    //   71: astore 4
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	h
    //   0	78	1	paramBoolean	boolean
    //   30	14	2	l	long
    //   71	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	71	finally
    //   14	47	71	finally
    //   50	68	71	finally
  }
  
  public final boolean a(g paramg)
  {
    boolean bool = false;
    Object localObject;
    if (paramg == null) {
      localObject = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.a.g.a.f("[event] eN:%s", new Object[] { localObject });
        if ((this.c == null) || (paramg == null))
        {
          com.tencent.beacon.a.g.a.d("[event] context is null or bean is null !", new Object[0]);
          return bool;
          localObject = paramg.d();
          continue;
        }
        if (!e())
        {
          com.tencent.beacon.a.g.a.d("[event] disable process.", new Object[0]);
          continue;
        }
        this.b.add(paramg);
      }
      finally {}
      localObject = d.a();
      int i = ((d)localObject).b();
      long l = ((d)localObject).c() * 1000;
      int j = this.b.size();
      this.b.size();
      if (("rqd_applaunched".equals(paramg.d())) || (j >= i) || (paramg.f()))
      {
        com.tencent.beacon.a.g.a.f("[event] upload by max num or immediate.", new Object[0]);
        b.a().a(this.d);
        b.a().a(103, this.d, l, l);
      }
      paramg = com.tencent.beacon.a.f.h.a(this.c).c().iterator();
      while (paramg.hasNext()) {
        ((com.tencent.beacon.a.f.i)paramg.next()).b();
      }
      com.tencent.beacon.a.g.a.a("[event] processUA:true!", new Object[0]);
      bool = true;
    }
  }
  
  protected final void b()
  {
    if (!e()) {
      com.tencent.beacon.a.g.a.d("[event] disable upload.", new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return;
      localObject1 = d();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = com.tencent.beacon.a.f.h.a(this.c);
        d locald = d.a();
        if ((com.tencent.beacon.a.a.h(this.c)) && (localObject2 != null) && (locald.g())) {
          break;
        }
        com.tencent.beacon.a.g.a.f("[event] sync real events 2 db", new Object[0]);
        localObject1 = com.tencent.beacon.a.a.a(this.c, (List)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.beacon.a.f.h.a(this.c).c().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.beacon.a.f.i)((Iterator)localObject2).next()).b(localObject1.length);
          }
        }
      }
    }
    com.tencent.beacon.a.g.a.f("[event] sync real events 2 upload", new Object[0]);
    ((com.tencent.beacon.a.f.g)localObject2).a(new i(this.c, (List)localObject1));
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 198
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 200	com/tencent/beacon/a/g/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 202	com/tencent/beacon/a/b/h:a	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 124	com/tencent/beacon/a/a/b:a	()Lcom/tencent/beacon/a/a/b;
    //   25: aload_0
    //   26: getfield 35	com/tencent/beacon/a/b/h:e	Ljava/lang/Runnable;
    //   29: invokevirtual 169	com/tencent/beacon/a/a/b:a	(Ljava/lang/Runnable;)V
    //   32: goto -13 -> 19
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	h
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
      long l = d.a().c() * 1000;
      b.a().a(103, this.d, 5000L, l);
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
 * Qualified Name:     com.tencent.beacon.a.b.h
 * JD-Core Version:    0.7.0.1
 */