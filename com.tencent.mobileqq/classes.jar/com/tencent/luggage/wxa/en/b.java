package com.tencent.luggage.wxa.en;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b<SERVICE extends h, PAGE extends u>
  implements a<SERVICE, PAGE>
{
  private final b.a<SERVICE> a;
  private final b.a<PAGE> b;
  private b.b c = b.b.a;
  private final HashSet<a.a> d = new HashSet();
  private final Queue<PAGE> e = new ConcurrentLinkedQueue();
  private final Queue<SERVICE> f = new ConcurrentLinkedQueue();
  private volatile boolean g = false;
  private volatile boolean h = false;
  
  public b(b.a<SERVICE> parama, b.a<PAGE> parama1)
  {
    this.a = parama;
    this.b = parama1;
  }
  
  private void d()
  {
    o.e("Luggage.RuntimePreloader[applaunch]", "reset");
    for (;;)
    {
      try
      {
        this.c = b.b.a;
        this.d.clear();
        localObject3 = new LinkedList(this.e);
        this.e.clear();
        localObject1 = new LinkedList(this.f);
        this.f.clear();
        localObject3 = ((List)localObject3).iterator();
      }
      finally
      {
        Object localObject3;
        Object localObject1;
        u localu;
        continue;
        throw localObject2;
        continue;
        continue;
        continue;
      }
      if (((Iterator)localObject3).hasNext()) {
        localu = (u)((Iterator)localObject3).next();
      }
      try
      {
        localu.l();
      }
      catch (Exception localException2) {}
    }
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext()) {
        localObject3 = (h)((Iterator)localObject1).next();
      }
      try
      {
        ((h)localObject3).l();
      }
      catch (Exception localException1) {}
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 48	com/tencent/luggage/wxa/en/b:f	Ljava/util/Queue;
    //   7: invokeinterface 117 1 0
    //   12: ifle +35 -> 47
    //   15: ldc 2
    //   17: monitorexit
    //   18: ldc 71
    //   20: ldc 119
    //   22: invokestatic 121	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc 2
    //   27: monitorenter
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 50	com/tencent/luggage/wxa/en/b:g	Z
    //   33: aload_0
    //   34: invokespecial 123	com/tencent/luggage/wxa/en/b:g	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: getfield 54	com/tencent/luggage/wxa/en/b:a	Lcom/tencent/luggage/wxa/en/b$a;
    //   54: invokeinterface 127 1 0
    //   59: checkcast 112	com/tencent/luggage/wxa/iu/h
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 130	com/tencent/luggage/wxa/iu/h:B	()V
    //   67: ldc 2
    //   69: monitorenter
    //   70: aload_0
    //   71: getfield 48	com/tencent/luggage/wxa/en/b:f	Ljava/util/Queue;
    //   74: aload_1
    //   75: invokeinterface 134 2 0
    //   80: pop
    //   81: ldc 2
    //   83: monitorexit
    //   84: ldc 71
    //   86: ldc 119
    //   88: invokestatic 121	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc 2
    //   93: monitorenter
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 50	com/tencent/luggage/wxa/en/b:g	Z
    //   99: aload_0
    //   100: invokespecial 123	com/tencent/luggage/wxa/en/b:g	()V
    //   103: ldc 2
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: ldc 2
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: goto +48 -> 174
    //   129: astore_1
    //   130: ldc 71
    //   132: ldc 136
    //   134: iconst_1
    //   135: anewarray 5	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: invokestatic 139	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: ldc 71
    //   147: ldc 119
    //   149: invokestatic 121	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 2
    //   154: monitorenter
    //   155: aload_0
    //   156: iconst_1
    //   157: putfield 50	com/tencent/luggage/wxa/en/b:g	Z
    //   160: aload_0
    //   161: invokespecial 123	com/tencent/luggage/wxa/en/b:g	()V
    //   164: ldc 2
    //   166: monitorexit
    //   167: return
    //   168: astore_1
    //   169: ldc 2
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: ldc 71
    //   176: ldc 119
    //   178: invokestatic 121	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: ldc 2
    //   183: monitorenter
    //   184: aload_0
    //   185: iconst_1
    //   186: putfield 50	com/tencent/luggage/wxa/en/b:g	Z
    //   189: aload_0
    //   190: invokespecial 123	com/tencent/luggage/wxa/en/b:g	()V
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: ldc 2
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	b
    //   41	5	1	localObject1	Object
    //   62	13	1	localh	h
    //   107	5	1	localObject2	Object
    //   113	5	1	localObject3	Object
    //   119	5	1	localObject4	Object
    //   125	1	1	localObject5	Object
    //   129	12	1	localException	Exception
    //   168	29	1	localObject6	Object
    //   198	5	1	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   28	40	41	finally
    //   42	45	41	finally
    //   94	106	107	finally
    //   108	111	107	finally
    //   70	84	113	finally
    //   114	117	113	finally
    //   3	18	119	finally
    //   47	50	119	finally
    //   120	123	119	finally
    //   0	3	125	finally
    //   50	70	125	finally
    //   117	119	125	finally
    //   123	125	125	finally
    //   130	145	125	finally
    //   0	3	129	java/lang/Exception
    //   50	70	129	java/lang/Exception
    //   117	119	129	java/lang/Exception
    //   123	125	129	java/lang/Exception
    //   155	167	168	finally
    //   169	172	168	finally
    //   184	196	198	finally
    //   199	202	198	finally
  }
  
  private void f()
  {
    b.3 local3 = new b.3(this);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      local3.run();
      return;
    }
    t.a(local3);
  }
  
  private void g()
  {
    try
    {
      o.d("Luggage.RuntimePreloader[applaunch]", "notifyDoneIfAllReady, service:%b, page:%b", new Object[] { Boolean.valueOf(this.g), Boolean.valueOf(this.h) });
      if ((this.g) && (this.h)) {
        c();
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  public SERVICE a(String paramString)
  {
    try
    {
      b.b localb = this.c;
      h localh = (h)this.f.poll();
      String str = localb.name();
      int i;
      if (localh == null) {
        i = 0;
      } else {
        i = localh.hashCode();
      }
      o.d("Luggage.RuntimePreloader[applaunch]", "getServices appID:%s, state:%s, service:%d", new Object[] { paramString, str, Integer.valueOf(i) });
      if (localb == b.b.a)
      {
        o.d("Luggage.RuntimePreloader[applaunch]", "RuntimePreloader not preload, just return null");
        return null;
      }
      if (localb == b.b.b)
      {
        o.a("Luggage.RuntimePreloader[applaunch]", new IllegalStateException(), "RuntimePreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
        return null;
      }
      return localh;
    }
    finally {}
  }
  
  public void a(a.a parama, boolean paramBoolean)
  {
    try
    {
      o.d("Luggage.RuntimePreloader[applaunch]", "preload forcePreload:%b, currentState:%s", new Object[] { Boolean.valueOf(paramBoolean), this.c });
      if ((this.c == b.b.c) && (paramBoolean)) {
        d();
      }
      b.b localb = this.c;
      if ((localb == b.b.a) || (localb == b.b.b))
      {
        if (parama != null) {
          this.d.add(parama);
        }
        this.c = b.b.b;
        this.g = false;
        this.h = false;
      }
      if (localb == b.b.b) {
        return;
      }
      if (localb == b.b.c)
      {
        if (parama != null) {
          parama.a();
        }
        return;
      }
      o.d("Luggage.RuntimePreloader[applaunch]", "TRACE_ORDER:RuntimePreloader.java");
      f.a.a(new b.1(this), "_PreInitWebView");
      f.a.a(new b.2(this), "_PreloadService");
      return;
    }
    finally {}
  }
  
  public final boolean a()
  {
    for (;;)
    {
      try
      {
        if (this.c == b.b.c)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean a(a.a parama)
  {
    try
    {
      o.d("Luggage.RuntimePreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", new Object[] { this.c.name() });
      if (this.c == b.b.b)
      {
        if (parama != null) {
          this.d.add(parama);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  @Nullable
  public SERVICE b()
  {
    try
    {
      h localh = (h)this.f.peek();
      return localh;
    }
    finally {}
  }
  
  @Nullable
  public PAGE b(String paramString)
  {
    try
    {
      paramString = (u)this.e.poll();
      return paramString;
    }
    finally {}
  }
  
  @CallSuper
  protected void c()
  {
    o.d("Luggage.RuntimePreloader[applaunch]", "preInit finished, currentState=%s, callbacks.size=%d", new Object[] { this.c, Integer.valueOf(this.d.size()) });
    this.c = b.b.c;
    Object localObject = new LinkedList(this.d);
    this.d.clear();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if (locala != null) {
        locala.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.b
 * JD-Core Version:    0.7.0.1
 */