package com.tencent.beacon.stat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.atomic.AtomicLong;

class c
  implements Runnable
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  
  c(d paramd) {}
  
  public void run()
  {
    synchronized (this.c)
    {
      long l1 = d.a(this.c).get();
      long l2 = d.b(this.c).get();
      if ((this.a == l1) && (this.b == l2)) {
        return;
      }
      this.a = l1;
      this.b = l2;
      Object localObject1 = d.a(this.c, d.c(this.c)).edit();
      localObject1 = ((SharedPreferences.Editor)localObject1).putString("on_date", d.d(this.c));
      localObject1 = ((SharedPreferences.Editor)localObject1).putLong("realtime_log_id", this.a);
      ((SharedPreferences.Editor)localObject1).putLong("normal_log_id", this.b).apply();
      localObject1 = new StringBuilder();
      localObject1 = ((StringBuilder)localObject1).append("[LogID ").append(d.e(this.c));
      com.tencent.beacon.core.e.d.a("]  write serial to sp, date: %s ,realtime: %d, normal: %d ", new Object[] { d.d(this.c), Long.valueOf(this.a), Long.valueOf(this.b) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.c
 * JD-Core Version:    0.7.0.1
 */