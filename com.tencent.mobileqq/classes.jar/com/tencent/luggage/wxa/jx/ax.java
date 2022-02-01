package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.jg;
import com.tencent.luggage.wxa.qw.jh;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ax
  extends a<h>
{
  public static final int CTRL_INDEX = 313;
  @NotNull
  public static final String NAME = "verifyPlugin";
  @Deprecated
  public static final ax.a a = new ax.a(null);
  
  public void a(@NotNull h paramh, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    if ((paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appId[");
      ((StringBuilder)localObject).append(paramh.getAppId());
      ((StringBuilder)localObject).append("] callbackId[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(']');
      localObject = ((StringBuilder)localObject).toString();
      jg localjg = new jg();
      localjg.a = paramh.getAppId();
      localjg.b = paramJSONObject.optString("data");
      paramJSONObject = (b)paramh.a(b.class);
      if (paramJSONObject != null)
      {
        paramJSONObject.b("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", localjg.a, (com.tencent.luggage.wxa.qu.a)localjg, jh.class).a((e.c)new ax.c(this, (String)localObject, paramh, paramInt));
        return;
      }
      ((Function0)new ax.b(this, (String)localObject, paramh, paramInt)).invoke();
      return;
    }
    paramh.a(paramInt, b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ax
 * JD-Core Version:    0.7.0.1
 */