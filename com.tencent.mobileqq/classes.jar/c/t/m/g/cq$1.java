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
    if ((paramIntent == null) || (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))) {}
    for (;;)
    {
      return;
      try
      {
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        co.a("intent:" + paramIntent + ",");
        if (!bool)
        {
          co.a(cq.a(this.a), 107, 2000L);
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.cq.1
 * JD-Core Version:    0.7.0.1
 */