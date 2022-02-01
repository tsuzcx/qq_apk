package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;

class c$3$1
  implements IXWebWorkingHandler
{
  c$3$1(c.3 param3) {}
  
  public boolean isRunOnWorkingThread()
  {
    return this.a.c.l();
  }
  
  public void post(Runnable paramRunnable)
  {
    if (this.a.c != null)
    {
      if (this.a.c.l())
      {
        paramRunnable.run();
        return;
      }
      this.a.c.a(paramRunnable);
      return;
    }
    o.b("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.c.3.1
 * JD-Core Version:    0.7.0.1
 */