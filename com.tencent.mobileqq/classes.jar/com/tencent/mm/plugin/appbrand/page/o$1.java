package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.oj.a;
import com.tencent.luggage.wxa.oj.a.a;
import com.tencent.luggage.wxa.oj.c;
import java.util.Comparator;

class o$1
  implements Comparator<a>
{
  o$1(o paramo) {}
  
  public int a(a parama1, a parama2)
  {
    c localc1 = this.a.getCurrentPage().a(parama1.b());
    c localc2 = this.a.getCurrentPage().a(parama2.b());
    if (localc1 == null) {
      return 1;
    }
    if (localc2 == null) {
      return -1;
    }
    return parama2.a().a() - parama1.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.1
 * JD-Core Version:    0.7.0.1
 */