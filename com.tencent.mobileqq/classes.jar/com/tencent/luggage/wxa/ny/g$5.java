package com.tencent.luggage.wxa.ny;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;

class g$5
  implements e.b
{
  g$5(g paramg, String paramString, boolean paramBoolean, b paramb) {}
  
  public void a(Function<d, Boolean> paramFunction)
  {
    paramFunction = new g.5.1(this, paramFunction);
    this.c.a(paramFunction);
  }
  
  public void a(c paramc)
  {
    o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramc });
    g.a(this.d, this.a, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g.5
 * JD-Core Version:    0.7.0.1
 */