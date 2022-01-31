package c.t.m.g;

import android.content.Context;
import android.content.IntentFilter;

final class u
  implements Runnable
{
  public final void run()
  {
    try
    {
      o.e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      l.a().registerReceiver(o.m(), localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.u
 * JD-Core Version:    0.7.0.1
 */