package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public void run()
  {
    synchronized (i.a(this.a))
    {
      if (i.a(this.a).isEmpty()) {
        return;
      }
      ah localah = (ah)i.a(this.a).remove(0);
      int i = i.a(this.a).size();
      localah.a();
      o.f("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localah.d(), Integer.valueOf(i) });
      synchronized (i.a(this.a))
      {
        boolean bool = i.a(this.a).isEmpty();
        if (!bool) {
          l.a().a(this, i.d());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.i.1
 * JD-Core Version:    0.7.0.1
 */