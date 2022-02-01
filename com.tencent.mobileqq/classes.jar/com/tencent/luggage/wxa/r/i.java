package com.tencent.luggage.wxa.r;

import android.util.Pair;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import java.util.Arrays;
import java.util.Collections;

public final class i
  implements h
{
  private static final double[] c = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private String a;
  private l b;
  private boolean d;
  private long e;
  private final boolean[] f = new boolean[4];
  private final i.a g = new i.a(128);
  private long h;
  private boolean i;
  private long j;
  private long k;
  private long l;
  private boolean m;
  private boolean n;
  
  private static Pair<com.tencent.luggage.wxa.h.k, Long> a(i.a parama, String paramString)
  {
    byte[] arrayOfByte = Arrays.copyOf(parama.c, parama.a);
    int i2 = arrayOfByte[4];
    int i1 = arrayOfByte[5] & 0xFF;
    int i3 = arrayOfByte[6];
    i2 = (i2 & 0xFF) << 4 | i1 >> 4;
    i3 = (i1 & 0xF) << 8 | i3 & 0xFF;
    i1 = (arrayOfByte[7] & 0xF0) >> 4;
    float f1;
    if (i1 != 2)
    {
      if (i1 != 3)
      {
        if (i1 != 4)
        {
          f1 = 1.0F;
          break label162;
        }
        f1 = i3 * 121;
        i1 = i2 * 100;
      }
      else
      {
        f1 = i3 * 16;
        i1 = i2 * 9;
      }
    }
    else
    {
      f1 = i3 * 4;
      i1 = i2 * 3;
    }
    f1 /= i1;
    label162:
    paramString = com.tencent.luggage.wxa.h.k.a(paramString, "video/mpeg2", null, -1, -1, i2, i3, -1.0F, Collections.singletonList(arrayOfByte), -1, f1, null);
    long l2 = 0L;
    i1 = (arrayOfByte[7] & 0xF) - 1;
    long l1 = l2;
    if (i1 >= 0)
    {
      double[] arrayOfDouble = c;
      l1 = l2;
      if (i1 < arrayOfDouble.length)
      {
        double d2 = arrayOfDouble[i1];
        i2 = parama.b + 9;
        i1 = (arrayOfByte[i2] & 0x60) >> 5;
        i2 = arrayOfByte[i2] & 0x1F;
        double d1 = d2;
        if (i1 != i2)
        {
          d1 = i1;
          Double.isNaN(d1);
          double d3 = i2 + 1;
          Double.isNaN(d3);
          d1 = d2 * ((d1 + 1.0D) / d3);
        }
        l1 = (1000000.0D / d1);
      }
    }
    return Pair.create(paramString, Long.valueOf(l1));
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.ao.k.a(this.f);
    this.g.a();
    this.h = 0L;
    this.i = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.j = paramLong;
  }
  
  public void a(m paramm)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.a = paramd.c();
    this.b = paramf.a(paramd.b(), 2);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.i
 * JD-Core Version:    0.7.0.1
 */