package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.sj.g;
import java.util.Deque;
import java.util.List;

class DanmuView$5
  implements g
{
  DanmuView$5(DanmuView paramDanmuView, int paramInt) {}
  
  public String a()
  {
    return "DanmuView-seekToPlayTime";
  }
  
  public void run()
  {
    synchronized (DanmuView.b(this.b))
    {
      int i = DanmuView.a(this.b).size() - 1;
      while (i >= 0)
      {
        d locald = (d)DanmuView.a(this.b).get(i);
        if (locald.e() < this.a) {
          break;
        }
        o.f("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.e()) });
        DanmuView.b(this.b).addFirst(locald);
        i -= 1;
      }
      DanmuView.c(this.b);
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5
 * JD-Core Version:    0.7.0.1
 */