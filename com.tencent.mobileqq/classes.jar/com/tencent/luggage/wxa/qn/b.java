package com.tencent.luggage.wxa.qn;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static b a;
  private Context b;
  private ConcurrentHashMap<Class<? extends a>, a> c = new ConcurrentHashMap();
  
  private b(Context paramContext)
  {
    this.b = paramContext;
    b();
  }
  
  public static <T extends a> T a(Class<T> paramClass)
  {
    return (a)a().c.get(paramClass);
  }
  
  public static b a()
  {
    if (a == null) {
      a(null);
    }
    return a;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      b localb = a;
      if (localb != null) {
        return;
      }
      o.d("MicroMsg.Audio.AudioPlayerCoreService", "create");
      a = new b(paramContext);
      return;
    }
    finally {}
  }
  
  private void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qn.b
 * JD-Core Version:    0.7.0.1
 */