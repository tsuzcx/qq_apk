package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class em
  extends BroadcastReceiver
{
  final ea a;
  boolean b;
  
  public em(ea paramea)
  {
    this.a = paramea;
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
      if (fn.b(paramContext))
      {
        this.a.b(Integer.valueOf(1));
        return;
      }
      this.a.b(Integer.valueOf(0));
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.em
 * JD-Core Version:    0.7.0.1
 */