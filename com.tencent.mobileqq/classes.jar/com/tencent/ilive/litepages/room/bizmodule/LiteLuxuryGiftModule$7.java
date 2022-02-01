package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.datamodel.RoomState;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.ReceiveGiftMessageListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;

class LiteLuxuryGiftModule$7
  implements GiftServiceInterface.ReceiveGiftMessageListener
{
  LiteLuxuryGiftModule$7(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public void onGiftMessageReceive(GiftMessage paramGiftMessage)
  {
    LogInterface localLogInterface = LiteLuxuryGiftModule.access$800(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("giftMessage.messageType is ");
    localStringBuilder.append(paramGiftMessage.mMessageType);
    localStringBuilder.append(" giftMessage.giftType is ");
    localStringBuilder.append(paramGiftMessage.mGiftType);
    localLogInterface.d("LiteLuxuryGiftModule", localStringBuilder.toString(), new Object[0]);
    if ((paramGiftMessage.mMessageType == 4) && (paramGiftMessage.mGiftType == 104))
    {
      if (this.this$0.getRoomBizContext().getRoomState().isSwipedScreen)
      {
        LiteLuxuryGiftModule.access$800(this.this$0).d("LiteLuxuryGiftModule", "luxury show swipe screen return ", new Object[0]);
        return;
      }
      paramGiftMessage = LiteLuxuryGiftModule.access$1800(this.this$0, paramGiftMessage);
      LiteLuxuryGiftModule.access$1600(this.this$0).displayLuxuryGift(paramGiftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.7
 * JD-Core Version:    0.7.0.1
 */