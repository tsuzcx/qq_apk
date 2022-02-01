package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.qz.o;
import java.util.Set;

class n$2
  implements Runnable
{
  n$2(n paramn) {}
  
  public void run()
  {
    int j = n.c(this.a).size();
    int i = 0;
    o.d("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(j) });
    if (n.c(this.a).size() <= 0) {
      return;
    }
    n.a[] arrayOfa = new n.a[n.c(this.a).size()];
    n.c(this.a).toArray(arrayOfa);
    j = arrayOfa.length;
    while (i < j)
    {
      arrayOfa[i].a();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.n.2
 * JD-Core Version:    0.7.0.1
 */