package com.tencent.beacon.base.net.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.RequiresPermission;
import com.tencent.beacon.a.b.a;
import com.tencent.beacon.base.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BroadcastReceiver
  implements Runnable
{
  private static final List<e.a> a = new ArrayList();
  private static volatile boolean b = false;
  private boolean c = true;
  private volatile boolean d = false;
  
  private void a()
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(Context paramContext, e.a parama)
  {
    if (paramContext == null)
    {
      c.b("[net] context == null!", new Object[0]);
      return;
    }
    synchronized (a)
    {
      if (!a.contains(parama)) {
        a.add(parama);
      }
      if (!b)
      {
        parama = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.registerReceiver(new e(), parama);
        b = true;
      }
      return;
    }
  }
  
  public static void a(e.a parama)
  {
    synchronized (a)
    {
      a.remove(parama);
      return;
    }
  }
  
  private void b()
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).b();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.c)
    {
      this.c = false;
      return;
    }
    if (!this.d) {
      a.a().a(this);
    }
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public void run()
  {
    this.d = true;
    if (d.d())
    {
      c.d("[net] current network available!", new Object[0]);
      a();
    }
    else
    {
      c.d("[net] current network unavailable!", new Object[0]);
      b();
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.c.e
 * JD-Core Version:    0.7.0.1
 */