package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Iterator;
import java.util.LinkedList;

class g$4
  implements Runnable
{
  g$4(g paramg) {}
  
  public void run()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
    ??? = g.e(this.a).iterator();
    int i = 0;
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      if (this.a.k(str) == 0)
      {
        this.a.o(str);
        i = 1;
      }
    }
    if (i == 0) {
      synchronized (g.a(this.a))
      {
        g.a(this.a, true);
        g.a(this.a, System.currentTimeMillis());
        t.a(g.b(this.a), 1800000L);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.4
 * JD-Core Version:    0.7.0.1
 */