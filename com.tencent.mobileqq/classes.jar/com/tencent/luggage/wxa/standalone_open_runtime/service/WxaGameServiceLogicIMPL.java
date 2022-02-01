package com.tencent.luggage.wxa.standalone_open_runtime.service;

import com.tencent.luggage.standalone_ext.service.b;
import com.tencent.luggage.wxa.fc.g;
import com.tencent.luggage.wxa.jx.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaGameServiceLogicIMPL;", "Lcom/tencent/luggage/standalone_ext/service/MGameServiceLogic;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "service", "(Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;)V", "onCreateJsApiPool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "createForGame", "Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/WxaJsApiPool;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class WxaGameServiceLogicIMPL
  extends b<a>
{
  public WxaGameServiceLogicIMPL(@NotNull a parama)
  {
    super((com.tencent.luggage.wxa.du.c)parama);
  }
  
  private final Map<String, m> a(@NotNull g paramg)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramg.b());
    localHashMap.putAll(paramg.a());
    localHashMap.putAll(new com.tencent.luggage.wxa.bn.c().a());
    return (Map)localHashMap;
  }
  
  @NotNull
  protected Map<String, m> E()
  {
    return a(g.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.service.WxaGameServiceLogicIMPL
 * JD-Core Version:    0.7.0.1
 */