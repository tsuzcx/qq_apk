package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.jx.aa;
import com.tencent.luggage.wxa.jx.bb;
import com.tencent.luggage.wxa.jx.o;
import com.tencent.luggage.wxa.jx.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "pageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke"}, k=3, mv={1, 1, 16})
final class e$n
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  public static final n a = new n();
  
  e$n()
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    bb.a(bb.a, w.a, 0L, (aa)new e.n.1(parame), 2, null);
    paramContext = new o(true);
    int i = parame.getComponentId();
    parame = parame.i();
    Intrinsics.checkExpressionValueIsNotNull(parame, "pageView.service");
    paramContext.a(i, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.n
 * JD-Core Version:    0.7.0.1
 */