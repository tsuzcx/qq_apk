package com.tencent.beacon.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.beacon.a.b.j;
import com.tencent.beacon.a.g.a;

public final class d
  extends BroadcastReceiver
  implements Runnable
{
  private boolean a = false;
  private Context b;
  private Runnable c = new Runnable()
  {
    public final void run()
    {
      try
      {
        j.c(true);
        return;
      }
      catch (Throwable localThrowable)
      {
        a.a(localThrowable);
      }
    }
  };
  
  public final void a(Context paramContext)
  {
    if (paramContext == null) {
      a.d("[net] Context is null!", new Object[0]);
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
    b.a.a().a(this);
  }
  
  public final void run()
  {
    try
    {
      if (this.b == null)
      {
        a.d("[net] onReceive context is null!", new Object[0]);
        return;
      }
      localObject2 = (ConnectivityManager)this.b.getSystemService("connectivity");
      if (localObject2 == null)
      {
        a.d("[net] onReceive ConnectivityManager is null!", new Object[0]);
        return;
      }
    }
    catch (Exception localException)
    {
      a.a(localException);
      return;
    }
    Object localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    Object localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if (localObject1 != null)
    {
      localObject1 = ((NetworkInfo)localObject1).getState();
      if (localObject2 != null)
      {
        localObject2 = ((NetworkInfo)localObject2).getState();
        break label168;
        label82:
        break label167;
        label83:
        com.tencent.beacon.a.e.b localb = com.tencent.beacon.a.e.b.j(this.b);
        if ((localb.g()) || (j.g() == null) || (com.tencent.beacon.a.e.b.j(this.b).q() == 0) || (localb.o() == 2)) {
          break label179;
        }
        localb.j();
        break label179;
      }
    }
    for (;;)
    {
      if ((NetworkInfo.State.CONNECTED == localObject2) || (NetworkInfo.State.CONNECTED == localObject1))
      {
        b.a().a(this.c);
        return;
        localObject2 = null;
        break label168;
        localObject1 = null;
        break;
      }
      label167:
      return;
      label168:
      if ((localObject1 != null) || (localObject2 != null)) {
        break label83;
      }
      label179:
      if (localObject1 == null) {
        if (localObject2 == null) {
          break label82;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.d
 * JD-Core Version:    0.7.0.1
 */