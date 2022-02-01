package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.websocket.libwcwss.WcwssNative;

class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    o.e("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", new Object[] { this.a });
    d.a(this.d.c).updateInterface(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.2.1
 * JD-Core Version:    0.7.0.1
 */