package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.a;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;
import java.lang.ref.WeakReference;

class d$2
  implements WcwssNative.IWcWssWebSocketListener
{
  d$2(d paramd, WeakReference paramWeakReference, c paramc) {}
  
  public int doCertificateVerify(String paramString1, long paramLong, String paramString2, byte[][] paramArrayOfByte)
  {
    if ((d.b(this.c) == null) || (d.c(this.c) == null))
    {
      d.a(this.c, (a)this.b.b(a.class));
      if (d.b(this.c) != null)
      {
        paramString1 = this.c;
        d.a(paramString1, j.b(d.b(paramString1)));
        if (d.c(this.c) == null) {
          o.b("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
        }
      }
      else
      {
        o.b("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
      }
    }
    return d.a(paramString2, paramArrayOfByte, d.c(this.c));
  }
  
  public void onStateChange(String paramString, long paramLong, int paramInt)
  {
    ((q)this.a.get()).a(new d.2.1(this, paramString, paramLong, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.2
 * JD-Core Version:    0.7.0.1
 */