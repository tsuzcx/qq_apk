package com.tencent.luggage.wxa.nd;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.na.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import org.json.JSONObject;

public class a
  implements com.tencent.luggage.wxa.gc.a
{
  private boolean a = true;
  private volatile boolean b = false;
  @Nullable
  private d c = null;
  @Nullable
  private i.a d = null;
  
  private e a(com.tencent.luggage.wxa.fx.a parama)
  {
    parama = com.tencent.luggage.wxa.mu.b.a(parama);
    if (parama != null) {
      return (e)parama.c(e.class);
    }
    return null;
  }
  
  private void c()
  {
    if ((this.b) && (this.a))
    {
      d();
      return;
    }
    e();
  }
  
  private void d()
  {
    if (this.d != null)
    {
      o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
      return;
    }
    if (this.c != null)
    {
      o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
      this.d = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.a(this.c).a(com.tencent.mm.plugin.appbrand.page.capsulebar.a.b.c);
    }
  }
  
  private void e()
  {
    if (this.d != null)
    {
      o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
      this.d.a();
      this.d = null;
    }
  }
  
  public com.tencent.luggage.wxa.gc.b a()
  {
    return new b();
  }
  
  public String a(com.tencent.luggage.wxa.fx.a parama, Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isVoip", false))
    {
      parama = com.tencent.luggage.wxa.mu.b.a(parama);
      if (parama != null)
      {
        parama = (c)parama.c(c.class);
        if (parama != null)
        {
          parama = parama.a();
          o.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          return parama;
        }
      }
    }
    else
    {
      o.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not voip mode");
    }
    return null;
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.gc.a.a parama1)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return;
    }
    parama = (com.tencent.luggage.wxa.ju.b)parama;
    Object localObject = parama.d();
    String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (af.c(str))
    {
      o.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      return;
    }
    com.tencent.luggage.wxa.na.b.a(parama.g(), str, (String)localObject, new a.1(this, parama1, str));
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, String paramString1, String paramString2, com.tencent.luggage.wxa.gc.a.a parama1)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return;
    }
    parama = (com.tencent.luggage.wxa.ju.b)parama;
    if (af.c(paramString1))
    {
      o.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      return;
    }
    com.tencent.luggage.wxa.na.b.a(parama.g(), paramString1, paramString2, new a.2(this, parama1, paramString1));
  }
  
  public void a(com.tencent.luggage.wxa.fx.a parama, String paramString1, String paramString2, boolean paramBoolean, com.tencent.luggage.wxa.gc.a.b paramb)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b))
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
      if (paramb != null) {
        paramb.a(paramString1);
      }
      return;
    }
    if (af.c(paramString1))
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
      if (paramb != null) {
        paramb.a(paramString1);
      }
      return;
    }
    parama = parama.g();
    if (parama == null)
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
      if (paramb != null) {
        paramb.a(paramString1);
      }
      return;
    }
    com.tencent.luggage.wxa.na.b.a(parama, paramString1, paramBoolean, paramString2, new a.3(this, paramb, paramString1));
  }
  
  public void a(j paramj, com.tencent.luggage.wxa.fx.a parama)
  {
    parama = a(parama);
    if (parama != null)
    {
      parama.b(paramj);
      return;
    }
    o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
  }
  
  public void a(j paramj, com.tencent.luggage.wxa.fx.a parama, Bundle paramBundle)
  {
    this.a = paramBundle.getBoolean("enableMic", this.a);
    c();
    int i = 0;
    if (paramBundle.getBoolean("isVoip", false))
    {
      e locale = a(parama);
      paramBundle = locale;
      if (locale == null)
      {
        o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
        paramBundle = new e();
        i = 1;
        com.tencent.luggage.wxa.mu.b.a(parama).a(paramBundle);
      }
      paramBundle.a(paramj);
      paramBundle.a(com.tencent.luggage.wxa.mu.b.a(parama), this.a);
      if ((i != 0) && (this.b))
      {
        o.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
        paramBundle.a(com.tencent.luggage.wxa.mu.b.a(parama), paramj);
      }
    }
    else
    {
      o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
    }
  }
  
  public boolean a(j paramj, com.tencent.luggage.wxa.fx.a parama, int paramInt)
  {
    parama = a(parama);
    if (parama != null) {
      return parama.a(paramj, paramInt);
    }
    o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    return false;
  }
  
  public com.tencent.luggage.wxa.gc.c b()
  {
    return new com.tencent.luggage.wxa.na.c();
  }
  
  public void b(com.tencent.luggage.wxa.fx.a parama, com.tencent.luggage.wxa.gc.a.a parama1)
  {
    if (!(parama instanceof com.tencent.luggage.wxa.ju.b)) {
      return;
    }
    com.tencent.luggage.wxa.ju.b localb = (com.tencent.luggage.wxa.ju.b)parama;
    String str = localb.d().optString("url");
    if (af.c(str))
    {
      o.c("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.a("fail:invalid data");
      return;
    }
    com.tencent.luggage.wxa.na.b.a(localb.g(), str, null, new a.4(this, parama1, str));
  }
  
  public void b(j paramj, com.tencent.luggage.wxa.fx.a parama)
  {
    this.b = false;
    c();
    e locale = a(parama);
    if (locale != null)
    {
      parama = com.tencent.luggage.wxa.mu.b.a(parama);
      if (parama != null)
      {
        locale.b(parama, paramj);
        parama.b(locale);
      }
    }
    else
    {
      o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    }
  }
  
  public void b(j paramj, com.tencent.luggage.wxa.fx.a parama, Bundle paramBundle)
  {
    this.a = paramBundle.getBoolean("enableMic", this.a);
    c();
    paramj = a(parama);
    if (paramj != null)
    {
      paramj.a(com.tencent.luggage.wxa.mu.b.a(parama), this.a);
      return;
    }
    o.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nd.a
 * JD-Core Version:    0.7.0.1
 */