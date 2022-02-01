package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ju.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "()V", "mEventData", "", "mInvokeContext", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "mLastUpdatePos", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "getBaseEventData", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "onVideoTimeUpdate", "currentPosition", "duration", "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "Companion", "OnXWebCastingInterrupt", "OnXWebCastingUserSelect", "OnXWebVideoEnded", "OnXWebVideoError", "OnXWebVideoLoadedMetaData", "OnXWebVideoPause", "OnXWebVideoPlay", "OnXWebVideoPreloadedMetaData", "OnXWebVideoProgress", "OnXWebVideoTimeUpdate", "OnXWebVideoWaiting", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  implements com.tencent.luggage.wxa.ge.a
{
  public static final a.a a = new a.a(null);
  private static final String e = "MicroMsg.SameLayer.AppBrandVideoCastEventHandler";
  private int b;
  private String c = "";
  private b d;
  
  private final void a(ah paramah, JSONObject paramJSONObject)
  {
    if (paramah != null)
    {
      if ((!(paramah instanceof a.h)) && (!(paramah instanceof a.g))) {
        o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "dispatch event:%s, data:%s", new Object[] { paramah.d(), paramJSONObject.toString() });
      }
      paramah = paramah.b(paramJSONObject.toString());
      paramJSONObject = this.d;
      if (paramJSONObject != null)
      {
        if (paramJSONObject == null) {
          Intrinsics.throwNpe();
        }
        paramJSONObject = paramJSONObject.g();
        if (paramJSONObject != null) {
          if ((paramJSONObject instanceof h))
          {
            paramJSONObject = (h)paramJSONObject;
            if (paramah == null) {
              Intrinsics.throwNpe();
            }
            paramJSONObject.a(paramah, null);
            paramJSONObject = paramJSONObject.v();
            if (paramJSONObject != null) {
              paramJSONObject.a(paramah, null);
            }
          }
          else if ((paramJSONObject instanceof u))
          {
            paramJSONObject = (u)paramJSONObject;
            if (paramah == null) {
              Intrinsics.throwNpe();
            }
            paramJSONObject.a(paramah, null);
            paramJSONObject = paramJSONObject.p();
            if (paramJSONObject != null) {
              paramJSONObject.a(paramah, null);
            }
          }
          else
          {
            paramJSONObject.a(paramah, null);
          }
        }
      }
    }
  }
  
  private final JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.c);
    return localJSONObject;
  }
  
  public void a()
  {
    try
    {
      this.b = 0;
      JSONObject localJSONObject = f();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((ah)new a.f(), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVideoProgress: ");
    ((StringBuilder)localObject).append(paramInt);
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", ((StringBuilder)localObject).toString());
    try
    {
      localObject = f();
      ((JSONObject)localObject).put("buffered", paramInt);
      ((JSONObject)localObject).put("type", "DLNA");
      a((ah)new a.g(), (JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVideoTimeUpdate: currentPosition = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" duration = ");
    ((StringBuilder)localObject).append(paramInt2);
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", ((StringBuilder)localObject).toString());
    try
    {
      if (Math.abs(paramInt1 - this.b) < 250) {
        return;
      }
      this.b = paramInt1;
      double d1 = paramInt2;
      Double.isNaN(d1);
      double d2 = 1000;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      double d3 = paramInt1;
      Double.isNaN(d3);
      Double.isNaN(d2);
      d2 = d3 * 1.0D / d2;
      d2 = new BigDecimal(d2).setScale(3, 4).doubleValue();
      localObject = f();
      ((JSONObject)localObject).put("type", "DLNA");
      ((JSONObject)localObject).put("position", d2);
      ((JSONObject)localObject).put("duration", d1);
      a((ah)new a.h(), (JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.fx.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "invokeContext");
    if ((parama instanceof b)) {
      this.d = ((b)parama);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "success";
    } else {
      str = "fail";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onXWebDLNACastingStateChange: status = ");
    ((StringBuilder)localObject).append(str);
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", ((StringBuilder)localObject).toString());
    try
    {
      localObject = f();
      ((JSONObject)localObject).put("status", str);
      a((ah)new a.j(), (JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebDLNACastingStateChange fail", new Object[] { localJSONException });
    }
  }
  
  public void b()
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoPause: ");
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("type", "DLNA");
      a((ah)new a.e(), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingUserSelect: ");
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = f();
        localJSONObject.put("type", "DLNA");
        if (paramBoolean)
        {
          String str1 = "success";
          localJSONObject.put("state", str1);
          a((ah)new a.c(), localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebCastingUserSelect fail", new Object[] { localJSONException });
        return;
      }
      String str2 = "fail";
    }
  }
  
  public void c()
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoEnded: ");
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("type", "DLNA");
      a((ah)new a.d(), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
    }
  }
  
  public void d()
  {
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((ah)new a.i(), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
    }
  }
  
  public void e()
  {
    try
    {
      JSONObject localJSONObject = f();
      a((ah)new a.b(), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingInterrupt fail", new Object[] { localJSONException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.a
 * JD-Core Version:    0.7.0.1
 */