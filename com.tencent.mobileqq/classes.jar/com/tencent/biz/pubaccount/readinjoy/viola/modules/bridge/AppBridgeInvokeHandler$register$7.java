package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tgp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "param", "Lorg/json/JSONObject;", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class AppBridgeInvokeHandler$register$7
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  public AppBridgeInvokeHandler$register$7(tgp paramtgp)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.this$0.a().downloadApkPause(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.AppBridgeInvokeHandler.register.7
 * JD-Core Version:    0.7.0.1
 */