package c.t.m.g;

import android.os.SystemClock;

final class an
  implements Runnable
{
  an(am paramam, ag paramag, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    try
    {
      aj localaj = this.a.a();
      this.a.k = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localaj.a == 0)
      {
        int i = localaj.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      am.a(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.an
 * JD-Core Version:    0.7.0.1
 */