package com.tencent.beacon.d;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.net.c.d;

class b
  implements Runnable
{
  b(c paramc, String paramString, a parama) {}
  
  public void run()
  {
    if (!d.d()) {
      return;
    }
    boolean bool = c.a(this.c);
    if ((c.b(this.c)) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[event] rqd_heartbeat A85=Y report success : ");
      localStringBuilder.append(this.a);
      com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
      this.b.edit().putString("active_user_date", this.a).commit();
      this.b.edit().putString("HEART_DENGTA", this.a).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.d.b
 * JD-Core Version:    0.7.0.1
 */