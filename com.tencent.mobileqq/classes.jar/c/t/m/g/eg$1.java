package c.t.m.g;

import android.location.LocationManager;

final class eg$1
  implements Runnable
{
  eg$1(eg parameg) {}
  
  public final void run()
  {
    try
    {
      bool1 = eg.b(this.a).h.addNmeaListener(eg.a(this.a));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          bool2 = eg.b(this.a).h.addGpsStatusListener(eg.a(this.a));
          if ((!bool1) && (!bool2))
          {
            fg.a = true;
            eg.c(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.eg.1
 * JD-Core Version:    0.7.0.1
 */