package com.tencent.mobileqq.ar.ARPromotion;

import android.widget.RelativeLayout;
import apce;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$5
  implements Runnable
{
  public ARTransferDoorLogicManager$5(apce paramapce, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a == true) {
      apce.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.d(apce.a, 2, "makeARTransferPromotionTouchViewVisiable " + this.a);
      return;
      apce.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */