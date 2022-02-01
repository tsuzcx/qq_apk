package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tgp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "param", "Lorg/json/JSONObject;", "callback", "", "invoke"}, k=3, mv={1, 1, 16})
public final class AppBridgeInvokeHandler$register$4
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  public AppBridgeInvokeHandler$register$4(tgp paramtgp)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    String str2 = null;
    BridgeModule localBridgeModule = this.this$0.a();
    if (paramJSONObject != null) {}
    for (String str1 = paramJSONObject.optString("schema");; str1 = null)
    {
      if (paramJSONObject != null) {
        str2 = paramJSONObject.optString("sourceId");
      }
      localBridgeModule.openApp(str1, paramString, str2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.4
 * JD-Core Version:    0.7.0.1
 */