package com.tencent.ilive.litepages.room.bizmodule;

import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.litepages.room.webmodule.event.StopLuxuryAnimationPlayEvent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;

class LiteLuxuryGiftModule$5
  implements Observer<StopLuxuryAnimationPlayEvent>
{
  LiteLuxuryGiftModule$5(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onChanged(StopLuxuryAnimationPlayEvent paramStopLuxuryAnimationPlayEvent)
  {
    LiteLuxuryGiftModule.access$800(this.this$0).d("LiteLuxuryGiftModule", "StopLuxuryAnimationPlayEvent stopLuxuyAnimationAndHide", new Object[0]);
    if (LiteLuxuryGiftModule.access$1600(this.this$0) != null) {
      LiteLuxuryGiftModule.access$1600(this.this$0).stopLuxuyAnimationAndHide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.5
 * JD-Core Version:    0.7.0.1
 */