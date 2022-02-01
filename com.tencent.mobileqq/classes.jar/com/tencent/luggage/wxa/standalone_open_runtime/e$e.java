package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$1$2", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$2"}, k=3, mv={1, 1, 16})
final class e$e
  extends Lambda
  implements Function3<Context, e, String, Boolean>
{
  e$e(e parame)
  {
    super(3);
  }
  
  public final boolean a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "<anonymous parameter 1>");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    paramContext = this.a.f();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "runtime");
    return (paramContext.i().a() & 32) <= 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.e
 * JD-Core Version:    0.7.0.1
 */