package com.tencent.luggage.wxa.cw;

import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qw.cq;
import com.tencent.luggage.wxa.qw.cr;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/werun/JsApiOpenWeRunSetting;", "Lcom/tencent/luggage/opensdk/OpenSDKBridgedJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends f<h>
{
  private static final int CTRL_INDEX = 228;
  @NotNull
  public static final String NAME = "openWeRunSetting";
  public static final a.a a = new a.a(null);
  
  public void a(@Nullable h paramh, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramh != null)
    {
      Object localObject = (com.tencent.luggage.wxa.ob.b)paramh.a(com.tencent.luggage.wxa.ob.b.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.wxa.ob.b)localObject).b("/cgi-bin/mmoc-bin/hardware/getwerunuserstate", paramh.getAppId(), (com.tencent.luggage.wxa.qu.a)new cq(), cr.class);
        if (localObject != null)
        {
          paramJSONObject = ((d)localObject).b((com.tencent.luggage.wxa.rl.b)new a.b(this, paramh, paramInt, paramJSONObject));
          if ((paramJSONObject != null) && (paramJSONObject.a((e.a)new a.c(this, paramh, paramInt)) != null)) {
            return;
          }
        }
      }
      ((Function0)new a.d(this, paramh, paramInt)).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cw.a
 * JD-Core Version:    0.7.0.1
 */