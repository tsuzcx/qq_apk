package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.websocket.libwcwss.WcwssNative;

class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (d.a(this.a) != null)
      {
        o.d("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", new Object[] { d.d(this.a) });
        d.a(this.a).destoryWcwss();
        d.a(this.a, null);
      }
      else
      {
        o.b("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.4
 * JD-Core Version:    0.7.0.1
 */