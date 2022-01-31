package com.tencent.beacon.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.beacon.a.b.e;

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
      this.b = com.tencent.beacon.a.a.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
    }
    if ((this.b != null) && (com.tencent.beacon.a.a.a("android.app.ActivityThread", this.b, "mNumVisibleActivities") > 0)) {
      com.tencent.beacon.a.c.a.a = true;
    }
  }
  
  public final void run()
  {
    int i = this.d;
    this.d = (i + 1);
    if (i < 10)
    {
      if (com.tencent.beacon.a.c.a.a)
      {
        new e(this.a).c();
        this.d = 10;
      }
    }
    else {
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
      b.a().a(this, 5000L);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.a
 * JD-Core Version:    0.7.0.1
 */