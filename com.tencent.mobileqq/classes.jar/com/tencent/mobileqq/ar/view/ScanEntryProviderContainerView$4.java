package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;

class ScanEntryProviderContainerView$4
  implements Runnable
{
  ScanEntryProviderContainerView$4(ScanEntryProviderContainerView paramScanEntryProviderContainerView, PromotionConfigInfo.PromotionItem paramPromotionItem) {}
  
  public void run()
  {
    ARScanEntryView localARScanEntryView;
    if ((ScanEntryProviderContainerView.f(this.this$0) != null) && ((ScanEntryProviderContainerView.f(this.this$0) instanceof ARScanEntryView)))
    {
      localARScanEntryView = (ARScanEntryView)ScanEntryProviderContainerView.f(this.this$0);
      localARScanEntryView.f(true);
    }
    else
    {
      localARScanEntryView = null;
    }
    if (localARScanEntryView != null) {
      localARScanEntryView.a(this.a);
    }
    if (this.this$0.j())
    {
      this.this$0.a("onTransferDoorAllReady", this.a, true);
      if (localARScanEntryView != null) {
        localARScanEntryView.a("onTransferDoorAllReady", this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.4
 * JD-Core Version:    0.7.0.1
 */