package com.tencent.beacon.core.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.beacon.core.e.f;
import com.tencent.beacon.core.event.m;

public class b
  implements Runnable
{
  private final Context a;
  private Object b;
  private boolean c = false;
  int d = 0;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a()
  {
    if (this.b == null) {
      this.b = f.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      int i = f.a("android.app.ActivityThread", localObject, "mNumVisibleActivities");
      if (i > 0)
      {
        com.tencent.beacon.core.e.d.a("[core] mNumVisibleActivities: " + i, new Object[0]);
        com.tencent.beacon.core.info.a.f = true;
      }
    }
  }
  
  private void b()
  {
    if ((Integer.valueOf(Build.VERSION.SDK).intValue() < 18) && (this.b == null) && (!this.c))
    {
      new Handler(this.a.getMainLooper()).post(new a(this));
      this.c = true;
      return;
    }
    a();
  }
  
  public void run()
  {
    if (this.d == 0) {
      com.tencent.beacon.core.e.d.a("[core] Activity Monitor Task was started.", new Object[0]);
    }
    int i = this.d;
    this.d = (i + 1);
    if (i < 10)
    {
      if (!com.tencent.beacon.core.info.a.f) {
        break label88;
      }
      com.tencent.beacon.core.e.d.a("[core] Found visible activity.", new Object[0]);
      new m(this.a).c();
      this.d = 10;
    }
    for (;;)
    {
      if (this.d == 10) {
        com.tencent.beacon.core.e.d.a("[core] Activity Monitor Task was exited.", new Object[0]);
      }
      return;
      label88:
      b();
      d.a().a(this, 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.b
 * JD-Core Version:    0.7.0.1
 */