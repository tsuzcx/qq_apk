package com.tencent.luggage.wxa.fy;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.s;
import com.tencent.luggage.wxa.or.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

public abstract class a
{
  protected boolean a = false;
  protected boolean b = false;
  @NonNull
  private final com.tencent.luggage.wxa.gf.a c;
  @NonNull
  private final s d;
  @Nullable
  private u e;
  private boolean f = false;
  private i g = null;
  private f.c h = null;
  
  public a(@NonNull com.tencent.luggage.wxa.gf.a parama, @NonNull s params)
  {
    this.c = parama;
    this.d = params;
  }
  
  private void a(@NonNull u paramu)
  {
    if (this.f) {
      return;
    }
    if (this.g == null)
    {
      this.g = new a.1(this, paramu);
      this.h = new a.2(this, paramu);
    }
    Activity localActivity = paramu.Y();
    if (localActivity == null)
    {
      o.c("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "listenOrientationChanged, null == activity");
      return;
    }
    com.tencent.luggage.wxa.or.h.a(localActivity).a(this.g);
    paramu.a(this.h);
    this.f = true;
  }
  
  protected void a(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.e != null) {
      return;
    }
    parama = parama.g();
    if (!(parama instanceof u))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageView, component(");
      localStringBuilder.append(parama);
      localStringBuilder.append(") is not AppBrandPageView");
      o.c("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", localStringBuilder.toString());
      if (!(parama instanceof com.tencent.luggage.wxa.iu.h))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPageView, component(");
        localStringBuilder.append(parama);
        localStringBuilder.append(") is not AppBrandService");
        o.c("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", localStringBuilder.toString());
        return;
      }
      parama = ((com.tencent.luggage.wxa.iu.h)parama).v();
    }
    else
    {
      parama = (u)parama;
    }
    a(parama);
    this.e = parama;
  }
  
  public abstract void a(@NonNull String paramString, @NonNull com.tencent.luggage.wxa.fx.a parama);
  
  protected abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.a
 * JD-Core Version:    0.7.0.1
 */