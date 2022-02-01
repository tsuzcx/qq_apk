package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", "errorCode", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$a
{
  public final void a(@NotNull c paramc, @NotNull d paramd, int paramInt1, @NotNull String paramString, @Nullable Map<String, ? extends Object> paramMap, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "service");
    Intrinsics.checkParameterIsNotNull(paramd, "jsapi");
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    Map localMap = (Map)new LinkedHashMap();
    if ((paramInt2 != -1) && (paramInt2 != 0)) {
      localMap.put("errCode", Integer.valueOf(paramInt2));
    }
    if (paramMap != null) {
      localMap.putAll(paramMap);
    }
    paramd = paramd.a(paramString, localMap);
    paramString = new StringBuilder();
    paramString.append("[callbackJsApi] return json:");
    paramString.append(paramd);
    o.d("JsApiRequestSubscribeMessage", paramString.toString());
    paramc.a(paramInt1, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.d.a
 * JD-Core Version:    0.7.0.1
 */