package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import org.json.JSONObject;

final class m$6
  implements com.tencent.luggage.wxa.rl.b<Void, Void>
{
  m$6(com.tencent.luggage.wxa.iu.b paramb, f paramf, JSONObject paramJSONObject) {}
  
  public Void a(Void paramVoid)
  {
    paramVoid = m.a(this.a);
    if (paramVoid == null)
    {
      h.b().a(new IllegalStateException("Invalid env state"));
    }
    else
    {
      com.tencent.luggage.wxa.ro.b localb = h.b();
      k localk = new k(this.a.getContext());
      localk.a(this.b, this.a, this.c);
      localk.a(new m.6.1(this, localb, localk));
      paramVoid.a(localk);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.6
 * JD-Core Version:    0.7.0.1
 */