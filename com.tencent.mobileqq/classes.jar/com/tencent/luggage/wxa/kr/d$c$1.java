package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$c$1
  extends Lambda
  implements Function0<Unit>
{
  d$c$1(d.c paramc)
  {
    super(0);
  }
  
  public final void a()
  {
    d.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult appId[");
    localStringBuilder.append(this.a.b.getAppId());
    localStringBuilder.append("] NULL contactUri");
    o.b("Luggage.Common.JsApiChooseContactNew", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.d.c.1
 * JD-Core Version:    0.7.0.1
 */