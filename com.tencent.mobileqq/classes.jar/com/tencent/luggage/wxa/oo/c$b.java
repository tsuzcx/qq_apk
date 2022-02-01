package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.iu.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$b
{
  public static final b a = new b();
  private static final c.b.a b = new c.b.a();
  
  @JvmStatic
  @NotNull
  public static final c a(@NotNull b paramb, @NotNull c.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramd, "listener");
    Object localObject = (c.c)paramb.a(c.c.class);
    if (localObject != null)
    {
      localObject = ((c.c)localObject).a(paramb, paramd);
      if (localObject != null) {
        return localObject;
      }
    }
    paramb = b.a(paramb, paramd);
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.c.b
 * JD-Core Version:    0.7.0.1
 */