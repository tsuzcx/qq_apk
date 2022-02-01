package com.tencent.luggage.wxa.oh;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oe.e;
import com.tencent.luggage.wxa.oe.e.a;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.on.c.c;
import com.tencent.luggage.wxa.qz.o;

public final class b
  extends e
{
  private c.c b;
  
  public b(e.a parama, h paramh)
  {
    super(parama, paramh);
  }
  
  protected void a()
  {
    c localc = ((d)this.a.q()).a();
    if (localc == null)
    {
      o.b("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
      return;
    }
    this.b = new b.1(this);
    localc.a(this.b);
  }
  
  protected void b()
  {
    if (this.b == null) {
      return;
    }
    if (this.a.q() == null) {
      return;
    }
    c localc = ((d)this.a.q()).a();
    if (localc == null) {
      return;
    }
    localc.b(this.b);
  }
  
  public int c()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.b
 * JD-Core Version:    0.7.0.1
 */