package com.tencent.mobileqq.ar.ARPromotion;

import akjt;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$5
  implements Runnable
{
  public ARTransferDoorLogicManager$5(akjt paramakjt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a == true) {
      akjt.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.d(akjt.a, 2, "makeARTransferPromotionTouchViewVisiable " + this.a);
      return;
      akjt.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */