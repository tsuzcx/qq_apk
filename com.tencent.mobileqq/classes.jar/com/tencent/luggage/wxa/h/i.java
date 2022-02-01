package com.tencent.luggage.wxa.h;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.ao.v;
import com.tencent.luggage.wxa.z.h.a;
import com.tencent.luggage.wxa.z.h.b;
import java.io.IOException;

final class i
  implements Handler.Callback, com.tencent.luggage.wxa.al.g.a, com.tencent.luggage.wxa.z.g.a, h.a
{
  private long A;
  private int B;
  private i.c C;
  private long D;
  private i.a E;
  private i.a F;
  private i.a G;
  private x H;
  private final s[] a;
  private final t[] b;
  private final com.tencent.luggage.wxa.al.g c;
  private final n d;
  private final com.tencent.luggage.wxa.ao.s e;
  private final Handler f;
  private final HandlerThread g;
  private final Handler h;
  private final f i;
  private final x.b j;
  private final x.a k;
  private final o l;
  private i.b m;
  private q n;
  private s o;
  private com.tencent.luggage.wxa.ao.i p;
  private com.tencent.luggage.wxa.z.h q;
  private s[] r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public i(s[] paramArrayOfs, com.tencent.luggage.wxa.al.g paramg, n paramn, boolean paramBoolean, int paramInt, Handler paramHandler, i.b paramb, f paramf)
  {
    this.a = paramArrayOfs;
    this.c = paramg;
    this.d = paramn;
    this.t = paramBoolean;
    this.x = paramInt;
    this.h = paramHandler;
    this.w = 1;
    this.m = paramb;
    this.i = paramf;
    this.b = new t[paramArrayOfs.length];
    paramInt = 0;
    while (paramInt < paramArrayOfs.length)
    {
      paramArrayOfs[paramInt].a(paramInt);
      this.b[paramInt] = paramArrayOfs[paramInt].b();
      paramInt += 1;
    }
    this.e = new com.tencent.luggage.wxa.ao.s();
    this.r = new s[0];
    this.j = new x.b();
    this.k = new x.a();
    this.l = new o();
    paramg.a(this);
    this.n = q.a;
    this.g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.g.start();
    this.f = new Handler(this.g.getLooper(), this);
  }
  
  private int a(int paramInt, x paramx1, x paramx2)
  {
    int i3 = paramx1.c();
    int i1 = 0;
    int i2 = paramInt;
    paramInt = -1;
    while ((i1 < i3) && (paramInt == -1))
    {
      i2 = paramx1.a(i2, this.k, this.j, this.x);
      if (i2 == -1) {
        return paramInt;
      }
      paramInt = paramx2.a(paramx1.a(i2, this.k, true).b);
      i1 += 1;
    }
    return paramInt;
  }
  
  private long a(h.b paramb, long paramLong)
  {
    d();
    this.u = false;
    a(2);
    i.a locala1 = this.G;
    Object localObject;
    if (locala1 == null)
    {
      paramb = this.E;
      if (paramb != null) {
        paramb.e();
      }
      localObject = null;
    }
    else
    {
      i.a locala2 = null;
      for (;;)
      {
        localObject = locala2;
        if (locala1 == null) {
          break;
        }
        if ((locala2 == null) && (a(paramb, paramLong, locala1))) {
          locala2 = locala1;
        } else {
          locala1.e();
        }
        locala1 = locala1.j;
      }
    }
    paramb = this.G;
    if ((paramb != localObject) || (paramb != this.F))
    {
      paramb = this.r;
      int i2 = paramb.length;
      int i1 = 0;
      while (i1 < i2)
      {
        paramb[i1].l();
        i1 += 1;
      }
      this.r = new s[0];
      this.p = null;
      this.o = null;
      this.G = null;
    }
    if (localObject != null)
    {
      localObject.j = null;
      this.E = localObject;
      this.F = localObject;
      b(localObject);
      long l1 = paramLong;
      if (this.G.i) {
        l1 = this.G.a.b(paramLong);
      }
      a(l1);
      m();
      paramLong = l1;
    }
    else
    {
      this.E = null;
      this.F = null;
      this.G = null;
      a(paramLong);
    }
    this.f.sendEmptyMessage(2);
    return paramLong;
  }
  
  private Pair<Integer, Long> a(int paramInt, long paramLong)
  {
    return this.H.a(this.j, this.k, paramInt, paramLong);
  }
  
  private i.a a(i.a parama, int paramInt)
  {
    for (;;)
    {
      parama.g = this.l.a(parama.g, paramInt);
      if (parama.g.f) {
        break;
      }
      if (parama.j == null) {
        return parama;
      }
      parama = parama.j;
    }
    return parama;
  }
  
  private void a(int paramInt)
  {
    if (this.w != paramInt)
    {
      this.w = paramInt;
      this.h.obtainMessage(1, paramInt, 0).sendToTarget();
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.G;
    if (localObject == null) {
      paramLong += 60000000L;
    } else {
      paramLong = ((i.a)localObject).a(paramLong);
    }
    this.D = paramLong;
    this.e.a(this.D);
    localObject = this.r;
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localObject[i1].a(this.D);
      i1 += 1;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    this.f.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      this.f.sendEmptyMessage(2);
      return;
    }
    this.f.sendEmptyMessageDelayed(2, paramLong1);
  }
  
  private void a(Pair<x, Object> paramPair)
  {
    Object localObject3 = this.H;
    this.H = ((x)paramPair.first);
    this.l.a(this.H);
    Object localObject2 = paramPair.second;
    int i2 = 0;
    long l1 = -9223372036854775807L;
    long l2;
    if (localObject3 == null)
    {
      if (this.B > 0)
      {
        paramPair = b(this.C);
        i1 = this.B;
        this.B = 0;
        this.C = null;
        if (paramPair == null)
        {
          a(localObject2, i1);
          return;
        }
        i2 = ((Integer)paramPair.first).intValue();
        l2 = ((Long)paramPair.second).longValue();
        paramPair = this.l.a(i2, l2);
        if (paramPair.a()) {
          l1 = 0L;
        } else {
          l1 = l2;
        }
        this.m = new i.b(paramPair, l1, l2);
        b(localObject2, i1);
        return;
      }
      if (this.m.b == -9223372036854775807L)
      {
        if (this.H.a())
        {
          a(localObject2);
          return;
        }
        paramPair = a(0, -9223372036854775807L);
        i1 = ((Integer)paramPair.first).intValue();
        l2 = ((Long)paramPair.second).longValue();
        paramPair = this.l.a(i1, l2);
        if (paramPair.a()) {
          l1 = 0L;
        } else {
          l1 = l2;
        }
        this.m = new i.b(paramPair, l1, l2);
        b(localObject2);
        return;
      }
      b(localObject2);
      return;
    }
    int i3 = this.m.a.b;
    paramPair = this.G;
    if (paramPair == null) {
      paramPair = this.E;
    }
    if ((paramPair == null) && (i3 >= ((x)localObject3).c()))
    {
      b(localObject2);
      return;
    }
    Object localObject1;
    if (paramPair == null) {
      localObject1 = ((x)localObject3).a(i3, this.k, true).b;
    } else {
      localObject1 = paramPair.b;
    }
    int i1 = this.H.a(localObject1);
    if (i1 == -1)
    {
      i1 = a(i3, (x)localObject3, this.H);
      if (i1 == -1)
      {
        a(localObject2);
        return;
      }
      localObject1 = a(this.H.a(i1, this.k).c, -9223372036854775807L);
      i1 = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.H.a(i1, this.k, true);
      if (paramPair != null)
      {
        localObject1 = this.k.b;
        paramPair.g = paramPair.g.a(-1);
        while (paramPair.j != null)
        {
          paramPair = paramPair.j;
          if (paramPair.b.equals(localObject1)) {
            paramPair.g = this.l.a(paramPair.g, i1);
          } else {
            paramPair.g = paramPair.g.a(-1);
          }
        }
      }
      paramPair = new h.b(i1);
      this.m = new i.b(paramPair, a(paramPair, l1));
      b(localObject2);
      return;
    }
    if (i1 != i3) {
      this.m = this.m.a(i1);
    }
    if (this.m.a.a())
    {
      localObject1 = this.l.a(i1, this.m.c);
      if ((!((h.b)localObject1).a()) || (((h.b)localObject1).d != this.m.a.d))
      {
        l2 = a((h.b)localObject1, this.m.c);
        if (((h.b)localObject1).a()) {
          l1 = this.m.c;
        }
        this.m = new i.b((h.b)localObject1, l2, l1);
        b(localObject2);
        return;
      }
    }
    if (paramPair == null)
    {
      b(localObject2);
      return;
    }
    paramPair = a(paramPair, i1);
    while (paramPair.j != null)
    {
      localObject1 = paramPair.j;
      i1 = this.H.a(i1, this.k, this.j, this.x);
      if ((i1 != -1) && (((i.a)localObject1).b.equals(this.H.a(i1, this.k, true).b)))
      {
        paramPair = a((i.a)localObject1, i1);
      }
      else
      {
        localObject3 = this.F;
        i1 = i2;
        if (localObject3 != null)
        {
          i1 = i2;
          if (((i.a)localObject3).c < ((i.a)localObject1).c) {
            i1 = 1;
          }
        }
        if (i1 == 0)
        {
          l1 = a(this.G.g.a, this.m.d);
          this.m = new i.b(this.G.g.a, l1, this.m.c);
        }
        else
        {
          this.E = paramPair;
          this.E.j = null;
          a((i.a)localObject1);
        }
      }
    }
    b(localObject2);
  }
  
  private void a(i.a parama)
  {
    while (parama != null)
    {
      parama.e();
      parama = parama.j;
    }
  }
  
  private void a(i.c paramc)
  {
    Object localObject1 = this.H;
    int i3 = 1;
    if (localObject1 == null)
    {
      this.B += 1;
      this.C = paramc;
      return;
    }
    localObject1 = b(paramc);
    if (localObject1 == null)
    {
      this.m = new i.b(0, 0L);
      this.h.obtainMessage(4, 1, 0, this.m).sendToTarget();
      this.m = new i.b(0, -9223372036854775807L);
      a(4);
      d(false);
      return;
    }
    int i1;
    if (paramc.c == -9223372036854775807L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = ((Integer)((Pair)localObject1).first).intValue();
    long l2 = ((Long)((Pair)localObject1).second).longValue();
    paramc = this.l.a(i2, l2);
    long l1;
    if (paramc.a())
    {
      l1 = 0L;
      i1 = 1;
    }
    else
    {
      l1 = l2;
    }
    try
    {
      if (paramc.equals(this.m.a))
      {
        l3 = l1 / 1000L;
        long l4 = this.m.d / 1000L;
        if (l3 == l4) {
          return;
        }
      }
      long l3 = a(paramc, l1);
      if (l1 != l3) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      this.m = new i.b(paramc, l3, l2);
      paramc = this.h;
      if ((i2 | i1) != 0) {
        i1 = i3;
      } else {
        i1 = 0;
      }
      paramc.obtainMessage(4, i1, 0, this.m).sendToTarget();
      return;
    }
    finally
    {
      this.m = new i.b(paramc, l1, l2);
      this.h.obtainMessage(4, i1, 0, this.m).sendToTarget();
    }
  }
  
  private void a(s params)
  {
    if (params.d() == 2) {
      params.k();
    }
  }
  
  private void a(Object paramObject)
  {
    a(paramObject, 0);
  }
  
  private void a(Object paramObject, int paramInt)
  {
    this.m = new i.b(0, 0L);
    b(paramObject, paramInt);
    this.m = new i.b(0, -9223372036854775807L);
    a(4);
    d(false);
  }
  
  private void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.r = new s[paramInt];
    paramInt = 0;
    int i2;
    for (int i1 = 0;; i1 = i2)
    {
      Object localObject1 = this.a;
      if (paramInt >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[paramInt];
      Object localObject2 = this.G.k.b.a(paramInt);
      i2 = i1;
      if (localObject2 != null)
      {
        this.r[i1] = localObject1;
        if (((s)localObject1).d() == 0)
        {
          u localu = this.G.k.d[paramInt];
          if ((this.t) && (this.w == 3)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          boolean bool;
          if ((paramArrayOfBoolean[paramInt] == 0) && (i2 != 0)) {
            bool = true;
          } else {
            bool = false;
          }
          k[] arrayOfk = new k[((com.tencent.luggage.wxa.al.e)localObject2).e()];
          int i3 = 0;
          while (i3 < arrayOfk.length)
          {
            arrayOfk[i3] = ((com.tencent.luggage.wxa.al.e)localObject2).a(i3);
            i3 += 1;
          }
          ((s)localObject1).a(localu, arrayOfk, this.G.d[paramInt], this.D, bool, this.G.a());
          localObject2 = ((s)localObject1).c();
          if (localObject2 != null) {
            if (this.p == null)
            {
              this.p = ((com.tencent.luggage.wxa.ao.i)localObject2);
              this.o = ((s)localObject1);
              this.p.a(this.n);
            }
            else
            {
              throw e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
            }
          }
          if (i2 != 0) {
            ((s)localObject1).e();
          }
        }
        i2 = i1 + 1;
      }
      paramInt += 1;
    }
  }
  
  private boolean a(h.b paramb, long paramLong, i.a parama)
  {
    if ((paramb.equals(parama.g.a)) && (parama.h))
    {
      this.H.a(parama.g.a.b, this.k);
      int i1 = this.k.b(paramLong);
      if ((i1 == -1) || (this.k.a(i1) == parama.g.c)) {
        return true;
      }
    }
    return false;
  }
  
  private Pair<Integer, Long> b(i.c paramc)
  {
    Object localObject2 = paramc.a;
    Object localObject1 = localObject2;
    if (((x)localObject2).a()) {
      localObject1 = this.H;
    }
    try
    {
      localObject2 = ((x)localObject1).a(this.j, this.k, paramc.b, paramc.c);
      paramc = this.H;
      if (paramc == localObject1) {
        return localObject2;
      }
      int i1 = paramc.a(((x)localObject1).a(((Integer)((Pair)localObject2).first).intValue(), this.k, true).b);
      if (i1 != -1) {
        return Pair.create(Integer.valueOf(i1), ((Pair)localObject2).second);
      }
      i1 = a(((Integer)((Pair)localObject2).first).intValue(), (x)localObject1, this.H);
      if (i1 != -1) {
        return a(this.H.a(i1, this.k).c, -9223372036854775807L);
      }
      return null;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label154:
      break label154;
    }
    throw new m(this.H, paramc.b, paramc.c);
  }
  
  private void b(int paramInt)
  {
    this.x = paramInt;
    this.l.a(paramInt);
    Object localObject1 = this.G;
    if (localObject1 == null) {
      localObject1 = this.E;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      return;
    }
    for (;;)
    {
      i1 = this.H.a(((i.a)localObject2).g.a.b, this.k, this.j, paramInt);
      while ((((i.a)localObject2).j != null) && (!((i.a)localObject2).g.f)) {
        localObject2 = ((i.a)localObject2).j;
      }
      if ((i1 == -1) || (((i.a)localObject2).j == null) || (((i.a)localObject2).j.g.a.b != i1)) {
        break;
      }
      localObject2 = ((i.a)localObject2).j;
    }
    int i1 = this.E.c;
    localObject1 = this.F;
    if (localObject1 != null) {
      paramInt = ((i.a)localObject1).c;
    } else {
      paramInt = -1;
    }
    if (((i.a)localObject2).j != null)
    {
      a(((i.a)localObject2).j);
      ((i.a)localObject2).j = null;
    }
    ((i.a)localObject2).g = this.l.a(((i.a)localObject2).g);
    int i3 = ((i.a)localObject2).c;
    int i2 = 1;
    if (i1 <= i3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      this.E = ((i.a)localObject2);
    }
    if ((paramInt != -1) && (paramInt <= ((i.a)localObject2).c)) {
      paramInt = i2;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      localObject1 = this.G;
      if (localObject1 != null)
      {
        localObject1 = ((i.a)localObject1).g.a;
        this.m = new i.b((h.b)localObject1, a((h.b)localObject1, this.m.d), this.m.c);
      }
    }
  }
  
  private void b(i.a parama)
  {
    if (this.G == parama) {
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.a.length];
    int i1 = 0;
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      Object localObject = this.a;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      int i4;
      if (((s)localObject).d() != 0) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      arrayOfBoolean[i1] = i4;
      com.tencent.luggage.wxa.al.e locale = parama.k.b.a(i1);
      i3 = i2;
      if (locale != null) {
        i3 = i2 + 1;
      }
      if ((arrayOfBoolean[i1] != 0) && ((locale == null) || ((((s)localObject).i()) && (((s)localObject).f() == this.G.d[i1]))))
      {
        if (localObject == this.o)
        {
          this.e.a(this.p);
          this.p = null;
          this.o = null;
        }
        a((s)localObject);
        ((s)localObject).l();
      }
      i1 += 1;
    }
    this.G = parama;
    this.h.obtainMessage(3, parama.k).sendToTarget();
    a(arrayOfBoolean, i2);
  }
  
  private void b(q paramq)
  {
    com.tencent.luggage.wxa.ao.i locali = this.p;
    if (locali != null) {
      paramq = locali.a(paramq);
    } else {
      paramq = this.e.a(paramq);
    }
    this.n = paramq;
    this.h.obtainMessage(7, paramq).sendToTarget();
  }
  
  private void b(com.tencent.luggage.wxa.z.h paramh, boolean paramBoolean)
  {
    this.h.sendEmptyMessage(0);
    d(true);
    this.d.a();
    if (paramBoolean) {
      this.m = new i.b(0, -9223372036854775807L);
    } else {
      this.m = new i.b(this.m.a, this.m.d, this.m.c);
    }
    this.q = paramh;
    if (paramh != null) {
      paramh.a(this.i, true, this);
    }
    a(2);
    this.f.sendEmptyMessage(2);
  }
  
  private void b(Object paramObject)
  {
    b(paramObject, 0);
  }
  
  private void b(Object paramObject, int paramInt)
  {
    this.h.obtainMessage(6, new i.d(this.H, paramObject, this.m, paramInt)).sendToTarget();
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean b(long paramLong)
  {
    return (paramLong == -9223372036854775807L) || (this.m.d < paramLong) || ((this.G.j != null) && ((this.G.j.h) || (this.G.j.g.a.a())));
  }
  
  private void c()
  {
    int i1 = 0;
    this.u = false;
    this.e.a();
    s[] arrayOfs = this.r;
    int i2 = arrayOfs.length;
    while (i1 < i2)
    {
      arrayOfs[i1].e();
      i1 += 1;
    }
  }
  
  private void c(com.tencent.luggage.wxa.z.g paramg)
  {
    i.a locala = this.E;
    if (locala != null)
    {
      if (locala.a != paramg) {
        return;
      }
      this.E.c();
      if (this.G == null)
      {
        this.F = this.E;
        a(this.F.g.b);
        b(this.F);
      }
      m();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.u = false;
    this.t = paramBoolean;
    if (!paramBoolean)
    {
      d();
      e();
      return;
    }
    int i1 = this.w;
    if (i1 == 3)
    {
      c();
      this.f.sendEmptyMessage(2);
      return;
    }
    if (i1 == 2) {
      this.f.sendEmptyMessage(2);
    }
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore_3
    //   3: iconst_0
    //   4: istore_2
    //   5: iload_2
    //   6: iload_3
    //   7: if_icmpge +35 -> 42
    //   10: aload_1
    //   11: iload_2
    //   12: aaload
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 542	com/tencent/luggage/wxa/h/f$c:a	Lcom/tencent/luggage/wxa/h/f$b;
    //   20: aload 4
    //   22: getfield 543	com/tencent/luggage/wxa/h/f$c:b	I
    //   25: aload 4
    //   27: getfield 545	com/tencent/luggage/wxa/h/f$c:c	Ljava/lang/Object;
    //   30: invokeinterface 550 3 0
    //   35: iload_2
    //   36: iconst_1
    //   37: iadd
    //   38: istore_2
    //   39: goto -34 -> 5
    //   42: aload_0
    //   43: getfield 87	com/tencent/luggage/wxa/h/i:w	I
    //   46: iconst_3
    //   47: if_icmpeq +11 -> 58
    //   50: aload_0
    //   51: getfield 87	com/tencent/luggage/wxa/h/i:w	I
    //   54: iconst_2
    //   55: if_icmpne +12 -> 67
    //   58: aload_0
    //   59: getfield 159	com/tencent/luggage/wxa/h/i:f	Landroid/os/Handler;
    //   62: iconst_2
    //   63: invokevirtual 227	android/os/Handler:sendEmptyMessage	(I)Z
    //   66: pop
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 552	com/tencent/luggage/wxa/h/i:z	I
    //   74: iconst_1
    //   75: iadd
    //   76: putfield 552	com/tencent/luggage/wxa/h/i:z	I
    //   79: aload_0
    //   80: invokevirtual 555	java/lang/Object:notifyAll	()V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: monitorenter
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 552	com/tencent/luggage/wxa/h/i:z	I
    //   99: iconst_1
    //   100: iadd
    //   101: putfield 552	com/tencent/luggage/wxa/h/i:z	I
    //   104: aload_0
    //   105: invokevirtual 555	java/lang/Object:notifyAll	()V
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: goto +5 -> 120
    //   118: aload_1
    //   119: athrow
    //   120: goto -2 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	i
    //   0	123	1	paramArrayOfc	f.c[]
    //   4	35	2	i1	int
    //   2	6	3	i2	int
    //   13	13	4	localc	f.c
    // Exception table:
    //   from	to	target	type
    //   69	85	86	finally
    //   87	89	86	finally
    //   0	3	91	finally
    //   15	35	91	finally
    //   42	58	91	finally
    //   58	67	91	finally
    //   94	110	112	finally
    //   113	115	112	finally
  }
  
  private void d()
  {
    this.e.b();
    s[] arrayOfs = this.r;
    int i2 = arrayOfs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a(arrayOfs[i1]);
      i1 += 1;
    }
  }
  
  private void d(com.tencent.luggage.wxa.z.g paramg)
  {
    i.a locala = this.E;
    if (locala != null)
    {
      if (locala.a != paramg) {
        return;
      }
      m();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.f.removeMessages(2);
    this.u = false;
    this.e.b();
    this.p = null;
    this.o = null;
    this.D = 60000000L;
    s[] arrayOfs = this.r;
    int i2 = arrayOfs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      s locals = arrayOfs[i1];
      try
      {
        a(locals);
        locals.l();
      }
      catch (RuntimeException localRuntimeException) {}catch (e locale) {}
      Log.e("ExoPlayerImplInternal", "Stop failed.", locale);
      i1 += 1;
    }
    this.r = new s[0];
    Object localObject = this.G;
    if (localObject == null) {
      localObject = this.E;
    }
    a((i.a)localObject);
    this.E = null;
    this.F = null;
    this.G = null;
    b(false);
    if (paramBoolean)
    {
      localObject = this.q;
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.z.h)localObject).b();
        this.q = null;
      }
      this.l.a(null);
      this.H = null;
    }
  }
  
  private void e()
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    long l1 = ((i.a)localObject).a.c();
    if (l1 != -9223372036854775807L)
    {
      a(l1);
    }
    else
    {
      localObject = this.o;
      if ((localObject != null) && (!((s)localObject).u()))
      {
        this.D = this.p.w();
        this.e.a(this.D);
      }
      else
      {
        this.D = this.e.w();
      }
      l1 = this.G.b(this.D);
    }
    this.m.d = l1;
    this.A = (SystemClock.elapsedRealtime() * 1000L);
    if (this.r.length == 0) {
      l1 = -9223372036854775808L;
    } else {
      l1 = this.G.a.d();
    }
    localObject = this.m;
    long l2 = l1;
    if (l1 == -9223372036854775808L) {
      l2 = this.G.g.e;
    }
    ((i.b)localObject).e = l2;
  }
  
  private void f()
  {
    long l1 = SystemClock.elapsedRealtime();
    k();
    if (this.G == null)
    {
      j();
      a(l1, 10L);
      return;
    }
    v.a("doSomeWork");
    e();
    this.G.a.a(this.m.d);
    Object localObject1 = this.r;
    int i4 = localObject1.length;
    int i2 = 0;
    boolean bool = true;
    int i1 = 1;
    while (i2 < i4)
    {
      Object localObject2 = localObject1[i2];
      localObject2.a(this.D, this.A);
      if ((i1 != 0) && (localObject2.u())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i3;
      if ((!localObject2.t()) && (!localObject2.u())) {
        i3 = 0;
      } else {
        i3 = 1;
      }
      if (i3 == 0) {
        localObject2.j();
      }
      if ((bool) && (i3 != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      i2 += 1;
    }
    if (!bool) {
      j();
    }
    localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.luggage.wxa.ao.i)localObject1).x();
      if (!((q)localObject1).equals(this.n))
      {
        this.n = ((q)localObject1);
        this.e.a(this.p);
        this.h.obtainMessage(7, localObject1).sendToTarget();
      }
    }
    long l2 = this.G.g.e;
    if ((i1 != 0) && ((l2 == -9223372036854775807L) || (l2 <= this.m.d)) && (this.G.g.g))
    {
      a(4);
      d();
    }
    else
    {
      i1 = this.w;
      if (i1 == 2)
      {
        if (this.r.length > 0)
        {
          if ((bool) && (this.E.a(this.u, this.D))) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else {
          bool = b(l2);
        }
        if (bool)
        {
          a(3);
          if (this.t) {
            c();
          }
        }
      }
      else if (i1 == 3)
      {
        if (this.r.length <= 0) {
          bool = b(l2);
        }
        if (!bool)
        {
          this.u = this.t;
          a(2);
          d();
        }
      }
    }
    if (this.w == 2)
    {
      localObject1 = this.r;
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject1[i1].j();
        i1 += 1;
      }
    }
    if ((!this.t) || (this.w != 3))
    {
      i1 = this.w;
      if (i1 != 2) {}
    }
    else
    {
      a(l1, 10L);
      break label568;
    }
    if ((this.r.length != 0) && (i1 != 4)) {
      a(l1, 1000L);
    } else {
      this.f.removeMessages(2);
    }
    label568:
    v.a();
  }
  
  private void g()
  {
    d(true);
    this.d.b();
    a(1);
  }
  
  private void h()
  {
    d(true);
    this.d.c();
    a(1);
    try
    {
      this.s = true;
      notifyAll();
      return;
    }
    finally {}
  }
  
  private void i()
  {
    i.a locala = this.G;
    if (locala == null) {
      return;
    }
    int i1 = 1;
    while (locala != null)
    {
      if (!locala.h) {
        return;
      }
      if (locala.d())
      {
        long l1;
        if (i1 != 0)
        {
          boolean bool;
          if (this.F != this.G) {
            bool = true;
          } else {
            bool = false;
          }
          a(this.G.j);
          Object localObject1 = this.G;
          ((i.a)localObject1).j = null;
          this.E = ((i.a)localObject1);
          this.F = ((i.a)localObject1);
          boolean[] arrayOfBoolean = new boolean[this.a.length];
          l1 = ((i.a)localObject1).a(this.m.d, bool, arrayOfBoolean);
          if (l1 != this.m.d)
          {
            this.m.d = l1;
            a(l1);
          }
          localObject1 = new boolean[this.a.length];
          i1 = 0;
          int i3;
          for (int i2 = 0;; i2 = i3)
          {
            Object localObject2 = this.a;
            if (i1 >= localObject2.length) {
              break;
            }
            localObject2 = localObject2[i1];
            if (((s)localObject2).d() != 0) {
              bool = true;
            } else {
              bool = false;
            }
            localObject1[i1] = bool;
            com.tencent.luggage.wxa.z.k localk = this.G.d[i1];
            i3 = i2;
            if (localk != null) {
              i3 = i2 + 1;
            }
            if (localObject1[i1] != 0) {
              if (localk != ((s)localObject2).f())
              {
                if (localObject2 == this.o)
                {
                  if (localk == null) {
                    this.e.a(this.p);
                  }
                  this.p = null;
                  this.o = null;
                }
                a((s)localObject2);
                ((s)localObject2).l();
              }
              else if (arrayOfBoolean[i1] != 0)
              {
                ((s)localObject2).a(this.D);
              }
            }
            i1 += 1;
          }
          this.h.obtainMessage(3, locala.k).sendToTarget();
          a((boolean[])localObject1, i2);
        }
        else
        {
          this.E = locala;
          for (locala = this.E.j; locala != null; locala = locala.j) {
            locala.e();
          }
          locala = this.E;
          locala.j = null;
          if (locala.h)
          {
            l1 = Math.max(this.E.g.b, this.E.b(this.D));
            this.E.a(l1, false);
          }
        }
        m();
        e();
        this.f.sendEmptyMessage(2);
        return;
      }
      if (locala == this.F) {
        i1 = 0;
      }
      locala = locala.j;
    }
  }
  
  private void j()
  {
    Object localObject = this.E;
    if ((localObject != null) && (!((i.a)localObject).h))
    {
      localObject = this.F;
      if ((localObject == null) || (((i.a)localObject).j == this.E))
      {
        localObject = this.r;
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (!localObject[i1].g()) {
            return;
          }
          i1 += 1;
        }
        this.E.a.d_();
      }
    }
  }
  
  private void k()
  {
    if (this.H == null)
    {
      localObject1 = this.q;
      if (localObject1 != null)
      {
        ((com.tencent.luggage.wxa.z.h)localObject1).a();
        return;
      }
    }
    l();
    Object localObject1 = this.E;
    int i1 = 0;
    if ((localObject1 != null) && (!((i.a)localObject1).b()))
    {
      if ((this.E != null) && (!this.v)) {
        m();
      }
    }
    else {
      b(false);
    }
    if (this.G == null) {
      return;
    }
    for (;;)
    {
      localObject1 = this.G;
      if ((localObject1 == this.F) || (this.D < ((i.a)localObject1).j.f)) {
        break;
      }
      this.G.e();
      b(this.G.j);
      this.m = new i.b(this.G.g.a, this.G.g.b, this.G.g.d);
      e();
      this.h.obtainMessage(5, this.m).sendToTarget();
    }
    Object localObject2;
    if (this.F.g.g)
    {
      for (;;)
      {
        localObject1 = this.a;
        if (i1 >= localObject1.length) {
          break;
        }
        localObject1 = localObject1[i1];
        localObject2 = this.F.d[i1];
        if ((localObject2 != null) && (((s)localObject1).f() == localObject2) && (((s)localObject1).g())) {
          ((s)localObject1).h();
        }
        i1 += 1;
      }
      return;
    }
    i1 = 0;
    for (;;)
    {
      localObject1 = this.a;
      if (i1 >= localObject1.length) {
        break label353;
      }
      localObject1 = localObject1[i1];
      localObject2 = this.F.d[i1];
      if (((s)localObject1).f() != localObject2) {
        break;
      }
      if ((localObject2 != null) && (!((s)localObject1).g())) {
        return;
      }
      i1 += 1;
    }
    return;
    label353:
    if ((this.F.j != null) && (this.F.j.h))
    {
      localObject1 = this.F.k;
      this.F = this.F.j;
      localObject2 = this.F.k;
      if (this.F.a.c() != -9223372036854775807L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = 0;
      for (;;)
      {
        Object localObject3 = this.a;
        if (i2 >= localObject3.length) {
          break;
        }
        localObject3 = localObject3[i2];
        if (((com.tencent.luggage.wxa.al.h)localObject1).b.a(i2) != null) {
          if (i1 != 0)
          {
            ((s)localObject3).h();
          }
          else if (!((s)localObject3).i())
          {
            com.tencent.luggage.wxa.al.e locale = ((com.tencent.luggage.wxa.al.h)localObject2).b.a(i2);
            Object localObject4 = localObject1.d[i2];
            u localu = localObject2.d[i2];
            if ((locale != null) && (localu.equals(localObject4)))
            {
              localObject4 = new k[locale.e()];
              int i3 = 0;
              while (i3 < localObject4.length)
              {
                localObject4[i3] = locale.a(i3);
                i3 += 1;
              }
              ((s)localObject3).a((k[])localObject4, this.F.d[i2], this.F.a());
            }
            else
            {
              ((s)localObject3).h();
            }
          }
        }
        i2 += 1;
      }
    }
  }
  
  private void l()
  {
    Object localObject1 = this.E;
    if (localObject1 == null)
    {
      localObject1 = this.l.a(this.m);
    }
    else
    {
      if ((((i.a)localObject1).g.g) || (!this.E.b())) {
        return;
      }
      if (this.E.g.e == -9223372036854775807L) {
        return;
      }
      if ((this.G != null) && (this.E.c - this.G.c == 100)) {
        return;
      }
      localObject1 = this.l.a(this.E.g, this.E.a(), this.D);
    }
    if (localObject1 == null)
    {
      this.q.a();
      return;
    }
    Object localObject2 = this.E;
    long l1;
    if (localObject2 == null) {
      l1 = 60000000L;
    } else {
      l1 = ((i.a)localObject2).a() + this.E.g.e;
    }
    localObject2 = this.E;
    int i1;
    if (localObject2 == null) {
      i1 = 0;
    } else {
      i1 = ((i.a)localObject2).c + 1;
    }
    localObject2 = this.H.a(((o.a)localObject1).a.b, this.k, true).b;
    localObject2 = new i.a(this.a, this.b, l1, this.c, this.d, this.q, localObject2, i1, (o.a)localObject1);
    i.a locala = this.E;
    if (locala != null) {
      locala.j = ((i.a)localObject2);
    }
    this.E = ((i.a)localObject2);
    this.E.a.a(this, ((o.a)localObject1).b);
    b(true);
  }
  
  private void m()
  {
    boolean bool = this.E.c(this.D);
    b(bool);
    if (bool) {
      this.E.d(this.D);
    }
  }
  
  public void a()
  {
    this.f.sendEmptyMessage(5);
  }
  
  public void a(q paramq)
  {
    this.f.obtainMessage(4, paramq).sendToTarget();
  }
  
  public void a(x paramx, int paramInt, long paramLong)
  {
    this.f.obtainMessage(3, new i.c(paramx, paramInt, paramLong)).sendToTarget();
  }
  
  public void a(x paramx, Object paramObject)
  {
    this.f.obtainMessage(7, Pair.create(paramx, paramObject)).sendToTarget();
  }
  
  public void a(com.tencent.luggage.wxa.z.g paramg)
  {
    this.f.obtainMessage(8, paramg).sendToTarget();
  }
  
  public void a(com.tencent.luggage.wxa.z.h paramh, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(f.c... paramVarArgs)
  {
    if (this.s)
    {
      Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
      return;
    }
    this.y += 1;
    this.f.obtainMessage(11, paramVarArgs).sendToTarget();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.s;
        if (bool) {
          return;
        }
        this.f.sendEmptyMessage(6);
        i1 = 0;
        bool = this.s;
        if (bool) {
          break;
        }
      }
      finally
      {
        int i1;
        continue;
        throw localObject;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      i1 = 1;
    }
    if (i1 != 0) {
      Thread.currentThread().interrupt();
    }
    this.g.quit();
  }
  
  public void b(com.tencent.luggage.wxa.z.g paramg)
  {
    this.f.obtainMessage(9, paramg).sendToTarget();
  }
  
  public void b(f.c... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if (this.s)
        {
          Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
          return;
        }
        int i2 = this.y;
        this.y = (i2 + 1);
        this.f.obtainMessage(11, paramVarArgs).sendToTarget();
        i1 = 0;
        int i3 = this.z;
        if (i3 > i2) {
          break;
        }
      }
      finally
      {
        int i1;
        continue;
        throw paramVarArgs;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException paramVarArgs)
      {
        continue;
      }
      i1 = 1;
    }
    if (i1 != 0) {
      Thread.currentThread().interrupt();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      int i1 = paramMessage.what;
      bool2 = false;
      bool1 = false;
      switch (i1)
      {
      case 12: 
        b(paramMessage.arg1);
        return true;
      }
    }
    catch (RuntimeException paramMessage)
    {
      boolean bool2;
      boolean bool1;
      com.tencent.luggage.wxa.z.h localh;
      Log.e("ExoPlayerImplInternal", "Internal runtime error.", paramMessage);
      this.h.obtainMessage(8, e.a(paramMessage)).sendToTarget();
      g();
      return true;
    }
    catch (IOException paramMessage)
    {
      Log.e("ExoPlayerImplInternal", "Source error.", paramMessage);
      this.h.obtainMessage(8, e.a(paramMessage)).sendToTarget();
      g();
      return true;
    }
    catch (e paramMessage)
    {
      Log.e("ExoPlayerImplInternal", "Renderer error.", paramMessage);
      this.h.obtainMessage(8, paramMessage).sendToTarget();
      g();
      return true;
    }
    c((f.c[])paramMessage.obj);
    return true;
    i();
    return true;
    d((com.tencent.luggage.wxa.z.g)paramMessage.obj);
    return true;
    c((com.tencent.luggage.wxa.z.g)paramMessage.obj);
    return true;
    a((Pair)paramMessage.obj);
    return true;
    h();
    return true;
    g();
    return true;
    b((q)paramMessage.obj);
    return true;
    a((i.c)paramMessage.obj);
    return true;
    f();
    return true;
    if (paramMessage.arg1 != 0) {
      bool1 = true;
    }
    c(bool1);
    return true;
    localh = (com.tencent.luggage.wxa.z.h)paramMessage.obj;
    bool1 = bool2;
    if (paramMessage.arg1 != 0) {
      bool1 = true;
    }
    b(localh, bool1);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.i
 * JD-Core Version:    0.7.0.1
 */