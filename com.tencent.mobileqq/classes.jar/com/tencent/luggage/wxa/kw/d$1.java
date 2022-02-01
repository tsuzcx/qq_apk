package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pp.i;
import com.tencent.luggage.wxa.pp.i.c;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;

class d$1
  implements i.c
{
  d$1(d paramd, i parami) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.a.a();
    u localu = this.b.b(i);
    if (localu != null)
    {
      if (!localu.d()) {
        return;
      }
      d.a locala = new d.a(null);
      HashMap localHashMap = new HashMap();
      localHashMap.put("height", Integer.valueOf(g.b(paramInt2)));
      localHashMap.put("lineCount", Integer.valueOf(paramInt1));
      localHashMap.put("inputId", Integer.valueOf(i));
      locala.a(localu).a(localHashMap).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.d.1
 * JD-Core Version:    0.7.0.1
 */