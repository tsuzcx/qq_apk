package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qg.e;
import com.tencent.luggage.wxa.qz.o;

public class d
{
  private static boolean a = false;
  private static long b;
  
  public static boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - b < 120000L) {
      return a;
    }
    b = l;
    a = e.d();
    o.d("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", new Object[] { Boolean.valueOf(a) });
    if (!a)
    {
      a = e.e();
      o.d("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", new Object[] { Boolean.valueOf(a) });
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.d
 * JD-Core Version:    0.7.0.1
 */