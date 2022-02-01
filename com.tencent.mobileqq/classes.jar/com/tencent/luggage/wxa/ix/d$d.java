package com.tencent.luggage.wxa.ix;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qz.o;

final class d$d
  extends f
{
  d$d(d paramd, g paramg)
  {
    super(paramg);
  }
  
  public void a()
  {
    super.a();
    if (d.j(this.a).A().Q == 2147483647) {
      return;
    }
    this.a.r().sendEmptyMessageDelayed(d.a.d.a(), d.j(this.a).A().Q * 1000L);
  }
  
  public boolean a(Message paramMessage)
  {
    int i = d.7.b[d.a.a(paramMessage.what).ordinal()];
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return super.a(paramMessage);
        }
        paramMessage = this.a;
        d.a(paramMessage, d.d(paramMessage));
        return true;
      }
      o.d(d.k(this.a), "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
      paramMessage = this.a;
      d.a(paramMessage, d.b(paramMessage));
      return true;
    }
    if (d.j(this.a).ad())
    {
      paramMessage = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(paramMessage);
      o.d(d.k(this.a), "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", new Object[] { Integer.valueOf(paramMessage.importance) });
      if (paramMessage.importance == 100)
      {
        paramMessage = this.a;
        d.a(paramMessage, d.b(paramMessage));
        return true;
      }
    }
    paramMessage = this.a;
    d.a(paramMessage, d.e(paramMessage));
    return true;
  }
  
  public void b()
  {
    super.b();
    this.a.r().removeMessages(d.a.d.a());
  }
  
  public String c()
  {
    return "|BackgroundTemporary";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.d
 * JD-Core Version:    0.7.0.1
 */