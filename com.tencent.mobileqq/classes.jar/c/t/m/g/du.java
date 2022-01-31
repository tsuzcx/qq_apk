package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class du
  extends BroadcastReceiver
{
  final de a;
  boolean b;
  
  public du(de paramde)
  {
    this.a = paramde;
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
      ev.a("TxNetworkStateMonitor", "listenNetworkState: Exception", paramContext);
      return;
    }
    if (ev.b(paramContext))
    {
      this.a.b(Integer.valueOf(1));
      return;
    }
    this.a.b(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.du
 * JD-Core Version:    0.7.0.1
 */