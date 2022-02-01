package com.tencent.luggage.wxa.standalone_open_runtime.service;

import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService$Companion;", "", "()V", "TAG", "", "createForApp", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "createForGame", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$a
{
  @NotNull
  public final a a()
  {
    try
    {
      Class localClass = Class.forName("com.tencent.luggage.wxa.standalone_open_runtime.service.WxaGameServiceLogicIMPL");
      if (localClass != null) {
        return new a(localClass);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out com.tencent.luggage.sdk.jsapi.component.service.BaseAppBrandServiceLogic<out com.tencent.luggage.sdk.jsapi.component.service.AppBrandServiceLU>>");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label29:
      break label29;
    }
    throw ((Throwable)new RuntimeException("Check your proguard config pls, you should keep 'com.tencent.luggage.wxa.standalone_open_runtime.service.WxaGameServiceLogicIMPL' for mini-game support."));
  }
  
  @NotNull
  public final a b()
  {
    return new a(c.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.service.a.a
 * JD-Core Version:    0.7.0.1
 */