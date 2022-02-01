package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.gz.a;
import com.tencent.luggage.wxa.gz.a.a;
import com.tencent.luggage.wxa.qw.kh;
import com.tencent.luggage.wxa.qy.c;
import org.json.JSONObject;

class g$4
  extends c<a>
{
  g$4(g paramg) {}
  
  public boolean a(a parama)
  {
    if ((parama != null) && (parama.a != null))
    {
      if (parama.a.c == null) {
        return true;
      }
      kh localkh = new kh();
      localkh.a = parama.a.a;
      localkh.b = parama.a.b;
      localkh.c = parama.a.c.toString();
      localkh.d = System.currentTimeMillis();
      parama = l.a(localkh, g.b(this.a), "networkDebugAPI");
      this.a.a(parama);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g.4
 * JD-Core Version:    0.7.0.1
 */