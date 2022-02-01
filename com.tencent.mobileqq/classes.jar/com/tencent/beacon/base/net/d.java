package com.tencent.beacon.base.net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.base.net.a.i;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.net.adapter.g;
import com.tencent.beacon.base.net.c.e.a;
import java.io.Closeable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class d
  implements e.a, f, Closeable
{
  private static volatile d a;
  private final List<com.tencent.beacon.base.net.adapter.a> b = new LinkedList();
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final AtomicInteger d = new AtomicInteger();
  public com.tencent.beacon.base.net.b.a e;
  public com.tencent.beacon.base.net.b.b f;
  private com.tencent.beacon.base.net.adapter.a g;
  private Context h;
  private com.tencent.beacon.base.net.adapter.a i;
  private com.tencent.beacon.base.net.adapter.a j;
  
  public static d c()
  {
    try
    {
      if (a == null) {
        a = new d();
      }
      d locald = a;
      return locald;
    }
    finally {}
  }
  
  private void f()
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", new Object[] { Integer.valueOf(this.d.decrementAndGet()) });
  }
  
  private void g()
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", new Object[] { Integer.valueOf(this.d.incrementAndGet()) });
  }
  
  public com.tencent.beacon.base.net.a.d a(com.tencent.beacon.base.net.a.f paramf)
  {
    return new com.tencent.beacon.base.net.a.d(paramf);
  }
  
  public i a(k paramk)
  {
    return new i(paramk);
  }
  
  @NonNull
  public com.tencent.beacon.base.net.adapter.a a(@Nullable com.tencent.beacon.base.net.adapter.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("skip adapter: ");
    String str;
    if (parama == null) {
      str = "";
    } else {
      str = parama.getClass().getSimpleName();
    }
    localStringBuilder.append(str);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
    int m = this.b.indexOf(parama) + 1;
    int k = m;
    if (m >= this.b.size()) {
      k = 0;
    }
    return (com.tencent.beacon.base.net.adapter.a)this.b.get(k);
  }
  
  public void a()
  {
    this.c.set(false);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new Object[0]);
  }
  
  public void a(Context paramContext, com.tencent.beacon.base.net.adapter.a parama)
  {
    this.h = paramContext;
    Object localObject = parama;
    if (parama == null) {
      localObject = new com.tencent.beacon.base.net.adapter.c();
    }
    this.i = g.a();
    this.j = ((com.tencent.beacon.base.net.adapter.a)localObject);
    this.b.add(this.i);
    this.b.add(localObject);
    this.e = com.tencent.beacon.base.net.b.a.a();
    this.f = com.tencent.beacon.base.net.b.b.a();
    com.tencent.beacon.base.net.c.e.a(paramContext, this);
  }
  
  public void a(com.tencent.beacon.base.net.a.f paramf, com.tencent.beacon.base.net.a.b<a> paramb)
  {
    if (this.c.get())
    {
      paramb.a(new e(paramf.h(), null, 0, "BeaconNet close."));
      return;
    }
    g();
    this.j.request(paramf, new c(this, paramf, paramb));
  }
  
  public void a(k paramk, com.tencent.beacon.base.net.a.b<byte[]> paramb)
  {
    boolean bool2 = this.c.get();
    boolean bool1 = false;
    if (bool2)
    {
      paramb.a(new e(paramk.g().name(), null, 0, "BeaconNet close."));
      return;
    }
    com.tencent.beacon.base.net.adapter.a locala = a(this.g);
    if (locala == this.i) {
      bool1 = true;
    }
    g();
    if (paramk.g() == RequestType.EVENT) {
      locala = this.i;
    }
    locala.request(paramk, new b(this, paramk, bool1, paramb));
  }
  
  public void a(@NonNull e parame)
  {
    if (!parame.a.equals("atta"))
    {
      if (TextUtils.isEmpty(parame.b)) {
        return;
      }
      com.tencent.beacon.a.b.d.b().a(parame.b, parame.toString(), parame.e);
    }
  }
  
  public void b()
  {
    this.c.set(true);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
  }
  
  public void b(com.tencent.beacon.base.net.adapter.a parama)
  {
    this.g = parama;
  }
  
  public void close()
  {
    this.c.set(true);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
  }
  
  public boolean d()
  {
    return this.d.get() >= 5;
  }
  
  public void e()
  {
    this.c.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.d
 * JD-Core Version:    0.7.0.1
 */