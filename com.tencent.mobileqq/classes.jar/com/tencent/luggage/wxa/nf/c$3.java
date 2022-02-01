package com.tencent.luggage.wxa.nf;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.qz.o;

class c$3
  implements Runnable
{
  c$3(c paramc, Activity paramActivity, float paramFloat) {}
  
  public void run()
  {
    WindowManager.LayoutParams localLayoutParams = this.a.getWindow().getAttributes();
    float f2 = this.b;
    float f1 = f2;
    if (f2 < 0.01F) {
      f1 = 0.01F;
    }
    localLayoutParams.screenBrightness = f1;
    this.a.getWindow().setAttributes(localLayoutParams);
    o.c("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", new Object[] { Float.valueOf(localLayoutParams.screenBrightness) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.c.3
 * JD-Core Version:    0.7.0.1
 */