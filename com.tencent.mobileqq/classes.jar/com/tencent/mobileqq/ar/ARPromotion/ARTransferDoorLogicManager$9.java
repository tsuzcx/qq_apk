package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.statistics.ReportController;

class ARTransferDoorLogicManager$9
  implements Runnable
{
  ARTransferDoorLogicManager$9(ARTransferDoorLogicManager paramARTransferDoorLogicManager) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if (this.this$0.g == 2)
    {
      this.this$0.a.d(true);
      this.this$0.a.b(2);
    }
    else
    {
      this.this$0.a(false, "");
    }
    if (ARTransferDoorLogicManager.b(this.this$0))
    {
      ReportController.b(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, ARTransferDoorLogicManager.a(this.this$0), "0", "0", "");
      ARTransferDoorLogicManager.b(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.9
 * JD-Core Version:    0.7.0.1
 */