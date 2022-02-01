package com.tencent.luggage.wxa.nf;

import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.s;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ju.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.ma.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.page.u;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements com.tencent.luggage.wxa.ge.d
{
  private com.tencent.luggage.wxa.gd.d a;
  private b b;
  private double c;
  private int d;
  private v e;
  private HandlerThread f;
  private String g;
  private volatile boolean h = false;
  @Nullable
  private com.tencent.luggage.wxa.gd.a i = null;
  @Nullable
  private s j = null;
  
  private void a(ah paramah, JSONObject paramJSONObject)
  {
    if (paramah != null)
    {
      if ((!(paramah instanceof e.j)) && (!(paramah instanceof e.h))) {
        o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramah.d(), paramJSONObject.toString() });
      }
      paramah = paramah.b(paramJSONObject.toString());
      paramJSONObject = this.b;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.g();
        if (paramJSONObject != null) {
          if ((paramJSONObject instanceof h))
          {
            paramJSONObject = (h)paramJSONObject;
            paramJSONObject.a(paramah, null);
            paramJSONObject = paramJSONObject.v();
            if (paramJSONObject != null) {
              paramJSONObject.a(paramah, null);
            }
          }
          else if ((paramJSONObject instanceof u))
          {
            paramJSONObject = (u)paramJSONObject;
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
  
  private void d()
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
    if (this.f == null)
    {
      this.f = com.tencent.luggage.wxa.sc.d.b("AppBrandVideoEventHandler_HandlerThread", 5);
      this.f.start();
    }
    if ((this.e == null) && (this.f != null))
    {
      o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
      this.e = new v(this.f.getLooper(), new e.1(this), true);
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((v)localObject).a(0L, 250L);
    }
    localObject = this.b;
    if ((localObject != null) && (l.a(((b)localObject).a())))
    {
      o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
      com.tencent.luggage.wxa.qy.a.a.a(new com.tencent.luggage.wxa.mg.a());
    }
  }
  
  private void e()
  {
    o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    v localv = this.e;
    if (localv != null) {
      localv.c();
    }
  }
  
  private JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.g);
    return localJSONObject;
  }
  
  private void g()
  {
    t.a(new e.2(this));
  }
  
  private void h()
  {
    t.a(new e.3(this));
  }
  
  private void i()
  {
    o.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
        if (localObject == null)
        {
          o.c("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
          return;
        }
        ((com.tencent.luggage.wxa.mu.a)localObject).c(this.a);
        return;
      }
    }
    o.c("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
  }
  
  private void j()
  {
    o.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
        if (localObject == null)
        {
          o.c("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
          return;
        }
        ((com.tencent.luggage.wxa.mu.a)localObject).d(this.a);
        return;
      }
    }
    o.c("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
  }
  
  public void a()
  {
    try
    {
      a(new e.b(null), f());
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
    }
    e();
    h();
    j();
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("buffered", paramInt);
      a(new e.h(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.h)
    {
      o.e("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
      return;
    }
    try
    {
      if (Math.abs(paramInt1 - this.d) < 250) {
        return;
      }
      if (this.i != null) {
        this.i.a(paramInt1, paramInt2);
      }
      this.d = paramInt1;
      double d1 = paramInt2;
      Double.isNaN(d1);
      d1 = d1 * 1.0D / 1000.0D;
      double d2 = paramInt1;
      Double.isNaN(d2);
      d2 = d2 * 1.0D / 1000.0D;
      d2 = new BigDecimal(d2).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = f();
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a(new e.j(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      double d1 = paramInt3;
      Double.isNaN(d1);
      d1 = d1 * 1.0D / 1000.0D;
      this.c = d1;
      localJSONObject.put("duration", this.c);
      a(new e.d(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("preloadSize", paramLong);
      a(new e.g(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", new Object[] { localJSONException });
    }
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof b)) {
      this.b = ((b)parama);
    }
  }
  
  public void a(@Nullable s params)
  {
    try
    {
      this.j = params;
      return;
    }
    finally
    {
      params = finally;
      throw params;
    }
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.gd.a parama)
  {
    try
    {
      this.i = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(com.tencent.luggage.wxa.gd.d paramd)
  {
    this.a = paramd;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    e();
    h();
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new e.c(null), localJSONObject);
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
    }
    j();
    paramString = this.j;
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = false;
    try
    {
      this.d = 0;
      JSONObject localJSONObject = f();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new e.f(null), localJSONObject);
      d();
      g();
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
    }
    i();
    s locals = this.j;
    if (locals != null) {
      locals.a(paramBoolean);
    }
  }
  
  public void b()
  {
    this.h = true;
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new e.k(null), localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
    }
    s locals = this.j;
    if (locals != null) {
      locals.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.h = false;
    Object localObject = this.e;
    if (((localObject == null) || (((v)localObject).d())) && (this.a != null))
    {
      o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
      a(this.a.m(), (int)(this.c * 1000.0D));
    }
    try
    {
      localObject = f();
      ((JSONObject)localObject).put("position", paramInt);
      a(new e.i(null), (JSONObject)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", new Object[] { localJSONException });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      a(new e.e(null), f());
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
    }
    e();
    h();
    j();
    s locals = this.j;
    if (locals != null)
    {
      if (!paramBoolean)
      {
        locals.c();
        return;
      }
      locals.e();
    }
  }
  
  public void c()
  {
    e();
    HandlerThread localHandlerThread = this.f;
    if (localHandlerThread != null)
    {
      localHandlerThread.quit();
      this.f = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = f();
      localJSONObject.put("playInBackground", paramBoolean);
      a(new e.a(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", new Object[] { localJSONException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.e
 * JD-Core Version:    0.7.0.1
 */