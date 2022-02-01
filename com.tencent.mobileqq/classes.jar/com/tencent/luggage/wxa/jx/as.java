package com.tencent.luggage.wxa.jx;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiReturnCopyUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class as
  extends a<c>
{
  public static final int CTRL_INDEX = 755;
  @NotNull
  public static final String NAME = "returnCopyUrl";
  public static final as.a a = new as.a(null);
  
  public void a(@Nullable c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc != null)
    {
      Object localObject1;
      if (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.optString("url");
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      int i = 1;
      if ((paramJSONObject != null) && (paramJSONObject.optBoolean("shortLinkEnable", false) == true)) {
        bb.a.a(w.a, (String)localObject1);
      } else {
        bb.a.a(w.b, (String)localObject1);
      }
      Object localObject2 = r.a().getSystemService("clipboard");
      paramJSONObject = (JSONObject)localObject2;
      if (!(localObject2 instanceof ClipboardManager)) {
        paramJSONObject = null;
      }
      paramJSONObject = (ClipboardManager)paramJSONObject;
      if (paramJSONObject != null)
      {
        localObject1 = (CharSequence)localObject1;
        localObject2 = ClipData.newPlainText(null, (CharSequence)localObject1);
        ClipboardMonitor.setPrimaryClip(paramJSONObject, (ClipData)localObject2);
        paramJSONObject.setPrimaryClip((ClipData)localObject2);
        if (((CharSequence)localObject1).length() != 0) {
          i = 0;
        }
        if (i != 0) {
          paramJSONObject = "fail:empty url";
        } else {
          paramJSONObject = "ok";
        }
        paramc.a(paramInt, b(paramJSONObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.as
 * JD-Core Version:    0.7.0.1
 */