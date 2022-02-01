package com.tencent.mobileqq.ar.view;

import aosj;

class ScanEntryProviderContainerView$4
  implements Runnable
{
  ScanEntryProviderContainerView$4(ScanEntryProviderContainerView paramScanEntryProviderContainerView, aosj paramaosj) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (ScanEntryProviderContainerView.a(this.this$0) != null)
    {
      localObject1 = localObject2;
      if ((ScanEntryProviderContainerView.a(this.this$0) instanceof ARScanEntryView))
      {
        localObject1 = (ARScanEntryView)ScanEntryProviderContainerView.a(this.this$0);
        ((ARScanEntryView)localObject1).e(true);
      }
    }
    if (localObject1 != null) {
      ((ARScanEntryView)localObject1).a(this.a);
    }
    if (this.this$0.c())
    {
      this.this$0.a("onTransferDoorAllReady", this.a, true);
      if (localObject1 != null) {
        ((ARScanEntryView)localObject1).a("onTransferDoorAllReady", this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.4
 * JD-Core Version:    0.7.0.1
 */