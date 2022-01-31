package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.b;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class h
  implements Runnable
{
  private Context a;
  private int b;
  private int c = -1;
  private Map<String, String> d = new HashMap(2);
  private int e = 0;
  
  public h(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.e = Calendar.getInstance().get(5);
    this.d.put("A63", "N");
    this.d.put("A66", "F");
  }
  
  public final void run()
  {
    boolean bool;
    if (this.b > 0)
    {
      bool = b.h(this.a);
      int i = Calendar.getInstance().get(5);
      if (i != this.e)
      {
        this.e = i;
        new i(this.a, bool).a(true);
      }
      if (this.c == -1) {
        break label182;
      }
      if ((this.c != 0) || (!bool)) {
        break label164;
      }
      localObject = this.d;
      f.a(this.a);
      ((Map)localObject).put("A33", f.l(this.a));
      localMap = this.d;
      if (!b.a) {
        break label158;
      }
      localObject = "Y";
      localMap.put("A85", localObject);
      o.a("rqd_applaunched", true, 0L, this.d);
      a.a(" create a applaunched event", new Object[0]);
      this.c = 1;
      o.d(true);
    }
    label158:
    label164:
    while ((bool) || (this.c != 1)) {
      for (;;)
      {
        return;
        localObject = "N";
      }
    }
    label182:
    while (!bool)
    {
      Object localObject;
      Map localMap;
      this.c = 0;
      return;
    }
    this.c = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.h
 * JD-Core Version:    0.7.0.1
 */