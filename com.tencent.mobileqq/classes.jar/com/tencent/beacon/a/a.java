package com.tencent.beacon.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.beacon.event.i;

public final class a
  implements Runnable
{
  private final Context a;
  private Object b;
  private boolean c = false;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.a.getSystemService("activity");
    b.e(this.a);
  }
  
  private void a()
  {
    if (this.b == null) {
      this.b = f.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
    }
    if (this.b != null)
    {
      int i = f.a("android.app.ActivityThread", this.b, "mNumVisibleActivities");
      if (i > 0)
      {
        com.tencent.beacon.d.a.a("mNumVisibleActivities equals " + i, new Object[0]);
        b.a = true;
      }
    }
  }
  
  public final void run()
  {
    com.tencent.beacon.d.a.a("Activity Monitor Task was started.", new Object[0]);
    int i = 0;
    int j;
    for (;;)
    {
      j = i + 1;
      if (i < 10)
      {
        if (b.a) {
          new i(this.a).b();
        }
      }
      else
      {
        com.tencent.beacon.d.a.a("Activity Monitor Task was exited.", new Object[0]);
        return;
      }
      if ((Integer.valueOf(Build.VERSION.SDK).intValue() < 18) && (this.b == null) && (!this.c))
      {
        new Handler(this.a.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            a.a(a.this);
          }
        });
        this.c = true;
      }
      for (;;)
      {
        try
        {
          Thread.sleep(5000L);
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          com.tencent.beacon.d.a.a(localInterruptedException);
          i = j;
        }
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a
 * JD-Core Version:    0.7.0.1
 */