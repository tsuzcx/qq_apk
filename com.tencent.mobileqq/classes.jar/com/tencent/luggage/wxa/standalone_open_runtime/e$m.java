package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.ed.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke"}, k=3, mv={1, 1, 16})
final class e$m
  extends Lambda
  implements Function3<Context, e, String, Boolean>
{
  public static final m a = new m();
  
  e$m()
  {
    super(3);
  }
  
  public final boolean a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    if (parame.u())
    {
      paramContext = parame.f();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "pageView.runtime");
      paramContext.j().I = "";
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.m
 * JD-Core Version:    0.7.0.1
 */