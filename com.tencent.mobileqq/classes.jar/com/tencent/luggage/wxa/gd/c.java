package com.tencent.luggage.wxa.gd;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.nf.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.lang.ref.WeakReference;

class c
  implements d.a
{
  private final float a;
  private final float b;
  @NonNull
  private final WeakReference<b> c;
  
  public c(j paramj, b paramb)
  {
    this.a = paramj.i();
    this.b = paramj.j();
    o.d("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", new Object[] { Float.valueOf(this.a), Float.valueOf(this.b) });
    this.c = new WeakReference(paramb);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    o.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramBoolean)
    {
      o.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
      return;
    }
    if ((b)this.c.get() == null)
    {
      o.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
      return;
    }
    float f1 = paramFloat1 / this.a;
    float f2 = paramFloat2 / this.b;
    paramFloat2 = 1.0F;
    if (f1 >= f2)
    {
      paramFloat1 = f2 / f1 * 1.0F;
      paramBoolean = false;
    }
    else
    {
      paramFloat2 = f1 / f2 * 1.0F;
      paramFloat1 = 1.0F;
      paramBoolean = true;
    }
    o.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(paramBoolean) });
    f.a.a(new c.1(this, paramBoolean, paramFloat2, paramFloat1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.c
 * JD-Core Version:    0.7.0.1
 */