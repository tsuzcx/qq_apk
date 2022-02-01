package com.tencent.ilivesdk.giftservice;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.NoLoginObserver.NoLoginReason;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnPresentGiftCallback;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;
import com.tencent.protobuf.payGiftSvr.nano.GivePayGiftReq;
import com.tencent.protobuf.payGiftSvr.nano.GivePayGiftRsp;

class GiftService$3
  implements ChannelCallback
{
  GiftService$3(GiftService paramGiftService, GiftServiceInterface.OnPresentGiftCallback paramOnPresentGiftCallback, GiftMessage paramGiftMessage, GivePayGiftReq paramGivePayGiftReq) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.val$callback;
      if (paramString != null) {
        paramString.onFail(201, "time out");
      }
    }
    else
    {
      GiftServiceInterface.OnPresentGiftCallback localOnPresentGiftCallback = this.val$callback;
      if (localOnPresentGiftCallback != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("not get data ");
        localStringBuilder.append(paramString);
        localOnPresentGiftCallback.onFail(paramInt, localStringBuilder.toString());
      }
    }
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = GivePayGiftRsp.parseFrom(paramArrayOfByte);
      if (paramArrayOfByte.result != 0)
      {
        if (this.val$callback != null)
        {
          this.val$giftMessage.mBalance = GiftService.access$700(this.this$0);
          this.val$giftMessage.sendGiftErrorCode = paramArrayOfByte.result;
          this.val$giftMessage.sendGiftErrorMsg = paramArrayOfByte.errMsg;
          this.val$callback.onPresentGiftFail(this.val$giftMessage);
        }
        if (paramArrayOfByte.result == 8) {
          this.this$0.queryAllGiftsInfo(this.val$req.roomId, 0, null);
        } else if (paramArrayOfByte.result == 17) {
          GiftService.access$800(this.this$0).getLoginService().notifyNoLogin(NoLoginObserver.NoLoginReason.TICKET_EXPIRED);
        } else if (paramArrayOfByte.result == 22) {
          return;
        }
        if (this.val$callback != null) {
          this.val$callback.onFail(paramArrayOfByte.result, paramArrayOfByte.errMsg);
        }
      }
      else
      {
        GiftService.access$702(this.this$0, paramArrayOfByte.balance);
        if (this.val$callback != null)
        {
          this.val$giftMessage.mBalance = GiftService.access$700(this.this$0);
          this.val$callback.onPresentGift(this.val$giftMessage);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.3
 * JD-Core Version:    0.7.0.1
 */