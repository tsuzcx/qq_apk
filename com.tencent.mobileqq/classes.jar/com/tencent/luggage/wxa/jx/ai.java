package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.util.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetAppContact;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ai
  extends a<h>
{
  public static final int CTRL_INDEX = 927;
  @NotNull
  public static final String NAME = "getAppContact";
  public static final ai.a a = new ai.a(null);
  
  @ExperimentalContracts
  public void a(@Nullable h paramh, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((paramh != null) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.optString("keyPath");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("keyPath=");
      ((StringBuilder)localObject1).append(paramJSONObject);
      Log.i("JsApiGetAppContact", ((StringBuilder)localObject1).toString());
      localObject1 = u.a().b(paramh.getAppId(), new String[0]);
      if (localObject1 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "keyPath");
        localObject2 = StringsKt.split$default((CharSequence)paramJSONObject, new String[] { "." }, false, 0, 6, null);
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = new JSONObject(((s)localObject1).f());
        Iterator localIterator = ((List)localObject2).iterator();
        localObject2 = null;
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label355;
        }
        localObject1 = (String)localIterator.next();
        if (paramJSONObject == null)
        {
          paramJSONObject = (JSONObject)localObject2;
        }
        else
        {
          if (!paramJSONObject.has((String)localObject1)) {
            break label344;
          }
          paramJSONObject = paramJSONObject.opt((String)localObject1);
          if (paramJSONObject == null) {
            break label338;
          }
          break label332;
          if (!(localObject1 instanceof JSONObject)) {
            break label350;
          }
          paramJSONObject = (JSONObject)localObject1;
          continue;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("next=");
        if (c.a(paramJSONObject)) {
          localObject1 = "is null";
        } else {
          localObject1 = String.valueOf(paramJSONObject);
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.i("JsApiGetAppContact", ((StringBuilder)localObject2).toString());
        if (paramJSONObject == null)
        {
          paramh.a(paramInt, b("fail: keyPath not found"));
          return;
        }
        localObject1 = new HashMap();
        ((Map)localObject1).put("data", paramJSONObject);
        paramh.a(paramInt, a("ok", (Map)localObject1));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("JsApiGetAppContact", paramJSONObject.getMessage());
        paramh.a(paramInt, b("fail:internal error"));
      }
      return;
      for (;;)
      {
        label332:
        localObject1 = paramJSONObject;
        break;
        label338:
        paramJSONObject = "";
      }
      label344:
      localObject1 = null;
      continue;
      label350:
      paramJSONObject = null;
      continue;
      label355:
      paramJSONObject = (JSONObject)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ai
 * JD-Core Version:    0.7.0.1
 */