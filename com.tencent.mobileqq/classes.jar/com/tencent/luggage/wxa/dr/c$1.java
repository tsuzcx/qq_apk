package com.tencent.luggage.wxa.dr;

import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import java.lang.ref.WeakReference;

class c$1
  implements UdpNative.NativeCallBackInterface
{
  c$1(c paramc, WeakReference paramWeakReference) {}
  
  public void onCallBack(long paramLong, String paramString)
  {
    ((q)this.a.get()).a(new c.1.1(this, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.c.1
 * JD-Core Version:    0.7.0.1
 */