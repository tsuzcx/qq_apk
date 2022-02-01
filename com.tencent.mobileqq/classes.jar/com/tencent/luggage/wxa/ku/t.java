package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Reporter", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t
  extends a<u>
{
  public static final int CTRL_INDEX = -2;
  @NotNull
  public static final String NAME = "loadJsFiles";
  public static final t.a a = new t.a(null);
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull d paramd, @Nullable JSONArray paramJSONArray, @Nullable i parami, @Nullable h paramh, @Nullable String paramString, @Nullable t.b paramb)
  {
    a.a(paramd, paramJSONArray, parami, paramh, paramString, paramb);
  }
  
  public void a(@Nullable u paramu, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramu != null) && (paramJSONObject != null))
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("paths");
      paramJSONObject = paramJSONObject.optString("key");
      t.a locala = a;
      d locald = paramu.q();
      Intrinsics.checkExpressionValueIsNotNull(locald, "env.runtime");
      locala.a(locald, localJSONArray, paramu.getJsRuntime(), paramu.z(), paramJSONObject, (t.b)new t.c(this, paramu, localJSONArray, paramInt));
    }
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t
 * JD-Core Version:    0.7.0.1
 */