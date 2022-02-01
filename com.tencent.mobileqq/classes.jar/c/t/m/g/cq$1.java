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
    if (paramIntent != null) {
      if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
        return;
      }
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
      paramContext = new StringBuilder("intent:");
      paramContext.append(paramIntent);
      paramContext.append(",");
      co.a(paramContext.toString());
      if (!bool) {
        co.a(cq.a(this.a), 107, 2000L);
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cq.1
 * JD-Core Version:    0.7.0.1
 */