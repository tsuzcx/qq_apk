package com.tencent.luggage.wxa.eu;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class a$b
  implements Runnable
{
  a$b(c paramc, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  
  public final void a()
  {
    if (this.b[0].booleanValue()) {
      return;
    }
    Object localObject2 = this.a.getContentView();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup)localObject1;
    if (localObject1 != null)
    {
      localObject1 = a.a(a.a, (ViewGroup)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tryFastLoadEntryPage, show promptView, appId[");
      d locald = this.a.f();
      Intrinsics.checkExpressionValueIsNotNull(locald, "this.runtime");
      ((StringBuilder)localObject2).append(locald.aa());
      ((StringBuilder)localObject2).append(']');
      o.d("MicroMsg.MPEntryPageFastLoadHelper", ((StringBuilder)localObject2).toString());
      this.c[0] = localObject1;
      this.d[0] = Long.valueOf(af.b());
      this.a.X().a((View)localObject1);
      this.a.f().Q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.a.b
 * JD-Core Version:    0.7.0.1
 */