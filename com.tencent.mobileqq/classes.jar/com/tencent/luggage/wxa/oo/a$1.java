package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Locale;

class a$1
  extends a.b
{
  a$1(a parama, a.c paramc, d paramd)
  {
    super(paramc, null);
  }
  
  private String c()
  {
    b localb = this.a.a();
    String str = this.a.b();
    return String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { localb.getAppId(), localb.getClass().getSimpleName(), str });
  }
  
  public void a()
  {
    super.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfirm ");
    localStringBuilder.append(c());
    o.d("MicroMsg.AppBrandJsApiUserAuth", localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    o.d("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramString, c() });
  }
  
  public void b()
  {
    super.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancel ");
    localStringBuilder.append(c());
    o.d("MicroMsg.AppBrandJsApiUserAuth", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.1
 * JD-Core Version:    0.7.0.1
 */