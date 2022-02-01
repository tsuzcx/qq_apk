package com.tencent.luggage.wxa.cb;

import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.ig.f;
import com.tencent.luggage.wxa.nr.b;
import com.tencent.luggage.wxa.qz.o;

class a$d$1
  implements Runnable
{
  a$d$1(a.d paramd, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.h.d);
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString().hashCode());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = this.b;
    localObject1 = f.a(7, (String)localObject2, (String)localObject2, this.c, this.d, this.e, this.f, this.a, (String)localObject1, com.tencent.luggage.wxa.hz.a.d(), this.h.a(this.b), this.g, "");
    ((e)localObject1).s = true;
    com.tencent.luggage.wxa.ig.a.b((e)localObject1);
    b.b().a(a.d.b(this.h), this.h.d);
    b.b().b(this.h.d);
    b.b().a(((e)localObject1).c);
    o.d("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
    localObject1 = this.h;
    ((a.d)localObject1).g = -1;
    ((a.d)localObject1).h = "";
    ((a.d)localObject1).e = false;
    a.d.c((a.d)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.a.d.1
 * JD-Core Version:    0.7.0.1
 */