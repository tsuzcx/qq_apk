package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web.IRichGiftShowPlay;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;

class LuxuryGiftController$3
  implements IRichGiftShowPlay
{
  LuxuryGiftController$3(LuxuryGiftController paramLuxuryGiftController) {}
  
  public void onEnd()
  {
    this.this$0.setPrePareState(false);
    if (LuxuryGiftController.access$700(this.this$0) == null) {
      return;
    }
    if (LuxuryGiftController.access$700(this.this$0).giftType != 101) {
      LuxuryGiftController.access$800(this.this$0);
    }
  }
  
  public void onError(int paramInt)
  {
    this.this$0.setPrePareState(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.3
 * JD-Core Version:    0.7.0.1
 */