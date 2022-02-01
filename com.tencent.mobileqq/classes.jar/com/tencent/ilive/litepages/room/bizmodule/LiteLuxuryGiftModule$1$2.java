package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264ResListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;

class LiteLuxuryGiftModule$1$2
  implements IGetGiftEffectResListener
{
  LiteLuxuryGiftModule$1$2(LiteLuxuryGiftModule.1 param1, OnFetchH264ResListener paramOnFetchH264ResListener) {}
  
  public void onCompleted(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    this.val$listener.onFetchH264Res(LiteLuxuryGiftModule.access$1200(this.this$1.this$0, paramGiftEffectResourceInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.1.2
 * JD-Core Version:    0.7.0.1
 */