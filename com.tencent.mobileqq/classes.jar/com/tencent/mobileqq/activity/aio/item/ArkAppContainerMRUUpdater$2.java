package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.qqperf.monitor.base.IAPMMemoryClearListener;
import com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig.MemoryLevelInfo;

class ArkAppContainerMRUUpdater$2
  implements IAPMMemoryClearListener
{
  ArkAppContainerMRUUpdater$2(ArkAppContainerMRUUpdater paramArkAppContainerMRUUpdater) {}
  
  public void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo) {}
  
  public void a(long paramLong)
  {
    ArkAppContainerMRUUpdater.a("onLowMemory");
    ArkAppContainerMRUUpdater.c().sendMessage(ArkAppContainerMRUUpdater.c().obtainMessage(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainerMRUUpdater.2
 * JD-Core Version:    0.7.0.1
 */