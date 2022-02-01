package com.tencent.luggage.wxa.nf;

import android.app.Activity;
import android.view.Window;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ju.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public void run()
  {
    if (e.c(this.a) != null)
    {
      c localc = e.c(this.a).g();
      if (localc != null)
      {
        Object localObject2 = null;
        Object localObject1;
        if ((localc instanceof h))
        {
          localObject1 = ((h)localc).G();
        }
        else
        {
          localObject1 = localObject2;
          if ((localc instanceof u))
          {
            localObject1 = localObject2;
            if ((localc.getContext() instanceof Activity)) {
              localObject1 = (Activity)localc.getContext();
            }
          }
        }
        if (localObject1 != null)
        {
          o.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
          try
          {
            ((Activity)localObject1).getWindow().addFlags(128);
            return;
          }
          catch (Exception localException)
          {
            o.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", new Object[] { localException });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.e.2
 * JD-Core Version:    0.7.0.1
 */