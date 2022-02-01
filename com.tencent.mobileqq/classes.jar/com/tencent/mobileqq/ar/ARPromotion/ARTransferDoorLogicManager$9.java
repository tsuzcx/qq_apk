package com.tencent.mobileqq.ar.ARPromotion;

import apce;
import bdla;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class ARTransferDoorLogicManager$9
  implements Runnable
{
  public ARTransferDoorLogicManager$9(apce paramapce) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    for (;;)
    {
      return;
      if (this.this$0.g == 2)
      {
        this.this$0.a.d(true);
        this.this$0.a.b(2);
      }
      while (apce.b(this.this$0))
      {
        bdla.b(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, apce.a(this.this$0), "0", "0", "");
        apce.b(this.this$0, false);
        return;
        this.this$0.a(false, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.9
 * JD-Core Version:    0.7.0.1
 */