package com.tencent.beacon.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.StrategyQueryModule;

public final class d
  extends BroadcastReceiver
  implements Runnable
{
  private boolean a = false;
  private Context b;
  private boolean c = false;
  private Runnable d = new d.1();
  
  public final void a(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.beacon.core.d.b.d("[net] Context is null!", new Object[0]);
    }
    while (this.a) {
      return;
    }
    this.a = true;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b = paramContext.getApplicationContext();
    if (!this.c) {
      b.a.b().a(this);
    }
  }
  
  public final void run()
  {
    this.c = true;
    Object localObject2;
    try
    {
      if (this.b == null)
      {
        com.tencent.beacon.core.d.b.d("[net] onReceive context is null!", new Object[0]);
        return;
      }
      localObject2 = (ConnectivityManager)this.b.getSystemService("connectivity");
      if (localObject2 == null)
      {
        com.tencent.beacon.core.d.b.d("[net] onReceive ConnectivityManager is null!", new Object[0]);
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.d.b.a(localException);
    }
    label179:
    label190:
    label199:
    for (;;)
    {
      this.c = false;
      return;
      Object localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
      localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
      if (localObject1 != null)
      {
        localObject1 = ((NetworkInfo)localObject1).getState();
        label81:
        if (localObject2 != null)
        {
          localObject2 = ((NetworkInfo)localObject2).getState();
          break label179;
          label93:
          StrategyQueryModule localStrategyQueryModule = StrategyQueryModule.getInstance(this.b);
          if ((localStrategyQueryModule.isAtLeastAComQuerySuccess()) || (UserEventModule.getInstance() == null) || (StrategyQueryModule.getInstance(this.b).getCommonQueryTime() == 0) || (localStrategyQueryModule.getCurrentQueryStep() == 2)) {
            break label190;
          }
          localStrategyQueryModule.startQuery();
          break label190;
        }
      }
      for (;;)
      {
        if ((NetworkInfo.State.CONNECTED != localObject2) && (NetworkInfo.State.CONNECTED != localObject1)) {
          break label199;
        }
        b.b().a(this.d);
        break;
        localObject2 = null;
        break label179;
        localObject1 = null;
        break label81;
        if ((localObject1 != null) || (localObject2 != null)) {
          break label93;
        }
        if (localObject1 == null) {
          if (localObject2 == null) {
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.d
 * JD-Core Version:    0.7.0.1
 */