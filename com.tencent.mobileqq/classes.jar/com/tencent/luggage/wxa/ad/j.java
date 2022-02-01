package com.tencent.luggage.wxa.ad;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.l;
import java.util.Collections;
import java.util.List;

public final class j
  extends com.tencent.luggage.wxa.h.a
  implements Handler.Callback
{
  private final Handler a;
  private final j.a b;
  private final g c;
  private final l d;
  private boolean e;
  private boolean f;
  private int g;
  private k h;
  private e i;
  private h j;
  private i k;
  private i l;
  private int m;
  
  public j(j.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, g.a);
  }
  
  public j(j.a parama, Looper paramLooper, g paramg)
  {
    super(3);
    this.b = ((j.a)com.tencent.luggage.wxa.ao.a.a(parama));
    if (paramLooper == null) {
      parama = null;
    } else {
      parama = new Handler(paramLooper, this);
    }
    this.a = parama;
    this.c = paramg;
    this.d = new l();
  }
  
  private void a(List<a> paramList)
  {
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.obtainMessage(0, paramList).sendToTarget();
      return;
    }
    b(paramList);
  }
  
  private void b(List<a> paramList)
  {
    this.b.a(paramList);
  }
  
  private void v()
  {
    this.j = null;
    this.m = -1;
    i locali = this.k;
    if (locali != null)
    {
      locali.e();
      this.k = null;
    }
    locali = this.l;
    if (locali != null)
    {
      locali.e();
      this.l = null;
    }
  }
  
  private void w()
  {
    v();
    this.i.d();
    this.i = null;
    this.g = 0;
  }
  
  private void x()
  {
    w();
    this.i = this.c.b(this.h);
  }
  
  private long y()
  {
    int n = this.m;
    if ((n != -1) && (n < this.k.b())) {
      return this.k.a(this.m);
    }
    return 9223372036854775807L;
  }
  
  private void z()
  {
    a(Collections.emptyList());
  }
  
  public int a(k paramk)
  {
    if (this.c.a(paramk)) {
      return 4;
    }
    if (com.tencent.luggage.wxa.ao.j.c(paramk.f)) {
      return 1;
    }
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.f) {
      return;
    }
    if (this.l == null)
    {
      this.i.a(paramLong1);
      try
      {
        this.l = ((i)this.i.b());
      }
      catch (f localf1)
      {
        throw com.tencent.luggage.wxa.h.e.a(localf1, r());
      }
    }
    if (d() != 2) {
      return;
    }
    if (this.k != null)
    {
      paramLong2 = y();
      for (n = 0; paramLong2 <= paramLong1; n = 1)
      {
        this.m += 1;
        paramLong2 = y();
      }
    }
    int n = 0;
    i locali = this.l;
    int i1 = n;
    if (locali != null) {
      if (locali.c())
      {
        i1 = n;
        if (n == 0)
        {
          i1 = n;
          if (y() == 9223372036854775807L) {
            if (this.g == 2)
            {
              x();
              i1 = n;
            }
            else
            {
              v();
              this.f = true;
              i1 = n;
            }
          }
        }
      }
      else
      {
        i1 = n;
        if (this.l.a <= paramLong1)
        {
          locali = this.k;
          if (locali != null) {
            locali.e();
          }
          this.k = this.l;
          this.l = null;
          this.m = this.k.a(paramLong1);
          i1 = 1;
        }
      }
    }
    if (i1 != 0) {
      a(this.k.b(paramLong1));
    }
    if (this.g == 2) {
      return;
    }
    label448:
    com.tencent.luggage.wxa.h.e locale;
    try
    {
      do
      {
        for (;;)
        {
          if (this.e) {
            break label448;
          }
          if (this.j == null)
          {
            this.j = ((h)this.i.a());
            if (this.j == null) {
              return;
            }
          }
          if (this.g == 1)
          {
            this.j.a_(4);
            this.i.a(this.j);
            this.j = null;
            this.g = 2;
            return;
          }
          n = a(this.d, this.j, false);
          if (n != -4) {
            break;
          }
          if (this.j.c())
          {
            this.e = true;
          }
          else
          {
            this.j.d = this.d.a.w;
            this.j.h();
          }
          this.i.a(this.j);
          this.j = null;
        }
      } while (n != -3);
      return;
    }
    catch (f localf2)
    {
      locale = com.tencent.luggage.wxa.h.e.a(localf2, r());
    }
    for (;;)
    {
      throw locale;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    z();
    this.e = false;
    this.f = false;
    if (this.g != 0)
    {
      x();
      return;
    }
    v();
    this.i.c();
  }
  
  protected void a(k[] paramArrayOfk, long paramLong)
  {
    this.h = paramArrayOfk[0];
    if (this.i != null)
    {
      this.g = 1;
      return;
    }
    this.i = this.c.b(this.h);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      b((List)paramMessage.obj);
      return true;
    }
    throw new IllegalStateException();
  }
  
  protected void p()
  {
    this.h = null;
    z();
    w();
  }
  
  public boolean t()
  {
    return true;
  }
  
  public boolean u()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ad.j
 * JD-Core Version:    0.7.0.1
 */