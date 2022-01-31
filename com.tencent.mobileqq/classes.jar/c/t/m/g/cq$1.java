package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class cq$1
  extends BroadcastReceiver
{
  cq$1(cq paramcq) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = 0L;
    if ((paramIntent == null) || (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))) {
      return;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        co.a("intent:" + paramIntent + ",");
        if (bool) {
          break;
        }
        co.a(cq.a(this.a), 107, 2000L);
        if (cq.b(this.a) == null) {
          break;
        }
        paramContext = cq.b(this.a);
        if (2000L < 0L)
        {
          paramContext.a(1004, l);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        return;
      }
      l = 2000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.cq.1
 * JD-Core Version:    0.7.0.1
 */