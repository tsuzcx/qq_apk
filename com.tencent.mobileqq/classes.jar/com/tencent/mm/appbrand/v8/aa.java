package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

class aa
  implements d
{
  private static final ThreadLocal<aa> i = new ThreadLocal();
  @NonNull
  private final Thread a = Thread.currentThread();
  private final m<Runnable> b = m.a.a();
  private aa.a c = aa.a.a;
  private boolean d;
  private volatile boolean e;
  private final boolean f;
  @Nullable
  private d.a g;
  private l h = new l();
  private Queue<Runnable> j = new LinkedList();
  private Queue<Runnable> k = new LinkedList();
  private boolean l = false;
  private int m = -1;
  
  aa(boolean paramBoolean)
  {
    this.f = paramBoolean;
    o.d("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  private void a(Runnable paramRunnable)
  {
    try
    {
      paramRunnable.run();
      return;
    }
    catch (NullPointerException paramRunnable)
    {
      o.a("MicroMsg.V8JSRuntimeLooper", paramRunnable, "runTask", new Object[0]);
      throw paramRunnable;
    }
    catch (UndeclaredThrowableException paramRunnable)
    {
      o.b("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", new Object[] { paramRunnable, paramRunnable.getCause() });
      return;
    }
    catch (V8ScriptException paramRunnable)
    {
      d.a locala = this.g;
      if (locala != null) {
        locala.a(paramRunnable);
      }
    }
  }
  
  private int r()
  {
    synchronized (this.b)
    {
      int n = this.b.size();
      return n;
    }
  }
  
  public void a()
  {
    o.d("MicroMsg.V8JSRuntimeLooper", "loop start %d", new Object[] { Integer.valueOf(hashCode()) });
    while (!this.e) {
      synchronized (this.b)
      {
        for (;;)
        {
          boolean bool1 = p();
          if ((!bool1) || (this.b.a()))
          {
            boolean bool2 = i();
            if (!bool2) {
              break label136;
            }
          }
          label136:
          try
          {
            this.b.wait();
            if (aa.a.b == this.c) {
              o.d("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", new Object[] { this.c, Integer.valueOf(hashCode()) });
            }
            this.c = aa.a.a;
          }
          catch (InterruptedException localInterruptedException)
          {
            label118:
            break label118;
          }
        }
        o.d("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
        this.a.interrupt();
        q();
        this.j.clear();
        this.b.a(this.j, bool1);
        j();
      }
    }
    l();
    synchronized (this.b)
    {
      this.b.clear();
      return;
    }
  }
  
  public void a(d.a parama)
  {
    this.g = parama;
  }
  
  public void a(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    if (paramLong == 0L)
    {
      if (this.e)
      {
        o.d("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
        return;
      }
      boolean bool = p();
      synchronized (this.b)
      {
        this.b.a(paramRunnable, paramBoolean);
        if ((paramBoolean) || (!bool)) {
          this.b.notify();
        }
        if ((paramBoolean) && (bool)) {
          o.d("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(r()) });
        }
        m();
        return;
      }
    }
    throw new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    if (this.e)
    {
      o.d("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
      return;
    }
    boolean bool;
    if (Thread.currentThread().getId() == this.a.getId())
    {
      a(paramRunnable);
      if (this.h.a) {
        this.h.b.remove(null);
      }
    }
    else
    {
      bool = p();
    }
    synchronized (this.b)
    {
      this.b.a(paramRunnable, paramBoolean);
      if ((paramBoolean) || (!bool))
      {
        this.c = aa.a.c;
        this.b.notify();
      }
      if ((paramBoolean) && (bool)) {
        o.d("MicroMsg.V8JSRuntimeLooper", "schedule: important task in pause state. queue.size:[%d]", new Object[] { Integer.valueOf(r()) });
      }
      m();
      return;
    }
  }
  
  public boolean b()
  {
    return Thread.currentThread().getId() == this.a.getId();
  }
  
  @Nullable
  public String c()
  {
    return (String)this.h.b.peek();
  }
  
  public void d()
  {
    o.d("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(r()) });
    try
    {
      this.d = true;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: ldc 91
    //   2: ldc 254
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: invokevirtual 148	java/lang/Object:hashCode	()I
    //   14: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: invokespecial 208	com/tencent/mm/appbrand/v8/aa:r	()I
    //   24: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 104	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 252	com/tencent/mm/appbrand/v8/aa:d	Z
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_0
    //   41: invokevirtual 257	com/tencent/mm/appbrand/v8/aa:n	()V
    //   44: aload_0
    //   45: getfield 57	com/tencent/mm/appbrand/v8/aa:b	Lcom/tencent/mm/appbrand/v8/m;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getstatic 168	com/tencent/mm/appbrand/v8/aa$a:b	Lcom/tencent/mm/appbrand/v8/aa$a;
    //   55: putfield 63	com/tencent/mm/appbrand/v8/aa:c	Lcom/tencent/mm/appbrand/v8/aa$a;
    //   58: aload_0
    //   59: getfield 57	com/tencent/mm/appbrand/v8/aa:b	Lcom/tencent/mm/appbrand/v8/m;
    //   62: invokevirtual 204	java/lang/Object:notify	()V
    //   65: aload_1
    //   66: monitorexit
    //   67: return
    //   68: astore_2
    //   69: aload_1
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	aa
    //   73	4	1	localObject1	Object
    //   68	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	67	68	finally
    //   69	71	68	finally
    //   33	40	73	finally
    //   74	76	73	finally
  }
  
  public void f()
  {
    o.d("MicroMsg.V8JSRuntimeLooper", "quit %d", new Object[] { Integer.valueOf(hashCode()) });
    o();
    this.e = true;
    this.a.interrupt();
  }
  
  public void g()
  {
    Iterator localIterator = this.j.iterator();
    int n = -1;
    do
    {
      Runnable localRunnable;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localRunnable = (Runnable)localIterator.next();
        if ((this.f) && (this.e))
        {
          o.d("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
          break;
        }
        n += 1;
      } while (n <= this.m);
      this.m = n;
      a(localRunnable);
      if (this.h.a) {
        this.h.b.pollFirst();
      }
    } while (!this.l);
    this.l = true;
  }
  
  public boolean h()
  {
    if (this.e)
    {
      this.l = true;
      return true;
    }
    synchronized (this.b)
    {
      for (;;)
      {
        boolean bool1 = p();
        if ((!bool1) || (this.b.a()))
        {
          boolean bool2 = i();
          if (!bool2) {
            break label122;
          }
        }
        try
        {
          this.b.wait();
          if (aa.a.b == this.c) {
            o.d("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", new Object[] { this.c, Integer.valueOf(hashCode()) });
          }
          this.c = aa.a.a;
        }
        catch (InterruptedException localInterruptedException)
        {
          label104:
          label122:
          break label104;
        }
      }
      o.d("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
      this.a.interrupt();
      q();
      this.k.clear();
      this.b.a(this.k, bool1);
      k();
      return false;
    }
  }
  
  protected boolean i()
  {
    return this.b.isEmpty();
  }
  
  protected void j()
  {
    this.m = -1;
    this.l = false;
    Iterator localIterator = this.j.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.f) && (this.e))
      {
        o.d("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        return;
      }
      this.m += 1;
      a(localRunnable);
      if (this.h.a) {
        this.h.b.pollFirst();
      }
    } while (!this.l);
  }
  
  protected void k()
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      if ((this.f) && (this.e))
      {
        o.d("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
        return;
      }
      a(localRunnable);
      if (this.h.a) {
        this.h.b.pollFirst();
      }
    }
  }
  
  protected void l()
  {
    o.d("MicroMsg.V8JSRuntimeLooper", "loop end");
  }
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o() {}
  
  protected boolean p()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.aa
 * JD-Core Version:    0.7.0.1
 */