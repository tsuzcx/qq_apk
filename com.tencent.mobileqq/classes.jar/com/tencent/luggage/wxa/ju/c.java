package com.tencent.luggage.wxa.ju;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public abstract class c
  extends a
{
  public int a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return -1;
    }
    return paramJSONObject.optInt("viewId", -1);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
      return;
    }
    int i = a(paramJSONObject);
    if (i == -1)
    {
      o.c("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
      paramc.a(paramInt, b("fail:no viewId in data"));
      return;
    }
    boolean bool = paramc instanceof u;
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = paramc.getJsRuntime();
    }
    else
    {
      if ((paramc instanceof h))
      {
        localObject1 = ((h)paramc).v();
        if (localObject1 != null)
        {
          localObject1 = ((u)localObject1).getJsRuntime();
          break label105;
        }
      }
      localObject1 = null;
    }
    label105:
    if (b(paramc, paramJSONObject, paramInt)) {
      return;
    }
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = (com.tencent.luggage.wxa.fx.b)((i)localObject1).a(com.tencent.luggage.wxa.fx.b.class);
    }
    if (localObject1 == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
      paramc.a(paramInt, b("fail:invalid runtime"));
      return;
    }
    Object localObject1 = ((com.tencent.luggage.wxa.fx.b)localObject1).getWebViewPluginClientProxy();
    if (localObject1 == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
      paramc.a(paramInt, b("fail:webview has no plugin client"));
      return;
    }
    paramc = new b(paramInt, paramJSONObject, paramc, this);
    ((com.tencent.luggage.wxa.gg.c)localObject1).a(c(), i, paramc);
  }
  
  protected boolean b(@NonNull com.tencent.luggage.wxa.jx.c paramc, @NonNull JSONObject paramJSONObject, int paramInt)
  {
    return false;
  }
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ju.c
 * JD-Core Version:    0.7.0.1
 */