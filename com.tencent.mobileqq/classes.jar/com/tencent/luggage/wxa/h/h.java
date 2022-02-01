package com.tencent.luggage.wxa.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.al.g;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.z.h.b;
import com.tencent.luggage.wxa.z.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  implements f
{
  private final s[] a;
  private final g b;
  private final com.tencent.luggage.wxa.al.f c;
  private final Handler d;
  private final i e;
  private final CopyOnWriteArraySet<r.a> f;
  private final x.b g;
  private final x.a h;
  private boolean i;
  private boolean j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private x p;
  private Object q;
  private o r;
  private com.tencent.luggage.wxa.al.f s;
  private q t;
  private i.b u;
  private int v;
  private int w;
  private long x;
  
  @SuppressLint({"HandlerLeak"})
  public h(s[] paramArrayOfs, g paramg, n paramn)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init ");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" [");
    ((StringBuilder)localObject).append("ExoPlayerLib/2.5.4");
    ((StringBuilder)localObject).append("] [");
    ((StringBuilder)localObject).append(com.tencent.luggage.wxa.ao.x.e);
    ((StringBuilder)localObject).append("]");
    Log.i("ExoPlayerImpl", ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramArrayOfs.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    this.a = ((s[])a.a(paramArrayOfs));
    this.b = ((g)a.a(paramg));
    this.j = false;
    this.k = 0;
    this.l = 1;
    this.f = new CopyOnWriteArraySet();
    this.c = new com.tencent.luggage.wxa.al.f(new com.tencent.luggage.wxa.al.e[paramArrayOfs.length]);
    this.p = x.a;
    this.g = new x.b();
    this.h = new x.a();
    this.r = o.a;
    this.s = this.c;
    this.t = q.a;
    if (Looper.myLooper() != null) {
      localObject = Looper.myLooper();
    } else {
      localObject = Looper.getMainLooper();
    }
    this.d = new h.1(this, (Looper)localObject);
    this.u = new i.b(0, 0L);
    this.e = new i(paramArrayOfs, paramg, paramn, this.j, this.k, this.d, this.u, this);
  }
  
  private long b(long paramLong)
  {
    long l1 = b.a(paramLong);
    paramLong = l1;
    if (!this.u.a.a())
    {
      this.p.a(this.u.a.b, this.h);
      paramLong = l1 + this.h.b();
    }
    return paramLong;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && ((this.p.a()) || (paramInt < this.p.b())))
    {
      this.m += 1;
      this.v = paramInt;
      if (this.p.a())
      {
        this.w = 0;
      }
      else
      {
        this.p.a(paramInt, this.g);
        if (paramLong == -9223372036854775807L) {
          l1 = this.g.a();
        } else {
          l1 = b.b(paramLong);
        }
        int i1 = this.g.f;
        long l2 = this.g.c() + l1;
        for (long l1 = this.p.a(i1, this.h).a(); (l1 != -9223372036854775807L) && (l2 >= l1) && (i1 < this.g.g); l1 = ((x)localObject).a(i1, this.h).a())
        {
          l2 -= l1;
          localObject = this.p;
          i1 += 1;
        }
        this.w = i1;
      }
      if (paramLong == -9223372036854775807L)
      {
        this.x = 0L;
        this.e.a(this.p, paramInt, -9223372036854775807L);
        return;
      }
      this.x = paramLong;
      this.e.a(this.p, paramInt, b.b(paramLong));
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((r.a)((Iterator)localObject).next()).a();
      }
      return;
    }
    Object localObject = new m(this.p, paramInt, paramLong);
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    a(f(), paramLong);
  }
  
  void a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    boolean bool = true;
    Iterator localIterator;
    switch (i1)
    {
    default: 
      throw new IllegalStateException();
    case 8: 
      paramMessage = (e)paramMessage.obj;
      localIterator = this.f.iterator();
    }
    while (localIterator.hasNext())
    {
      ((r.a)localIterator.next()).a(paramMessage);
      continue;
      paramMessage = (q)paramMessage.obj;
      if (!this.t.equals(paramMessage))
      {
        this.t = paramMessage;
        localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          ((r.a)localIterator.next()).a(paramMessage);
          continue;
          paramMessage = (i.d)paramMessage.obj;
          this.m -= paramMessage.d;
          if (this.n == 0)
          {
            this.p = paramMessage.a;
            this.q = paramMessage.b;
            this.u = paramMessage.c;
            if ((this.m == 0) && (this.p.a()))
            {
              this.w = 0;
              this.v = 0;
              this.x = 0L;
            }
            paramMessage = this.f.iterator();
            while (paramMessage.hasNext())
            {
              ((r.a)paramMessage.next()).a(this.p, this.q);
              continue;
              if (this.m == 0)
              {
                this.u = ((i.b)paramMessage.obj);
                paramMessage = this.f.iterator();
                while (paramMessage.hasNext())
                {
                  ((r.a)paramMessage.next()).a();
                  continue;
                  i1 = this.m - 1;
                  this.m = i1;
                  if (i1 == 0)
                  {
                    this.u = ((i.b)paramMessage.obj);
                    if (this.p.a())
                    {
                      this.w = 0;
                      this.v = 0;
                      this.x = 0L;
                    }
                    if (paramMessage.arg1 != 0)
                    {
                      paramMessage = this.f.iterator();
                      while (paramMessage.hasNext())
                      {
                        ((r.a)paramMessage.next()).a();
                        continue;
                        if (this.n == 0)
                        {
                          paramMessage = (com.tencent.luggage.wxa.al.h)paramMessage.obj;
                          this.i = true;
                          this.r = paramMessage.a;
                          this.s = paramMessage.b;
                          this.b.a(paramMessage.c);
                          paramMessage = this.f.iterator();
                          while (paramMessage.hasNext())
                          {
                            ((r.a)paramMessage.next()).a(this.r, this.s);
                            continue;
                            if (paramMessage.arg1 == 0) {
                              bool = false;
                            }
                            this.o = bool;
                            paramMessage = this.f.iterator();
                            while (paramMessage.hasNext())
                            {
                              ((r.a)paramMessage.next()).a(this.o);
                              continue;
                              this.l = paramMessage.arg1;
                              paramMessage = this.f.iterator();
                              while (paramMessage.hasNext())
                              {
                                ((r.a)paramMessage.next()).a(this.j, this.l);
                                continue;
                                this.n -= 1;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(@Nullable q paramq)
  {
    q localq = paramq;
    if (paramq == null) {
      localq = q.a;
    }
    this.e.a(localq);
  }
  
  public void a(r.a parama)
  {
    this.f.add(parama);
  }
  
  public void a(com.tencent.luggage.wxa.z.h paramh)
  {
    a(paramh, true, true);
  }
  
  public void a(com.tencent.luggage.wxa.z.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      Iterator localIterator;
      if ((!this.p.a()) || (this.q != null))
      {
        this.p = x.a;
        this.q = null;
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((r.a)localIterator.next()).a(this.p, this.q);
        }
      }
      if (this.i)
      {
        this.i = false;
        this.r = o.a;
        this.s = this.c;
        this.b.a(null);
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((r.a)localIterator.next()).a(this.r, this.s);
        }
      }
    }
    this.n += 1;
    this.e.a(paramh, paramBoolean1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      this.e.a(paramBoolean);
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((r.a)localIterator.next()).a(paramBoolean, this.l);
      }
    }
  }
  
  public void a(f.c... paramVarArgs)
  {
    this.e.a(paramVarArgs);
  }
  
  public void b(r.a parama)
  {
    this.f.remove(parama);
  }
  
  public void b(f.c... paramVarArgs)
  {
    this.e.b(paramVarArgs);
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public void d()
  {
    this.e.a();
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Release ");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" [");
    localStringBuilder.append("ExoPlayerLib/2.5.4");
    localStringBuilder.append("] [");
    localStringBuilder.append(com.tencent.luggage.wxa.ao.x.e);
    localStringBuilder.append("] [");
    localStringBuilder.append(j.a());
    localStringBuilder.append("]");
    Log.i("ExoPlayerImpl", localStringBuilder.toString());
    this.e.b();
    this.d.removeCallbacksAndMessages(null);
  }
  
  public int f()
  {
    if ((!this.p.a()) && (this.m <= 0)) {
      return this.p.a(this.u.a.b, this.h).c;
    }
    return this.v;
  }
  
  public long g()
  {
    if (this.p.a()) {
      return -9223372036854775807L;
    }
    if (k())
    {
      h.b localb = this.u.a;
      this.p.a(localb.b, this.h);
      return b.a(this.h.b(localb.c, localb.d));
    }
    return this.p.a(f(), this.g).b();
  }
  
  public long h()
  {
    if ((!this.p.a()) && (this.m <= 0)) {
      return b(this.u.d);
    }
    return this.x;
  }
  
  public long i()
  {
    if ((!this.p.a()) && (this.m <= 0)) {
      return b(this.u.e);
    }
    return this.x;
  }
  
  public int j()
  {
    boolean bool = this.p.a();
    int i1 = 0;
    if (bool) {
      return 0;
    }
    long l1 = i();
    long l2 = g();
    if (l1 != -9223372036854775807L)
    {
      if (l2 == -9223372036854775807L) {
        return 0;
      }
      if (l2 == 0L) {
        return 100;
      }
      i1 = com.tencent.luggage.wxa.ao.x.a((int)(l1 * 100L / l2), 0, 100);
    }
    return i1;
  }
  
  public boolean k()
  {
    return (!this.p.a()) && (this.m == 0) && (this.u.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.h
 * JD-Core Version:    0.7.0.1
 */