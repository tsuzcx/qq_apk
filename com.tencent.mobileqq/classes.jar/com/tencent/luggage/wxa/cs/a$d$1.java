package com.tencent.luggage.wxa.cs;

import com.tencent.luggage.wxa.iu.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/luggage/jsapi/version/JsApiUpdateApp$invoke$1$3$1"}, k=3, mv={1, 1, 16})
final class a$d$1
  extends Lambda
  implements Function0<Unit>
{
  a$d$1(a.d paramd)
  {
    super(0);
  }
  
  public final void a()
  {
    b localb = this.a.d;
    if (localb != null) {
      localb.a(this.a.e, this.a.c.b("fail sync error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cs.a.d.1
 * JD-Core Version:    0.7.0.1
 */