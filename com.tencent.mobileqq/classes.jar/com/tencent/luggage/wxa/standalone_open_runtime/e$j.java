package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$5$2", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$7"}, k=3, mv={1, 1, 16})
final class e$j
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$j(e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (c)this.a, 40, null, 0L, 0, 0, 60, null);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(a.class, parame.getAppId());
    paramContext = parame.getAppId();
    paramString = new StringBuilder();
    paramString.append("Network:");
    paramString.append(x.b(r.a()));
    com.tencent.mm.plugin.appbrand.keylogger.d.a(a.class, paramContext, paramString.toString());
    paramContext = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "pageView.runtime");
    paramContext.j().I = ((String)null);
    parame.f().aE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.j
 * JD-Core Version:    0.7.0.1
 */