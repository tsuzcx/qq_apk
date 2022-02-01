package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class LuxuryGiftComponentImpl$2
  implements Runnable
{
  LuxuryGiftComponentImpl$2(LuxuryGiftComponentImpl paramLuxuryGiftComponentImpl) {}
  
  public void run()
  {
    if (LuxuryGiftComponentImpl.access$300(this.this$0) == null) {
      return;
    }
    this.this$0.getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "======================animationEnd-----------------", new Object[0]);
    LuxuryGiftComponentImpl.access$200(this.this$0).setPrePareState(false);
    this.this$0.getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " animationEnd  playNext", new Object[0]);
    LuxuryGiftComponentImpl.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftComponentImpl.2
 * JD-Core Version:    0.7.0.1
 */