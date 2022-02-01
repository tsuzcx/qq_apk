package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;

class c$2
  implements Runnable
{
  c$2(c paramc, i parami, UdpNative.NativeCallBackInterface paramNativeCallBackInterface) {}
  
  public void run()
  {
    o.d("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
    if (this.c.a != null)
    {
      o.d("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
      return;
    }
    u localu = (u)this.a.a(u.class);
    if (localu == null)
    {
      o.b("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
      return;
    }
    if (c.a(this.c)) {
      this.c.a = new UdpNative(localu.k(), localu.j(), localu.i());
    } else {
      this.c.a = new UdpNative(localu.k(), localu.j(), 0L);
    }
    o.d("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(this.c.a.InitCallBack(this.b)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.c.2
 * JD-Core Version:    0.7.0.1
 */