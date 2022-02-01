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
    } else {
      ARTransferDoorLogicManager.a(this.this$0).setVisibility(8);
    }
    String str = ARTransferDoorLogicManager.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("makeARTransferPromotionTouchViewVisiable ");
    localStringBuilder.append(this.a);
    QLog.d(str, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */