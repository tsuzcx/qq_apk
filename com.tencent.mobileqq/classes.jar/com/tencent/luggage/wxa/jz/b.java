package com.tencent.luggage.wxa.jz;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.rp.g;
import com.tencent.luggage.wxa.rp.h;
import com.tencent.luggage.wxa.sc.d;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static s a;
  private static volatile HandlerThread b;
  private static String c = "app_brand_audio_player";
  private static Object d = new Object();
  private static AtomicInteger e = new AtomicInteger(0);
  
  private static void a()
  {
    if (b == null)
    {
      b = d.c(c, 5);
      b.start();
      h localh = new h(b.getLooper(), c);
      g.a(c, localh);
    }
    a = new s(b.getLooper());
  }
  
  public static void a(Runnable paramRunnable)
  {
    synchronized (d)
    {
      if (a != null)
      {
        a.a(paramRunnable);
      }
      else
      {
        o.c("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
        a();
        a.a(paramRunnable);
      }
      return;
    }
  }
  
  public static void a(String arg0)
  {
    o.d("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", new Object[] { ??? });
    if (e.incrementAndGet() == 1) {
      synchronized (d)
      {
        a();
        return;
      }
    }
  }
  
  private static void b()
  {
    if (b == null) {
      return;
    }
    if (b != null)
    {
      g.a(c);
      b.quit();
      b = null;
      a = null;
    }
  }
  
  public static void b(String arg0)
  {
    o.d("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", new Object[] { ??? });
    if (e.decrementAndGet() == 0) {
      synchronized (d)
      {
        b();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.b
 * JD-Core Version:    0.7.0.1
 */