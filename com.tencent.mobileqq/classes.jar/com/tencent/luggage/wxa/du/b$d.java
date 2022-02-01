package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.pd.l.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.appbrand.v8.n.c;
import java.util.concurrent.atomic.AtomicInteger;

class b$d
  implements l.b
{
  private final String a;
  private final String b;
  private final c c;
  private final boolean d;
  private boolean e = false;
  private n.c f = null;
  private final AtomicInteger g = new AtomicInteger(2);
  private final long h;
  
  private b$d(String paramString1, String paramString2, c paramc, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramc;
    this.d = paramBoolean;
    this.h = System.currentTimeMillis();
  }
  
  private void a()
  {
    if (this.g.decrementAndGet() == 0)
    {
      Object localObject = this.f;
      long l1;
      if (localObject == null) {
        l1 = this.h;
      } else {
        l1 = ((n.c)localObject).a;
      }
      localObject = this.f;
      long l2;
      if (localObject == null) {
        l2 = System.currentTimeMillis();
      } else {
        l2 = ((n.c)localObject).b;
      }
      localObject = new d.a();
      ((d.a)localObject).a = this.a;
      String str = this.b;
      ((d.a)localObject).b = str;
      ((d.a)localObject).c = af.b(str).length();
      this.c.a((d.a)localObject, this.e, l1, l2, this.f);
    }
  }
  
  public void a(n.c paramc)
  {
    this.f = paramc;
    a();
  }
  
  public void a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(String paramString)
  {
    this.e = false;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.b.d
 * JD-Core Version:    0.7.0.1
 */