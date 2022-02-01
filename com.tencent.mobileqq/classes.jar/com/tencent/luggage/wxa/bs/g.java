package com.tencent.luggage.wxa.bs;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

public class g
  implements com.tencent.luggage.wxa.oi.b, com.tencent.luggage.wxa.oi.d, e.a
{
  private final u a;
  private String b;
  private boolean c = false;
  private boolean d = false;
  
  g(@NonNull u paramu, String paramString)
  {
    this.a = paramu;
    this.b = paramString;
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(e.a parama)
  {
    if (this.d)
    {
      o.c("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", new Object[] { this.a.getAppId() });
      return;
    }
    if ((this.a.y() != null) && (this.a.y().getOrientationHandler() != null))
    {
      if (this.a.q().aT())
      {
        o.h("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
        if (parama != null) {
          parama.a(null, false);
        }
        return;
      }
      e.b localb = e.b.a(this.b);
      o.h("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", new Object[] { this.a.getAppId(), localb });
      if (localb != null) {
        this.a.y().getOrientationHandler().a(localb, new g.1(this, parama));
      }
      return;
    }
    if (parama != null) {
      parama.a(null, false);
    }
  }
  
  public void a(@Nullable e.b paramb, boolean paramBoolean)
  {
    if (paramb == null) {
      paramb = "null";
    } else {
      paramb = paramb.name();
    }
    o.d("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", new Object[] { paramb, Boolean.valueOf(paramBoolean) });
  }
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public void a(@Nullable String paramString)
  {
    o.b("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation not support for game, appId[%s]", new Object[] { this.a.getAppId() });
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.c = true;
    if ((this.a.af() != null) && (this.a.af().d())) {
      this.a.af().a(new g.2(this));
    } else {
      a(null);
    }
    a(null);
  }
  
  public void d()
  {
    this.c = false;
  }
  
  public void e()
  {
    this.c = false;
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.g
 * JD-Core Version:    0.7.0.1
 */