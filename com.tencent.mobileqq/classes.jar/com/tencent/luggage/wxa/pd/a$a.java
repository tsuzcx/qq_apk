package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 1, 16})
public final class a$a
  implements j.a
{
  @NotNull
  public a b(@Nullable e parame)
  {
    if (parame != null)
    {
      parame = parame.getContext();
      if (parame != null) {}
    }
    else
    {
      parame = r.a();
      Intrinsics.checkExpressionValueIsNotNull(parame, "MMApplicationContext.getContext()");
    }
    return new a(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.a.a
 * JD-Core Version:    0.7.0.1
 */