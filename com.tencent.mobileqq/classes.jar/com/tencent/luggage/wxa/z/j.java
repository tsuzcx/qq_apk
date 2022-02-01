package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.am.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.l.a;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class j
  implements com.tencent.luggage.wxa.l.l
{
  private final com.tencent.luggage.wxa.am.b a;
  private final int b;
  private final i c;
  private final i.a d;
  private final m e;
  private j.a f;
  private j.a g;
  private j.a h;
  private k i;
  private boolean j;
  private k k;
  private long l;
  private long m;
  private boolean n;
  private j.b o;
  
  public j(com.tencent.luggage.wxa.am.b paramb)
  {
    this.a = paramb;
    this.b = paramb.c();
    this.c = new i();
    this.d = new i.a();
    this.e = new m(32);
    this.f = new j.a(0L, this.b);
    paramb = this.f;
    this.g = paramb;
    this.h = paramb;
  }
  
  private static k a(k paramk, long paramLong)
  {
    if (paramk == null) {
      return null;
    }
    k localk = paramk;
    if (paramLong != 0L)
    {
      localk = paramk;
      if (paramk.w != 9223372036854775807L) {
        localk = paramk.a(paramk.w + paramLong);
      }
    }
    return localk;
  }
  
  private void a(long paramLong)
  {
    while (paramLong >= this.g.b) {
      this.g = this.g.e;
    }
  }
  
  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    a(paramLong);
    while (paramInt > 0)
    {
      int i2 = Math.min(paramInt, (int)(this.g.b - paramLong));
      paramByteBuffer.put(this.g.d.a, this.g.a(paramLong), i2);
      int i1 = paramInt - i2;
      long l1 = paramLong + i2;
      paramLong = l1;
      paramInt = i1;
      if (l1 == this.g.b)
      {
        this.g = this.g.e;
        paramLong = l1;
        paramInt = i1;
      }
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    a(paramLong);
    int i1 = paramInt;
    while (i1 > 0)
    {
      int i3 = Math.min(i1, (int)(this.g.b - paramLong));
      System.arraycopy(this.g.d.a, this.g.a(paramLong), paramArrayOfByte, paramInt - i1, i3);
      int i2 = i1 - i3;
      long l1 = paramLong + i3;
      paramLong = l1;
      i1 = i2;
      if (l1 == this.g.b)
      {
        this.g = this.g.e;
        paramLong = l1;
        i1 = i2;
      }
    }
  }
  
  private void a(com.tencent.luggage.wxa.j.e parame, i.a parama)
  {
    long l1 = parama.b;
    this.e.a(1);
    a(l1, this.e.a, 1);
    l1 += 1L;
    Object localObject1 = this.e.a;
    int i3 = 0;
    int i2 = localObject1[0];
    if ((i2 & 0x80) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    i2 &= 0x7F;
    if (parame.a.a == null) {
      parame.a.a = new byte[16];
    }
    a(l1, parame.a.a, i2);
    l1 += i2;
    if (i1 != 0)
    {
      this.e.a(2);
      a(l1, this.e.a, 2);
      l1 += 2L;
      i2 = this.e.h();
    }
    else
    {
      i2 = 1;
    }
    Object localObject2 = parame.a.d;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length >= i2) {}
    }
    else
    {
      localObject1 = new int[i2];
    }
    Object localObject3 = parame.a.e;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length >= i2) {}
    }
    else
    {
      localObject2 = new int[i2];
    }
    if (i1 != 0)
    {
      i1 = i2 * 6;
      this.e.a(i1);
      a(l1, this.e.a, i1);
      long l2 = l1 + i1;
      this.e.c(0);
      i1 = i3;
      for (;;)
      {
        l1 = l2;
        if (i1 >= i2) {
          break;
        }
        localObject1[i1] = this.e.h();
        localObject2[i1] = this.e.t();
        i1 += 1;
      }
    }
    localObject1[0] = 0;
    localObject2[0] = (parama.a - (int)(l1 - parama.b));
    localObject3 = parama.c;
    parame.a.a(i2, (int[])localObject1, (int[])localObject2, ((l.a)localObject3).b, parame.a.a, ((l.a)localObject3).a, ((l.a)localObject3).c, ((l.a)localObject3).d);
    int i1 = (int)(l1 - parama.b);
    parama.b += i1;
    parama.a -= i1;
  }
  
  private void a(j.a parama)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int b(int paramInt)
  {
    if (!this.h.c) {
      this.h.a(this.a.a(), new j.a(this.h.b, this.b));
    }
    return Math.min(paramInt, (int)(this.h.b - this.m));
  }
  
  private void b(long paramLong)
  {
    if (paramLong == -1L) {
      return;
    }
    while (paramLong >= this.f.b)
    {
      this.a.a(this.f.d);
      this.f = this.f.a();
    }
    if (this.g.a < this.f.a) {
      this.g = this.f;
    }
  }
  
  private void c(int paramInt)
  {
    this.m += paramInt;
    if (this.m == this.h.b) {
      this.h = this.h.e;
    }
  }
  
  public int a(com.tencent.luggage.wxa.h.l paraml, com.tencent.luggage.wxa.j.e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i1 = this.c.a(paraml, parame, paramBoolean1, paramBoolean2, this.i, this.d);
    if (i1 != -5)
    {
      if (i1 != -4)
      {
        if (i1 == -3) {
          return -3;
        }
        throw new IllegalStateException();
      }
      if (!parame.c())
      {
        if (parame.c < paramLong) {
          parame.b(-2147483648);
        }
        if (parame.g()) {
          a(parame, this.d);
        }
        parame.e(this.d.a);
        a(this.d.b, parame.b, this.d.a);
      }
      return -4;
    }
    this.i = paraml.a;
    return -5;
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, int paramInt, boolean paramBoolean)
  {
    paramInt = b(paramInt);
    paramInt = parame.a(this.h.d.a, this.h.a(this.m), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    c(paramInt);
    return paramInt;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, l.a parama)
  {
    if (this.j) {
      a(this.k);
    }
    if (this.n) {
      if ((paramInt1 & 0x1) != 0)
      {
        if (!this.c.b(paramLong)) {
          return;
        }
        this.n = false;
      }
      else
      {
        return;
      }
    }
    long l1 = this.l;
    long l2 = this.m;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.c.a(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, parama);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(this.c.b(paramLong, paramBoolean1, paramBoolean2));
  }
  
  public void a(m paramm, int paramInt)
  {
    while (paramInt > 0)
    {
      int i1 = b(paramInt);
      paramm.a(this.h.d.a, this.h.a(this.m), i1);
      paramInt -= i1;
      c(i1);
    }
  }
  
  public void a(k paramk)
  {
    k localk = a(paramk, this.l);
    boolean bool = this.c.a(localk);
    this.k = paramk;
    this.j = false;
    paramk = this.o;
    if ((paramk != null) && (bool)) {
      paramk.a(localk);
    }
  }
  
  public void a(j.b paramb)
  {
    this.o = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    a(this.f);
    this.f = new j.a(0L, this.b);
    j.a locala = this.f;
    this.g = locala;
    this.h = locala;
    this.m = 0L;
    this.a.b();
  }
  
  public void b()
  {
    this.n = true;
  }
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.c.a(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public int c()
  {
    return this.c.a();
  }
  
  public boolean d()
  {
    return this.c.d();
  }
  
  public int e()
  {
    return this.c.b();
  }
  
  public int f()
  {
    return this.c.c();
  }
  
  public k g()
  {
    return this.c.e();
  }
  
  public long h()
  {
    return this.c.f();
  }
  
  public void i()
  {
    this.c.g();
    this.g = this.f;
  }
  
  public void j()
  {
    b(this.c.i());
  }
  
  public void k()
  {
    b(this.c.j());
  }
  
  public void l()
  {
    this.c.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.j
 * JD-Core Version:    0.7.0.1
 */