package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.ch;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class g$3
  implements b<Object, ch>
{
  g$3(g paramg) {}
  
  public Object a(ch paramch)
  {
    if (paramch == null)
    {
      o.b("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, null response");
      return null;
    }
    if (paramch.z.a != 0)
    {
      o.b("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s, rr.resp = %b", new Object[] { Integer.valueOf(paramch.z.a), paramch.z.b, Boolean.valueOf(false) });
      return null;
    }
    g.b(this.a).a(paramch.a);
    o.d("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", new Object[] { paramch.a });
    if (g.i(this.a).a()) {
      g.c(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g.3
 * JD-Core Version:    0.7.0.1
 */