package com.tencent.luggage.wxa.ni;

import com.tencent.luggage.wxa.ge.e;
import com.tencent.luggage.wxa.ma.k;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.math.BigInteger;

public class a
{
  public static final BigInteger a = BigInteger.valueOf(1024L);
  private a.a b = new a.a(this);
  
  private void a(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb)
  {
    if ((paramb != null) && (parame != null) && (this.b.f <= 0L))
    {
      this.b.f = af.d();
      parame.a(1234L, 20L, 1L, false);
      if (k.a(paramb))
      {
        parame.a(1234L, 40L, 1L, false);
        return;
      }
      if (k.b(paramb)) {
        parame.a(1234L, 45L, 1L, false);
      }
    }
  }
  
  public void a(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramb != null) && (parame != null))
    {
      parame.a(1234L, 65L, 1L, false);
      o.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (k.a(paramb)) {
        parame.a(1234L, 70L, 1L, false);
      } else if (k.b(paramb)) {
        parame.a(1234L, 75L, 1L, false);
      }
      if (!af.c(paramString)) {
        if (paramString.equalsIgnoreCase("MEDIA_ERR_NETWORK"))
        {
          parame.a(1234L, 67L, 1L, false);
          if (k.a(paramb)) {
            parame.a(1234L, 72L, 1L, false);
          } else if (k.b(paramb)) {
            parame.a(1234L, 77L, 1L, false);
          }
        }
        else if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
        {
          parame.a(1234L, 68L, 1L, false);
          if (k.a(paramb)) {
            parame.a(1234L, 73L, 1L, false);
          } else if (k.b(paramb)) {
            parame.a(1234L, 78L, 1L, false);
          }
        }
        else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
        {
          parame.a(1234L, 66L, 1L, false);
          if (k.a(paramb)) {
            parame.a(1234L, 71L, 1L, false);
          } else if (k.b(paramb)) {
            parame.a(1234L, 76L, 1L, false);
          }
        }
        else
        {
          parame.a(1234L, 69L, 1L, false);
          if (k.a(paramb)) {
            parame.a(1234L, 74L, 1L, false);
          } else if (k.b(paramb)) {
            parame.a(1234L, 79L, 1L, false);
          }
        }
      }
      parame = this.b;
      parame.o = paramInt1;
      parame.p = paramInt2;
      parame.q = paramString;
    }
  }
  
  public void a(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb, long paramLong, String paramString)
  {
    if ((paramb != null) && (parame != null) && (!af.c(paramString)))
    {
      parame.a(1234L, 10L, 1L, false);
      if (paramLong > 0L)
      {
        parame.a(1234L, 11L, 1L, false);
        long l = BigInteger.valueOf(paramLong).divide(a).longValue();
        parame.a(1234L, 13L, l, false);
        o.e("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      }
      this.b.a(paramString);
      this.b.d = paramLong;
    }
  }
  
  public void b(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb)
  {
    if ((paramb != null) && (parame != null) && (this.b.k <= 0L))
    {
      parama = this.b;
      parama.i += 1;
      this.b.k = af.d();
      parame.a(1234L, 20L, 1L, false);
    }
  }
  
  public void b(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb, long paramLong)
  {
    if ((paramb != null) && (parame != null))
    {
      if (this.b.g <= 0L)
      {
        this.b.g = af.d();
        parame.a(1234L, 21L, 1L, false);
        long l = this.b.g - this.b.f;
        this.b.h = l;
        parame.a(1234L, 23L, l, false);
        o.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (k.a(paramb))
        {
          parame.a(1234L, 41L, 1L, false);
          parame.a(1234L, 43L, l, false);
        }
        else if (k.b(paramb))
        {
          parame.a(1234L, 46L, 1L, false);
          parame.a(1234L, 48L, l, false);
        }
      }
      if ((this.b.e <= 0L) && (paramLong > 0L))
      {
        double d = paramLong;
        Double.isNaN(d);
        paramLong = (d * 1.0D / 1000.0D);
        this.b.e = paramLong;
        parame.a(1234L, 35L, 1L, false);
        parame.a(1234L, 38L, paramLong, false);
        o.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
    }
  }
  
  public void c(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb)
  {
    if ((paramb != null) && (parame != null))
    {
      if (this.b.l <= 0L)
      {
        this.b.l = af.d();
        parame.a(1234L, 21L, 1L, false);
        long l = this.b.l - this.b.k;
        parama = this.b;
        parama.j += l;
        parame.a(1234L, 23L, l, false);
        o.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
      }
      this.b.b();
    }
  }
  
  public void d(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb)
  {
    if ((parame != null) && (!af.c(this.b.a)) && (this.b.f > 0L))
    {
      this.b.m = af.d();
      a(parame, parama, paramb, "onMediaPlayerVideoStop");
    }
  }
  
  public void e(e parame, com.tencent.luggage.wxa.fx.a parama, b paramb)
  {
    if ((parame != null) && (!af.c(this.b.a)) && (this.b.f > 0L))
    {
      this.b.n = af.d();
      a(parame, parama, paramb, "onMediaPlayerVideoEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ni.a
 * JD-Core Version:    0.7.0.1
 */