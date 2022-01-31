package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

final class dr$1
  extends TimerTask
{
  dr$1(HandlerThread paramHandlerThread, Handler paramHandler, Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      dr.a(this.a);
      if (this.d != null) {
        this.d.cancel();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!co.e()) {}
      co.a("timertask error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dr.1
 * JD-Core Version:    0.7.0.1
 */