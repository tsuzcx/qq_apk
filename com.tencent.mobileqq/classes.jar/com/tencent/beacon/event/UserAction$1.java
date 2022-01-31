package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.core.a;
import com.tencent.beacon.core.d.e;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.c;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;

final class UserAction$1
  implements Runnable
{
  UserAction$1(InitHandleListener paramInitHandleListener, long paramLong) {}
  
  public final void run()
  {
    UserAction.beaconModules.add(UserEventModule.getInstance(UserAction.mContext));
    UserAction.beaconModules.add(TunnelModule.getInstance(UserAction.mContext));
    Iterator localIterator = a.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject = UserAction.mContext;
        localObject = (com.tencent.beacon.core.b)e.a(str, "getInstance", new Class[] { Context.class }, new Object[] { localObject });
        if (localObject != null)
        {
          com.tencent.beacon.core.d.b.a("[core] %s module load successfully.", new Object[] { str });
          UserAction.beaconModules.add(localObject);
        }
      }
      catch (Exception localException) {}
    }
    StrategyQueryModule.getInstance(UserAction.mContext).setInitHandleListener(this.a);
    UserAction.beaconModules.add(StrategyQueryModule.getInstance(UserAction.mContext));
    localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.beacon.core.b)localIterator.next()).onSDKInit(UserAction.mContext);
    }
    long l2 = this.b;
    if (l2 > 0L)
    {
      long l1 = l2;
      if (l2 > 10000L) {
        l1 = 10000L;
      }
      c.a(l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction.1
 * JD-Core Version:    0.7.0.1
 */