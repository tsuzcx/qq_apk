package com.tencent.luggage.wxa.mv;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.kp.f;
import com.tencent.luggage.wxa.mw.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.gf.a
{
  private static a.a h;
  private SurfaceTexture e;
  private f f;
  private com.tencent.luggage.wxa.jx.c g;
  private List<Runnable> i = new Vector();
  
  private void a()
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      ((SurfaceTexture)localObject1).release();
      this.e = null;
    }
    localObject1 = this.f;
    if (localObject1 == null)
    {
      o.c("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
      return;
    }
    Object localObject2 = this.g;
    if ((localObject2 instanceof e))
    {
      localObject2 = (e)localObject2;
      ((e)localObject2).b((f.d)localObject1);
      ((e)localObject2).b(this.f);
      ((e)localObject2).b(this.f);
    }
    this.f.g();
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    if (this.e == null)
    {
      o.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
      return;
    }
    Object localObject = paramc.getContext();
    this.f = ((f)h.a((Context)localObject));
    if ((paramc instanceof e))
    {
      localObject = (e)paramc;
      com.tencent.luggage.wxa.mw.b localb = (com.tencent.luggage.wxa.mw.b)paramm;
      localb.a((e)localObject, this.f, paramJSONObject, this.e);
      localb.a((e)localObject, this.f, new a.3(this, paramc, paramInt, paramm));
      paramc.a(new a.4(this, (e)localObject));
      parama.a(new a.5(this, (e)localObject, paramc, parama));
    }
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    if (((com.tencent.luggage.wxa.mw.c)paramm).a(paramc, this.f, paramJSONObject))
    {
      paramc.a(paramInt, paramm.b("ok"));
      return;
    }
    o.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
    paramc.a(paramInt, paramm.b("fail:internal error"));
  }
  
  private void a(e parame)
  {
    View localView = this.f.getView();
    if (parame.getCustomViewContainer().b().findViewById(localView.hashCode()) == null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(1, 1);
      localView.setId(localView.hashCode());
      parame.getCustomViewContainer().b().addView(localView, localLayoutParams);
    }
  }
  
  public static void a(a.a parama)
  {
    h = parama;
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, m paramm, int paramInt)
  {
    try
    {
      if (((d)paramm).a(paramc, this.f, paramJSONObject))
      {
        paramc.a(paramInt, paramm.b("ok"));
      }
      else
      {
        o.b("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
        paramc.a(paramInt, paramm.b("fail:internal error"));
      }
      return;
    }
    finally {}
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    this.e = paramSurfaceTexture;
    o.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", new Object[] { Integer.valueOf(this.i.size()) });
    paramSurfaceTexture = this.i.iterator();
    while (paramSurfaceTexture.hasNext()) {
      ((Runnable)paramSurfaceTexture.next()).run();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.f.a(paramMotionEvent);
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return true;
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b))
    {
      com.tencent.luggage.wxa.ju.b localb = (com.tencent.luggage.wxa.ju.b)parama;
      com.tencent.luggage.wxa.jx.c localc = localb.g();
      m localm = localb.k();
      JSONObject localJSONObject = localb.i();
      int j = localb.j();
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { A(), localm.d(), localJSONObject.toString() });
      localc.a(new a.2(this, localm, new a.1(this, localc, localm, parama, localJSONObject, j)));
    }
    return null;
  }
  
  public void d()
  {
    super.d();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mv.a
 * JD-Core Version:    0.7.0.1
 */