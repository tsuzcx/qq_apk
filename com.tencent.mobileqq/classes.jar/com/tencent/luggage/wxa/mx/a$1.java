package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.mz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    if (a.a(this.a) != null)
    {
      a.a(this.a).swapSurface(a.b(this.a));
      if (a.c(this.a) == null)
      {
        o.b("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, return");
        return;
      }
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", new Object[] { Integer.valueOf(a.d(this.a)) });
      c.a(a.c(this.a), a.d(this.a));
      return;
    }
    o.b("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.a.1
 * JD-Core Version:    0.7.0.1
 */