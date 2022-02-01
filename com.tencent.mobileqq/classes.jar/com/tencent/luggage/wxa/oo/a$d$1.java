package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;

class a$d$1
  implements Runnable
{
  a$d$1(a.d paramd) {}
  
  public void run()
  {
    Runnable localRunnable = (Runnable)a.f().pollFirst();
    if (localRunnable != null)
    {
      localRunnable.run();
      return;
    }
    o.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
    a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.d.1
 * JD-Core Version:    0.7.0.1
 */