package com.tencent.luggage.wxa.qg;

import com.tencent.luggage.wxa.qz.o;

public class i
{
  public static boolean a(String paramString)
  {
    return (h.e(paramString)) && (h.b(paramString) > 0L);
  }
  
  public static boolean b(String paramString)
  {
    com.tencent.luggage.wxa.ig.g localg = e.a(g.b(paramString));
    boolean bool2 = false;
    if (localg == null)
    {
      o.b("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
      return false;
    }
    boolean bool1 = bool2;
    if (h.e(paramString))
    {
      bool1 = bool2;
      if (h.b(paramString) > 0L)
      {
        bool1 = bool2;
        if (localg.b == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.i
 * JD-Core Version:    0.7.0.1
 */