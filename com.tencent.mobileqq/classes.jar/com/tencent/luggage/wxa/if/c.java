package com.tencent.luggage.wxa.if;

import com.tencent.luggage.wxa.gz.b.a;
import com.tencent.luggage.wxa.gz.b.b;
import com.tencent.luggage.wxa.qz.o;

public final class c
{
  public static a a()
  {
    o.d("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 20;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.d;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 10;
    localb.b.c = paramString1;
    localb.b.b = paramString2;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.b.b;
  }
  
  public static boolean a(a parama)
  {
    o.d("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", new Object[] { Boolean.valueOf(parama.a) });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 19;
    localb.b.g = parama;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean a(b paramb)
  {
    o.d("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { paramb.a, paramb.b });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 18;
    localb.b.b = paramb.a;
    localb.b.e = paramb;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean a(String paramString)
  {
    o.e("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 2;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    o.d("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 4;
    localb.b.b = paramString;
    localb.b.d = paramInt;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean a(String paramString, b paramb)
  {
    o.e("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 1;
    localb.b.b = paramString;
    localb.b.e = paramb;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean b(b paramb)
  {
    o.e("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { paramb.a });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 0;
    localb.b.b = paramb.a;
    localb.b.e = paramb;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean b(String paramString)
  {
    o.d("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 3;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean c(String paramString)
  {
    o.d("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 5;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean d(String paramString)
  {
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 7;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean e(String paramString)
  {
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 17;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static d f(String paramString)
  {
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 6;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.c;
  }
  
  public static void g(String paramString)
  {
    o.d("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 12;
    localb.b.c = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
  }
  
  public static void h(String paramString)
  {
    o.d("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 9;
    localb.b.c = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
  }
  
  public static boolean i(String paramString)
  {
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 13;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static boolean j(String paramString)
  {
    o.d("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[] { paramString });
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 14;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.c.a;
  }
  
  public static b k(String paramString)
  {
    com.tencent.luggage.wxa.gz.b localb = new com.tencent.luggage.wxa.gz.b();
    localb.b.a = 16;
    localb.b.b = paramString;
    com.tencent.luggage.wxa.qd.a.a(localb);
    return localb.b.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.if.c
 * JD-Core Version:    0.7.0.1
 */