package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.dh;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;

class a$1
  implements Runnable
{
  a$1(a parama, com.tencent.luggage.wxa.iu.d paramd, a.a parama1) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((com.tencent.luggage.wxa.iu.d)localObject).ae() != null))
    {
      o.d("MicroMsg.AppBrandGameExtraConfigMgr", "hy: trigger wxa game config update");
      a.a(this.c, null);
      a.a(this.c, null);
      a.a(this.c, null);
      a.a(this.c, null);
      localObject = a.a(this.c, this.a);
      b localb = (b)this.a.d(b.class);
      if (localb != null) {
        localb.b("/cgi-bin/mmgame-bin/getwxagameconfig", this.a.aa(), (com.tencent.luggage.wxa.qu.a)localObject, dh.class).a(new a.1.2(this)).a(new a.1.1(this));
      }
      return;
    }
    o.c("MicroMsg.AppBrandGameExtraConfigMgr", "hy: runtime is null!");
    localObject = this.b;
    if (localObject != null) {
      ((a.a)localObject).a(-1, -1, "runtime is null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.a.1
 * JD-Core Version:    0.7.0.1
 */