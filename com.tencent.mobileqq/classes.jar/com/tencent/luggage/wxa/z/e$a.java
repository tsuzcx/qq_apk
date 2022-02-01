package com.tencent.luggage.wxa.z;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.t.c;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.f;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.b;
import com.tencent.luggage.wxa.l.d;

final class e$a
  implements t.c
{
  private final Uri b;
  private final g c;
  private final e.b d;
  private final f e;
  private final com.tencent.luggage.wxa.l.j f;
  private volatile boolean g;
  private boolean h;
  private long i;
  private long j;
  
  public e$a(e parame, Uri paramUri, g paramg, e.b paramb, f paramf)
  {
    this.b = ((Uri)a.a(paramUri));
    this.c = ((g)a.a(paramg));
    this.d = ((e.b)a.a(paramb));
    this.e = paramf;
    this.f = new com.tencent.luggage.wxa.l.j();
    this.h = true;
    this.j = -1L;
  }
  
  public void a()
  {
    this.g = true;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.f.a = paramLong1;
    this.i = paramLong2;
    this.h = true;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    int k = 0;
    b localb;
    for (;;)
    {
      if ((k != 0) || (this.g)) {
        return;
      }
      try
      {
        long l2 = this.f.a;
        this.j = this.c.a(new com.tencent.luggage.wxa.am.j(this.b, l2, -1L, e.e(this.a)));
        if (this.j != -1L) {
          this.j += l2;
        }
        localb = new b(this.c, l2, this.j);
        int n = k;
        try
        {
          d locald = this.d.a(localb, this.c.b());
          int m = k;
          long l1 = l2;
          n = k;
          if (this.h)
          {
            n = k;
            locald.a(l2, this.i);
            n = k;
            this.h = false;
            l1 = l2;
            m = k;
          }
          while (m == 0)
          {
            n = m;
            if (this.g) {
              break;
            }
            n = m;
            this.e.c();
            n = m;
            k = locald.a(localb, this.f);
            m = k;
            n = k;
            if (localb.c() > e.f(this.a) + l1)
            {
              n = k;
              l1 = localb.c();
              n = k;
              this.e.b();
              n = k;
              e.h(this.a).post(e.g(this.a));
              m = k;
            }
          }
          if (m == 1)
          {
            k = 0;
          }
          else
          {
            this.f.a = localb.c();
            k = m;
          }
          x.a(this.c);
          continue;
        }
        finally
        {
          k = n;
        }
        if (k == 1) {
          break label345;
        }
      }
      finally
      {
        localb = null;
      }
    }
    if (localb != null) {
      this.f.a = localb.c();
    }
    label345:
    x.a(this.c);
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.e.a
 * JD-Core Version:    0.7.0.1
 */