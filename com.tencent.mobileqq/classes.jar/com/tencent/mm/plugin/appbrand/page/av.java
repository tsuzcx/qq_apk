package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qz.af;
import java.util.Locale;
import java.util.Map;

public final class av
  implements com.tencent.luggage.wxa.oi.b, com.tencent.luggage.wxa.oi.d
{
  private final u a;
  private final com.tencent.luggage.wxa.ds.e b;
  private volatile String c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private Configuration h;
  private av.a i;
  
  av(@NonNull u paramu)
  {
    this.a = paramu;
    this.b = new com.tencent.luggage.wxa.ds.e(paramu);
    this.a.ag().addOnLayoutChangeListener(new av.1(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if ((!this.f) && (this.g))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", new Object[] { this.a.getAppId(), this.a.an(), Boolean.valueOf(this.e) });
      f();
      this.g = false;
    }
  }
  
  private void f()
  {
    h localh = this.a.p();
    if (localh == null) {
      return;
    }
    if (this.e) {
      return;
    }
    this.b.a(localh);
  }
  
  private String g()
  {
    return this.a.getAppId();
  }
  
  private String h()
  {
    return this.a.an();
  }
  
  private boolean i()
  {
    Object localObject;
    if (this.a.y() == null) {
      localObject = null;
    } else {
      localObject = this.a.y().getOrientationHandler();
    }
    if ((localObject != null) && (!(localObject instanceof com.tencent.luggage.wxa.os.a)))
    {
      e.b localb2 = ((com.tencent.luggage.wxa.oq.e)localObject).a();
      e.b localb1 = e.b.a(b());
      com.tencent.luggage.wxa.qz.o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", new Object[] { g(), h(), localb2, localb1 });
      if (e.b.b == localb1) {
        return false;
      }
      if (((this.a.y() instanceof n)) && ((k()) || (j())))
      {
        com.tencent.luggage.wxa.qz.o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], fixed orientation device", new Object[] { g(), h() });
        return false;
      }
      localObject = localb1;
      if (localb1 == null) {
        localObject = e.b.a;
      }
      return !localb2.a((e.b)localObject);
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", new Object[] { this.a.getAppId(), this.a.an() });
    return false;
  }
  
  private boolean j()
  {
    return (e.b.b(l().a())) && (((com.tencent.luggage.wxa.do.a)this.a.b(com.tencent.luggage.wxa.do.a.class)).a);
  }
  
  private boolean k()
  {
    boolean bool1 = this.a.y().h_();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((k.a.c()) && (com.tencent.luggage.wxa.pd.o.a(this.a.getContext()))) {
      return true;
    }
    bool1 = bool2;
    if (com.tencent.luggage.wxa.re.b.a())
    {
      bool1 = bool2;
      if (com.tencent.luggage.wxa.pd.o.a(this.a.getContext()))
      {
        bool1 = bool2;
        if (!k.a.c()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private com.tencent.luggage.wxa.oq.e l()
  {
    return this.a.y().getOrientationHandler();
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.d) && (!this.e))
    {
      Configuration localConfiguration = this.h;
      if ((localConfiguration != null) && (localConfiguration.orientation != paramConfiguration.orientation))
      {
        this.h = new Configuration(paramConfiguration);
        if (this.i == null) {
          this.i = new av.a(this, null);
        }
        this.i.a();
      }
    }
  }
  
  public void a(e.a parama)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.a.a(new av.3(this, parama));
      return;
    }
    if (this.e)
    {
      com.tencent.luggage.wxa.qz.o.c("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", new Object[] { g(), this.a.an() });
      return;
    }
    a(true);
    parama = new av.4(this, parama);
    boolean bool = this.a.y() instanceof n;
    if ((e.b.b(l().a())) && (bool) && ((j()) || (k())))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", new Object[] { g(), h() });
      parama.a(null, false);
      return;
    }
    if (this.a.q().aT())
    {
      com.tencent.luggage.wxa.qz.o.h("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
      parama.a(null, false);
      return;
    }
    com.tencent.luggage.wxa.qz.o.h("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", new Object[] { g(), h(), b() });
    String str = af.a(b(), "portrait");
    int j = -1;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1430647483: 
      if (str.equals("landscape")) {
        j = 1;
      }
      break;
    case 729267099: 
      if (str.equals("portrait")) {
        j = 2;
      }
      break;
    case 3005871: 
      if (str.equals("auto")) {
        j = 0;
      }
      break;
    case -2022952606: 
      if (str.equals("landscapeLeft")) {
        j = 3;
      }
      break;
    }
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            str = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[] { this.a.getAppId(), this.a.an(), b() });
            if (!this.a.L())
            {
              com.tencent.luggage.wxa.qz.o.b("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", str);
              parama.a(null, false);
              return;
            }
            throw new IllegalArgumentException(str);
          }
          l().a(e.b.e, parama);
          return;
        }
        l().a(e.b.a, parama);
        return;
      }
      l().a(e.b.c, parama);
      return;
    }
    l().a(e.b.b, parama);
  }
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  @AnyThread
  public void a(@Nullable String paramString)
  {
    this.c = paramString;
    a(null);
  }
  
  @AnyThread
  public void a(@Nullable String paramString, @Nullable Map<String, Object> paramMap)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.a.a(new av.2(this, paramString, paramMap));
      return;
    }
    this.b.a(paramMap);
    a(paramString);
  }
  
  public boolean a()
  {
    boolean bool = i();
    this.b.a(bool);
    return bool;
  }
  
  public String b()
  {
    return this.c;
  }
  
  void b(@Nullable String paramString)
  {
    this.b.a(false);
    this.c = paramString;
  }
  
  public void c()
  {
    if (this.h == null)
    {
      m localm = this.a.T();
      localm.getClass();
      this.h = new Configuration(((m)localm).getResources().getConfiguration());
    }
    this.d = true;
    if ((this.a.af() != null) && (this.a.af().d())) {
      this.a.af().a(new av.5(this));
    } else {
      a(null);
    }
    this.b.a();
  }
  
  public void d()
  {
    this.d = false;
    this.b.b();
  }
  
  public void e()
  {
    this.d = false;
    this.e = true;
    av.a locala = this.i;
    if (locala != null) {
      locala.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */