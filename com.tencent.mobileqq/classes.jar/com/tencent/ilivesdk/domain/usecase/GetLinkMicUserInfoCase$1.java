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
    paramString = GetLinkMicUserInfoCase.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestLinkMicSig ERROR--errCode=");
    localStringBuilder.append(paramInt);
    paramString.e("GetLinkMicUserInfoCase", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject = GetLinkMicUserInfoCase.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestLinkMicSig onSuccess--userSig=");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("tinyId=");
    localStringBuilder.append(paramLong);
    ((LogInterface)localObject).i("GetLinkMicUserInfoCase", localStringBuilder.toString(), new Object[0]);
    if ((GetLinkMicUserInfoCase.access$100(this.this$0) != null) && (GetLinkMicUserInfoCase.access$100(this.this$0).getLiveInfo() != null))
    {
      localObject = new GetLinkMicUserInfoCase.ResponseValue(this.this$0);
      ((GetLinkMicUserInfoCase.ResponseValue)localObject).linkMicSig = paramArrayOfByte;
      ((GetLinkMicUserInfoCase.ResponseValue)localObject).tinyId = paramLong;
      GetLinkMicUserInfoCase.access$200(this.this$0, localObject);
      return;
    }
    GetLinkMicUserInfoCase.access$000(this.this$0).e("GetLinkMicUserInfoCase", "requestLinkMicSig error--roomService or getLiveInfo is null", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetLinkMicUserInfoCase.1
 * JD-Core Version:    0.7.0.1
 */