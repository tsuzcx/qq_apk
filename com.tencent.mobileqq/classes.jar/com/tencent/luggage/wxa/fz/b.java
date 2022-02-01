package com.tencent.luggage.wxa.fz;

import com.tencent.luggage.wxa.hg.f;
import com.tencent.rtmp.TXLiveBase;

public class b
{
  private static boolean a;
  
  public static void a()
  {
    if (a) {
      return;
    }
    f.a("txffmpeg", b.class.getClassLoader());
    f.a("traeimp-rtmp", b.class.getClassLoader());
    f.a("liteavsdk", b.class.getClassLoader());
    b();
    a = true;
  }
  
  private static void b()
  {
    TXLiveBase.setLogLevel(1);
    TXLiveBase.setConsoleEnabled(false);
    TXLiveBase.setListener(new b.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fz.b
 * JD-Core Version:    0.7.0.1
 */