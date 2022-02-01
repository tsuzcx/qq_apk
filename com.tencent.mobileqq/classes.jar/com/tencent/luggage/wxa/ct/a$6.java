package com.tencent.luggage.wxa.ct;

import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;

class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public void run()
  {
    if (!a.a(this.a))
    {
      o.d("Luggage.STANDALONE.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(this.a.hashCode()) });
      a.e(this.a).clear();
      a.b(this.a).stopLoading();
      a.b(this.a).destroy();
      a.c(this.a).f();
      a.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.6
 * JD-Core Version:    0.7.0.1
 */