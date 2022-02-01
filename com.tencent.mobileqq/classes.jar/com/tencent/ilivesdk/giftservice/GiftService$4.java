package com.tencent.ilivesdk.giftservice;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryGiftInfoCallback;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGetGiftRsp;
import java.util.Map;

class GiftService$4
  implements ChannelCallback
{
  GiftService$4(GiftService paramGiftService, GiftServiceInterface.OnQueryGiftInfoCallback paramOnQueryGiftInfoCallback) {}
  
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
      GiftServiceInterface.OnQueryGiftInfoCallback localOnQueryGiftInfoCallback = this.val$callback;
      if (localOnQueryGiftInfoCallback != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("not get data ");
        localStringBuilder.append(paramString);
        localOnQueryGiftInfoCallback.onFail(paramInt, localStringBuilder.toString());
      }
    }
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      this.this$0.getServiceAdapter().getLogger().i("GiftService", "queryGiftInfo onRecv", new Object[0]);
      paramArrayOfByte = PersonGetGiftRsp.parseFrom(paramArrayOfByte);
      int i = paramArrayOfByte.result;
      if (i != 0)
      {
        if (this.val$callback == null) {
          return;
        }
        this.val$callback.onFail(20, "not get data");
        return;
      }
      if (paramArrayOfByte.giftInfo != null)
      {
        paramArrayOfByte = GiftService.access$100(this.this$0, paramArrayOfByte.giftInfo);
        GiftService.access$200(this.this$0).put(Integer.valueOf(paramArrayOfByte.mGiftId), Integer.valueOf(paramArrayOfByte.mGiftType));
        GiftService.access$300(this.this$0).put(Integer.valueOf(paramArrayOfByte.mGiftId), paramArrayOfByte);
        if (this.val$callback != null) {
          this.val$callback.onGetGiftInfo(paramArrayOfByte);
        }
      }
      else if (this.val$callback != null)
      {
        this.val$callback.onFail(20, "not get data");
        return;
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.4
 * JD-Core Version:    0.7.0.1
 */