package com.tencent.luggage.wxa.mx;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.ju.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.gf.a
{
  private volatile boolean e;
  private e f;
  private int g;
  private SkiaCanvasView h;
  private a.a i;
  private List<com.tencent.luggage.wxa.fx.a> j = new ArrayList();
  private SurfaceTexture k;
  
  public a()
  {
    o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", new Object[] { SkiaCanvasView.version() });
  }
  
  private void a()
  {
    this.f.getAsyncHandler().post(new a.1(this));
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, Runnable paramRunnable)
  {
    if (paramc.getAsyncHandler().getLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    paramc.getAsyncHandler().post(paramRunnable);
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    this.g = paramJSONObject.optInt("viewId", 0);
    if (c.a(paramc) == null)
    {
      o.b("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "app is null, fail return");
      paramc.a(paramInt, paramm.b("fail"));
      return;
    }
    this.h = new SkiaCanvasView(c.a(paramc), this.k, paramc.getAppId(), this.g);
    this.f = ((e)paramc);
    this.i = new a.a(this.f);
    this.i.i = paramJSONObject.optString("data", "");
    this.i.h = paramJSONObject.optBoolean("gesture", false);
    paramc.a(paramInt, paramm.b("ok"));
  }
  
  private void b()
  {
    if (this.j.size() <= 0) {
      return;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      c((com.tencent.luggage.wxa.fx.a)localIterator.next());
    }
    this.j.clear();
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    if (this.h == null)
    {
      o.b("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
      paramc.a(paramInt, paramm.b("fail:internal error"));
      return;
    }
    c();
    paramc.a(paramInt, paramm.b("ok"));
  }
  
  private void c()
  {
    o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
    SkiaCanvasView localSkiaCanvasView = this.h;
    if (localSkiaCanvasView != null) {
      localSkiaCanvasView.recycle();
    }
  }
  
  private void c(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof b))
    {
      b localb = (b)parama;
      com.tencent.luggage.wxa.jx.c localc = localb.g();
      m localm = localb.k();
      JSONObject localJSONObject = localb.i();
      int m = localb.j();
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { A(), localm.d(), localJSONObject.toString() });
      a(localc, new a.2(this, localm, parama, localc, localJSONObject, m));
    }
  }
  
  private void c(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    if (this.h == null)
    {
      o.b("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
      paramc.a(paramInt, paramm.b("fail:internal error"));
      return;
    }
    paramc.a(paramInt, paramm.b("ok"));
  }
  
  private void d(com.tencent.luggage.wxa.fx.a parama)
  {
    parama.a(new a.3(this));
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", new Object[] { Integer.valueOf(this.g) });
    this.k = paramSurfaceTexture;
    if (this.e)
    {
      a();
      return;
    }
    b();
    this.e = true;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    o.f("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", new Object[] { paramMotionEvent });
    a.a locala = this.i;
    if (locala != null) {
      locala.a(paramMotionEvent);
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return true;
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    o.f("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", new Object[] { parama.e() });
    if (this.e) {
      c(parama);
    } else {
      this.j.add(parama);
    }
    return null;
  }
  
  public void d()
  {
    super.d();
    o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", new Object[] { Integer.valueOf(this.g) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.a
 * JD-Core Version:    0.7.0.1
 */