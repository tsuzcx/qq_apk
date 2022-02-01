package com.tencent.luggage.wxa.dq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.ln.v;
import com.tencent.luggage.wxa.oi.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import java.util.HashMap;
import java.util.Map;

public class c
  extends u
  implements d, com.tencent.luggage.wxa.jx.h
{
  private com.tencent.luggage.wxa.ov.b c;
  private final Runnable f = new c.5(this);
  private s g;
  
  public c()
  {
    super(ax.class);
  }
  
  public c(@Nullable Class<? extends w> paramClass)
  {
    super(paramClass);
  }
  
  @UiThread
  private void aQ()
  {
    FrameLayout localFrameLayout = (FrameLayout)ag().findViewById(2131428552);
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(8);
      Bitmap localBitmap;
      if ((localFrameLayout.getBackground() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)localFrameLayout.getBackground()).getBitmap();
      } else {
        localBitmap = null;
      }
      localFrameLayout.setBackground(null);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
  
  private s aR()
  {
    if (this.g == null) {
      this.g = new s(Looper.getMainLooper());
    }
    return this.g;
  }
  
  private void j(String paramString)
  {
    if (!f().a().a(this, c.b.class))
    {
      k();
      return;
    }
    o.d("MicroMsg.AppBrandPageViewLU", "publishPageNotFound url:%s", new Object[] { paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", m.b(paramString));
    localHashMap.put("query", m.c(paramString));
    localHashMap.put("rawPath", paramString);
    localHashMap.put("isEntryPage", Boolean.valueOf(af.b(paramString).equals(f().as())));
    a(new c.b(null).a(localHashMap), null);
    a(this.f, 2000L);
  }
  
  @UiThread
  private FrameLayout r()
  {
    FrameLayout localFrameLayout2 = (FrameLayout)ag().findViewById(2131428552);
    FrameLayout localFrameLayout1 = localFrameLayout2;
    if (localFrameLayout2 == null)
    {
      localFrameLayout1 = new FrameLayout(getContext());
      localFrameLayout1.setId(2131428552);
      ag().addView(localFrameLayout1, -1, -1);
    }
    return localFrameLayout1;
  }
  
  @UiThread
  private void u()
  {
    FrameLayout localFrameLayout = r();
    localFrameLayout.setBackground(null);
    localFrameLayout.setVisibility(0);
    localFrameLayout.bringToFront();
    try
    {
      o.e("MicroMsg.AppBrandPageViewLU", "showScreenshotCover get screenshot");
      Bitmap localBitmap = aJ();
      localFrameLayout.setBackground(new BitmapDrawable(getContext().getResources(), localBitmap));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label51:
      break label51;
    }
    o.b("MicroMsg.AppBrandPageViewLU", "showScreenshotCover oom, appId = %s, path = %s", new Object[] { getAppId(), an() });
    aQ();
  }
  
  protected com.tencent.luggage.wxa.ov.b a()
  {
    return new com.tencent.luggage.wxa.ov.b(getComponentId());
  }
  
  public void a(Context paramContext, com.tencent.luggage.wxa.iu.d paramd)
  {
    super.a(paramContext, paramd);
    b().a(paramd);
  }
  
  public void a(Bundle paramBundle)
  {
    a(new c.7(this));
    a(new c.8(this));
  }
  
  public final void a(@Nullable Runnable paramRunnable, long paramLong)
  {
    if ((f() != null) && (f().w()))
    {
      if (paramRunnable != null) {
        aR().b(paramRunnable, paramLong);
      }
    }
    else {
      super.a(paramRunnable, paramLong);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    c(this.f);
    if (paramBoolean) {
      f("cancelShowErrorPageViewRunnable");
    }
  }
  
  public boolean a(String paramString)
  {
    b().a(paramString);
    a(new c.1(this));
    a(new c.2(this));
    a(new c.3(this));
    a(new c.4(this));
    boolean bool = super.a(paramString);
    if (bool)
    {
      int i = 0;
      a(false);
      while (i < ag().getChildCount())
      {
        paramString = ag().getChildAt(i);
        if ((paramString instanceof com.tencent.mm.plugin.appbrand.page.d))
        {
          ag().removeView(paramString);
          return bool;
        }
        i += 1;
      }
    }
    return bool;
  }
  
  public final com.tencent.luggage.wxa.ov.b b()
  {
    try
    {
      if (this.c == null) {
        this.c = a();
      }
      com.tencent.luggage.wxa.ov.b localb = this.c;
      return localb;
    }
    finally {}
  }
  
  public final void b(@Nullable Runnable paramRunnable)
  {
    if ((f() != null) && (f().w()))
    {
      if (paramRunnable != null) {
        aR().a(paramRunnable);
      }
    }
    else {
      super.b(paramRunnable);
    }
  }
  
  @CallSuper
  public void b(String paramString)
  {
    super.f(true);
    j(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    com.tencent.luggage.wxa.on.c localc = f().a();
    if ((!localc.a(i(), v.class)) && (!localc.a(this, v.class)))
    {
      super.b(true);
      return;
    }
    super.b(paramBoolean);
  }
  
  @Nullable
  public com.tencent.luggage.wxa.mq.a c()
  {
    return null;
  }
  
  public final void c(@Nullable Runnable paramRunnable)
  {
    s locals = this.g;
    if ((locals != null) && (paramRunnable != null)) {
      locals.b(paramRunnable);
    }
    super.c(paramRunnable);
  }
  
  public com.tencent.luggage.wxa.ed.d f()
  {
    return (com.tencent.luggage.wxa.ed.d)super.q();
  }
  
  public com.tencent.luggage.wxa.du.c i()
  {
    return (com.tencent.luggage.wxa.du.c)super.p();
  }
  
  @CallSuper
  protected void j()
  {
    super.j();
    a(false);
    s locals = this.g;
    if (locals != null) {
      locals.a(null);
    }
  }
  
  public final void k()
  {
    if (!d())
    {
      o.c("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", new Object[] { getAppId(), an() });
      return;
    }
    o.d("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", new Object[] { getAppId(), an() });
    i(false);
    com.tencent.mm.plugin.appbrand.page.d locald = new com.tencent.mm.plugin.appbrand.page.d(getContext(), f());
    ag().addView(locald);
  }
  
  public boolean m()
  {
    i locali = (i)d(i.class);
    return (locali != null) && (locali.f());
  }
  
  public void n()
  {
    super.n();
    for (;;)
    {
      boolean bool1;
      try
      {
        a.d locald = am();
        locald.getClass();
        boolean bool2 = ((a.d)locald).g;
        bool1 = true;
        if ((!bool2) || (!f().a().a(this, c.a.class))) {
          break label62;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        return;
      }
      b(bool1);
      return;
      label62:
      int i = 0;
      if (i != 0) {
        bool1 = false;
      }
    }
  }
  
  public void o()
  {
    if ((f().k().getPageCount() == 1) && (this.e.a()))
    {
      ah().setNavHidden(true);
      return;
    }
    ah().setNavHidden(false);
  }
  
  public com.tencent.luggage.wxa.ro.d<Bitmap> q_()
  {
    com.tencent.luggage.wxa.oi.h localh = (com.tencent.luggage.wxa.oi.h)S().a(com.tencent.luggage.wxa.oi.h.class);
    if (localh != null) {
      return localh.m();
    }
    return com.tencent.luggage.wxa.ro.h.a().d(new c.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.c
 * JD-Core Version:    0.7.0.1
 */