package com.tencent.luggage.wxa.en;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public void run()
  {
    o.d("Luggage.RuntimePreloader[applaunch]", "preInit start");
    t.a(-2);
    if (e.a())
    {
      b.a(this.a);
      o.d("Luggage.RuntimePreloader[applaunch]", "webview already init done");
      return;
    }
    e.a(new b.1.1(this));
    o.d("Luggage.RuntimePreloader[applaunch]", "misc preload done");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.b.1
 * JD-Core Version:    0.7.0.1
 */