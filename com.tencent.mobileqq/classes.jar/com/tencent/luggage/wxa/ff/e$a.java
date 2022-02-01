package com.tencent.luggage.wxa.ff;

import com.tencent.luggage.wxa.fj.c;
import com.tencent.luggage.wxa.fq.g.c;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class e$a
  implements Runnable
{
  e$a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, String paramString4, String paramString5, int paramInt4, com.tencent.luggage.wxa.fk.e parame, String paramString6, long paramLong) {}
  
  public final void run()
  {
    c localc = new c(null, null, null, 0, null, 0, 0, null, 0, 0, 0, null, 0L, 0, 16383, null);
    localc.a(g.c.a.a());
    localc.b(this.a);
    localc.c(this.b);
    localc.a(this.c);
    localc.d(this.d);
    localc.b(this.e);
    localc.c(this.f);
    localc.e(this.g);
    CharSequence localCharSequence1 = (CharSequence)this.h;
    CharSequence localCharSequence2 = (CharSequence)"ok";
    int m = 2;
    if (StringsKt.contains$default(localCharSequence1, localCharSequence2, false, 2, null)) {
      m = 1;
    } else if (StringsKt.contains$default((CharSequence)this.h, (CharSequence)"cancel", false, 2, null)) {
      m = 3;
    }
    localc.d(m);
    localc.e(this.i);
    localc.f(0);
    localc.f(this.h);
    localc.a(g.c.a.b());
    localc.g(553976065);
    localc.a();
    e.a(e.a, this.j, this.a, this.b, this.g, this.k, this.i, this.l, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.e.a
 * JD-Core Version:    0.7.0.1
 */