package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

public final class dq
  extends BroadcastReceiver
{
  private final da a;
  private boolean b;
  
  public dq(da paramda)
  {
    this.a = paramda;
  }
  
  public final void a()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    try
    {
      this.a.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void a(Handler paramHandler)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.a.a.registerReceiver(this, localIntentFilter, null, paramHandler);
      return;
    }
    catch (Exception paramHandler)
    {
      f.a.a("TxNetworkStateMonitor", "listenNetworkState: failed", paramHandler);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      if (paramIntent.getBooleanExtra("noConnectivity", false))
      {
        this.a.b(Integer.valueOf(-1));
        return;
      }
    }
    catch (Exception paramContext)
    {
      f.a.a("TxNetworkStateMonitor", "listenNetworkState: Exception", paramContext);
      return;
    }
    if (f.a.e(paramContext))
    {
      this.a.b(Integer.valueOf(1));
      return;
    }
    this.a.b(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dq
 * JD-Core Version:    0.7.0.1
 */