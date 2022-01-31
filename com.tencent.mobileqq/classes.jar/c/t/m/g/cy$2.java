package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

final class cy$2
  extends TimerTask
{
  cy$2(cy paramcy, Timer paramTimer) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cy.2
 * JD-Core Version:    0.7.0.1
 */