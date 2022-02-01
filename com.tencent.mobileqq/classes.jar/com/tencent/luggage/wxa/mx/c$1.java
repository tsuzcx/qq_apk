package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.i;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;

final class c$1
  implements IXWebLibraryLoader
{
  public boolean afterLoad()
  {
    f.a("skia-canvas-log-bridge", i.class.getClassLoader());
    return true;
  }
  
  public boolean beforeLoad()
  {
    return false;
  }
  
  public boolean load(String paramString)
  {
    o.d("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramString });
    try
    {
      f.a(paramString, i.class.getClassLoader());
      return true;
    }
    catch (Throwable localThrowable)
    {
      o.b("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramString, localThrowable });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c.1
 * JD-Core Version:    0.7.0.1
 */