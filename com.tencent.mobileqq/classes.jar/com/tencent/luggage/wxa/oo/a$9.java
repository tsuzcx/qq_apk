package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;

final class a$9
  implements Runnable
{
  a$9(Runnable paramRunnable, String paramString, d paramd) {}
  
  public void run()
  {
    if (a.e())
    {
      a.f().add(this.a);
      o.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { this.b, this.c.b() });
      return;
    }
    a.a(true);
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.9
 * JD-Core Version:    0.7.0.1
 */