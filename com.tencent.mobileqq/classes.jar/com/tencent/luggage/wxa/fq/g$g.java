package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.fv.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$g
  extends Lambda
  implements Function0<Unit>
{
  public static final g a = new g();
  
  g$g()
  {
    super(0);
  }
  
  public final void a()
  {
    g.a();
    o.d("Luggage.WxaApiImpl", "clearAuth success");
    a.c.a(true);
    Unit localUnit = Unit.INSTANCE;
    g.d.a(g.d.a, "clearAuth", true, null, 0, 12, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.g
 * JD-Core Version:    0.7.0.1
 */