package com.tencent.luggage.wxa.nf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.ma.l;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.page.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  implements com.tencent.luggage.wxa.ge.b
{
  public static final String a = "MicroMsg.SameLayer.AppBrandVideoCustomHandler";
  @Nullable
  private com.tencent.luggage.wxa.oq.b b;
  private com.tencent.luggage.wxa.gd.d c;
  private com.tencent.luggage.wxa.ni.a d;
  private String e;
  private c.a f = new c.4(this);
  
  public c()
  {
    com.tencent.luggage.wxa.ng.c localc = (com.tencent.luggage.wxa.ng.c)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ng.c.class);
    if (localc != null) {
      this.b = localc.a();
    }
    this.d = new com.tencent.luggage.wxa.ni.a();
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bitmap recycle ");
      localStringBuilder.append(paramBitmap.toString());
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", localStringBuilder.toString());
      paramBitmap.recycle();
    }
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
    if (this.c == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      return;
    }
    paramd = (com.tencent.luggage.wxa.mu.a)paramd.c(com.tencent.luggage.wxa.mu.a.class);
    if (paramd == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
      return;
    }
    paramd.e(this.c);
  }
  
  private com.tencent.luggage.wxa.ge.e f()
  {
    com.tencent.luggage.wxa.gd.d locald = this.c;
    if (locald != null) {
      return locald.o();
    }
    return null;
  }
  
  public com.tencent.luggage.wxa.ge.f a()
  {
    return new g();
  }
  
  public com.tencent.luggage.wxa.mi.b a(com.tencent.luggage.wxa.fx.a parama, Handler paramHandler)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    h localh = (h)com.tencent.luggage.wxa.ba.e.a(h.class);
    if (localh == null) {
      paramHandler = new com.tencent.luggage.wxa.mi.d();
    } else {
      paramHandler = localh.a(parama, paramHandler);
    }
    long l2 = System.currentTimeMillis();
    this.d.a(f(), parama, paramHandler, l2 - l1);
    return paramHandler;
  }
  
  public b a(com.tencent.luggage.wxa.ge.a parama, com.tencent.luggage.wxa.fx.a parama1)
  {
    return new b(parama, parama1);
  }
  
  public String a(com.tencent.luggage.wxa.fx.a parama, String paramString)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return paramString;
    }
    if ((!af.c(paramString)) && (paramString.startsWith("cloud://"))) {
      return null;
    }
    parama = parama.g();
    if ((!af.c(paramString)) && (parama != null) && (parama.getFileSystem() != null) && (parama.getFileSystem().a(paramString)))
    {
      parama = parama.getFileSystem().g(paramString);
      if (parama != null)
      {
        paramString = new StringBuilder();
        paramString.append("file://");
        paramString.append(parama.l());
        paramString = paramString.toString();
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
      return paramString;
    }
    parama = paramString;
    if (!af.c(paramString))
    {
      parama = paramString;
      if (com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class) != null) {
        parama = ((com.tencent.luggage.wxa.ma.g)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class)).a(paramString);
      }
    }
    return parama;
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, @NonNull Bitmap paramBitmap)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return;
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      com.tencent.luggage.wxa.jx.c localc = parama.g();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(com.tencent.luggage.wxa.rc.b.a());
      ((StringBuilder)localObject).append(String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
      String str = ((StringBuilder)localObject).toString();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      try
      {
        com.tencent.luggage.wxa.qz.b.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
        localObject = new com.tencent.luggage.wxa.pc.i();
        if (localc.getFileSystem() != null)
        {
          if (localc.getFileSystem().a(new com.tencent.luggage.wxa.rt.i(str), "jpg", true, (com.tencent.luggage.wxa.pc.i)localObject) != j.a)
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
            parama.a("fail:snapshot error");
            return;
          }
          a(paramBitmap);
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, ((com.tencent.luggage.wxa.pc.i)localObject).a });
          paramBitmap = new HashMap();
          paramBitmap.put("tempImagePath", ((com.tencent.luggage.wxa.pc.i)localObject).a);
          paramBitmap.put("width", Integer.valueOf(i));
          paramBitmap.put("height", Integer.valueOf(j));
          parama.a("ok", paramBitmap);
          return;
        }
        parama.a("fail");
        return;
      }
      catch (IOException paramBitmap)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
        parama.a("fail:snapshot error");
        return;
      }
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
    parama.a("fail:snapshot error");
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    if ((parama != null) && (l.a(parama.a())))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      com.tencent.luggage.wxa.qy.a.a.a(new com.tencent.luggage.wxa.mg.a());
    }
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    this.d.a(f(), parama, paramb, paramInt1, paramInt2, paramString);
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb, long paramLong)
  {
    this.d.b(f(), parama, paramb, paramLong);
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb, String paramString)
  {
    long l;
    if (com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class) != null) {
      l = ((com.tencent.luggage.wxa.ma.g)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class)).a(paramString, 0L, 9223372036854775807L);
    } else {
      l = 0L;
    }
    if (l < 0L) {
      l = 0L;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l) });
    com.tencent.luggage.wxa.gd.d locald = this.c;
    if ((locald != null) && (locald.n() != null)) {
      this.c.n().a(l);
    }
    this.d.a(f(), parama, paramb, l, paramString);
  }
  
  public void a(com.tencent.luggage.wxa.gd.d paramd)
  {
    this.c = paramd;
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return false;
    }
    Object localObject = parama.d();
    com.tencent.luggage.wxa.jx.c localc = ((com.tencent.luggage.wxa.ju.b)parama).g();
    parama = null;
    if ((localc instanceof u)) {
      parama = (u)localc;
    } else if ((localc instanceof com.tencent.luggage.wxa.iu.h)) {
      parama = ((com.tencent.luggage.wxa.iu.h)localc).v();
    }
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      return false;
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0))
      {
        int i = 90;
        int j = ((JSONArray)localObject).optInt(0, 90);
        if (j != -90)
        {
          if (j == 0) {
            i = 0;
          }
        }
        else {
          i = -90;
        }
        parama.a(new c.1(this, parama, i));
        return true;
      }
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
    }
    return false;
  }
  
  public com.tencent.luggage.wxa.ge.e b()
  {
    return new f();
  }
  
  public void b(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    this.d.a(f(), parama, paramb);
  }
  
  public boolean b(com.tencent.luggage.wxa.fx.a parama)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return false;
    }
    com.tencent.luggage.wxa.jx.c localc = ((com.tencent.luggage.wxa.ju.b)parama).g();
    parama = null;
    if ((localc instanceof u)) {
      parama = (u)localc;
    } else if ((localc instanceof com.tencent.luggage.wxa.iu.h)) {
      parama = ((com.tencent.luggage.wxa.iu.h)localc).v();
    }
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
      return false;
    }
    parama.a(new c.2(this, parama));
    return true;
  }
  
  public com.tencent.luggage.wxa.ge.c c()
  {
    return new d();
  }
  
  public void c(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    this.d.b(f(), parama, paramb);
  }
  
  public boolean c(com.tencent.luggage.wxa.fx.a parama)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return false;
    }
    Object localObject = parama.d();
    com.tencent.luggage.wxa.jx.c localc = ((com.tencent.luggage.wxa.ju.b)parama).g();
    parama = null;
    if ((localc instanceof u)) {
      parama = (u)localc;
    } else if ((localc instanceof com.tencent.luggage.wxa.iu.h)) {
      parama = ((com.tencent.luggage.wxa.iu.h)localc).v();
    }
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
      return false;
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0))
      {
        float f1 = (float)((JSONArray)localObject).optDouble(0, -1.0D);
        if ((!Float.isNaN(f1)) && (f1 >= 0.0F))
        {
          if (f1 > 1.0F) {
            return false;
          }
          if ((parama.getContext() instanceof Activity))
          {
            t.a(new c.3(this, (Activity)parama.getContext(), f1));
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
      }
    }
    return false;
  }
  
  public com.tencent.luggage.wxa.ge.d d()
  {
    return new e();
  }
  
  public void d(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b))
    {
      com.tencent.luggage.wxa.jx.c localc = parama.g();
      this.e = localc.getAppId();
      parama = null;
      if ((localc instanceof com.tencent.luggage.wxa.iu.h)) {
        parama = ((com.tencent.luggage.wxa.iu.h)localc).q();
      } else if ((localc instanceof u)) {
        parama = ((u)localc).q();
      }
      if ((parama != null) && (!l.a(parama.aa())))
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
        parama.al().a(this.f);
      }
    }
  }
  
  public void d(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    this.d.c(f(), parama, paramb);
  }
  
  public com.tencent.luggage.wxa.ge.a e()
  {
    return new a();
  }
  
  public void e(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b))
    {
      com.tencent.luggage.wxa.jx.c localc = parama.g();
      parama = null;
      if ((localc instanceof com.tencent.luggage.wxa.iu.h)) {
        parama = ((com.tencent.luggage.wxa.iu.h)localc).q();
      } else if ((localc instanceof u)) {
        parama = ((u)localc).q();
      }
      if (parama != null)
      {
        if (!l.a(parama.aa()))
        {
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
          parama.al().b(this.f);
        }
        a(parama);
      }
    }
  }
  
  public void e(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    this.d.d(f(), parama, paramb);
  }
  
  @Nullable
  public String f(@NonNull com.tencent.luggage.wxa.fx.a parama)
  {
    parama = com.tencent.luggage.wxa.mu.b.a(parama);
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "getBanEnableBackgroundRunHint, runtime is null");
      return null;
    }
    parama = (com.tencent.luggage.wxa.nd.c)parama.c(com.tencent.luggage.wxa.nd.c.class);
    if (parama == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "getBanEnableBackgroundRunHint, helper is null");
      return null;
    }
    parama = parama.a();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "getBanEnableBackgroundRunHint, banHint: ", new Object[] { parama });
    return parama;
  }
  
  public void f(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.mi.b paramb)
  {
    this.d.e(f(), parama, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.c
 * JD-Core Version:    0.7.0.1
 */