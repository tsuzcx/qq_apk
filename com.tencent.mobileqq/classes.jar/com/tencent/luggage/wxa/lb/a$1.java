package com.tencent.luggage.wxa.lb;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.ny.a.b;
import com.tencent.luggage.wxa.ny.a.d;
import com.tencent.luggage.wxa.qz.o;

class a$1
  implements a.b
{
  a$1(a parama, String paramString1, String paramString2, h paramh, String paramString3) {}
  
  public void a(a.d paramd)
  {
    o.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramd.toString(), this.a, this.b });
    int i = a.3.a[paramd.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 4) {
          return;
        }
        o.c("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
        a.a.a(this.c, this.d, "fail", this.b);
        return;
      }
      a.a.a(this.c, this.d, "fail", this.b);
      return;
    }
    a.a.a(this.c, this.d, "success", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lb.a.1
 * JD-Core Version:    0.7.0.1
 */