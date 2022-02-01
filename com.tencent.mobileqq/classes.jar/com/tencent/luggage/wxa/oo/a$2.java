package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.el;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class a$2
  implements b<Void, el>
{
  a$2(a parama, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public Void a(el paramel)
  {
    if ((paramel.a.a == 0) && (1 == this.a))
    {
      o.d("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s  scope=%s", new Object[] { this.b, this.c, this.d });
      a.b().b(this.b, this.c);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.2
 * JD-Core Version:    0.7.0.1
 */