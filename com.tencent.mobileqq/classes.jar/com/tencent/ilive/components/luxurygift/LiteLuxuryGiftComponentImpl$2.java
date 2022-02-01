package com.tencent.ilive.components.luxurygift;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class LiteLuxuryGiftComponentImpl$2
  implements Runnable
{
  LiteLuxuryGiftComponentImpl$2(LiteLuxuryGiftComponentImpl paramLiteLuxuryGiftComponentImpl) {}
  
  public void run()
  {
    if (LiteLuxuryGiftComponentImpl.access$300(this.this$0) == null) {
      return;
    }
    this.this$0.getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "======================animationEnd-----------------", new Object[0]);
    LiteLuxuryGiftComponentImpl.access$200(this.this$0).setPrePareState(false);
    this.this$0.getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " animationEnd  playNext", new Object[0]);
    LiteLuxuryGiftComponentImpl.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftComponentImpl.2
 * JD-Core Version:    0.7.0.1
 */