package com.tencent.luggage.wxa.ab;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.ac.b.a;
import com.tencent.luggage.wxa.ac.c;
import com.tencent.luggage.wxa.ac.e.e;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.am.u.a;
import com.tencent.luggage.wxa.h.f;
import com.tencent.luggage.wxa.h.j;
import com.tencent.luggage.wxa.h.x;
import com.tencent.luggage.wxa.z.a.a;
import com.tencent.luggage.wxa.z.h.a;
import com.tencent.luggage.wxa.z.h.b;
import com.tencent.luggage.wxa.z.m;
import java.util.List;

public final class h
  implements e.e, com.tencent.luggage.wxa.z.h
{
  private final Uri a;
  private final d b;
  private final int c;
  private final a.a d;
  private final u.a<c> e;
  private com.tencent.luggage.wxa.ac.e f;
  private h.a g;
  
  static
  {
    j.a("goog.exo.hls");
  }
  
  public h(Uri paramUri, d paramd, int paramInt, Handler paramHandler, com.tencent.luggage.wxa.z.a parama)
  {
    this(paramUri, paramd, paramInt, paramHandler, parama, new com.tencent.luggage.wxa.ac.d());
  }
  
  public h(Uri paramUri, d paramd, int paramInt, Handler paramHandler, com.tencent.luggage.wxa.z.a parama, u.a<c> parama1)
  {
    this.a = paramUri;
    this.b = paramd;
    this.c = paramInt;
    this.e = parama1;
    this.d = new a.a(paramHandler, parama);
  }
  
  public h(Uri paramUri, g.a parama, int paramInt, Handler paramHandler, com.tencent.luggage.wxa.z.a parama1)
  {
    this(paramUri, new b(parama), paramInt, paramHandler, parama1);
  }
  
  public h(Uri paramUri, g.a parama, Handler paramHandler, com.tencent.luggage.wxa.z.a parama1)
  {
    this(paramUri, parama, 3, paramHandler, parama1);
  }
  
  public com.tencent.luggage.wxa.z.g a(h.b paramb, com.tencent.luggage.wxa.am.b paramb1)
  {
    boolean bool;
    if (paramb.b == 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    return new g(this.f, this.b, this.c, this.d, paramb1);
  }
  
  public void a()
  {
    this.f.d();
  }
  
  public void a(com.tencent.luggage.wxa.ac.b paramb)
  {
    long l2;
    if (paramb.k) {
      l2 = 0L;
    } else {
      l2 = -9223372036854775807L;
    }
    long l3;
    if (paramb.k) {
      l3 = com.tencent.luggage.wxa.h.b.a(paramb.c);
    } else {
      l3 = -9223372036854775807L;
    }
    long l1 = paramb.b;
    Object localObject;
    if (this.f.e())
    {
      long l4;
      if (paramb.j)
      {
        l4 = paramb.c;
        l4 = paramb.n + l4;
      }
      else
      {
        l4 = -9223372036854775807L;
      }
      localObject = paramb.m;
      if (l1 == -9223372036854775807L) {
        if (((List)localObject).isEmpty()) {
          l1 = 0L;
        } else {
          l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).d;
        }
      }
      localObject = new m(l2, l3, l4, paramb.n, paramb.c, l1, true, paramb.j ^ true);
    }
    else
    {
      if (l1 == -9223372036854775807L) {
        l1 = 0L;
      }
      localObject = new m(l2, l3, paramb.c + paramb.n, paramb.n, paramb.c, l1, true, false);
    }
    this.g.a((x)localObject, new e(this.f.b(), paramb));
  }
  
  public void a(f paramf, boolean paramBoolean, h.a parama)
  {
    if (this.f == null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    com.tencent.luggage.wxa.ao.a.b(paramBoolean);
    this.f = new com.tencent.luggage.wxa.ac.e(this.a, this.b, this.d, this.c, this, this.e);
    this.g = parama;
    this.f.a();
  }
  
  public void a(com.tencent.luggage.wxa.z.g paramg)
  {
    ((g)paramg).f();
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.ac.e locale = this.f;
    if (locale != null)
    {
      locale.c();
      this.f = null;
    }
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.h
 * JD-Core Version:    0.7.0.1
 */