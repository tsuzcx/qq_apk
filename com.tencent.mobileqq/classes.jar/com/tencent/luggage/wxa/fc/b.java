package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.opensdk.i;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/JsApiNavigateToMiniProgramBridged;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "BridgedPageContainer", "BridgedPageRenderer", "BridgedRuntimeConfigAssembler", "BridgedRuntimeInitConfig", "BridgedWxaRuntime", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = -2;
  @NotNull
  public static final String NAME = "sdk_navigateToMiniProgram";
  public static final b.f a = new b.f(null);
  
  public void a(@NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    boolean bool = i.a.a("sdk_navigateToMiniProgram");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("invoke appId:");
    ((StringBuilder)localObject1).append(paramb.getAppId());
    ((StringBuilder)localObject1).append(", callbackId:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", isWechatSupported:");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(", data:");
    ((StringBuilder)localObject1).append(paramJSONObject.toString());
    o.d("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", ((StringBuilder)localObject1).toString());
    if (!bool)
    {
      paramb.a(paramInt, b("fail wechat not support"));
      com.tencent.luggage.wxa.fh.a.a.a(paramb, 2131889045);
      return;
    }
    localObject1 = paramb.q();
    if (localObject1 != null) {
      localObject1 = ((d)localObject1).af();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof e)) {
      localObject2 = null;
    }
    localObject1 = (e)localObject2;
    if (localObject1 != null) {
      paramb.a((Runnable)new b.g(this, (e)localObject1, paramb, paramJSONObject.optString("appId"), paramInt, paramJSONObject));
    }
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b
 * JD-Core Version:    0.7.0.1
 */