package c.t.m.g;

import android.os.SystemClock;

final class as
  implements Runnable
{
  as(ar paramar, al paramal, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    try
    {
      ao localao = this.a.a();
      this.a.k = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localao.a == 0)
      {
        int i = localao.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      ar.a(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.as
 * JD-Core Version:    0.7.0.1
 */