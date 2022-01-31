package com.tencent.beacon.core.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.beacon.core.d.e;
import com.tencent.beacon.core.event.f;

public final class a
  implements Runnable
{
  private final Context a;
  private Object b;
  private boolean c = false;
  private int d = 0;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a()
  {
    if (this.b == null) {
      this.b = e.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
    }
    if (this.b != null)
    {
      int i = e.a("android.app.ActivityThread", this.b, "mNumVisibleActivities");
      if (i > 0)
      {
        com.tencent.beacon.core.d.b.b("[core] mNumVisibleActivities: " + i, new Object[0]);
        com.tencent.beacon.core.b.a.a = true;
      }
    }
  }
  
  public final void run()
  {
    if (this.d == 0) {
      com.tencent.beacon.core.d.b.b("[core] Activity Monitor Task was started.", new Object[0]);
    }
    int i = this.d;
    this.d = (i + 1);
    if (i < 10)
    {
      if (com.tencent.beacon.core.b.a.a)
      {
        com.tencent.beacon.core.d.b.b("[core] Found visible activity.", new Object[0]);
        new f(this.a).c();
        this.d = 10;
      }
    }
    else
    {
      if (this.d == 10) {
        com.tencent.beacon.core.d.b.b("[core] Activity Monitor Task was exited.", new Object[0]);
      }
      return;
    }
    if ((Integer.valueOf(Build.VERSION.SDK).intValue() < 18) && (this.b == null) && (!this.c))
    {
      new Handler(this.a.getMainLooper()).post(new a.1(this));
      this.c = true;
    }
    for (;;)
    {
      b.b().a(this, 5000L);
      break;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.a
 * JD-Core Version:    0.7.0.1
 */