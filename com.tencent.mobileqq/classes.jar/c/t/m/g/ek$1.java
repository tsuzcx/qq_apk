package c.t.m.g;

import android.location.LocationManager;

final class ek$1
  implements Runnable
{
  ek$1(ek paramek) {}
  
  public final void run()
  {
    try
    {
      bool1 = ek.b(this.a).h.addNmeaListener(ek.a(this.a));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          bool2 = ek.b(this.a).h.addGpsStatusListener(ek.a(this.a));
          if ((!bool1) && (!bool2))
          {
            fj.a = true;
            ek.c(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ek.1
 * JD-Core Version:    0.7.0.1
 */