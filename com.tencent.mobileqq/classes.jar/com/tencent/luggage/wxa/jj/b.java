package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfigTrimHelper;", "", "()V", "TAG", "", "trimOffInjectConfigFields", "", "appId", "injectConfig", "Lorg/json/JSONObject;", "pruneWxConfigByPage", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  
  @JvmStatic
  public static final void a(@NotNull String paramString, @NotNull JSONObject paramJSONObject, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "injectConfig");
    long l1 = af.d();
    Object localObject = paramJSONObject.optJSONObject("tabBar");
    int j = 0;
    int k;
    int i;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if (localObject != null)
      {
        k = ((JSONArray)localObject).length();
        i = 0;
        while (i < k)
        {
          ((JSONArray)localObject).getJSONObject(i).remove("iconData");
          ((JSONArray)localObject).getJSONObject(i).remove("selectedIconData");
          i += 1;
        }
      }
    }
    localObject = paramJSONObject.optJSONArray("subPackages");
    if (localObject != null)
    {
      k = ((JSONArray)localObject).length();
      i = 0;
      while (i < k)
      {
        ((JSONArray)localObject).getJSONObject(i).remove("pages");
        i += 1;
      }
    }
    localObject = paramJSONObject.optJSONArray("subpackages");
    if (localObject != null)
    {
      k = ((JSONArray)localObject).length();
      i = j;
      while (i < k)
      {
        ((JSONArray)localObject).getJSONObject(i).remove("pages");
        i += 1;
      }
    }
    if (paramBoolean)
    {
      paramJSONObject.remove("page");
      paramJSONObject.remove("preloadRule");
    }
    paramJSONObject.remove("preloadResources");
    paramJSONObject.remove("preloadSubpackages");
    paramJSONObject.remove("manualSplashScreen");
    paramJSONObject.remove("useCommandBuffer");
    paramJSONObject.remove("permission");
    paramJSONObject.remove("navigateToMiniProgramAppIdList");
    long l2 = af.d();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("trimOffInjectConfigFields appId[");
    paramJSONObject.append(paramString);
    paramJSONObject.append("] cost[");
    paramJSONObject.append(l2 - l1);
    paramJSONObject.append("ms]");
    o.e("Luggage.WXA.AppBrandAppConfigTrimHelper", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.b
 * JD-Core Version:    0.7.0.1
 */