package com.tencent.luggage.wxa.iu;

import android.widget.FrameLayout;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import java.util.Map;

class f$3$1
  implements Runnable
{
  f$3$1(f.3 param3) {}
  
  public void run()
  {
    o.d("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", new Object[] { this.a.a.aa() });
    if (this.a.a.aQ()) {
      this.a.a.ay();
    }
    this.a.a.aC();
    f.e(this.a.b).removeView(this.a.a.ai());
    f.d(this.a.b).remove(this.a.a.aa());
    f.c(this.a.b).remove(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.f.3.1
 * JD-Core Version:    0.7.0.1
 */