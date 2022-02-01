package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.linkmicbizserviceinterface.RequestLinkMicSigCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;

class GetLinkMicUserInfoCase$1
  implements RequestLinkMicSigCallback
{
  GetLinkMicUserInfoCase$1(GetLinkMicUserInfoCase paramGetLinkMicUserInfoCase) {}
  
  public void onFail(int paramInt, String paramString)
  {
    GetLinkMicUserInfoCase.access$000(this.this$0).e("GetLinkMicUserInfoCase", "requestLinkMicSig ERROR--errCode=" + paramInt, new Object[0]);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, long paramLong)
  {
    GetLinkMicUserInfoCase.access$000(this.this$0).i("GetLinkMicUserInfoCase", "requestLinkMicSig onSuccess--userSig=" + paramArrayOfByte + "tinyId=" + paramLong, new Object[0]);
    if ((GetLinkMicUserInfoCase.access$100(this.this$0) == null) || (GetLinkMicUserInfoCase.access$100(this.this$0).getLiveInfo() == null))
    {
      GetLinkMicUserInfoCase.access$000(this.this$0).e("GetLinkMicUserInfoCase", "requestLinkMicSig error--roomService or getLiveInfo is null", new Object[0]);
      return;
    }
    GetLinkMicUserInfoCase.ResponseValue localResponseValue = new GetLinkMicUserInfoCase.ResponseValue(this.this$0);
    localResponseValue.linkMicSig = paramArrayOfByte;
    localResponseValue.tinyId = paramLong;
    GetLinkMicUserInfoCase.access$200(this.this$0, localResponseValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetLinkMicUserInfoCase.1
 * JD-Core Version:    0.7.0.1
 */