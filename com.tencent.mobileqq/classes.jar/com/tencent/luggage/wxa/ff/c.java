package com.tencent.luggage.wxa.ff;

import android.text.TextUtils;
import com.tencent.luggage.wxa.fk.e;
import com.tencent.luggage.wxa.fq.f;
import com.tencent.luggage.wxa.jx.c.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.o;

public class c
  extends com.tencent.luggage.wxa.iu.a
{
  private final e a;
  private final h b;
  private final a c;
  
  public c(e parame, h paramh)
  {
    super(parame, paramh, parame.a());
    this.a = parame;
    this.b = paramh;
    this.c = parame.S();
  }
  
  private String a()
  {
    if (this.a.t()) {}
    try
    {
      localObject = af.b(this.a.G().I);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label26:
      break label26;
    }
    return "";
    localObject = this.a.k();
    if (localObject == null) {
      return null;
    }
    return ((o)localObject).getCurrentUrl();
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.c.a(paramInt, paramString);
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramm, paramString1, paramInt, paramString2);
    if (!TextUtils.isEmpty(paramString2))
    {
      if ((f.a()) && ("fail:internal error invalid js component".equals(paramString2))) {
        throw new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { paramm.d() }));
      }
      this.c.a(paramInt, paramString2);
    }
  }
  
  public boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    this.c.a(paramInt, this.b, paramm, paramString, a());
    return super.a(paramm, paramString, paramInt, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.c
 * JD-Core Version:    0.7.0.1
 */