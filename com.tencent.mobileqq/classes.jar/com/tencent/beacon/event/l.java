package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.f;
import com.tencent.beacon.upload.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l
  implements j
{
  private boolean a = false;
  private List<k> b;
  private Context c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      try
      {
        l.this.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
      }
    }
  };
  private Runnable e = new Runnable()
  {
    public final void run()
    {
      l.a(l.this);
    }
  };
  
  public l(Context paramContext)
  {
    this.c = paramContext;
    this.b = Collections.synchronizedList(new ArrayList(25));
  }
  
  /* Error */
  private List<k> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/beacon/event/l:b	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 52	com/tencent/beacon/event/l:b	Ljava/util/List;
    //   13: invokeinterface 62 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 65	com/tencent/beacon/event/l:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 41	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 66	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 52	com/tencent/beacon/event/l:b	Ljava/util/List;
    //   49: invokeinterface 70 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 52	com/tencent/beacon/event/l:b	Ljava/util/List;
    //   59: invokeinterface 73 1 0
    //   64: new 75	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 77
    //   70: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 62 1 0
    //   79: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 93	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -60 -> 32
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	l
    //   25	2	1	bool	boolean
    //   31	43	2	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	95	finally
    //   36	92	95	finally
  }
  
  private boolean c()
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
  
  private void d()
  {
    Object localObject = b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      com.tencent.beacon.d.a.f(" dsb real events 2 db" + ((List)localObject).size(), new Object[0]);
      localObject = f.a(this.c, (List)localObject);
      if (localObject != null) {
        o.d().d.b(localObject.length);
      }
    }
  }
  
  protected final void a()
  {
    if (!c()) {
      com.tencent.beacon.d.a.c(" err su 1R", new Object[0]);
    }
    Object localObject;
    h localh;
    do
    {
      do
      {
        return;
        localObject = b();
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      localh = o.d().h();
      g localg = o.d().i();
      if ((f.t(this.c)) && (localh != null) && (localg.l())) {
        break;
      }
      com.tencent.beacon.d.a.f(" dsu real events 2 db" + ((List)localObject).size(), new Object[0]);
      localObject = f.a(this.c, (List)localObject);
    } while (localObject == null);
    o.d().d.b(localObject.length);
    return;
    com.tencent.beacon.d.a.f(" dsu real events 2 up " + ((List)localObject).size(), new Object[0]);
    localh.a(new a(this.c, (List)localObject));
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/beacon/event/l:a	Z
    //   6: iload_1
    //   7: if_icmpeq +43 -> 50
    //   10: iload_1
    //   11: ifeq +42 -> 53
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 29	com/tencent/beacon/event/l:a	Z
    //   19: invokestatic 112	com/tencent/beacon/event/o:d	()Lcom/tencent/beacon/event/o;
    //   22: invokevirtual 131	com/tencent/beacon/event/o:i	()Lcom/tencent/beacon/event/g;
    //   25: invokevirtual 155	com/tencent/beacon/event/g:b	()I
    //   28: sipush 1000
    //   31: imul
    //   32: i2l
    //   33: lstore_2
    //   34: invokestatic 160	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   37: bipush 103
    //   39: aload_0
    //   40: getfield 34	com/tencent/beacon/event/l:d	Ljava/lang/Runnable;
    //   43: ldc2_w 161
    //   46: lload_2
    //   47: invokevirtual 165	com/tencent/beacon/a/c:a	(ILjava/lang/Runnable;JJ)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 160	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   56: bipush 103
    //   58: invokevirtual 167	com/tencent/beacon/a/c:a	(I)V
    //   61: aload_0
    //   62: iconst_1
    //   63: invokevirtual 169	com/tencent/beacon/event/l:b	(Z)V
    //   66: aload_0
    //   67: iload_1
    //   68: putfield 29	com/tencent/beacon/event/l:a	Z
    //   71: goto -21 -> 50
    //   74: astore 4
    //   76: aload_0
    //   77: monitorexit
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	l
    //   0	81	1	paramBoolean	boolean
    //   33	14	2	l	long
    //   74	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	74	finally
    //   14	50	74	finally
    //   53	71	74	finally
  }
  
  public final boolean a(k paramk)
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    if (paramk == null)
    {
      localObject1 = "null";
      if (paramk != null) {
        break label79;
      }
      localObject2 = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.d.a.f(" BF eN:%s   isRT:%b  isCR:%b", new Object[] { localObject1, Boolean.valueOf(true), localObject2 });
        if ((this.c == null) || (paramk == null))
        {
          com.tencent.beacon.d.a.c("processUA return false, context is null or bean is null !", new Object[0]);
          return bool;
          localObject1 = paramk.d();
          break;
          label79:
          localObject2 = Boolean.valueOf(paramk.f());
          continue;
        }
        if (!c())
        {
          com.tencent.beacon.d.a.c("processUA return false, isEnable is false !", new Object[0]);
          continue;
        }
        localObject1 = o.d().i();
      }
      finally {}
      int i = ((g)localObject1).a();
      long l = ((g)localObject1).b() * 1000;
      if ((this.b.size() >= i) || (paramk.j()))
      {
        com.tencent.beacon.d.a.f(" BF mN!", new Object[0]);
        c.a().a(this.d);
        c.a().a(103, this.d, l, l);
      }
      this.b.add(paramk);
      if (this.b.size() >= i) {
        com.tencent.beacon.d.a.c(" err BF 3R! num:" + this.b.size(), new Object[0]);
      }
      if ("rqd_applaunched".equals(paramk.d())) {
        c.a().a(this.d);
      }
      o.d().d.b();
      com.tencent.beacon.d.a.a("processUA:true!", new Object[0]);
      bool = true;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 221
    //   4: iconst_0
    //   5: anewarray 4	java/lang/Object
    //   8: invokestatic 223	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokespecial 55	com/tencent/beacon/event/l:d	()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 160	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   25: aload_0
    //   26: getfield 37	com/tencent/beacon/event/l:e	Ljava/lang/Runnable;
    //   29: invokevirtual 200	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;)V
    //   32: goto -13 -> 19
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	l
    //   0	40	1	paramBoolean	boolean
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	35	finally
    //   15	19	35	finally
    //   22	32	35	finally
  }
  
  static final class a
    extends com.tencent.beacon.upload.a
  {
    private List<k> f = null;
    private Context g;
    private Long[] h = null;
    private boolean i = false;
    
    public a(Context paramContext, List<k> paramList)
    {
      super(1, 2);
      this.f = paramList;
      this.g = paramContext;
      this.e = this.f.size();
      if ((this.f.size() == 1) && ("rqd_heartbeat".equals(((k)this.f.get(0)).d()))) {
        this.i = true;
      }
      this.d = f.b(paramContext, 2);
      com.tencent.beacon.d.a.a("real rid:%s", new Object[] { this.d });
    }
    
    /* Error */
    public final com.tencent.beacon.b.a.b a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 83
      //   4: iconst_0
      //   5: anewarray 70	java/lang/Object
      //   8: invokestatic 85	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   11: aload_0
      //   12: getfield 23	com/tencent/beacon/event/l$a:f	Ljava/util/List;
      //   15: ifnull +17 -> 32
      //   18: aload_0
      //   19: getfield 23	com/tencent/beacon/event/l$a:f	Ljava/util/List;
      //   22: invokeinterface 35 1 0
      //   27: istore_1
      //   28: iload_1
      //   29: ifgt +9 -> 38
      //   32: aconst_null
      //   33: astore_2
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_2
      //   37: areturn
      //   38: aload_0
      //   39: getfield 29	com/tencent/beacon/event/l$a:g	Landroid/content/Context;
      //   42: astore_2
      //   43: aload_0
      //   44: getfield 87	com/tencent/beacon/event/l$a:a	I
      //   47: aload_0
      //   48: getfield 23	com/tencent/beacon/event/l$a:f	Ljava/util/List;
      //   51: invokestatic 92	com/tencent/beacon/event/m:a	(ILjava/util/List;)Lcom/tencent/beacon/b/a/b;
      //   54: astore_3
      //   55: aload_3
      //   56: astore_2
      //   57: aload_3
      //   58: ifnonnull -24 -> 34
      //   61: aconst_null
      //   62: astore_2
      //   63: goto -29 -> 34
      //   66: astore_2
      //   67: aload_2
      //   68: invokestatic 95	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
      //   71: ldc 97
      //   73: iconst_0
      //   74: anewarray 70	java/lang/Object
      //   77: invokestatic 99	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   80: goto -19 -> 61
      //   83: astore_2
      //   84: aload_0
      //   85: monitorexit
      //   86: aload_2
      //   87: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	a
      //   27	2	1	j	int
      //   33	30	2	localObject1	Object
      //   66	2	2	localThrowable	Throwable
      //   83	4	2	localObject2	Object
      //   54	4	3	localb	com.tencent.beacon.b.a.b
      // Exception table:
      //   from	to	target	type
      //   38	55	66	java/lang/Throwable
      //   2	28	83	finally
      //   38	55	83	finally
      //   67	80	83	finally
    }
    
    public final void b(boolean paramBoolean)
    {
      try
      {
        com.tencent.beacon.d.a.b(" TimeUpUploadDatas.done(), result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        if ((this.f != null) && (!paramBoolean))
        {
          com.tencent.beacon.d.a.f(" upload failed, save to db", new Object[0]);
          if (!this.i)
          {
            this.h = f.a(this.g, this.f);
            if (this.h != null) {
              o.d().d.b(this.h.length);
            }
            this.f = null;
          }
        }
        if ((paramBoolean) && (this.i))
        {
          Context localContext = this.g;
          c.a().a(108);
          com.tencent.beacon.a.b.a(localContext, "HEART_DENGTA", f.n());
          com.tencent.beacon.d.a.a("heartbeat uploaded sucess!", new Object[0]);
        }
        if ((paramBoolean) && (this.h != null)) {
          f.a(this.g, this.h);
        }
        if ((paramBoolean) && (this.f != null)) {
          o.d().d.c(this.f.size());
        }
        if ((paramBoolean) && (this.h == null) && (this.f != null)) {
          this.f = null;
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.l
 * JD-Core Version:    0.7.0.1
 */