package com.tencent.mobileqq.ar.ARPromotion;

import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class ARTransferDoorLogicManager$5
  implements Runnable
{
  ARTransferDoorLogicManager$5(ARTransferDoorLogicManager paramARTransferDoorLogicManager, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a == true) {
      ARTransferDoorLogicManager.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.d(ARTransferDoorLogicManager.a, 2, "makeARTransferPromotionTouchViewVisiable " + this.a);
      return;
      ARTransferDoorLogicManager.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */