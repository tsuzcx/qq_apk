package com.b.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private final AtomicInteger a = new AtomicInteger();
  private final Set<m<?>> b = new HashSet();
  private final PriorityBlockingQueue<m<?>> c = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<m<?>> d = new PriorityBlockingQueue();
  private final b e;
  private final g f;
  private final p g;
  private final h[] h;
  private c i;
  private final List<n.a> j = new ArrayList();
  private ExecutorService k = Executors.newFixedThreadPool(2);
  
  private n(b paramb, g paramg, int paramInt, boolean paramBoolean)
  {
    this.e = paramb;
    this.f = paramg;
    this.h = new h[4];
    if (paramBoolean) {}
    for (paramb = new p(new Handler(Looper.getMainLooper()));; paramb = new p(this.k))
    {
      this.g = paramb;
      return;
    }
  }
  
  public n(b paramb, g paramg, boolean paramBoolean)
  {
    this(paramb, paramg, 4, false);
  }
  
  public final <T> m<T> a(m<T> paramm)
  {
    paramm.a(this);
    synchronized (this.b)
    {
      this.b.add(paramm);
      paramm.a(this.a.incrementAndGet());
      paramm.a("add-to-queue");
      if (!paramm.l())
      {
        ??? = this.d;
        ((PriorityBlockingQueue)???).add(paramm);
        return paramm;
      }
      ??? = this.c;
    }
    for (;;)
    {
      throw paramm;
    }
  }
  
  public final void a()
  {
    Object localObject1 = this.i;
    if (localObject1 != null) {
      ((c)localObject1).a();
    }
    localObject1 = this.h;
    int i1 = localObject1.length;
    int n = 0;
    int m = 0;
    while (m < i1)
    {
      Object localObject2 = localObject1[m];
      if (localObject2 != null) {
        localObject2.a();
      }
      m += 1;
    }
    this.i = new c(this.c, this.d, this.e, this.g);
    this.i.start();
    m = n;
    while (m < this.h.length)
    {
      localObject1 = new h(this.d, this.f, this.e, this.g);
      this.h[m] = localObject1;
      ((h)localObject1).start();
      m += 1;
    }
  }
  
  final <T> void b(m<T> arg1)
  {
    synchronized (this.b)
    {
      this.b.remove(???);
      synchronized (this.j)
      {
        ??? = this.j.iterator();
        while (((Iterator)???).hasNext()) {
          ((Iterator)???).next();
        }
        return;
      }
    }
    for (;;)
    {
      throw ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.n
 * JD-Core Version:    0.7.0.1
 */