package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jl.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;

final class c$2
  implements Runnable
{
  c$2(com.tencent.luggage.wxa.jl.b paramb, a parama, h paramh) {}
  
  public void run()
  {
    o.d("Luggage.XWebCanvasLogic", "init resource loader");
    SkiaCanvasResourceLoader.setDelegate(new b(this.a, this.b, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c.2
 * JD-Core Version:    0.7.0.1
 */