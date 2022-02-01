package com.tencent.luggage.wxa.oc;

import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qz.o;

class a$1
  implements c.a
{
  a$1(a parama) {}
  
  @MainThread
  public void a(String paramString, b paramb)
  {
    o.d("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramString, paramb });
    if (!a.a(this.a).equals(paramString)) {
      return;
    }
    a.a(this.a, paramb);
    if ((a.b(this.a) != null) && (b.a == paramb))
    {
      paramString = this.a;
      a.a(paramString, a.b(paramString));
      a.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oc.a.1
 * JD-Core Version:    0.7.0.1
 */