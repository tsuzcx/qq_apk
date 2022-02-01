package com.tencent.luggage.wxa.sj;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.luggage.wxa.rz.c.e;
import com.tencent.luggage.wxa.rz.e.b;
import com.tencent.luggage.wxa.sg.h;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class i<V>
  extends FutureTask<V>
  implements c, d<V>, g, Delayed, RunnableScheduledFuture<V>
{
  private static final com.tencent.luggage.wxa.sf.a g = com.tencent.luggage.wxa.sc.b.a;
  private static final AtomicLong h = new AtomicLong();
  private static final com.tencent.luggage.wxa.sh.b n = h.a;
  private static final long r = Looper.getMainLooper().getThread().getId();
  protected long a = 0L;
  protected long b = 0L;
  protected Thread c;
  protected long d = 0L;
  private boolean e = true;
  private com.tencent.luggage.wxa.rz.d f = com.tencent.luggage.wxa.rz.d.d;
  private final long i = h.getAndIncrement();
  private volatile long j;
  private final long k;
  private Object l;
  private String m;
  private com.tencent.luggage.wxa.sg.g o;
  private com.tencent.luggage.wxa.si.d p;
  private final int q;
  private Throwable s;
  
  public i(Runnable paramRunnable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramRunnable, null);
    this.l = paramRunnable;
    this.j = paramLong1;
    this.k = paramLong2;
    this.m = a();
    this.q = paramRunnable.hashCode();
    this.e = paramBoolean;
    if (paramBoolean)
    {
      paramRunnable = g;
      if (paramRunnable != null) {
        paramRunnable.a(this);
      }
    }
    com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), paramLong1 - System.nanoTime(), 0L, "", paramBoolean);
  }
  
  public i(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    super(paramRunnable, null);
    this.l = paramRunnable;
    this.j = paramLong;
    this.k = 0L;
    this.m = a();
    this.q = paramRunnable.hashCode();
    this.e = paramBoolean;
    if (paramBoolean)
    {
      paramRunnable = g;
      if (paramRunnable != null) {
        paramRunnable.a(this);
      }
    }
    com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), paramLong - System.nanoTime(), 0L, "", paramBoolean);
  }
  
  private long a(long paramLong)
  {
    long l1 = System.nanoTime();
    if (paramLong >= 4611686018427387903L) {
      paramLong = 4611686018427387903L;
    }
    return l1 + paramLong;
  }
  
  private void a(Looper paramLooper)
  {
    e.b localb = com.tencent.luggage.wxa.rz.a.j;
    if ((localb.a()) && (r != Thread.currentThread().getId()) && (Looper.myLooper() != null) && (paramLooper == null))
    {
      localb.a(Thread.currentThread(), a());
      if (localb.c()) {
        try
        {
          ((ThreadLocal)com.tencent.luggage.wxa.sl.c.a(Looper.class, "sThreadLocal")).set(null);
          return;
        }
        catch (Exception paramLooper)
        {
          this.s = paramLooper;
          return;
        }
      }
      if (localb.b())
      {
        paramLooper = new StringBuilder();
        paramLooper.append("this task has prepared looper, is not ");
        paramLooper.append(a());
        this.s = new RuntimeException(paramLooper.toString());
      }
    }
  }
  
  private void m()
  {
    Throwable localThrowable = this.s;
    if (localThrowable != null)
    {
      if (!(localThrowable instanceof RuntimeException))
      {
        if ((localThrowable instanceof Error)) {
          throw ((Error)localThrowable);
        }
        throw new Error(localThrowable);
      }
      throw ((RuntimeException)localThrowable);
    }
  }
  
  private void n()
  {
    boolean bool = isPeriodic();
    if (!a(bool))
    {
      cancel(false);
      return;
    }
    if (!bool)
    {
      super.run();
      return;
    }
    if (super.runAndReset())
    {
      c();
      if (this.e)
      {
        com.tencent.luggage.wxa.sf.a locala = g;
        if (locala != null) {
          locala.a(this);
        }
      }
      this.p.b(this);
    }
  }
  
  public int a(Delayed paramDelayed)
  {
    int i1 = 0;
    if (paramDelayed == this) {
      return 0;
    }
    if ((paramDelayed instanceof i))
    {
      paramDelayed = (i)paramDelayed;
      l1 = this.j - paramDelayed.j;
      if (l1 < 0L) {
        return -1;
      }
      if (l1 > 0L) {
        return 1;
      }
      if (this.i < paramDelayed.i) {
        return -1;
      }
      return 1;
    }
    long l1 = getDelay(TimeUnit.NANOSECONDS) - paramDelayed.getDelay(TimeUnit.NANOSECONDS);
    if (l1 < 0L) {
      return -1;
    }
    if (l1 > 0L) {
      i1 = 1;
    }
    return i1;
  }
  
  public String a()
  {
    String str = this.m;
    Object localObject = str;
    if (str == null)
    {
      localObject = this.l;
      if ((localObject instanceof f)) {
        return ((f)localObject).a();
      }
      localObject = localObject.getClass().getName();
    }
    return localObject;
  }
  
  public void a(com.tencent.luggage.wxa.rz.d paramd)
  {
    this.f = paramd;
  }
  
  public void a(com.tencent.luggage.wxa.si.d paramd)
  {
    this.p = paramd;
    this.b = SystemClock.uptimeMillis();
  }
  
  boolean a(boolean paramBoolean)
  {
    return this.p.a() ^ true;
  }
  
  public com.tencent.luggage.wxa.si.d b()
  {
    return this.p;
  }
  
  protected void c()
  {
    long l1 = this.k;
    if (l1 > 0L)
    {
      this.j += l1;
      return;
    }
    this.j = a(-l1);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (super.cancel(paramBoolean))
    {
      this.f = com.tencent.luggage.wxa.rz.d.c;
      if (this.e)
      {
        localObject = g;
        if (localObject != null) {
          ((com.tencent.luggage.wxa.sf.a)localObject).b(this);
        }
      }
      com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), 0L, 0L, "", this.e);
      Object localObject = this.p;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.si.d)localObject).c(this);
      }
      return true;
    }
    return false;
  }
  
  public Throwable d()
  {
    return this.s;
  }
  
  protected void done()
  {
    super.done();
    this.l = null;
  }
  
  public com.tencent.luggage.wxa.sh.b e()
  {
    return n;
  }
  
  public com.tencent.luggage.wxa.sg.g f()
  {
    if (this.o == null) {
      this.o = n.a(this.m);
    }
    return this.o;
  }
  
  protected void finalize()
  {
    super.finalize();
    if ((this.f == com.tencent.luggage.wxa.rz.d.d) || (this.f == com.tencent.luggage.wxa.rz.d.e)) {
      cancel(false);
    }
  }
  
  public com.tencent.luggage.wxa.rz.d g()
  {
    return this.f;
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.j - System.nanoTime(), TimeUnit.NANOSECONDS);
  }
  
  public long[] h()
  {
    if (this.f == com.tencent.luggage.wxa.rz.d.g) {
      return new long[] { this.d, this.a };
    }
    return new long[2];
  }
  
  public boolean i()
  {
    return n.c(f());
  }
  
  public boolean isPeriodic()
  {
    return this.k != 0L;
  }
  
  public boolean j()
  {
    long l1 = n.a(f(), TimeUnit.NANOSECONDS);
    if (l1 >= 0L)
    {
      this.j = (System.nanoTime() + l1);
      return true;
    }
    return false;
  }
  
  public Object k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.q;
  }
  
  public void run()
  {
    if (isCancelled()) {
      return;
    }
    if (!i())
    {
      if (j())
      {
        a(com.tencent.luggage.wxa.rz.d.e);
        this.p.b(this);
        if (this.e)
        {
          localObject1 = g;
          if (localObject1 != null) {
            ((com.tencent.luggage.wxa.sf.a)localObject1).f(this);
          }
        }
        com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, f().a(), this.j - System.nanoTime(), b().c());
        return;
      }
      this.f = com.tencent.luggage.wxa.rz.d.a;
      if (this.e)
      {
        localObject1 = g;
        if (localObject1 != null) {
          ((com.tencent.luggage.wxa.sf.a)localObject1).e(this);
        }
      }
      com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), 0L, 0L, b().c(), this.e);
      return;
    }
    this.a = SystemClock.uptimeMillis();
    this.b -= this.a;
    this.d = SystemClock.currentThreadTimeMillis();
    this.f = com.tencent.luggage.wxa.rz.d.f;
    com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), this.a, this.d, b().c(), this.e);
    if (this.e)
    {
      localObject1 = g;
      if (localObject1 != null) {
        ((com.tencent.luggage.wxa.sf.a)localObject1).c(this);
      }
    }
    Object localObject1 = Looper.myLooper();
    this.c = Thread.currentThread();
    try
    {
      n();
      this.a = (SystemClock.uptimeMillis() - this.a);
      this.d = (SystemClock.currentThreadTimeMillis() - this.d);
      if (this.f != com.tencent.luggage.wxa.rz.d.b) {
        this.f = com.tencent.luggage.wxa.rz.d.g;
      }
      if (g != null)
      {
        i1 = i.1.a[this.f.ordinal()];
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            if (this.e) {
              g.a(this, this.d, this.a);
            }
            com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), this.a, this.d, b().c(), this.e);
          }
        }
        else
        {
          if (this.e) {
            g.d(this);
          }
          com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, d());
        }
      }
      a((Looper)localObject1);
      m();
      return;
    }
    finally
    {
      int i1;
      this.a = (SystemClock.uptimeMillis() - this.a);
      this.d = (SystemClock.currentThreadTimeMillis() - this.d);
      if (this.f != com.tencent.luggage.wxa.rz.d.b) {
        this.f = com.tencent.luggage.wxa.rz.d.g;
      }
      if (g != null)
      {
        i1 = i.1.a[this.f.ordinal()];
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            if (this.e) {
              g.a(this, this.d, this.a);
            }
            com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, g(), this.a, this.d, b().c(), this.e);
          }
        }
        else
        {
          if (this.e) {
            g.d(this);
          }
          com.tencent.luggage.wxa.rz.c.a.a(a(), this.q, d());
        }
      }
      a((Looper)localObject1);
      m();
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    super.setException(paramThrowable);
    this.f = com.tencent.luggage.wxa.rz.d.b;
    this.s = paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sj.i
 * JD-Core Version:    0.7.0.1
 */