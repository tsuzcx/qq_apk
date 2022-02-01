package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

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
    if (!(this.mApp instanceof QQAppInterface)) {
      QLog.e("IMCore.friend.OnlineStatusFriendProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
    }
    for (;;)
    {
      return;
      Object localObject1 = (QQAppInterface)this.mApp;
      localObject1 = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (Pair)paramList.next();
        Friends localFriends1 = (Friends)((Pair)localObject2).first;
        localObject2 = (FriendInfo)((Pair)localObject2).second;
        localFriends1.uExtOnlineStatus = ((FriendInfo)localObject2).uExtOnlineStatus;
        localFriends1.iBatteryStatus = ((FriendInfo)localObject2).iBatteryStatus;
        OnlineMusicStatusManager.a(localFriends1, ((FriendInfo)localObject2).vecMusicInfo, "GetFriendList");
        Friends localFriends2 = ((IFriendDataService)localObject1).getFriend(localFriends1.uin, true, true);
        OnlineStatusUtil.a(localFriends1, ((FriendInfo)localObject2).vecExtOnlineBusinessInfo, "GetFriendList", localFriends2);
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.OnlineStatusFriendProcessor", 2, new Object[] { "handleGetFriendList selfUin=" + paramFriends.uin + ", cSpecialFlag=" + paramFriends.cSpecialFlag, " battery:", Integer.valueOf(paramFriendInfo.iBatteryStatus), " extOnline:", Long.valueOf(paramFriendInfo.uExtOnlineStatus) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.OnlineStatusProcessor
 * JD-Core Version:    0.7.0.1
 */