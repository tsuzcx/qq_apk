package com.tencent.luggage.scanner.scanner.ui;

import android.os.Bundle;
import com.tencent.luggage.scanner.camera.g;
import com.tencent.luggage.wxa.qz.o;

class a$2$3
  implements Runnable
{
  a$2$3(a.2 param2, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.a == a.f(this.c.a)) && (this.a != 0L) && (this.b.containsKey("param_zoom_ratio")))
    {
      float f = this.b.getFloat("param_zoom_ratio", 0.0F);
      o.d("Luggage.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
      if ((f > 0.0F) && (a.h(this.c.a)) && (this.c.a.b.a()))
      {
        int i = (int)(((com.tencent.luggage.scanner.camera.a)this.c.a.b).i() * f);
        ((com.tencent.luggage.scanner.camera.a)this.c.a.b).b(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a.2.3
 * JD-Core Version:    0.7.0.1
 */