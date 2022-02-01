package com.tencent.luggage.wxa.mg;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.ma.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements f.c
{
  private a a;
  private e b;
  private v c;
  private int d;
  
  public b(a parama, e parame)
  {
    this.a = parama;
    this.b = parame;
    this.b.a(this);
  }
  
  private void a(ah paramah, JSONObject paramJSONObject)
  {
    if ((!(paramah instanceof b.k)) && (!(paramah instanceof b.i))) {
      o.d("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramah.d() });
    }
    this.b.a(paramah.b(paramJSONObject.toString()), null);
  }
  
  private JSONObject h()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.a.getCookieData());
    return localJSONObject;
  }
  
  private void i()
  {
    if (this.c == null) {
      this.c = new v(new b.1(this), true);
    }
    this.c.a(250L);
  }
  
  private void j()
  {
    v localv = this.c;
    if (localv != null) {
      localv.c();
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      o.d("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d, duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = h();
      localJSONObject.put("buffered", paramInt1);
      localJSONObject.put("duration", paramInt2);
      a(new b.i(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate e=%s", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      o.d("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      JSONObject localJSONObject = h();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      double d1 = paramInt3;
      Double.isNaN(d1);
      d1 = d1 * 1.0D / 1000.0D;
      localJSONObject.put("duration", d1);
      a(new b.f(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      o.d("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramBoolean) });
      JSONObject localJSONObject = h();
      localJSONObject.put("showDanmu", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt);
      a(new b.b(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    try
    {
      o.d("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = h();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = h();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("url", paramString);
      a(new b.a(null), localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    b();
    try
    {
      JSONObject localJSONObject = h();
      localJSONObject.put("errMsg", paramString);
      a(new b.d(null), localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { paramString });
    }
  }
  
  public void b()
  {
    this.b.b(this);
    j();
  }
  
  public void c()
  {
    try
    {
      a(new b.c(null), h());
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { localJSONException });
    }
    j();
  }
  
  public void d()
  {
    o.e("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    b();
    this.a.setCallback(null);
  }
  
  public void e()
  {
    try
    {
      a(new b.g(null), h());
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { localJSONException });
    }
    j();
  }
  
  public void f()
  {
    try
    {
      this.d = 0;
      JSONObject localJSONObject = h();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new b.h(null), localJSONObject);
      i();
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { localJSONException });
    }
  }
  
  public void g()
  {
    try
    {
      JSONObject localJSONObject = h();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new b.l(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { localJSONException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mg.b
 * JD-Core Version:    0.7.0.1
 */