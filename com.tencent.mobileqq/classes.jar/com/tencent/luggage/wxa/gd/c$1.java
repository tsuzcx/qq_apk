package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

class c$1
  implements Runnable
{
  c$1(c paramc, boolean paramBoolean, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    b localb = (b)c.a(this.d).get();
    if (localb == null)
    {
      o.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
      return;
    }
    if (this.a)
    {
      localb.setTextureViewWidthWeight(this.b);
      return;
    }
    localb.setTextureViewHeightWeight(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.c.1
 * JD-Core Version:    0.7.0.1
 */