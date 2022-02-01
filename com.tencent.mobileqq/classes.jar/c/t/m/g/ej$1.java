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
      boolean bool1;
      label24:
      label50:
      break label24;
    }
    bool1 = true;
    try
    {
      bool2 = ej.b(this.a).h.addGpsStatusListener(ej.a(this.a));
    }
    catch (Throwable localThrowable2)
    {
      boolean bool2;
      break label50;
    }
    bool2 = true;
    if ((!bool1) && (!bool2))
    {
      fj.a = true;
      ej.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ej.1
 * JD-Core Version:    0.7.0.1
 */