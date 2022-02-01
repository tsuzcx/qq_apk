package com.tencent.luggage.wxa.ls;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/EventOnInitialRenderingCacheReady$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatchReady", "", "content", "webviewData", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$a
{
  @JvmStatic
  public final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable u paramu)
  {
    Object localObject;
    if ((paramString1 != null) && (paramu != null))
    {
      localObject = (CharSequence)paramString2;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      localObject = null;
      if (i != 0) {
        paramString2 = (String)localObject;
      }
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      localObject = new a().a((c)paramu);
      HashMap localHashMap = new HashMap();
      localHashMap.put("content", paramString1);
      localHashMap.put("webviewData", paramString2);
      localHashMap.put("path", paramu.an());
      ((n)localObject).a((Map)localHashMap).a();
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2 = (String)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ls.a.a
 * JD-Core Version:    0.7.0.1
 */