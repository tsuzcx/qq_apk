package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;

class j$1$3
  implements Runnable
{
  j$1$3(j.1 param1, int paramInt) {}
  
  public void run()
  {
    String str = j.c(this.b.b);
    o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(this.a), str });
    int i = this.a;
    if (i == 3)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
      j.1.b(this.b);
      j.b(this.b.b, System.currentTimeMillis());
      return;
    }
    if (i == 2)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
      o.d("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - j.i(this.b.b)) });
      j.1.a(this.b);
      return;
    }
    if (i == 4)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
      o.d("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - j.i(this.b.b)) });
      j.1.c(this.b);
      return;
    }
    if (i == 5)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
      j.1.d(this.b);
      return;
    }
    if (i == 6)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
      j.1.e(this.b);
      return;
    }
    if (i == 7)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
      j.1.f(this.b);
      return;
    }
    if (i == 8)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
      j.1.g(this.b);
      return;
    }
    if (i == 9) {
      o.d("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.j.1.3
 * JD-Core Version:    0.7.0.1
 */