package com.tencent.beacon.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  extends BroadcastReceiver
  implements Runnable
{
  private static volatile g a;
  private static final List<g.a> b = new ArrayList();
  private Context c;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private boolean f = true;
  
  public static g a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, g.a parama)
  {
    if (paramContext == null) {
      com.tencent.beacon.core.e.d.b("[net] Context is null!", new Object[0]);
    }
    for (;;)
    {
      return;
      synchronized (b)
      {
        b.add(parama);
        if (this.e) {
          continue;
        }
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.e = true;
        return;
      }
    }
  }
  
  public void a(g.a parama)
  {
    synchronized (b)
    {
      b.remove(parama);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.c = paramContext.getApplicationContext();
    if (this.f) {
      this.f = false;
    }
    while (this.d) {
      return;
    }
    d.a().a(this);
  }
  
  public void run()
  {
    this.d = true;
    try
    {
      Context localContext = this.c;
      if (localContext == null)
      {
        com.tencent.beacon.core.e.d.b("[net] onReceive context is null!", new Object[0]);
        return;
      }
      localContext = this.c;
      localObject2 = (ConnectivityManager)localContext.getSystemService("connectivity");
      if (localObject2 != null) {
        break label64;
      }
      com.tencent.beacon.core.e.d.b("[net] onReceive ConnectivityManager is null!", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.e.d.a(localException);
    }
    this.d = false;
    return;
    label64:
    ??? = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    Object localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if (??? != null) {}
    for (??? = ((NetworkInfo)???).getState();; ??? = null)
    {
      if (localObject2 != null) {}
      Object localObject4;
      for (localObject2 = ((NetworkInfo)localObject2).getState();; localObject4 = null)
      {
        if ((NetworkInfo.State.CONNECTED != localObject2) && (NetworkInfo.State.CONNECTED != ???)) {
          break label162;
        }
        synchronized (b)
        {
          localObject2 = b.iterator();
          if (((Iterator)localObject2).hasNext()) {
            ((g.a)((Iterator)localObject2).next()).a();
          }
        }
        break;
      }
      label162:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.g
 * JD-Core Version:    0.7.0.1
 */