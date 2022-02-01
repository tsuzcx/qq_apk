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
    if (paramBoolean) {
      if (this.val$callback != null) {
        this.val$callback.onFail(201, "time out");
      }
    }
    while (this.val$callback == null) {
      return;
    }
    this.val$callback.onFail(paramInt, "not get data " + paramString);
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
          this.val$callback.onPresentGiftFail(this.val$giftMessage);
        }
        if (paramArrayOfByte.result == 8) {
          this.this$0.queryAllGiftsInfo(this.val$req.roomId, 0, null);
        }
        while (this.val$callback != null)
        {
          this.val$callback.onFail(paramArrayOfByte.result, paramArrayOfByte.errMsg);
          return;
          if (paramArrayOfByte.result == 17) {
            GiftService.access$800(this.this$0).getLoginService().notifyNoLogin(NoLoginObserver.NoLoginReason.TICKET_EXPIRED);
          }
        }
      }
      GiftService.access$702(this.this$0, paramArrayOfByte.balance);
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    if (this.val$callback != null)
    {
      this.val$giftMessage.mBalance = GiftService.access$700(this.this$0);
      this.val$callback.onPresentGift(this.val$giftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.3
 * JD-Core Version:    0.7.0.1
 */