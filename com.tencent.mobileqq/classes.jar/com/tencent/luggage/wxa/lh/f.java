package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.li.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  extends a<c>
{
  public static final int CTRL_INDEX = 788;
  @NotNull
  public static final String NAME = "isSupportNFC";
  public static final f.a a = new f.a(null);
  
  public void a(@Nullable c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null) {
      return;
    }
    paramJSONObject = (ab)e.a(ab.class);
    if ((paramJSONObject != null) && (!paramJSONObject.a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    if (d.c())
    {
      paramc.a(paramInt, b("ok"));
      return;
    }
    paramc.a(paramInt, a("fail", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13000)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.f
 * JD-Core Version:    0.7.0.1
 */