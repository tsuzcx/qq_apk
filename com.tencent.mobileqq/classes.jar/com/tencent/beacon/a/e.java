package com.tencent.beacon.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.beacon.a.b.b;
import com.tencent.beacon.d.a;
import com.tencent.beacon.event.o;

public final class e
  extends BroadcastReceiver
  implements Runnable
{
  protected Context a;
  private boolean b = false;
  private Runnable c = new Runnable()
  {
    public final void run()
    {
      if (e.this.a != null) {
        h.c(e.this.a);
      }
    }
  };
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      a.b(" db events to up on netConnectChange", new Object[0]);
      try
      {
        o.d(true);
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
      a.c(" Context is null!", new Object[0]);
    }
    while (this.b) {
      return;
    }
    this.b = true;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext;
    c.a.a().a(this);
  }
  
  public final void run()
  {
    try
    {
      if (this.a == null)
      {
        a.c(" onReceive context is null!", new Object[0]);
        return;
      }
      localObject2 = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject2 == null)
      {
        a.c(" onReceive ConnectivityManager is null!", new Object[0]);
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
        break label174;
        label82:
        break label173;
        label83:
        b localb = b.a(this.a);
        if ((localb.a()) || (o.d().j() == 0) || (localb.j() == 2)) {
          break label185;
        }
        c.a().a(localb.d());
        break label185;
      }
    }
    for (;;)
    {
      if ((NetworkInfo.State.CONNECTED == localObject2) || (NetworkInfo.State.CONNECTED == localObject1))
      {
        c.a().a(this.d);
        c.a().a(this.c);
        return;
        localObject2 = null;
        break label174;
        localObject1 = null;
        break;
      }
      label173:
      return;
      label174:
      if ((localObject1 != null) || (localObject2 != null)) {
        break label83;
      }
      label185:
      if (localObject1 == null) {
        if (localObject2 == null) {
          break label82;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e
 * JD-Core Version:    0.7.0.1
 */