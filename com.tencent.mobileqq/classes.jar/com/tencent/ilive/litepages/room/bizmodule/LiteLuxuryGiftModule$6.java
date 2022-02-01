package com.tencent.ilive.litepages.room.bizmodule;

import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.litepages.room.webmodule.event.ClearLuxuryQueueEvent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;

class LiteLuxuryGiftModule$6
  implements Observer<ClearLuxuryQueueEvent>
{
  LiteLuxuryGiftModule$6(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onChanged(ClearLuxuryQueueEvent paramClearLuxuryQueueEvent)
  {
    LiteLuxuryGiftModule.access$800(this.this$0).d("LiteLuxuryGiftModule", "ClearLuxuryQueueEvent clearLuxuryQueue", new Object[0]);
    if (LiteLuxuryGiftModule.access$1600(this.this$0) != null) {
      LiteLuxuryGiftModule.access$1600(this.this$0).clearLuxuryQueue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.6
 * JD-Core Version:    0.7.0.1
 */