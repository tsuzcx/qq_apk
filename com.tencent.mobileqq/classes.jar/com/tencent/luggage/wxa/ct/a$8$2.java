package com.tencent.luggage.wxa.ct;

import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Iterator;
import java.util.LinkedList;

class a$8$2
  implements Runnable
{
  a$8$2(a.8 param8) {}
  
  public void run()
  {
    l locall = a.c(this.a.a).getDialogContainer();
    if (locall != null)
    {
      Iterator localIterator = a.e(this.a.a).iterator();
      while (localIterator.hasNext()) {
        locall.b((com.tencent.mm.plugin.appbrand.widget.dialog.b)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.8.2
 * JD-Core Version:    0.7.0.1
 */