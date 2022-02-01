package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;

class ARScanEntryView$9
  implements Runnable
{
  ARScanEntryView$9(ARScanEntryView paramARScanEntryView, ARTarget paramARTarget) {}
  
  public void run()
  {
    ARScanEntryView.b(this.this$0, true);
    ARScanEntryView.m(this.this$0);
    ARScanEntryView.n(this.this$0);
    ARScanEntryView.c(this.this$0, false);
    if ((this.this$0.s) && (this.this$0.B))
    {
      this.this$0.i();
      return;
    }
    ARScanEntryView.a(this.this$0, this.a.a.m.c);
    this.this$0.t = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */