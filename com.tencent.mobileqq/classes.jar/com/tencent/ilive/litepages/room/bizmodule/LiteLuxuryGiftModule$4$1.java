package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import java.util.List;

class LiteLuxuryGiftModule$4$1
  implements IGetGiftEffectResListener
{
  LiteLuxuryGiftModule$4$1(LiteLuxuryGiftModule.4 param4, List paramList) {}
  
  public void onCompleted(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    if ((this.val$giftEffectResInfoList != null) && (paramGiftEffectResourceInfo != null))
    {
      LogInterface localLogInterface = LiteLuxuryGiftModule.access$800(this.this$1.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadLuxuryGift download complete = \n");
      localStringBuilder.append(paramGiftEffectResourceInfo.mGiftEffectId);
      localLogInterface.d("LiteLuxuryGiftModule", localStringBuilder.toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.4.1
 * JD-Core Version:    0.7.0.1
 */