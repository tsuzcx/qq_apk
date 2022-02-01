package com.tencent.luggage.wxa.gs;

import android.os.Process;
import java.util.List;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public void run()
  {
    Process.setThreadPriority(-19);
    if (this.a.i())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "stop and exit");
      return;
    }
    while (!this.a.i())
    {
      this.a.e();
      if (this.a.i()) {
        return;
      }
      System.nanoTime();
      List localList = this.a.j();
      if (localList.size() > 0)
      {
        long l1 = System.nanoTime();
        com.tencent.luggage.wxa.gm.b localb = d.a(this.a).a(localList);
        long l2 = System.nanoTime();
        d.b(this.a);
        d locald = this.a;
        d.a(locald, d.c(locald) + (l2 - l1));
        if (localb != null) {
          d.a(this.a, localb);
        }
        d.a(this.a, localList);
        localList.clear();
      }
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.d.1
 * JD-Core Version:    0.7.0.1
 */