package com.tencent.beacon.core.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.core.info.e;
import com.tencent.beacon.event.UserAction;
import java.util.Map;

class h
  implements Runnable
{
  h(j paramj, Activity paramActivity) {}
  
  public void run()
  {
    Context localContext = this.a.getApplicationContext();
    e locale = e.d(localContext);
    j.a(this.b).put("A33", locale.k(localContext));
    Map localMap = j.a(this.b);
    if (a.f) {}
    for (String str = "Y";; str = "N")
    {
      localMap.put("A85", str);
      j.a(this.b).put("A20", locale.p(localContext));
      j.a(this.b).put("A69", locale.q(localContext));
      UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, j.a(this.b), true);
      TunnelModule.doUploadRecentCommonData(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.h
 * JD-Core Version:    0.7.0.1
 */