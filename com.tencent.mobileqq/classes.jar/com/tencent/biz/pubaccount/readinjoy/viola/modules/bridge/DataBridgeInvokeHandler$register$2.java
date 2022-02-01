package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tgs;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lorg/json/JSONObject;", "callback", "", "invoke"}, k=3, mv={1, 1, 16})
public final class DataBridgeInvokeHandler$register$2
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  public DataBridgeInvokeHandler$register$2(tgs paramtgs)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.this$0.a().getUserInfo(paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.register.2
 * JD-Core Version:    0.7.0.1
 */