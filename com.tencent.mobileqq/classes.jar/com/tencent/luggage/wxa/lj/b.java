package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.lk.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public abstract class b
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final b.a a = new b.a(null);
  private final String b;
  private final String c;
  private final String d;
  private final Function1<Object, Object> e;
  
  public b(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull Function1<Object, ? extends Object> paramFunction1)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramFunction1;
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
      return;
    }
    paramJSONObject = (ab)e.a(ab.class);
    if ((paramJSONObject != null) && (!paramJSONObject.a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
      paramc.a(paramInt, b("fail:unknown"));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke, appId: ");
    localStringBuilder.append(paramc.getAppId());
    o.d("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", localStringBuilder.toString());
    paramJSONObject.a(this.b, this.c, null, (Function1)new b.b(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.b
 * JD-Core Version:    0.7.0.1
 */