package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListReceiver
  extends BaseHandlerReceiver
{
  public FriendListReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = Boolean.valueOf(true);
    if ((bool) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      LastLoginPageInfo localLastLoginPageInfo = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      a(localArrayList);
      if (localLastLoginPageInfo.dwCurrentReqIndex == localLastLoginPageInfo.dwTotalReqTimes)
      {
        ContactConfig.a(this.a.getApp().getApplicationContext(), this.a.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        this.b.notifyUI(47, true, paramFromServiceMsg);
        return;
      }
      if (localLastLoginPageInfo.dwCurrentReqIndex < localLastLoginPageInfo.dwTotalReqTimes)
      {
        this.b.notifyUI(47, true, Boolean.valueOf(false));
        this.b.getLastLoginInfo(localLastLoginPageInfo.dwTotalReqTimes, localLastLoginPageInfo.dwCurrentReqIndex, localLastLoginPageInfo.dwCurrentReqUin);
      }
    }
    else
    {
      this.b.notifyUI(47, false, paramFromServiceMsg);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null)
      {
        a(13, false, null);
        return;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
      {
        a(13, false, null);
        return;
      }
      int i;
      if (paramFromServiceMsg.shClickInterval > 30) {
        i = paramFromServiceMsg.shClickInterval * 1000;
      } else {
        i = 30000;
      }
      QQAppInterface.sGetOnlineFriendDelay = i;
      if (paramFromServiceMsg.intervalTimeMin > 3) {
        i = paramFromServiceMsg.intervalTimeMin * 60 * 1000;
      } else {
        i = 180000;
      }
      QQAppInterface.sNextGetOnlineFriendDelay = i;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("Next Get Online Friend Delay ");
        paramObject.append(QQAppInterface.sNextGetOnlineFriendDelay);
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
      }
      this.b.saveShowPcIconIfNeccessary(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() > 0)
      {
        ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramFromServiceMsg.vecFriendInfo);
        a(13, true, null);
        return;
      }
      a(13, false, null);
    }
  }
  
  private void a(List<LastLoginInfo> paramList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveLastLoginInfos begin ");
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = ((FriendsManager)localObject1).j();
    if ((paramList != null) && (localObject2 != null))
    {
      ArrayList localArrayList = new ArrayList(((List)localObject2).size());
      if (paramList.size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Friends)paramList.next();
          if (localObject2 != null)
          {
            if (((Friends)localObject2).lastLoginType != 0L)
            {
              ((Friends)localObject2).lastLoginType = 0L;
              i = 1;
            }
            else
            {
              i = 0;
            }
            if (((Friends)localObject2).showLoginClient != 0L)
            {
              ((Friends)localObject2).showLoginClient = 0L;
              i = 1;
            }
            if (i != 0) {
              localArrayList.add(localObject2);
            }
          }
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        Friends localFriends = ((FriendsManager)localObject1).m(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient != ((LastLoginInfo)localObject2).dwClient)
          {
            localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
            i = 1;
          }
          else
          {
            i = 0;
          }
          if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
          {
            localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
            i = 1;
          }
          if (i != 0) {
            localArrayList.add(localFriends);
          }
        }
      }
      ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "saveLastLoginInfos ends ");
    }
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.GetLastLoginInfoReq".equals(paramString)) || ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ("friendlist.GetLastLoginInfoReq".equals(paramToServiceMsg))
    {
      a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
      return;
    }
    if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramToServiceMsg))
    {
      if (paramObject != null)
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      a(13, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendListReceiver
 * JD-Core Version:    0.7.0.1
 */