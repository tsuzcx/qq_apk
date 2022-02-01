package com.tencent.luggage.wxa.qj;

import com.tencent.luggage.wxa.ql.d;
import com.tencent.luggage.wxa.qz.o;

class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public void run()
  {
    boolean bool1 = this.a.a().B();
    boolean bool2 = this.a.a().t();
    o.d("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2)) {
      this.a.a().G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qj.g.1
 * JD-Core Version:    0.7.0.1
 */