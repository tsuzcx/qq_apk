package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.udp.libmmudp.UdpNative;

class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (this.a.a != null)
      {
        o.d("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
        this.a.a.destoryUdp();
        this.a.a = null;
      }
      else
      {
        o.d("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.c.3
 * JD-Core Version:    0.7.0.1
 */