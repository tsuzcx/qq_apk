package com.tencent.luggage.wxa.z;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.am.b;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.h.x.a;

public final class f
  implements e.c, h
{
  private final Uri a;
  private final g.a b;
  private final com.tencent.luggage.wxa.l.g c;
  private final int d;
  private final Handler e;
  private final f.a f;
  private final x.a g;
  private final String h;
  private final int i;
  private h.a j;
  private long k;
  private boolean l;
  
  public f(Uri paramUri, g.a parama, com.tencent.luggage.wxa.l.g paramg, int paramInt1, Handler paramHandler, f.a parama1, String paramString, int paramInt2)
  {
    this.a = paramUri;
    this.b = parama;
    this.c = paramg;
    this.d = paramInt1;
    this.e = paramHandler;
    this.f = parama1;
    this.h = paramString;
    this.i = paramInt2;
    this.g = new x.a();
  }
  
  public f(Uri paramUri, g.a parama, com.tencent.luggage.wxa.l.g paramg, Handler paramHandler, f.a parama1)
  {
    this(paramUri, parama, paramg, paramHandler, parama1, null);
  }
  
  public f(Uri paramUri, g.a parama, com.tencent.luggage.wxa.l.g paramg, Handler paramHandler, f.a parama1, String paramString)
  {
    this(paramUri, parama, paramg, -1, paramHandler, parama1, paramString, 1048576);
  }
  
  private void b(long paramLong, boolean paramBoolean)
  {
    this.k = paramLong;
    this.l = paramBoolean;
    this.j.a(new m(this.k, this.l), null);
  }
  
  public g a(h.b paramb, b paramb1)
  {
    boolean bool;
    if (paramb.b == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    return new e(this.a, this.b.a(), this.c.a(), this.d, this.e, this.f, this, paramb1, this.h, this.i);
  }
  
  public void a() {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = this.k;
    }
    if (((this.k == l1) && (this.l == paramBoolean)) || ((this.k != -9223372036854775807L) && (l1 == -9223372036854775807L))) {
      return;
    }
    b(l1, paramBoolean);
  }
  
  public void a(com.tencent.luggage.wxa.h.f paramf, boolean paramBoolean, h.a parama)
  {
    this.j = parama;
    b(-9223372036854775807L, false);
  }
  
  public void a(g paramg)
  {
    ((e)paramg).f();
  }
  
  public void b()
  {
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.f
 * JD-Core Version:    0.7.0.1
 */