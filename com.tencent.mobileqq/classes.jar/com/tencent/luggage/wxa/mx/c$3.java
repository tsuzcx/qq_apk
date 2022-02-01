package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;

final class c$3
  implements Runnable
{
  c$3(i parami, h paramh, q paramq) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      o.b("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
      return;
    }
    localObject = (u)((i)localObject).a(u.class);
    int i = this.b.hashCode();
    c.a(i, new SkiaCanvasApp(((u)localObject).k(), ((u)localObject).j(), new c.3.1(this)));
    o.d("Luggage.XWebCanvasLogic", "init id:%s %s", new Object[] { Integer.valueOf(i), c.a(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c.3
 * JD-Core Version:    0.7.0.1
 */