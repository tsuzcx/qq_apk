package com.tencent.beacon.event.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.atomic.AtomicLong;

class d
  implements Runnable
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  
  d(e parame) {}
  
  public void run()
  {
    synchronized (this.c)
    {
      long l1 = e.a(this.c).get();
      long l2 = e.b(this.c).get();
      if ((this.a == l1) && (this.b == l2)) {
        return;
      }
      this.a = l1;
      this.b = l2;
      SharedPreferences.Editor localEditor = e.a(this.c, e.c(this.c)).edit();
      localEditor = localEditor.putString("on_date", e.d(this.c));
      localEditor = localEditor.putLong("realtime_log_id", this.a);
      localEditor.putLong("normal_log_id", this.b).apply();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.d
 * JD-Core Version:    0.7.0.1
 */