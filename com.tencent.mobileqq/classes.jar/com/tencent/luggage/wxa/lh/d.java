package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public abstract class d
  extends a
{
  private d.a a = null;
  
  private void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.a;
      if (localObject != null) {
        ((d.a)localObject).a(paramInt, paramString);
      }
    }
    else
    {
      localObject = paramString;
      if (af.c(paramString)) {
        localObject = "unknown error";
      }
      paramString = this.a;
      if (paramString != null) {
        paramString.a(paramInt, (String)localObject);
      }
    }
  }
  
  protected void a(d.a parama)
  {
    this.a = parama;
    parama = new d.b(this);
    parama.h();
    parama.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.d
 * JD-Core Version:    0.7.0.1
 */