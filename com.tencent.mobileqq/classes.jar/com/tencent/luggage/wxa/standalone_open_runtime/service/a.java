package com.tencent.luggage.wxa.standalone_open_runtime.service;

import com.tencent.luggage.wxa.dq.b.a;
import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.jx.c.b;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.standalone_open_runtime.b;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "Lcom/tencent/luggage/standalone_ext/service/AppService;", "logic", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandLogicImpComponentType$AppBrandLogicImpComponentTypeService;", "(Lcom/tencent/luggage/sdk/jsapi/component/AppBrandLogicImpComponentType$AppBrandLogicImpComponentTypeService;)V", "logicImpl", "Ljava/lang/Class;", "Lcom/tencent/luggage/sdk/jsapi/component/service/BaseAppBrandServiceLogic;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "(Ljava/lang/Class;)V", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "onInit", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class a
  extends com.tencent.luggage.standalone_ext.service.a
{
  public static final a.a c = new a.a(null);
  
  public a(@NotNull b.a parama)
  {
    super(parama);
  }
  
  public a(@NotNull Class<? extends com.tencent.luggage.wxa.du.e<? extends com.tencent.luggage.wxa.du.c>> paramClass)
  {
    super(paramClass);
  }
  
  public void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    super.a(paramJSONObject);
    b.a.a(paramJSONObject);
  }
  
  protected void m()
  {
    super.m();
    d locald = x();
    if (locald != null)
    {
      a((c.b)new com.tencent.luggage.wxa.ff.c((com.tencent.luggage.wxa.fk.e)locald, (h)this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.service.a
 * JD-Core Version:    0.7.0.1
 */