package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.LinkedList;

class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public void run()
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
    Iterator localIterator = g.e(this.a).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.a.k(str) == 0) {
        this.a.m(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.3
 * JD-Core Version:    0.7.0.1
 */