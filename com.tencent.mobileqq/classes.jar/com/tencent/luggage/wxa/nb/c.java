package com.tencent.luggage.wxa.nb;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.ga.b;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.h.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.u;

public final class c
  implements h
{
  @NonNull
  private final a a;
  private c.a b;
  
  public c(@NonNull a parama)
  {
    this.a = parama;
    this.b = new c.a(this, null);
  }
  
  public int a()
  {
    return this.a.n();
  }
  
  public void a(@NonNull u paramu, @NonNull h.a parama)
  {
    paramu = paramu.getJsRuntime();
    if (paramu == null)
    {
      o.c("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.a(this.a.p(), this.a.q());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("document.querySelector('embed[embed-id=\"");
    ((StringBuilder)localObject).append(this.a.B());
    ((StringBuilder)localObject).append("\"]').getBoundingClientRect().toJSON()");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVideoPositionAsync, jsScript: ");
    localStringBuilder.append((String)localObject);
    o.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", localStringBuilder.toString());
    paramu.evaluateJavascript((String)localObject, new c.1(this, parama));
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.a.a(paramInt1, paramInt2);
  }
  
  public boolean a(@Nullable Surface paramSurface)
  {
    return this.a.a(paramSurface);
  }
  
  public int b()
  {
    return this.a.o();
  }
  
  public Point c()
  {
    return new Point(this.a.p(), this.a.q());
  }
  
  @NonNull
  public j d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.a.s();
  }
  
  @Nullable
  public b f()
  {
    return this.a.k();
  }
  
  @Nullable
  public SurfaceTexture g()
  {
    return this.a.l();
  }
  
  @Nullable
  public Surface h()
  {
    return this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.c
 * JD-Core Version:    0.7.0.1
 */