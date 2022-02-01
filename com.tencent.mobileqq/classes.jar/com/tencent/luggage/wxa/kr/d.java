package com.tencent.luggage.wxa.kr;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.jx.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 1, 16})
public final class d
  extends com.tencent.luggage.wxa.jx.a<c>
{
  public static final int CTRL_INDEX = 72;
  @NotNull
  public static final String NAME = "chooseContact";
  @Deprecated
  public static final d.a a = new d.a(null);
  
  public void a(@Nullable c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramc != null) && (paramJSONObject != null))
    {
      paramJSONObject = com.tencent.luggage.wxa.rc.a.a(paramc.getContext());
      if (paramJSONObject != null)
      {
        paramJSONObject = LuggageActivityHelper.FOR((Context)paramJSONObject);
        Intent localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("vnd.android.cursor.dir/phone_v2");
        paramJSONObject.startActivityForResult(localIntent, (LuggageActivityHelper.ActivityResultCallback)new d.c(this, paramc, paramInt));
        return;
      }
      ((Function0)new d.b(paramc, paramInt)).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.d
 * JD-Core Version:    0.7.0.1
 */