package com.tencent.luggage.wxa.am;

import android.net.Uri;
import com.tencent.luggage.wxa.ao.x;

public final class u<T>
  implements t.c
{
  public final j a;
  public final int b;
  private final g c;
  private final u.a<? extends T> d;
  private volatile T e;
  private volatile boolean f;
  private volatile long g;
  
  public u(g paramg, Uri paramUri, int paramInt, u.a<? extends T> parama)
  {
    this.c = paramg;
    this.a = new j(paramUri, 1);
    this.b = paramInt;
    this.d = parama;
  }
  
  public final void a()
  {
    this.f = true;
  }
  
  public final boolean b()
  {
    return this.f;
  }
  
  public final void c()
  {
    i locali = new i(this.c, this.a);
    try
    {
      locali.b();
      this.e = this.d.b(this.c.b(), locali);
      return;
    }
    finally
    {
      this.g = locali.a();
      x.a(locali);
    }
  }
  
  public final T d()
  {
    return this.e;
  }
  
  public long e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.u
 * JD-Core Version:    0.7.0.1
 */