package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$e$a
  extends Lambda
  implements Function0<Unit>
{
  d$e$a(d.e parame)
  {
    super(0);
  }
  
  public final void a()
  {
    d.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cgiExecutor.onSuccess get NULL normal item with ");
    localStringBuilder.append(d.e(this.a.a));
    o.b("MicroMsg.AppBrand.CommonPkgFetcher", localStringBuilder.toString());
    d.b(this.a.a).invoke(j.a.b, "get invalid url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.e.a
 * JD-Core Version:    0.7.0.1
 */