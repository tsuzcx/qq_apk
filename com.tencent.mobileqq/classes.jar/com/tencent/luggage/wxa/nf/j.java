package com.tencent.luggage.wxa.nf;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.gd.d.a;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.h.a;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.u;

public final class j
  implements h
{
  @NonNull
  private final d a;
  private j.a b;
  
  public j(@NonNull d paramd)
  {
    this.a = paramd;
    this.b = new j.a(this, null);
    paramd.a(new j.1(this));
    paramd.a(new j.2(this));
  }
  
  public int a()
  {
    return this.a.u();
  }
  
  public void a(@Nullable d.a parama)
  {
    this.a.a(parama);
  }
  
  public void a(@NonNull u paramu, @NonNull h.a parama)
  {
    paramu = paramu.getJsRuntime();
    if (paramu == null)
    {
      o.c("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
      parama.a(this.a.w(), this.a.x());
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
    o.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", localStringBuilder.toString());
    paramu.evaluateJavascript((String)localObject, new j.3(this, parama));
  }
  
  public boolean a(@Nullable Surface paramSurface)
  {
    return this.a.a(paramSurface);
  }
  
  public int b()
  {
    return this.a.v();
  }
  
  public Point c()
  {
    return new Point(this.a.w(), this.a.x());
  }
  
  @NonNull
  public com.tencent.luggage.wxa.lp.j d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.a.z();
  }
  
  @Nullable
  public c f()
  {
    b localb = this.a.r();
    if (!(localb instanceof c)) {
      return null;
    }
    return (c)localb;
  }
  
  @Nullable
  public SurfaceTexture g()
  {
    return this.a.s();
  }
  
  @Nullable
  public Surface h()
  {
    return this.a.t();
  }
  
  public float i()
  {
    return this.a.g();
  }
  
  public float j()
  {
    return this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.j
 * JD-Core Version:    0.7.0.1
 */