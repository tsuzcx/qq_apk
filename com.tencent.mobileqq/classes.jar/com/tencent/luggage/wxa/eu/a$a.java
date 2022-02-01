package com.tencent.luggage.wxa.eu;

import android.view.View;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.jx.f.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.ui.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onReady"}, k=3, mv={1, 1, 16})
final class a$a
  implements f.g
{
  a$a(c paramc, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
  
  public final void a()
  {
    this.b[0] = Boolean.valueOf(true);
    Object localObject1;
    if (this.c[0].longValue() > 0L)
    {
      long l = this.c[0].longValue();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
      localObject2 = this.a.f();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "this.runtime");
      ((StringBuilder)localObject1).append(((d)localObject2).aa());
      ((StringBuilder)localObject1).append("], time diff: ");
      ((StringBuilder)localObject1).append(af.b() - l);
      o.d("MicroMsg.MPEntryPageFastLoadHelper", ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.d[0];
    if (localObject2 != null)
    {
      a.a((View)localObject2);
      localObject1 = localObject2;
      if (!(localObject2 instanceof ThreeDotsLoadingView)) {
        localObject1 = null;
      }
      localObject1 = (ThreeDotsLoadingView)localObject1;
      if (localObject1 != null) {
        ((ThreeDotsLoadingView)localObject1).stopLoadingAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.a.a
 * JD-Core Version:    0.7.0.1
 */