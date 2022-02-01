package com.tencent.luggage.wxa.ab;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ac.a.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.r.c;
import com.tencent.luggage.wxa.x.i;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f
  extends com.tencent.luggage.wxa.aa.d
{
  private static final AtomicInteger m = new AtomicInteger();
  private com.tencent.luggage.wxa.l.d A;
  private int B;
  private int C;
  private boolean D;
  private j E;
  private volatile boolean F;
  private volatile boolean G;
  public final int j;
  public final int k;
  public final a.a l;
  private final com.tencent.luggage.wxa.am.g n;
  private final com.tencent.luggage.wxa.am.j o;
  private final boolean p;
  private final boolean q;
  private final com.tencent.luggage.wxa.ao.u r;
  private final String s;
  private final com.tencent.luggage.wxa.l.d t;
  private final boolean u;
  private final boolean v;
  private final List<k> w;
  private final boolean x;
  private final com.tencent.luggage.wxa.x.g y;
  private final m z;
  
  public f(com.tencent.luggage.wxa.am.g paramg, com.tencent.luggage.wxa.am.j paramj1, com.tencent.luggage.wxa.am.j paramj2, a.a parama, List<k> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, boolean paramBoolean, com.tencent.luggage.wxa.ao.u paramu, f paramf, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(a(paramg, paramArrayOfByte1, paramArrayOfByte2), paramj1, parama.b, paramInt1, paramObject, paramLong1, paramLong2, paramInt2);
    this.k = paramInt3;
    this.o = paramj2;
    this.l = parama;
    this.w = paramList;
    this.q = paramBoolean;
    this.r = paramu;
    this.p = (this.h instanceof a);
    this.s = paramj1.a.getLastPathSegment();
    paramBoolean = this.s.endsWith(".aac");
    boolean bool = false;
    if ((!paramBoolean) && (!this.s.endsWith(".ac3")) && (!this.s.endsWith(".ec3")) && (!this.s.endsWith(".mp3"))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    this.x = paramBoolean;
    if (paramf != null)
    {
      this.y = paramf.y;
      this.z = paramf.z;
      this.t = paramf.A;
      if (paramf.l != parama) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      this.u = paramBoolean;
      if (paramf.k == paramInt3)
      {
        paramBoolean = bool;
        if (!this.u) {}
      }
      else
      {
        paramBoolean = true;
      }
      this.v = paramBoolean;
    }
    else
    {
      if (this.x) {
        paramj1 = new com.tencent.luggage.wxa.x.g();
      } else {
        paramj1 = null;
      }
      this.y = paramj1;
      if (this.x) {
        paramj1 = new m(10);
      } else {
        paramj1 = null;
      }
      this.z = paramj1;
      this.t = null;
      this.u = false;
      this.v = true;
    }
    this.n = paramg;
    this.j = m.getAndIncrement();
  }
  
  private long a(com.tencent.luggage.wxa.l.e parame)
  {
    parame.a();
    if (!parame.b(this.z.a, 0, 10, true)) {
      return -9223372036854775807L;
    }
    this.z.a(10);
    if (this.z.k() != com.tencent.luggage.wxa.x.g.a) {
      return -9223372036854775807L;
    }
    this.z.d(3);
    int i = this.z.s();
    int i1 = i + 10;
    Object localObject;
    if (i1 > this.z.e())
    {
      localObject = this.z.a;
      this.z.a(i1);
      System.arraycopy(localObject, 0, this.z.a, 0, 10);
    }
    if (!parame.b(this.z.a, 10, i, true)) {
      return -9223372036854775807L;
    }
    parame = this.y.a(this.z.a, i);
    if (parame == null) {
      return -9223372036854775807L;
    }
    i1 = parame.a();
    i = 0;
    while (i < i1)
    {
      localObject = parame.a(i);
      if ((localObject instanceof i))
      {
        localObject = (i)localObject;
        if ("com.apple.streaming.transportStreamTimestamp".equals(((i)localObject).a))
        {
          System.arraycopy(((i)localObject).b, 0, this.z.a, 0, 8);
          this.z.a(8);
          return this.z.p();
        }
      }
      i += 1;
    }
    return -9223372036854775807L;
  }
  
  private static com.tencent.luggage.wxa.am.g a(com.tencent.luggage.wxa.am.g paramg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return paramg;
      }
      return new a(paramg, paramArrayOfByte1, paramArrayOfByte2);
    }
    return paramg;
  }
  
  private com.tencent.luggage.wxa.l.d a(long paramLong)
  {
    Object localObject;
    if (this.s.endsWith(".aac")) {
      localObject = new c(paramLong);
    } else if ((!this.s.endsWith(".ac3")) && (!this.s.endsWith(".ec3")))
    {
      if (this.s.endsWith(".mp3"))
      {
        localObject = new com.tencent.luggage.wxa.o.b(0, paramLong);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown extension for audio file: ");
        ((StringBuilder)localObject).append(this.s);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    else {
      localObject = new com.tencent.luggage.wxa.r.a(paramLong);
    }
    ((com.tencent.luggage.wxa.l.d)localObject).a(this.E);
    return localObject;
  }
  
  private void g()
  {
    if ((this.t != this.A) && (!this.D))
    {
      Object localObject1 = this.o;
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((com.tencent.luggage.wxa.am.j)localObject1).a(this.B);
      try
      {
        localObject1 = new com.tencent.luggage.wxa.l.b(this.n, ((com.tencent.luggage.wxa.am.j)localObject1).c, this.n.a((com.tencent.luggage.wxa.am.j)localObject1));
        int i = 0;
        for (;;)
        {
          if (i == 0) {}
          try
          {
            if (!this.F) {
              i = this.A.a((com.tencent.luggage.wxa.l.e)localObject1, null);
            }
          }
          finally
          {
            this.B = ((int)(((com.tencent.luggage.wxa.l.e)localObject1).c() - this.o.c));
          }
        }
        x.a(this.h);
        this.D = true;
        return;
      }
      finally
      {
        x.a(this.h);
      }
    }
  }
  
  private void h()
  {
    boolean bool = this.p;
    int i2 = 0;
    Object localObject1;
    if (bool)
    {
      com.tencent.luggage.wxa.am.j localj = this.a;
      localObject1 = localj;
      if (this.C != 0)
      {
        i = 1;
        localObject1 = localj;
        break label55;
      }
    }
    else
    {
      localObject1 = this.a.a(this.C);
    }
    int i = 0;
    label55:
    if (!this.q) {
      this.r.e();
    } else if (this.r.a() == 9223372036854775807L) {
      this.r.a(this.f);
    }
    try
    {
      localObject1 = new com.tencent.luggage.wxa.l.b(this.h, ((com.tencent.luggage.wxa.am.j)localObject1).c, this.h.a((com.tencent.luggage.wxa.am.j)localObject1));
      if (this.A == null)
      {
        long l1 = a((com.tencent.luggage.wxa.l.e)localObject1);
        if (l1 != -9223372036854775807L) {
          l1 = this.r.b(l1);
        } else {
          l1 = this.f;
        }
        this.A = a(l1);
      }
      int i1 = i2;
      if (i != 0)
      {
        ((com.tencent.luggage.wxa.l.e)localObject1).b(this.C);
        i1 = i2;
      }
      for (;;)
      {
        if (i1 == 0) {}
        try
        {
          if (!this.F) {
            i1 = this.A.a((com.tencent.luggage.wxa.l.e)localObject1, null);
          }
        }
        finally
        {
          this.C = ((int)(((com.tencent.luggage.wxa.l.e)localObject1).c() - this.a.c));
        }
      }
      x.a(this.h);
      this.G = true;
      return;
    }
    finally
    {
      x.a(this.h);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private com.tencent.luggage.wxa.l.d i()
  {
    boolean bool = "text/vtt".equals(this.l.b.f);
    int i3 = 1;
    Object localObject;
    int i;
    if ((!bool) && (!this.s.endsWith(".webvtt")) && (!this.s.endsWith(".vtt")))
    {
      if (!this.v)
      {
        localObject = this.t;
        i = 0;
      }
      else
      {
        if (!this.s.endsWith(".mp4"))
        {
          localObject = this.s;
          if (!((String)localObject).startsWith(".m4", ((String)localObject).length() - 4))
          {
            i = 16;
            localObject = this.w;
            if (localObject != null) {
              i = 48;
            } else {
              localObject = Collections.emptyList();
            }
            String str = this.c.c;
            int i2 = i;
            if (!TextUtils.isEmpty(str))
            {
              int i1 = i;
              if (!"audio/mp4a-latm".equals(com.tencent.luggage.wxa.ao.j.e(str))) {
                i1 = i | 0x2;
              }
              i2 = i1;
              if (!"video/avc".equals(com.tencent.luggage.wxa.ao.j.d(str))) {
                i2 = i1 | 0x4;
              }
            }
            localObject = new com.tencent.luggage.wxa.r.u(2, this.r, new com.tencent.luggage.wxa.r.e(i2, (List)localObject));
            i = i3;
            break label270;
          }
        }
        localObject = new com.tencent.luggage.wxa.p.e(0, this.r);
        i = i3;
      }
    }
    else
    {
      localObject = new l(this.c.y, this.r);
      i = i3;
    }
    label270:
    if (i != 0) {
      ((com.tencent.luggage.wxa.l.d)localObject).a(this.E);
    }
    return localObject;
  }
  
  public void a()
  {
    this.F = true;
  }
  
  public void a(j paramj)
  {
    this.E = paramj;
    paramj.a(this.j, this.u);
  }
  
  public boolean b()
  {
    return this.F;
  }
  
  public void c()
  {
    if ((this.A == null) && (!this.x)) {
      this.A = i();
    }
    g();
    if (!this.F) {
      h();
    }
  }
  
  public long d()
  {
    return this.C;
  }
  
  public boolean f()
  {
    return this.G;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.f
 * JD-Core Version:    0.7.0.1
 */