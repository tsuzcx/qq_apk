package com.tencent.luggage.wxa.kc;

import com.tencent.luggage.wxa.iu.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$b
{
  public static final b a = new b();
  private static final a.b.a b = new a.b.a();
  
  @JvmStatic
  @NotNull
  public static final a a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Object localObject = (a.c)paramb.a(a.c.class);
    if (localObject != null)
    {
      localObject = ((a.c)localObject).a(paramb);
      if (localObject != null) {
        return localObject;
      }
    }
    paramb = b.a(paramb);
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kc.a.b
 * JD-Core Version:    0.7.0.1
 */