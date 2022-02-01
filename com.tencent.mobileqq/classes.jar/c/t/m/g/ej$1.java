package c.t.m.g;

import android.location.LocationManager;

final class ej$1
  implements Runnable
{
  ej$1(ej paramej) {}
  
  public final void run()
  {
    try
    {
      bool1 = ej.b(this.a).h.addNmeaListener(ej.a(this.a));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          bool2 = ej.b(this.a).h.addGpsStatusListener(ej.a(this.a));
          if ((!bool1) && (!bool2))
          {
            fj.a = true;
            ej.c(this.a);
          }
          return;
          localThrowable1 = localThrowable1;
          boolean bool1 = true;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          boolean bool2 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ej.1
 * JD-Core Version:    0.7.0.1
 */