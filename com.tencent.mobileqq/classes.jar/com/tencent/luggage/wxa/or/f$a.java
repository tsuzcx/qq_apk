package com.tencent.luggage.wxa.or;

import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;

class f$a
{
  e.a a;
  e.b b;
  boolean c;
  String d;
  
  private f$a(e.a parama, e.b paramb, boolean paramBoolean, String paramString)
  {
    this.a = parama;
    this.b = paramb;
    this.c = paramBoolean;
    this.d = paramString;
  }
  
  private void a()
  {
    o.d("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", new Object[] { this.d });
    e.a locala = this.a;
    if (locala == null)
    {
      o.d("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
      return;
    }
    locala.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.f.a
 * JD-Core Version:    0.7.0.1
 */