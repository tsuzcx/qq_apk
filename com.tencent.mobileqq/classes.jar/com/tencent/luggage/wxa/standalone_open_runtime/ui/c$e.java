package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$e
  extends Lambda
  implements Function0<Unit>
{
  c$e(c paramc, e parame)
  {
    super(0);
  }
  
  public final void a()
  {
    WxaProfileActivity.Companion localCompanion = WxaProfileActivity.Companion;
    Context localContext = c.a(this.a);
    String str = this.b.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(str, "page.appId");
    localCompanion.show(localContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.c.e
 * JD-Core Version:    0.7.0.1
 */