package com.tencent.luggage.wxa.iu;

import android.widget.FrameLayout;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.LinkedList;

class e$11
  implements Runnable
{
  e$11(e parame, d paramd) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", new Object[] { this.a.aa() });
    this.a.aC();
    e.a(this.b).removeView(this.a.ai());
    e.e(this.b).remove(this.a.aa());
    e.d(this.b).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.e.11
 * JD-Core Version:    0.7.0.1
 */