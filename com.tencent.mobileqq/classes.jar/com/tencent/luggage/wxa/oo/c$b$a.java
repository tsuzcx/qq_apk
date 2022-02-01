package com.tencent.luggage.wxa.oo;

import android.content.Context;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$b$a
  implements c.c
{
  @Nullable
  public c a(@NotNull b paramb, @NotNull c.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramd, "listener");
    Object localObject = paramb.q();
    if (localObject != null)
    {
      localObject = ((d)localObject).W();
      if (localObject != null) {}
    }
    else
    {
      localObject = paramb.y();
    }
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(component.runtime?.wind…omponent.windowAndroid)!!");
    boolean bool = ((com.tencent.luggage.wxa.oq.c)localObject).h_();
    Context localContext = paramb.getContext();
    if (localContext == null)
    {
      localContext = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
    }
    paramb = paramb.y();
    Intrinsics.checkExpressionValueIsNotNull(paramb, "component.windowAndroid");
    paramb = new f(localContext, paramb, paramd);
    if ((!bool) && (((com.tencent.luggage.wxa.oq.c)localObject).f())) {
      paramb.b(1);
    } else {
      paramb.b(2);
    }
    return (c)paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.c.b.a
 * JD-Core Version:    0.7.0.1
 */