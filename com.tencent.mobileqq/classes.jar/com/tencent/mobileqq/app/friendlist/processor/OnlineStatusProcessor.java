package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class OnlineStatusProcessor
  extends BaseFriendProcessor
{
  public OnlineStatusProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (MobileQQ.sProcessId != 1)
    {
      QLog.e("IMCore.friend.OnlineStatusFriendProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    IFriendDataService localIFriendDataService = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      Friends localFriends1 = (Friends)((Pair)localObject).first;
      localObject = (FriendInfo)((Pair)localObject).second;
      localFriends1.uExtOnlineStatus = ((FriendInfo)localObject).uExtOnlineStatus;
      localFriends1.iBatteryStatus = ((FriendInfo)localObject).iBatteryStatus;
      OnlineMusicStatusManager.a(localFriends1, ((FriendInfo)localObject).vecMusicInfo, "GetFriendList");
      Friends localFriends2 = localIFriendDataService.getFriend(localFriends1.uin, true, true);
      OnlineStatusUtil.a(localFriends1, ((FriendInfo)localObject).vecExtOnlineBusinessInfo, "GetFriendList", localFriends2);
    }
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
    paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
  }
  
  public void onUpdateSelfInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
    paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
    OnlineMusicStatusManager.a(paramFriends, paramFriendInfo.vecMusicInfo, "GetFriendList(self)");
    OnlineStatusUtil.a(paramFriends, paramFriendInfo.vecExtOnlineBusinessInfo, "GetFriendList(self)");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetFriendList selfUin=");
      localStringBuilder.append(paramFriends.uin);
      localStringBuilder.append(", cSpecialFlag=");
      localStringBuilder.append(paramFriends.cSpecialFlag);
      QLog.d("IMCore.friend.OnlineStatusFriendProcessor", 2, new Object[] { localStringBuilder.toString(), " battery:", Integer.valueOf(paramFriendInfo.iBatteryStatus), " extOnline:", Long.valueOf(paramFriendInfo.uExtOnlineStatus) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.OnlineStatusProcessor
 * JD-Core Version:    0.7.0.1
 */