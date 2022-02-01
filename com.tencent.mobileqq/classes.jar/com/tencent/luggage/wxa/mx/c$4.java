package com.tencent.luggage.wxa.mx;

import android.util.SparseArray;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;

final class c$4
  implements Runnable
{
  c$4(h paramh) {}
  
  public void run()
  {
    int i = this.a.hashCode();
    SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)c.e().get(i);
    c.e().remove(i);
    o.d("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", new Object[] { Integer.valueOf(i), localSkiaCanvasApp });
    localSkiaCanvasApp.onJSContextDestroying();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c.4
 * JD-Core Version:    0.7.0.1
 */