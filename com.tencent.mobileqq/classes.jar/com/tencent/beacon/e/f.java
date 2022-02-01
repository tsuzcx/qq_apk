package com.tencent.beacon.e;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.util.b;
import java.util.Date;

class f
  implements Runnable
{
  f(g paramg, String paramString1, String paramString2) {}
  
  public void run()
  {
    Date localDate = b.d(this.a);
    long l1;
    if (localDate != null) {
      l1 = localDate.getTime() / 1000L;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 == 0L) {
      l2 = new Date().getTime() / 1000L + 86400L;
    }
    a.a().edit().putString("sid_value", this.b).putLong("sid_mt", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.f
 * JD-Core Version:    0.7.0.1
 */