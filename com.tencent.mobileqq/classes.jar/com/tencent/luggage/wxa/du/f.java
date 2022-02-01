package com.tencent.luggage.wxa.du;

import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/service/EventOnSubPackageReady;", "", "moduleName", "", "(Ljava/lang/String;)V", "TAG", "getModuleName", "()Ljava/lang/String;", "dispatch", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "toEventJSONObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  private final String a;
  @NotNull
  private final String b;
  
  public f(@NotNull String paramString)
  {
    this.b = paramString;
    this.a = "Luggage.FULL.EventOnSubPackageReady";
  }
  
  private final JSONObject a(@NotNull WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("plugin_id", paramWxaPluginPkgInfo.provider);
    localJSONObject.put("custom_version", paramWxaPluginPkgInfo.stringVersion);
    localJSONObject.put("prefix_path", paramWxaPluginPkgInfo.prefixPath);
    localJSONObject.put("inner_version", paramWxaPluginPkgInfo.version);
    return localJSONObject;
  }
  
  public final void a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    try
    {
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("moduleName", this.b);
      localObject1 = (d)paramh.b(d.class);
      if (localObject1 == null) {
        break label263;
      }
      localObject1 = ((d)localObject1).S;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        Object localObject4;
        continue;
        Object localObject2 = null;
      }
    }
    localObject1 = ((af)localObject1).f;
    if (localObject1 != null)
    {
      localObject4 = ((ai)localObject1).a(this.b);
      if (localObject4 != null)
      {
        localObject1 = new JSONArray();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((JSONArray)localObject1).put(a((WxaPluginPkgInfo)((Iterator)localObject4).next()));
        }
        ((JSONObject)localObject3).put("separatedPlugins", localObject1);
      }
    }
    localObject1 = ((JSONObject)localObject3).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "try {\n            JSONOb…         return\n        }");
    localObject3 = this.a;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("dispatch appId(");
    ((StringBuilder)localObject4).append(paramh.getAppId());
    ((StringBuilder)localObject4).append(") onSubPackageReady(");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(')');
    o.d((String)localObject3, ((StringBuilder)localObject4).toString());
    paramh.b("onSubPackageReady", (String)localObject1);
    return;
    localObject1 = this.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("dispatch with service(");
    ((StringBuilder)localObject3).append(paramh.getAppId());
    ((StringBuilder)localObject3).append("), create data failed");
    o.b((String)localObject1, ((StringBuilder)localObject3).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.f
 * JD-Core Version:    0.7.0.1
 */