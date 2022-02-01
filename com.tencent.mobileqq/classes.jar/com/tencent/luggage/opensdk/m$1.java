package com.tencent.luggage.opensdk;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rr.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;

final class m$1
  implements com.tencent.luggage.wxa.rl.b<String, c<String, Bitmap>>
{
  m$1(com.tencent.luggage.wxa.iu.b paramb) {}
  
  public String a(c<String, Bitmap> paramc)
  {
    String str = (String)paramc.b();
    Object localObject = (Bitmap)paramc.c();
    paramc = m.a(this.a);
    if (paramc == null) {
      paramc = null;
    } else {
      paramc = paramc.getCurrentDialog();
    }
    if ((paramc instanceof k))
    {
      k localk = (k)paramc;
      localk.a((Bitmap)localObject);
      localObject = h.c();
      paramc = n.a(this.a, str, new m.1.1(this, paramc, (com.tencent.luggage.wxa.ro.b)localObject));
      localk.setOnDismissListener(new m.1.2(this, paramc));
      localk.setOnCancelListener(new m.1.3(this, paramc));
      return null;
    }
    h.b().a(new IllegalStateException("Invalid QRCodeDisplayDialog display state"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.1
 * JD-Core Version:    0.7.0.1
 */