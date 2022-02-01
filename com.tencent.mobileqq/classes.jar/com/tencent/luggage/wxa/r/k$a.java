package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.l.l;

final class k$a
{
  private final l a;
  private long b;
  private boolean c;
  private int d;
  private long e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private long k;
  private long l;
  private boolean m;
  
  public k$a(l paraml)
  {
    this.a = paraml;
  }
  
  private void a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = false;
    this.j = false;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if ((this.j) && (this.g))
    {
      this.m = this.c;
      this.j = false;
      return;
    }
    if ((this.h) || (this.g))
    {
      if (this.i) {
        a(paramInt + (int)(paramLong - this.b));
      }
      this.k = this.b;
      this.l = this.e;
      this.i = true;
      this.m = this.c;
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.g = false;
    this.h = false;
    this.e = paramLong2;
    this.d = 0;
    this.b = paramLong1;
    boolean bool2 = true;
    if (paramInt2 >= 32)
    {
      if ((!this.j) && (this.i))
      {
        a(paramInt1);
        this.i = false;
      }
      if (paramInt2 <= 34)
      {
        this.h = (this.j ^ true);
        this.j = true;
      }
    }
    if ((paramInt2 >= 16) && (paramInt2 <= 21)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    boolean bool1 = bool2;
    if (!this.c) {
      if (paramInt2 <= 9) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.f = bool1;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      int n = this.d;
      int i1 = paramInt1 + 2 - n;
      if (i1 < paramInt2)
      {
        boolean bool;
        if ((paramArrayOfByte[i1] & 0x80) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.g = bool;
        this.f = false;
        return;
      }
      this.d = (n + (paramInt2 - paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.k.a
 * JD-Core Version:    0.7.0.1
 */