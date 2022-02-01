package com.tencent.luggage.wxa.nb;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  implements com.tencent.luggage.wxa.gb.a
{
  private com.tencent.luggage.wxa.ga.a a;
  private com.tencent.luggage.wxa.ju.b b;
  private String c;
  private boolean d = false;
  private volatile boolean e = false;
  private c.a f = new a.3(this);
  
  private void b(@NonNull d paramd)
  {
    o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
    if (this.d)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
      return;
    }
    if (this.a == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      return;
    }
    paramd = (com.tencent.luggage.wxa.mu.a)paramd.c(com.tencent.luggage.wxa.mu.a.class);
    if (paramd == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
      return;
    }
    paramd.e(this.a);
  }
  
  private void c()
  {
    o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
    if (this.d)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
      return;
    }
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
        if (localObject == null)
        {
          o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
          return;
        }
        ((com.tencent.luggage.wxa.mu.a)localObject).c(this.a);
        return;
      }
    }
    o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
  }
  
  private void d()
  {
    o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
    if (this.d)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
      return;
    }
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = com.tencent.luggage.wxa.fy.e.a((com.tencent.luggage.wxa.fx.a)localObject);
        if (localObject == null)
        {
          o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
          return;
        }
        ((com.tencent.luggage.wxa.mu.a)localObject).d(this.a);
        return;
      }
    }
    o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
  }
  
  private com.tencent.luggage.wxa.na.e e(com.tencent.luggage.wxa.fx.a parama)
  {
    parama = com.tencent.luggage.wxa.mu.b.a(parama);
    if (parama != null) {
      return (com.tencent.luggage.wxa.na.e)parama.c(com.tencent.luggage.wxa.na.e.class);
    }
    return null;
  }
  
  public com.tencent.luggage.wxa.gb.b a()
  {
    return new b();
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onXWebLivePlayerEvent, errCode: ");
    paramBundle.append(paramInt2);
    o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", paramBundle.toString());
    if (this.e)
    {
      o.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      return;
    }
    if (paramInt2 != -2301) {
      if (paramInt2 != 2004)
      {
        if (paramInt2 == 2006) {}
      }
      else
      {
        c();
        return;
      }
    }
    d();
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, Bundle paramBundle)
  {
    parama = com.tencent.luggage.wxa.mu.b.a(parama);
    if (parama != null)
    {
      this.c = parama.aa();
      parama.al().a(this.f);
      a(parama, paramBundle);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ga.a parama)
  {
    this.a = parama;
  }
  
  public void a(d paramd)
  {
    if (paramd != null)
    {
      paramd = (com.tencent.luggage.wxa.na.e)paramd.c(com.tencent.luggage.wxa.na.e.class);
      if (paramd != null)
      {
        paramd.d(this.a);
        return;
      }
      o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    }
  }
  
  public void a(d paramd, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isVoip", false))
    {
      this.d = true;
      if (paramd != null)
      {
        paramBundle = (com.tencent.luggage.wxa.na.e)paramd.c(com.tencent.luggage.wxa.na.e.class);
        if (paramBundle == null)
        {
          o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
          paramBundle = new com.tencent.luggage.wxa.na.e();
          paramd.a(paramBundle);
          paramBundle.c(this.a);
          return;
        }
        paramBundle.c(this.a);
      }
    }
    else
    {
      this.d = false;
      o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
    }
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
    } else if ((localc instanceof h)) {
      parama = ((h)localc).v();
    }
    if (parama == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      return false;
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0))
      {
        int j = ((JSONArray)localObject).optInt(0, 0);
        int i = 90;
        if (j != -90)
        {
          if (j == 0) {
            i = 0;
          }
        }
        else {
          i = -90;
        }
        parama.a(new a.1(this, parama, i));
        return true;
      }
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
    }
    return false;
  }
  
  public boolean a(com.tencent.luggage.wxa.ga.a parama, com.tencent.luggage.wxa.fx.a parama1, int paramInt)
  {
    parama1 = e(parama1);
    if (parama1 != null) {
      return parama1.a(parama, paramInt);
    }
    o.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    return false;
  }
  
  public com.tencent.luggage.wxa.gb.c b()
  {
    return new com.tencent.luggage.wxa.na.c();
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
    } else if ((localc instanceof h)) {
      parama = ((h)localc).v();
    }
    if (parama == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
      return false;
    }
    parama.a(new a.2(this, parama));
    return true;
  }
  
  public void c(com.tencent.luggage.wxa.fx.a parama)
  {
    parama = com.tencent.luggage.wxa.mu.b.a(parama);
    if (parama != null)
    {
      parama.al().b(this.f);
      a(parama);
      b(parama);
    }
    this.e = true;
  }
  
  public void d(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b)) {
      this.b = ((com.tencent.luggage.wxa.ju.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.a
 * JD-Core Version:    0.7.0.1
 */