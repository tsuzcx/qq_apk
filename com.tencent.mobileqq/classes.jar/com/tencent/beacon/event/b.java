package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.f;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;

final class b
  implements Runnable
{
  b(Context paramContext, InitHandleListener paramInitHandleListener, long paramLong) {}
  
  public void run()
  {
    UserAction.beaconModules.add(UserEventModule.getInstance(UserAction.mContext));
    UserAction.beaconModules.add(TunnelModule.getInstance(UserAction.mContext));
    Iterator localIterator = com.tencent.beacon.core.b.a.iterator();
    for (;;)
    {
      Object localObject1;
      if (localIterator.hasNext()) {
        localObject1 = (String)localIterator.next();
      }
      try
      {
        Object localObject2 = UserAction.mContext;
        localObject2 = (c)f.a((String)localObject1, "getInstance", new Class[] { Context.class }, new Object[] { localObject2 });
        if (localObject2 != null)
        {
          d.d("[core] %s module load successfully.", new Object[] { localObject1 });
          UserAction.beaconModules.add(localObject2);
          continue;
        }
        localObject2 = com.tencent.beacon.core.d.i.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localStringBuilder.append("[core] SDK init ").append((String)localObject1);
        ((com.tencent.beacon.core.d.i)localObject2).a("201", " fail!");
      }
      catch (Exception localException) {}
      StrategyQueryModule.getInstance(UserAction.mContext).setInitHandleListener(this.b);
      UserAction.beaconModules.add(StrategyQueryModule.getInstance(UserAction.mContext));
      localIterator = UserAction.beaconModules.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).onSDKInit(UserAction.mContext);
      }
      QimeiSDK.getInstance().init(UserAction.mContext);
      long l2 = this.c;
      if (l2 > 0L)
      {
        long l1 = l2;
        if (l2 > 10000L) {
          l1 = 10000L;
        }
        com.tencent.beacon.core.strategy.i.a(l1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */