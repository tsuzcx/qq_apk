package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ae
  extends a<com.tencent.luggage.wxa.iu.b>
{
  @JvmField
  public static final int CTRL_INDEX = 410;
  @JvmField
  @NotNull
  public static final String NAME = "batchGetContact";
  @JvmField
  @NotNull
  public static final String a = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final ae.a b = new ae.a(null);
  
  static
  {
    NAME = "batchGetContact";
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramb != null)
    {
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONArray("appIds");
        if (paramJSONObject != null)
        {
          Object localObject1 = new LinkedList();
          int k = paramJSONObject.length();
          int i = 0;
          Object localObject2;
          Object localObject3;
          while (i < k)
          {
            localObject2 = paramJSONObject.optString(i);
            localObject3 = (CharSequence)localObject2;
            int j;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              j = 0;
            } else {
              j = 1;
            }
            if (j == 0) {
              ((LinkedList)localObject1).add(localObject2);
            }
            i += 1;
          }
          paramJSONObject = (JSONObject)localObject1;
          if (((LinkedList)localObject1).isEmpty()) {
            paramJSONObject = null;
          }
          if (paramJSONObject != null)
          {
            localObject1 = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "UUID.randomUUID().toString()");
            localObject2 = (com.tencent.luggage.wxa.ob.b)paramb.a(com.tencent.luggage.wxa.ob.b.class);
            if (localObject2 != null)
            {
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "env.customize(ICgiServic…iMsg.API_INTERNAL_ERROR))");
              localObject3 = new WeakReference(paramb);
              ae.h localh = new ae.h(this, (WeakReference)localObject3, paramInt, (String)localObject1);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Loader(");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(").load(), hostWxaAppId[");
              localStringBuilder.append(paramb.getAppId());
              localStringBuilder.append("], eventCallbackId[");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("] appIds[");
              localStringBuilder.append(StringUtils.join(paramJSONObject.iterator(), ","));
              localStringBuilder.append(']');
              o.d("Luggage.FULL.JsApiBatchGetContact", localStringBuilder.toString());
              paramb = paramb.getAppId();
              Intrinsics.checkExpressionValueIsNotNull(paramb, "env.appId");
              new ae.c(paramb, paramInt, (List)paramJSONObject, (com.tencent.luggage.wxa.ob.b)localObject2).a((Function1)new ae.d(paramInt, localh), (Function1)new ae.e(paramInt, localh, (WeakReference)localObject3, (String)localObject1), (Function0)new ae.f(paramInt, (WeakReference)localObject3, (String)localObject1), (Function1)new ae.g(this, paramInt, (WeakReference)localObject3));
              return;
            }
            paramb.a(paramInt, b("fail:internal error"));
            return;
          }
        }
        paramb.a(paramInt, b("fail:appIds is empty"));
        return;
      }
      paramb.a(paramInt, b("fail:invalid data"));
    }
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae
 * JD-Core Version:    0.7.0.1
 */