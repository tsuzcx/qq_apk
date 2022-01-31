package com.tencent.mobileqq.ar.view;

import albj;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;

class ARScanEntryView$8
  implements Runnable
{
  ARScanEntryView$8(ARScanEntryView paramARScanEntryView, albj paramalbj) {}
  
  public void run()
  {
    ARScanEntryView.a(this.this$0, true);
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if ((this.this$0.c) && (this.this$0.i))
    {
      this.this$0.i();
      return;
    }
    ARScanEntryView.a(this.this$0, this.a.a.a.a);
    this.this$0.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.8
 * JD-Core Version:    0.7.0.1
 */