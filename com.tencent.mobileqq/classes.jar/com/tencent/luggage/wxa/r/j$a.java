package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.k.a;
import com.tencent.luggage.wxa.ao.k.b;
import com.tencent.luggage.wxa.ao.n;
import com.tencent.luggage.wxa.l.l;
import java.util.Arrays;

final class j$a
{
  private final l a;
  private final boolean b;
  private final boolean c;
  private final SparseArray<k.b> d;
  private final SparseArray<k.a> e;
  private final n f;
  private byte[] g;
  private int h;
  private int i;
  private long j;
  private boolean k;
  private long l;
  private j.a.a m;
  private j.a.a n;
  private boolean o;
  private long p;
  private long q;
  private boolean r;
  
  public j$a(l paraml, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paraml;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = new SparseArray();
    this.e = new SparseArray();
    this.m = new j.a.a(null);
    this.n = new j.a.a(null);
    this.g = new byte[''];
    this.f = new n(this.g, 0, 0);
    b();
  }
  
  private void a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i2 = this.i;
    int i1 = 0;
    if ((i2 == 9) || ((this.c) && (j.a.a.a(this.n, this.m))))
    {
      if (this.o) {
        a(paramInt + (int)(paramLong - this.j));
      }
      this.p = this.j;
      this.q = this.l;
      this.r = false;
      this.o = true;
    }
    int i3 = this.r;
    i2 = this.i;
    if (i2 != 5)
    {
      paramInt = i1;
      if (this.b)
      {
        paramInt = i1;
        if (i2 == 1)
        {
          paramInt = i1;
          if (!this.n.b()) {}
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    this.r = (i3 | paramInt);
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    this.i = paramInt;
    this.l = paramLong2;
    this.j = paramLong1;
    if ((!this.b) || (this.i != 1))
    {
      if (this.c)
      {
        paramInt = this.i;
        if ((paramInt != 5) && (paramInt != 1) && (paramInt != 2)) {}
      }
    }
    else
    {
      j.a.a locala = this.m;
      this.m = this.n;
      this.n = locala;
      this.n.a();
      this.h = 0;
      this.k = true;
    }
  }
  
  public void a(k.a parama)
  {
    this.e.append(parama.a, parama);
  }
  
  public void a(k.b paramb)
  {
    this.d.append(paramb.a, paramb);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.k) {
      return;
    }
    paramInt2 -= paramInt1;
    Object localObject = this.g;
    int i1 = localObject.length;
    int i2 = this.h;
    if (i1 < i2 + paramInt2) {
      this.g = Arrays.copyOf((byte[])localObject, (i2 + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.g, this.h, paramInt2);
    this.h += paramInt2;
    this.f.a(this.g, 0, this.h);
    if (!this.f.b(8)) {
      return;
    }
    this.f.a();
    int i4 = this.f.c(2);
    this.f.a(5);
    if (!this.f.c()) {
      return;
    }
    this.f.d();
    if (!this.f.c()) {
      return;
    }
    int i5 = this.f.d();
    if (!this.c)
    {
      this.k = false;
      this.n.a(i5);
      return;
    }
    if (!this.f.c()) {
      return;
    }
    int i6 = this.f.d();
    if (this.e.indexOfKey(i6) < 0)
    {
      this.k = false;
      return;
    }
    paramArrayOfByte = (k.a)this.e.get(i6);
    localObject = (k.b)this.d.get(paramArrayOfByte.b);
    if (((k.b)localObject).e)
    {
      if (!this.f.b(2)) {
        return;
      }
      this.f.a(2);
    }
    if (!this.f.b(((k.b)localObject).g)) {
      return;
    }
    int i7 = this.f.c(((k.b)localObject).g);
    boolean bool1;
    if (!((k.b)localObject).f)
    {
      if (!this.f.b(1)) {
        return;
      }
      bool1 = this.f.b();
      if (bool1)
      {
        if (!this.f.b(1)) {
          return;
        }
        bool3 = this.f.b();
        bool2 = true;
        break label390;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = false;
    boolean bool3 = false;
    label390:
    boolean bool4;
    if (this.i == 5) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if (bool4)
    {
      if (!this.f.c()) {
        return;
      }
      i2 = this.f.d();
    }
    else
    {
      i2 = 0;
    }
    if (((k.b)localObject).h == 0)
    {
      if (!this.f.b(((k.b)localObject).i)) {
        return;
      }
      paramInt1 = this.f.c(((k.b)localObject).i);
      if ((paramArrayOfByte.c) && (!bool1))
      {
        if (!this.f.c()) {
          return;
        }
        paramInt2 = this.f.e();
        break label599;
      }
    }
    else
    {
      if ((((k.b)localObject).h == 1) && (!((k.b)localObject).j))
      {
        if (!this.f.c()) {
          return;
        }
        i1 = this.f.e();
        if ((paramArrayOfByte.c) && (!bool1))
        {
          if (!this.f.c()) {
            return;
          }
          i3 = this.f.e();
          paramInt1 = 0;
          paramInt2 = 0;
          break label605;
        }
        paramInt1 = 0;
        paramInt2 = 0;
        break label602;
      }
      paramInt1 = 0;
    }
    paramInt2 = 0;
    label599:
    i1 = 0;
    label602:
    int i3 = 0;
    label605:
    this.n.a((k.b)localObject, i4, i5, i7, i6, bool1, bool2, bool3, bool4, i2, paramInt1, paramInt2, i1, i3);
    this.k = false;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    this.k = false;
    this.o = false;
    this.n.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.j.a
 * JD-Core Version:    0.7.0.1
 */