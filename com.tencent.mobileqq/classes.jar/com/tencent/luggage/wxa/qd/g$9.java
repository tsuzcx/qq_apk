package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.y.a;
import java.util.ArrayList;
import java.util.Iterator;

class g$9
  implements y.a
{
  g$9(g paramg) {}
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "onPhoneCall state:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (g.n(this.a))
    {
      Iterator localIterator = g.n(this.a).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).a(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.9
 * JD-Core Version:    0.7.0.1
 */