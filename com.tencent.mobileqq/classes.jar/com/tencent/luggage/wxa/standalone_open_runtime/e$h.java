package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.setting.ui.WxaSettingActivity;
import com.tencent.luggage.setting.ui.WxaSettingActivity.d;
import com.tencent.luggage.wxa.ef.b;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.ou.m;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$3$1", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$5"}, k=3, mv={1, 1, 16})
final class e$h
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$h(e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "<anonymous parameter 1>");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (com.tencent.luggage.wxa.em.c)this.a, 30, null, 0L, 0, 0, 60, null);
    paramContext = this.a.getContext();
    parame = this.a.getAppId();
    paramString = b.a(this.a);
    if (paramString != null)
    {
      WxaSettingActivity.a(paramContext, parame, ((com.tencent.luggage.wxa.do.c)paramString).b, b.a(this.a).E, false, (WxaSettingActivity.d)new e.h.1(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.h
 * JD-Core Version:    0.7.0.1
 */