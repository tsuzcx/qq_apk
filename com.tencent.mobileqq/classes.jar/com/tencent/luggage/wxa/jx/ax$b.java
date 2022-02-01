package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ax$b
  extends Lambda
  implements Function0<Unit>
{
  ax$b(ax paramax, String paramString, h paramh, int paramInt)
  {
    super(0);
  }
  
  public final void a()
  {
    ax.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" NULL cgiService");
    o.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", localStringBuilder.toString());
    this.c.a(this.d, this.a.b("fail:internal error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ax.b
 * JD-Core Version:    0.7.0.1
 */