package com.tencent.luggage.wxa.ml;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.qz.o;

class a$10
  implements TextureView.SurfaceTextureListener
{
  a$10(a parama) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    a locala = this.a;
    locala.a(a.o(locala));
    a.a(this.a, new Surface(paramSurfaceTexture));
    o.d("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(this.a.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(a.n(this.a)), Integer.valueOf(a.o(this.a).hashCode()) });
    if ((this.a.a != null) && (a.n(this.a)))
    {
      this.a.a.a(a.o(this.a));
      if (a.r(this.a))
      {
        this.a.a.l();
      }
      else
      {
        a.c(this.a, true);
        this.a.a.a(0.0F, 0.0F);
        this.a.a.l();
      }
      a.e(this.a, false);
    }
    else
    {
      a.q(this.a);
    }
    if (a.s(this.a) != null) {
      a.s(this.a).C();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    o.d("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(this.a.hashCode()), Boolean.valueOf(a.n(this.a)) });
    paramSurfaceTexture = this.a;
    paramSurfaceTexture.a(a.o(paramSurfaceTexture));
    a.a(this.a, null);
    if ((this.a.a != null) && (a.n(this.a)))
    {
      if (this.a.e())
      {
        a.e(this.a, true);
        this.a.a.m();
        return false;
      }
    }
    else
    {
      a.p(this.a);
      a.e(this.a, false);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("on texture size changed width : ");
    paramSurfaceTexture.append(paramInt1);
    paramSurfaceTexture.append(" height : ");
    paramSurfaceTexture.append(paramInt2);
    o.d("MicroMsg.Video.AbstractVideoTextureView", paramSurfaceTexture.toString());
    if ((this.a.a != null) && (a.n(this.a)) && (a.a(this.a) == paramInt1) && (a.b(this.a) == paramInt2)) {
      this.a.a.l();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    o.e("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
    if (a.g(this.a))
    {
      if (this.a.a != null)
      {
        this.a.a.m();
        if (a.j(this.a)) {
          this.a.a.a(0.0F, 0.0F);
        } else {
          this.a.a.a(1.0F, 1.0F);
        }
      }
      a.c(this.a, false);
    }
    if ((a.k(this.a) > 0L) && (a.l(this.a) != null))
    {
      a.l(this.a).A();
      a.a(this.a, null);
    }
    a.a(this.a, System.currentTimeMillis());
    if (a.m(this.a))
    {
      o.d("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(this.a.hashCode()), Integer.valueOf(this.a.getCurrentPosition()) });
      if (this.a.a != null)
      {
        this.a.a.m();
        paramSurfaceTexture = this.a;
        paramSurfaceTexture.setMute(a.j(paramSurfaceTexture));
      }
      a.d(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.10
 * JD-Core Version:    0.7.0.1
 */