package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$8$3", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$11"}, k=3, mv={1, 1, 16})
final class e$l
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$l(com.tencent.luggage.wxa.nv.c paramc, e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (com.tencent.luggage.wxa.em.c)this.b, 33, null, 0L, 0, 0, 60, null);
    paramContext = this.a;
    paramString = this.b.getContext();
    parame = (u)parame;
    String str = this.b.getAppId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(r.a().getString(2131886786));
    localStringBuilder.append('@');
    localStringBuilder.append(r.c());
    paramContext.a(paramString, parame, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.l
 * JD-Core Version:    0.7.0.1
 */