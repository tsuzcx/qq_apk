package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tgx;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lorg/json/JSONObject;", "callback", "", "invoke"}, k=3, mv={1, 1, 16})
public final class DeviceBridgeInvokeHandler$register$7
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  public DeviceBridgeInvokeHandler$register$7(tgx paramtgx)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.this$0.a().getRecommendFlag(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DeviceBridgeInvokeHandler.register.7
 * JD-Core Version:    0.7.0.1
 */