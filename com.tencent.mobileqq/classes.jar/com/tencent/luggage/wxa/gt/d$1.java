package com.tencent.luggage.wxa.gt;

import android.media.AudioTrack;
import android.os.Process;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public void run()
  {
    Process.setThreadPriority(-19);
    if (d.a(this.a).get())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
      return;
    }
    if (d.b(this.a) == null) {
      d.c(this.a);
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
    while (!d.a(this.a).get())
    {
      this.a.i();
      if (d.a(this.a).get())
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
        break;
      }
      com.tencent.luggage.wxa.gm.b localb = this.a.g();
      if (localb != null)
      {
        byte[] arrayOfByte = localb.d;
        if (d.b(this.a) == null) {
          d.c(this.a);
        }
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          if ((d.b(this.a) != null) && ((d.b(this.a).getPlayState() == 1) || (d.b(this.a).getPlayState() == 2))) {
            d.b(this.a).play();
          }
          d.d(this.a);
          this.a.a(localb);
          long l = System.currentTimeMillis();
          int i;
          if (d.b(this.a) != null)
          {
            if (d.e(this.a).g())
            {
              com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.b(this.a).setStereoVolume(0.0F, 0.0F);
            }
            else
            {
              d.b(this.a).setStereoVolume(1.0F, 1.0F);
            }
            i = d.b(this.a).write(arrayOfByte, 0, arrayOfByte.length);
          }
          else
          {
            i = 0;
          }
          l = System.currentTimeMillis() - l;
          if (l > 100L) {
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.f(this.a)) });
          }
          if (i < 0) {
            com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
          }
          if (d.g(this.a).size() == 0)
          {
            d.h(this.a)[0] = arrayOfByte[(arrayOfByte.length - 2)];
            d.h(this.a)[1] = arrayOfByte[(arrayOfByte.length - 1)];
          }
          d.a(this.a, localb);
        }
        com.tencent.luggage.wxa.gn.b.a().a(localb);
      }
    }
    d.i(this.a);
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.d.1
 * JD-Core Version:    0.7.0.1
 */