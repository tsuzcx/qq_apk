package com.tencent.luggage.wxa.kc;

import android.content.Context;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.phonenumber.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$b$a
  implements a.c
{
  @Nullable
  public a a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Object localObject1 = paramb.getContext();
    if (localObject1 == null)
    {
      localObject1 = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "MMApplicationContext.getContext()");
    }
    Object localObject2 = paramb.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "component.appId");
    c localc = paramb.y();
    Intrinsics.checkExpressionValueIsNotNull(localc, "component.windowAndroid");
    localObject2 = new w((Context)localObject1, (String)localObject2, localc);
    localObject1 = paramb.q();
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).W();
      if (localObject1 != null)
      {
        paramb = (b)localObject1;
        break label92;
      }
    }
    paramb = paramb.y();
    label92:
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramb, "(component.runtime?.wind…omponent.windowAndroid)!!");
    if ((!paramb.h_()) && (paramb.f())) {
      ((w)localObject2).b(1);
    }
    return (a)localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kc.a.b.a
 * JD-Core Version:    0.7.0.1
 */