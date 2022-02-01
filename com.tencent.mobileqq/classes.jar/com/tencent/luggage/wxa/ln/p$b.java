package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.page.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class p$b
  implements Runnable
{
  p$b(p paramp, b paramb, String paramString, int paramInt) {}
  
  public final void run()
  {
    Object localObject = this.b.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "env.runtime");
    boolean bool = ((d)localObject).C().e(this.c);
    b localb = this.b;
    int i = this.d;
    p localp = this.a;
    if (bool) {
      localObject = "ok";
    } else {
      localObject = "fail";
    }
    localb.a(i, localp.b((String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.p.b
 * JD-Core Version:    0.7.0.1
 */