package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qw.es;
import com.tencent.luggage.wxa.qw.md;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createRequest", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataRequest;", "invoke"}, k=3, mv={1, 1, 16})
final class j$b
  extends Lambda
  implements Function0<es>
{
  j$b(j paramj, b paramb, String paramString)
  {
    super(0);
  }
  
  @NotNull
  public final es a()
  {
    es locales = new es();
    locales.a = this.b.getAppId();
    locales.b = this.a.a(this.c);
    d locald = this.b.q();
    Intrinsics.checkExpressionValueIsNotNull(locald, "service.runtime");
    locales.e = locald.ab();
    locales.f = this.a.a(new md(), (h)this.b);
    return locales;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.b
 * JD-Core Version:    0.7.0.1
 */