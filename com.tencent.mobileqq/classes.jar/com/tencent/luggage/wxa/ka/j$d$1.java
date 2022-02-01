package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$d$1
  extends Lambda
  implements Function0<Unit>
{
  j$d$1(j.d paramd)
  {
    super(0);
  }
  
  public final void a()
  {
    j.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("response ok but data is NULL, appId[");
    localStringBuilder.append(this.a.b.getAppId());
    localStringBuilder.append("], callbackId[");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(']');
    o.b("Luggage.WXA.JsApiOperateWXDataLU", localStringBuilder.toString());
    this.a.b.a(this.a.c, this.a.a.b("fail invalid response"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.d.1
 * JD-Core Version:    0.7.0.1
 */