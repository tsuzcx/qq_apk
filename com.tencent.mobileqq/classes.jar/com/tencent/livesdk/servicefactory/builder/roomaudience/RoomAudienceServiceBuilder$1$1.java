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
    Object localObject1 = this.this$1.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("batchQueryUserInfos size: ");
    ((StringBuilder)localObject2).append(paramList.size());
    ((LogInterface)localObject1).i("RoomAudienceServiceBuilder", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = this.val$users.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserServer)((Iterator)localObject1).next();
      UserInfo localUserInfo = getUserInfoById(paramList, ((UserServer)localObject2).uin);
      if (localUserInfo != null)
      {
        LogInterface localLogInterface = this.this$1.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("batchQueryUserInfos info: ");
        localStringBuilder.append(localUserInfo);
        localLogInterface.i("RoomAudienceServiceBuilder", localStringBuilder.toString(), new Object[0]);
        ((UserServer)localObject2).uin = localUserInfo.uid;
        ((UserServer)localObject2).faceUrl = localUserInfo.headUrl;
        ((UserServer)localObject2).nickName = localUserInfo.nick;
        ((UserServer)localObject2).logoFullUrl = localUserInfo.headUrl;
        ((UserServer)localObject2).businessUid = localUserInfo.businessUid;
      }
    }
    this.val$callBack.onSuccess(this.val$users);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.roomaudience.RoomAudienceServiceBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */