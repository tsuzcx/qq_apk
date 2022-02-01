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
    ARScanEntryView.c(this.this$0);
    ARScanEntryView.d(this.this$0);
    ARScanEntryView.a(this.this$0, false);
    if ((this.this$0.d) && (this.this$0.j))
    {
      this.this$0.i();
      return;
    }
    ARScanEntryView.a(this.this$0, this.a.a.a.a);
    this.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.9
 * JD-Core Version:    0.7.0.1
 */