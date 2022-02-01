package com.tencent.luggage.wxa.ng;

import android.content.Context;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.fx.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$q$1
  extends Lambda
  implements Function0<Unit>
{
  h$q$1(h.q paramq)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject1 = h.e(this.a.a);
    if (localObject1 != null) {
      ((c)localObject1).a(7);
    }
    localObject1 = d.a(h.f(this.a.a)).aa();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://mp.weixin.qq.com/mp/readtemplate?t=weapp/airplay_intro_tmpl&appid=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = (b)e.a(b.class);
    if (localObject2 != null)
    {
      com.tencent.luggage.wxa.jx.c localc = h.f(this.a.a).g();
      Intrinsics.checkExpressionValueIsNotNull(localc, "invokeContext.component");
      Context localContext = h.f(this.a.a).b();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "invokeContext.context");
      ((b)localObject2).a(localc, (String)localObject1, localContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.q.1
 * JD-Core Version:    0.7.0.1
 */