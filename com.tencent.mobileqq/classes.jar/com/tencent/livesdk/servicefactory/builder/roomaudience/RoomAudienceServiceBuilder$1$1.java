package com.tencent.livesdk.servicefactory.builder.roomaudience;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomaudienceservice_interface.RoomAudienceServiceAdapter.IUserInfoBack;
import com.tencent.ilivesdk.roomaudienceservice_interface.UserServer;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnBatchQueryUserInfosCallback;
import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;
import java.util.Iterator;
import java.util.List;

class RoomAudienceServiceBuilder$1$1
  implements UserInfoServiceInterface.OnBatchQueryUserInfosCallback
{
  RoomAudienceServiceBuilder$1$1(RoomAudienceServiceBuilder.1 param1, List paramList, RoomAudienceServiceAdapter.IUserInfoBack paramIUserInfoBack) {}
  
  private UserInfo getUserInfoById(List<UserInfo> paramList, long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)paramList.next();
      if (localUserInfo.uid == paramLong) {
        return localUserInfo;
      }
    }
    return null;
  }
  
  public void onFail(boolean paramBoolean, int paramInt, String paramString)
  {
    this.val$callBack.onFail(paramBoolean, paramInt, paramString);
  }
  
  public void onSuccess(List<UserInfo> paramList)
  {
    this.this$1.getLogger().i("RoomAudienceServiceBuilder", "batchQueryUserInfos size: " + paramList.size(), new Object[0]);
    Iterator localIterator = this.val$users.iterator();
    while (localIterator.hasNext())
    {
      UserServer localUserServer = (UserServer)localIterator.next();
      UserInfo localUserInfo = getUserInfoById(paramList, localUserServer.uin);
      if (localUserInfo != null)
      {
        this.this$1.getLogger().i("RoomAudienceServiceBuilder", "batchQueryUserInfos info: " + localUserInfo, new Object[0]);
        localUserServer.uin = localUserInfo.uid;
        localUserServer.faceUrl = localUserInfo.headUrl;
        localUserServer.nickName = localUserInfo.nick;
        localUserServer.logoFullUrl = localUserInfo.headUrl;
        localUserServer.businessUid = localUserInfo.businessUid;
      }
    }
    this.val$callBack.onSuccess(this.val$users);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roomaudience.RoomAudienceServiceBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */