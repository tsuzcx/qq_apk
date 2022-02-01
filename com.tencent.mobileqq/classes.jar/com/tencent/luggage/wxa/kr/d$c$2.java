package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$c$2
  extends Lambda
  implements Function0<Unit>
{
  d$c$2(d.c paramc)
  {
    super(0);
  }
  
  public final void a()
  {
    d.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult appId[");
    localStringBuilder.append(this.a.b.getAppId());
    localStringBuilder.append("] NULL ContentResolver");
    o.b("Luggage.Common.JsApiChooseContactNew", localStringBuilder.toString());
    this.a.b.a(this.a.c, this.a.a.b("fail:internal error invalid android context"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.d.c.2
 * JD-Core Version:    0.7.0.1
 */