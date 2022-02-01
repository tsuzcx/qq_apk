package com.tencent.luggage.wxa.ix;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.ra.a;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

abstract class d
  extends g
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private final d.e b;
  private final d.b c;
  private final d.f d;
  private final d.d e;
  private final d.c f;
  private final String g = q();
  private final com.tencent.luggage.wxa.iu.d h;
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final AtomicBoolean j = new AtomicBoolean(false);
  private final AtomicBoolean k = new AtomicBoolean(false);
  private final AtomicReference<com.tencent.luggage.wxa.ra.b> l = new AtomicReference(null);
  private final AtomicReference<com.tencent.luggage.wxa.ra.b> m = new AtomicReference(null);
  private final Queue<i<?>> n = new LinkedBlockingQueue();
  private final AtomicBoolean o = new AtomicBoolean(false);
  private volatile com.tencent.luggage.wxa.ra.b p = null;
  
  d(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    super(String.format(Locale.ENGLISH, "Luggage.AppRunningStateMachine[%s][%d]", new Object[] { paramd.aa(), Integer.valueOf(a.incrementAndGet()) }), Looper.getMainLooper());
    this.h = paramd;
    super.b(false);
    this.e = new d.d(this, this);
    this.f = new d.c(this, this);
    this.c = new d.b(this, this, paramd);
    this.b = new d.e(this, this);
    this.d = new d.f(this, this);
    paramd = new d.1(this);
    if (Looper.myLooper() == r().getLooper())
    {
      paramd.run();
      return;
    }
    this.k.set(true);
    r().post(paramd);
  }
  
  private b b(a parama)
  {
    if ((parama != this.c) && (parama != this.e) && (parama != this.f))
    {
      if (parama == this.d) {
        return b.c;
      }
      if (parama == this.b) {
        return b.a;
      }
      return b.a;
    }
    return b.b;
  }
  
  private void b(f paramf)
  {
    this.k.set(false);
    this.l.set(paramf);
    this.m.set(null);
    super.a(paramf);
  }
  
  private b c(boolean paramBoolean)
  {
    if (this.j.get())
    {
      o.e(this.g, "getRunningStateExportImpl, mStopped=true, return DESTROYED");
      return b.d;
    }
    Object localObject = (com.tencent.luggage.wxa.ra.b)this.l.get();
    if (localObject != null) {
      return b((a)localObject);
    }
    localObject = (com.tencent.luggage.wxa.ra.b)this.m.get();
    if (localObject != null) {
      return b((a)localObject);
    }
    if (!paramBoolean) {
      return b(this.p);
    }
    if (Thread.currentThread().getId() != r().getLooper().getThread().getId())
    {
      localObject = new d.4(this);
      o.e(this.g, "getRunningStateExportImpl, await");
      localObject = (a)((i)localObject).a(new s(r().getLooper()));
    }
    else
    {
      localObject = super.o();
    }
    return b((a)localObject);
  }
  
  private boolean k()
  {
    d.a[] arrayOfa = d.a.values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      d.a locala = arrayOfa[i1];
      if ((!d.a.b(locala)) && (r().hasMessages(d.a.a(locala)))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  @Nullable
  private t l()
  {
    if ((this.h.ae() != null) && (this.h.aw())) {
      return (t)this.h.ae().getJsRuntime().a(t.class);
    }
    return null;
  }
  
  abstract void a();
  
  protected void a(Message paramMessage)
  {
    a(" - unhandledMessage: msg.what=%d, msg.obj=%s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj });
    this.k.set(false);
  }
  
  abstract void a(b paramb);
  
  void a(@NonNull d.a parama)
  {
    a(parama, null);
  }
  
  void a(@NonNull d.a parama, @Nullable Object paramObject)
  {
    if (r() == null)
    {
      o.c(this.g, "executeOrPostMessage with cmd[%s], null handler", new Object[] { parama.name() });
      return;
    }
    this.k.set(true);
    if ((Looper.myLooper() == r().getLooper()) && (n() != null) && (n().what != -2) && (!k()) && (!j()))
    {
      r().dispatchMessage(a(d.a.a(parama), paramObject));
      return;
    }
    super.e(a(d.a.a(parama), paramObject));
  }
  
  public void a(f paramf)
  {
    this.l.set(null);
    this.m.set(paramf);
    Object localObject = n();
    if ((localObject != null) && (((Message)localObject).what == -2))
    {
      this.p = paramf;
      return;
    }
    localObject = this.p;
    this.p = paramf;
    if (localObject != null)
    {
      if (b((a)localObject) == b(paramf)) {
        return;
      }
      a(b(paramf));
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.o.set(paramBoolean);
  }
  
  final boolean b()
  {
    Handler localHandler = r();
    if (localHandler == null) {
      return false;
    }
    return localHandler.hasMessages(-2);
  }
  
  protected boolean b(Message paramMessage)
  {
    return paramMessage.what != d.a.l.a();
  }
  
  public void c()
  {
    if (this.j.get()) {
      return;
    }
    this.i.set(true);
    if (Looper.myLooper() == r().getLooper())
    {
      super.c();
      return;
    }
    r().post(new d.2(this));
  }
  
  void d()
  {
    LinkedList localLinkedList = new LinkedList(this.n);
    this.n.clear();
    while (!localLinkedList.isEmpty()) {
      ((i)localLinkedList.poll()).c();
    }
  }
  
  b e()
  {
    Object localObject2 = r();
    if (localObject2 == null)
    {
      o.e(this.g, "getRunningStateExport, NULL handler, return DESTROYED");
      return b.d;
    }
    if (((Handler)localObject2).hasMessages(-1))
    {
      o.e(this.g, "getRunningStateExport, has SM_QUIT_CMD, return DESTROYED");
      return b.d;
    }
    if (this.j.get())
    {
      o.e(this.g, "getRunningStateExport, mStopped=true, return DESTROYED");
      return b.d;
    }
    if (b()) {
      return b.a;
    }
    if ((this.k.get()) && (Looper.myLooper() != ((Handler)localObject2).getLooper()))
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {}
      for (Object localObject1 = "query from main-looper";; localObject1 = "skip flag marked true by outer")
      {
        i1 = 1;
        break label143;
        if (!this.o.get()) {
          break;
        }
      }
      localObject1 = null;
      int i1 = 0;
      label143:
      if (i1 != 0)
      {
        com.tencent.luggage.wxa.ra.b localb = (com.tencent.luggage.wxa.ra.b)this.m.get();
        boolean bool = this.j.get();
        o.d(this.g, "getRunningStateExport, pending change in sm-looper(%d) but %s, cached-state=%s, stopped=%b", new Object[] { Long.valueOf(((Handler)localObject2).getLooper().getThread().getId()), localObject1, localb, Boolean.valueOf(bool) });
        if (localb != null) {
          return b(localb);
        }
        if (bool) {
          return b.d;
        }
        return b.a;
      }
      localObject1 = new d.3(this, 500L, null);
      o.e(this.g, "getRunningStateExport, await");
      this.n.add(localObject1);
      localObject2 = (b)((i)localObject1).a(new s(((Handler)localObject2).getLooper()));
      this.n.remove(localObject1);
      if (localObject2 == null)
      {
        o.e(this.g, "getRunningStateExport, await timeout");
        return c(false);
      }
    }
    return c(true);
  }
  
  boolean f()
  {
    int i1 = d.7.a[e().ordinal()];
    if (i1 != 1)
    {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 != 4) {
          return false;
        }
        return ((Boolean)new d.5(this, 1000L, Boolean.FALSE).a(new s(r().getLooper()))).booleanValue();
      }
      return false;
    }
    return true;
  }
  
  void g()
  {
    if (!this.i.get())
    {
      o.a(this.g, new Throwable(), "Illegal internal state, stop() called before start()", new Object[0]);
      return;
    }
    this.j.set(true);
    if (b())
    {
      o.b(this.g, "stop() called, but still isInConstruction");
      s();
    }
    else
    {
      t();
    }
    a(b.d);
  }
  
  boolean h()
  {
    return this.j.get();
  }
  
  protected void i()
  {
    super.i();
    if (r().getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
      r().post(new d.6(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d
 * JD-Core Version:    0.7.0.1
 */