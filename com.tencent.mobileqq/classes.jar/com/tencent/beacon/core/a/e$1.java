package com.tencent.beacon.core.a;

import android.content.Context;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.event.UserAction;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(e parame, Context paramContext) {}
  
  public final void run()
  {
    d.a(this.a);
    e.a(this.b).put("A33", d.j(this.a));
    Map localMap = e.a(this.b);
    if (a.a) {}
    for (String str = "Y";; str = "N")
    {
      localMap.put("A85", str);
      e.a(this.b).put("A20", d.g(this.a));
      e.a(this.b).put("A69", d.h(this.a));
      UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, e.a(this.b), true);
      e.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.e.1
 * JD-Core Version:    0.7.0.1
 */