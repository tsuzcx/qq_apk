package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

final class dt$1
  extends TimerTask
{
  dt$1(HandlerThread paramHandlerThread, Handler paramHandler, Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      dt.a(this.a);
      if (this.d != null) {
        this.d.cancel();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (co.e()) {
        co.a("timertask error.", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dt.1
 * JD-Core Version:    0.7.0.1
 */