package com.tencent.luggage.wxa.jx;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.c.c;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.ui.h.a;
import com.tencent.mm.plugin.appbrand.ui.h.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class aj
  extends u<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean a = false;
  
  private Map<String, Object> a(Rect paramRect)
  {
    paramRect.left = g.a(paramRect.left);
    paramRect.top = g.a(paramRect.top);
    paramRect.right = g.a(paramRect.right);
    paramRect.bottom = g.a(paramRect.bottom);
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("left", Integer.valueOf(paramRect.left));
    localHashMap.put("top", Integer.valueOf(paramRect.top));
    localHashMap.put("right", Integer.valueOf(paramRect.right));
    localHashMap.put("bottom", Integer.valueOf(paramRect.bottom));
    localHashMap.put("width", Integer.valueOf(paramRect.width()));
    localHashMap.put("height", Integer.valueOf(paramRect.height()));
    return localHashMap;
  }
  
  private Map<String, Object> a(@NonNull com.tencent.mm.plugin.appbrand.page.u paramu)
  {
    Object localObject = new int[2];
    paramu.ah().getCapsuleView().getLocationInWindow((int[])localObject);
    int i = paramu.ah().getCapsuleView().getWidth();
    int j = paramu.ah().getCapsuleView().getHeight();
    int k = localObject[1];
    int m = localObject[0];
    if ((m != 0) && (i != 0))
    {
      localObject = a(new Rect(m, k, m + i, j + k));
      o.d("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { paramu.getAppId(), localObject });
      return localObject;
    }
    o.b("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { paramu.getAppId() });
    return null;
  }
  
  private int b(@NonNull com.tencent.luggage.wxa.iu.h paramh)
  {
    paramh = paramh.y().getStatusBar();
    if ((paramh != null) && (8 != paramh.b)) {
      return paramh.a;
    }
    return 0;
  }
  
  private Map<String, Object> c(@NonNull com.tencent.luggage.wxa.iu.h paramh)
  {
    Object localObject2 = a(paramh);
    if (localObject2 == null)
    {
      o.b("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { paramh.getAppId() });
      return null;
    }
    int n = b(paramh);
    Object localObject1 = ((com.tencent.mm.plugin.appbrand.ui.h)localObject2).b();
    localObject2 = ((com.tencent.mm.plugin.appbrand.ui.h)localObject2).a();
    int m = com.tencent.luggage.wxa.pd.w.a(paramh)[0];
    int j = ((h.b)localObject1).a();
    int k = ((h.b)localObject1).b();
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((h.a)localObject2).b();
    }
    n += i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((h.a)localObject2).c();
    }
    int i = m - i;
    localObject1 = a(new Rect(i - j, n, i, k + n));
    o.d("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { paramh.getAppId(), localObject1 });
    return localObject1;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.h a(@NonNull com.tencent.luggage.wxa.iu.h paramh)
  {
    return (com.tencent.mm.plugin.appbrand.ui.h)paramh.a(com.tencent.mm.plugin.appbrand.ui.h.class);
  }
  
  public String a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject)
  {
    Object localObject2 = bd.a(paramb);
    paramJSONObject = null;
    Object localObject1 = null;
    if (localObject2 != null) {
      try
      {
        localObject2 = a((com.tencent.mm.plugin.appbrand.page.u)localObject2);
        paramJSONObject = (JSONObject)localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          paramJSONObject = (JSONObject)localObject2;
          if (a)
          {
            localObject1 = localObject2;
            c(bd.b(paramb));
            paramJSONObject = (JSONObject)localObject2;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        o.b("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { paramJSONObject });
        paramJSONObject = (JSONObject)localObject1;
      }
    }
    localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = c(bd.b(paramb));
    }
    if (localObject1 != null) {
      return a("ok", (Map)localObject1);
    }
    return b("fail:internal error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.aj
 * JD-Core Version:    0.7.0.1
 */