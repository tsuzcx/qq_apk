package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$4$1", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$6"}, k=3, mv={1, 1, 16})
final class e$i
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$i(e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (c)this.a, 31, null, 0L, 0, 0, 60, null);
    paramContext = b.a;
    paramString = parame.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pageView.appId");
    paramContext.a(paramString, parame.getContext(), "sdk_openFeedback", (Function0)new e.i.1(parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.i
 * JD-Core Version:    0.7.0.1
 */