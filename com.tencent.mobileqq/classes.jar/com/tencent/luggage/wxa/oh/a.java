package com.tencent.luggage.wxa.oh;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.iu.i;
import com.tencent.luggage.wxa.iu.i.b;
import com.tencent.luggage.wxa.oe.e;
import com.tencent.luggage.wxa.oe.e.a;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import java.util.Vector;

public final class a
  extends e
{
  private i.b b;
  
  public a(e.a parama, h paramh)
  {
    super(parama, paramh);
  }
  
  private void a(Map<String, Object> paramMap, c paramc)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
      return;
    }
    paramc = paramc.b();
    if (paramc == null)
    {
      o.d("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
      return;
    }
    paramMap.put("fg", paramc.elementAt(0));
    paramMap.put("bg", paramc.elementAt(1));
  }
  
  protected void a()
  {
    this.b = new a.1(this);
    i.a().a(this.a, this.b);
  }
  
  protected void b()
  {
    i.a().b(this.a, this.b);
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.a
 * JD-Core Version:    0.7.0.1
 */