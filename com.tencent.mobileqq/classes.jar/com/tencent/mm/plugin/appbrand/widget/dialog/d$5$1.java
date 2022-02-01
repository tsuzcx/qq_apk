package com.tencent.mm.plugin.appbrand.widget.dialog;

import java.util.Iterator;
import java.util.Set;

class d$5$1
  implements Runnable
{
  d$5$1(d.5 param5) {}
  
  public void run()
  {
    this.a.c.removeView(this.a.a);
    d.a(this.a.c, true);
    Iterator localIterator = d.c(this.a.c).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a(this.a.b);
    }
    d.a(this.a.c, false);
    if (!d.d(this.a.c).isEmpty())
    {
      d.c(this.a.c).removeAll(d.d(this.a.c));
      d.d(this.a.c).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d.5.1
 * JD-Core Version:    0.7.0.1
 */