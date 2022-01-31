package com.tencent.ark;

import java.lang.ref.WeakReference;

class ArkViewModelBase$22
  implements Runnable
{
  ArkViewModelBase$22(ArkViewModelBase paramArkViewModelBase, long paramLong, String paramString1, String paramString2, WeakReference paramWeakReference) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.val$beginTick;
    ArkPerfMonitor.getInstance().addRecord(this.val$appID, this.val$view, l);
    ArkViewModelBase localArkViewModelBase = (ArkViewModelBase)this.val$weakThis.get();
    if (localArkViewModelBase != null)
    {
      localArkViewModelBase.mPerfTaskRunning = false;
      if (l > 30L) {
        localArkViewModelBase.runPerfStat();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.22
 * JD-Core Version:    0.7.0.1
 */