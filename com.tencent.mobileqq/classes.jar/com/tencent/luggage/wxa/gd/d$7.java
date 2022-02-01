package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.qz.o;

class d$7
  implements Runnable
{
  d$7(d paramd, boolean paramBoolean) {}
  
  public void run()
  {
    if ((d.g(this.b) != null) && (d.p(this.b)) && (this.a))
    {
      o.d(d.b(this.b), "handleWebViewForeground runnable, video playing when enter background");
      d.a(this.b, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.7
 * JD-Core Version:    0.7.0.1
 */