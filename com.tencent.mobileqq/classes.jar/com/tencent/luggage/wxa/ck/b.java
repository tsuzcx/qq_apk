package com.tencent.luggage.wxa.ck;

import com.tencent.luggage.ui.WxaPreviewImageUI;
import com.tencent.luggage.ui.WxaPreviewImageUI.a;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/media/JsApiPreviewImage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 30;
  @NotNull
  public static final String NAME = "previewImage";
  public static final b.a a = new b.a(null);
  
  public void a(@NotNull h paramh, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "env");
    if (paramJSONObject == null)
    {
      paramh.a(paramInt, b("fail:invalid data"));
      return;
    }
    Object localObject1 = paramJSONObject.optJSONArray("urls");
    if (localObject1 == null)
    {
      paramh.a(paramInt, b("fail:invalid data"));
      return;
    }
    String[] arrayOfString = new String[((JSONArray)localObject1).length()];
    int j = ((JSONArray)localObject1).length();
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((JSONArray)localObject1).optString(i);
      i += 1;
    }
    paramJSONObject = paramJSONObject.opt("current");
    if ((paramJSONObject instanceof Integer))
    {
      i = ((Number)paramJSONObject).intValue();
    }
    else if ((paramJSONObject instanceof String))
    {
      k = arrayOfString.length;
      j = 0;
      i = 0;
      while (j < k)
      {
        localObject1 = arrayOfString[j];
        if (Intrinsics.areEqual(paramJSONObject, localObject1)) {
          i = ArraysKt.indexOf(arrayOfString, localObject1);
        }
        j += 1;
      }
    }
    else
    {
      i = 0;
    }
    int k = arrayOfString.length;
    j = 0;
    while (j < k)
    {
      paramJSONObject = paramh.getFileSystem();
      Object localObject2 = null;
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.g(arrayOfString[j]);
      } else {
        paramJSONObject = null;
      }
      localObject1 = paramJSONObject;
      if (paramJSONObject == null)
      {
        localObject1 = paramh.getFileSystem();
        paramJSONObject = localObject2;
        if (localObject1 != null) {
          paramJSONObject = ((o)localObject1).d(arrayOfString[j]);
        }
        localObject1 = paramJSONObject;
      }
      if (localObject1 != null) {
        arrayOfString[j] = ((i)localObject1).l();
      }
      j += 1;
    }
    paramJSONObject = com.tencent.luggage.wxa.mn.a.a(arrayOfString);
    localObject1 = com.tencent.luggage.wxa.mn.a.a(paramJSONObject, arrayOfString);
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "converted");
    j = i;
    if (i >= paramJSONObject.length) {
      j = 0;
    }
    WxaPreviewImageUI.a.a(paramh.getContext(), new ArrayList((Collection)CollectionsKt.listOf((String[])Arrays.copyOf(paramJSONObject, paramJSONObject.length))), j, (LuggageActivityHelper.ActivityResultCallback)new b.b((String[])localObject1));
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ck.b
 * JD-Core Version:    0.7.0.1
 */