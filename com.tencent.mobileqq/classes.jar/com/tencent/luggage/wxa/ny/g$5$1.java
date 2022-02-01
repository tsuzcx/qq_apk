package com.tencent.luggage.wxa.ny;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.jj.a;
import com.tencent.luggage.wxa.qz.o;

class g$5$1
  implements Runnable
{
  g$5$1(g.5 param5, Function paramFunction) {}
  
  public void run()
  {
    boolean bool2 = g.a(this.b.d).au();
    boolean bool1;
    if (bool2) {
      bool1 = false;
    } else {
      bool1 = ((Boolean)this.a.apply(g.a(this.b.d))).booleanValue();
    }
    o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", new Object[] { g.a(this.b.d).toString(), this.b.a, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (bool2) {
      return;
    }
    if ((bool1) && (!g.a(this.b.d).aj().i().booleanValue())) {
      g.a(this.b.d).ak();
    }
    g localg = this.b.d;
    String str = this.b.a;
    a.d locald;
    if (bool1) {
      locald = a.d.a;
    } else {
      locald = a.d.b;
    }
    g.a(localg, str, locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.5.1
 * JD-Core Version:    0.7.0.1
 */