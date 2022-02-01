package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.magicbrush.handler.b;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.nio.ByteBuffer;

class a$6
  implements b
{
  a$6(a parama) {}
  
  public String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (this.a.y() == null) {
      return "";
    }
    try
    {
      paramString1 = ((c)this.a.y()).a(paramString1, paramString2, paramInt, paramBoolean);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      com.tencent.luggage.wxa.qz.o.a("Luggage.AppBrandGameServiceLogicImp", paramString1, "IMBInvokeHandler.invoke", new Object[0]);
      t.a(new a.6.1(this, paramString1));
    }
    return "";
  }
  
  public ByteBuffer a(String paramString)
  {
    if (this.a.y() == null) {
      return null;
    }
    i locali = new i();
    j localj = ((c)this.a.y()).getFileSystem().b(paramString, locali);
    if (localj == j.a) {
      return p.a((ByteBuffer)locali.a);
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandGameServiceLogicImp", "readFile %s failed: %s", new Object[] { paramString, localj });
    return null;
  }
  
  public String[] a()
  {
    if (this.a.y() == null) {
      return null;
    }
    return ((c)this.a.y()).O();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.6
 * JD-Core Version:    0.7.0.1
 */