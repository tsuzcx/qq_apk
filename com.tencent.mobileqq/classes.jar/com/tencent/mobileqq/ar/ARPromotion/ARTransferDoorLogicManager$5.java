package com.tencent.mobileqq.ar.ARPromotion;

import android.widget.RelativeLayout;
import anzc;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$5
  implements Runnable
{
  public ARTransferDoorLogicManager$5(anzc paramanzc, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a == true) {
      anzc.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.d(anzc.a, 2, "makeARTransferPromotionTouchViewVisiable " + this.a);
      return;
      anzc.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */