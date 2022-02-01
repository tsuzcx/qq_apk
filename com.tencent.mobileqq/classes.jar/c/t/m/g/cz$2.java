package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

final class cz$2
  extends TimerTask
{
  cz$2(cz paramcz, Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      this.a.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a("timer cancel error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cz.2
 * JD-Core Version:    0.7.0.1
 */