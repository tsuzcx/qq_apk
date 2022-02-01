package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;

class j$1$1
  implements Runnable
{
  j$1$1(j.1 param1, int paramInt) {}
  
  public void run()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(this.a) });
    if (j.a(this.b.b) != 0)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(j.a(this.b.b)) });
      j.a(this.b.b, 0);
      j.1.a(this.b);
      return;
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.j.1.1
 * JD-Core Version:    0.7.0.1
 */