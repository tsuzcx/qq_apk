package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public class c
{
  protected UdpNative a;
  private boolean b = true;
  private final c.a c = new c.a(this, new c.3(this));
  
  public void a(i parami)
  {
    o.d("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      o.b("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      return;
    }
    ((m)parami.a(m.class)).a(this.c);
  }
  
  public void a(i parami, com.tencent.luggage.wxa.jx.c paramc)
  {
    o.d("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      o.b("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      return;
    }
    a.a();
    q localq = (q)parami.a(q.class);
    if (localq == null)
    {
      o.b("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      return;
    }
    paramc = (b)paramc.a(b.class);
    if (paramc != null)
    {
      this.b = paramc.a();
      o.d("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.b) });
    }
    localq.a(new c.2(this, parami, new c.1(this, new WeakReference(localq))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.c
 * JD-Core Version:    0.7.0.1
 */