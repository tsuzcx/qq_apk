package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.ou.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "<anonymous parameter 2>", "", "invoke", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$1$1", "com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class e$d
  extends Lambda
  implements Function3<Context, e, String, Unit>
{
  e$d(com.tencent.luggage.wxa.fm.c paramc, e parame)
  {
    super(3);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull e parame, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(parame, "<anonymous parameter 1>");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    m.a(m.a, (com.tencent.luggage.wxa.em.c)this.b, 39, null, 0L, 0, 0, 60, null);
    parame = new com.tencent.luggage.wxa.cq.a();
    paramContext = this.b.f();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "runtime");
    parame.a(paramContext.j().E);
    parame.a_("");
    parame.c(this.b.ao());
    paramContext = this.b.r();
    if (paramContext != null) {
      paramContext = paramContext.getCurrentURL();
    } else {
      paramContext = null;
    }
    parame.d(paramContext);
    paramContext = this.b.f();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "runtime");
    parame.e(paramContext.j().F);
    if (this.a.f().b("enable_share_with_share_ticket")) {
      paramContext = "withShareTicket";
    } else {
      paramContext = "common";
    }
    parame.f(paramContext);
    parame.a(this.a.f().b("enable_share_dynamic"));
    parame.b((com.tencent.luggage.wxa.jx.c)this.b.i(), this.b.getComponentId()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.d
 * JD-Core Version:    0.7.0.1
 */