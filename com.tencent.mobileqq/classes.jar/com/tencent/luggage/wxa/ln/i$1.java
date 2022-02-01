package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;

class i$1
  implements Runnable
{
  i$1(i parami, b paramb, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = this.a.q().A().L;
    if (this.a.q().C().getPageCount() >= i)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("page limit exceeded: ");
      ((StringBuilder)localObject).append(i);
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiNavigateTo", ((StringBuilder)localObject).toString());
      localObject = this.a;
      int j = this.b;
      i locali = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:page limit exceeded: ");
      localStringBuilder.append(i);
      ((b)localObject).a(j, locali.b(localStringBuilder.toString()));
      return;
    }
    this.a.q().C().b(this.c);
    this.a.a(this.b, this.d.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.i.1
 * JD-Core Version:    0.7.0.1
 */