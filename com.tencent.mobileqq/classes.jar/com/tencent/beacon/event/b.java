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
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject;
      try
      {
        localObject = UserAction.mContext;
        localObject = (c)f.a(str, "getInstance", new Class[] { Context.class }, new Object[] { localObject });
        if (localObject == null) {
          break label135;
        }
        d.d("[core] %s module load successfully.", new Object[] { str });
        UserAction.beaconModules.add(localObject);
      }
      catch (Exception localException) {}
      continue;
      label135:
      if (!localException.contains("nativeaudit"))
      {
        localObject = com.tencent.beacon.core.d.i.a(this.a);
        StringBuilder localStringBuilder2 = new StringBuilder();
        StringBuilder localStringBuilder1 = localStringBuilder2.append("[core] SDK init ").append(localException);
        ((com.tencent.beacon.core.d.i)localObject).a("201", " fail!");
      }
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */