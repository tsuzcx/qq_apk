package com.tencent.ilive.litepages.room.bizmodule;

import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.litepages.room.webmodule.event.PreloadLuxuryAnimationEvent;
import java.util.ArrayList;

class LiteLuxuryGiftModule$3
  implements Observer<PreloadLuxuryAnimationEvent>
{
  LiteLuxuryGiftModule$3(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onChanged(PreloadLuxuryAnimationEvent paramPreloadLuxuryAnimationEvent)
  {
    if ((paramPreloadLuxuryAnimationEvent == null) || (paramPreloadLuxuryAnimationEvent.effectIds == null) || (paramPreloadLuxuryAnimationEvent.effectIds.size() == 0)) {
      return;
    }
    LiteLuxuryGiftModule.access$900(this.this$0).d("LiteLuxuryGiftModule", "PreloadLuxuryAnimationEvent preloadLuxuryGift", new Object[0]);
    LiteLuxuryGiftModule.access$1800(this.this$0, paramPreloadLuxuryAnimationEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.3
 * JD-Core Version:    0.7.0.1
 */