package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnQueryLGInfoListener;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryGiftInfoCallback;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;

class LiteLuxuryGiftModule$1$1
  implements GiftServiceInterface.OnQueryGiftInfoCallback
{
  LiteLuxuryGiftModule$1$1(LiteLuxuryGiftModule.1 param1, OnQueryLGInfoListener paramOnQueryLGInfoListener) {}
  
  public void onFail(int paramInt, String paramString) {}
  
  public void onGetGiftInfo(GiftInfo paramGiftInfo)
  {
    paramGiftInfo = LiteLuxuryGiftModule.access$500(this.this$1.this$0, paramGiftInfo);
    OnQueryLGInfoListener localOnQueryLGInfoListener = this.val$onQueryLGInfoLIstener;
    if (localOnQueryLGInfoListener != null) {
      localOnQueryLGInfoListener.onGetLuxuryGiftInfo(paramGiftInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.1.1
 * JD-Core Version:    0.7.0.1
 */