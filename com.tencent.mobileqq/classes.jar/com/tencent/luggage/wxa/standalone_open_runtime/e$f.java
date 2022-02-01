package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.cq.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.ou.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$2$1", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$3"}, k=3, mv={1, 1, 16})
final class e$f
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$f(e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "<anonymous parameter 1>");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (com.tencent.luggage.wxa.em.c)this.a, 41, null, 0L, 0, 0, 60, null);
    paramContext = new b();
    paramContext.a(this.a.aD());
    paramContext.b_(this.a.ao());
    paramContext.b((com.tencent.luggage.wxa.jx.c)this.a.i(), this.a.getComponentId()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.f
 * JD-Core Version:    0.7.0.1
 */