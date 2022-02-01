package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"}, k=1, mv={1, 1, 16})
public final class v
{
  public static final v a = new v();
  
  @JvmStatic
  @Nullable
  public static final s.f a(@Nullable String paramString)
  {
    label141:
    int i;
    label146:
    do
    {
      try
      {
        localObject = (CharSequence)paramString;
        if (localObject == null) {
          break label146;
        }
        if (((CharSequence)localObject).length() != 0) {
          break label141;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        s.f localf;
        return null;
      }
      localObject = new JSONObject(paramString);
      localf = new s.f();
      localf.a = 0;
      localf.h = s.g.a(((JSONObject)localObject).optString("module_list"));
      localf.m = s.h.a(((JSONObject)localObject).optString("widget_list"));
      localf.i = (af.a(localf.h) ^ true);
      if (localf.i) {
        paramString = ((JSONObject)localObject).optString("entrance_module");
      } else {
        paramString = "";
      }
      localf.j = paramString;
      localf.f = s.d.a(localf.m, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
      localf.k = ((JSONObject)localObject).optString("client_js_ext_info");
      return localf;
      i = 0;
      continue;
      i = 1;
    } while (i == 0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.v
 * JD-Core Version:    0.7.0.1
 */