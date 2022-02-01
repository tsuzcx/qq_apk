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
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      a(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(48, true, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getLastLoginInfo(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(48, false, Boolean.valueOf(true));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        a(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      a(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      i = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.sGetOnlineFriendDelay = i;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label182;
      }
    }
    label182:
    for (int i = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i = 180000)
    {
      QQAppInterface.sNextGetOnlineFriendDelay = i;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "Next Get Online Friend Delay " + QQAppInterface.sNextGetOnlineFriendDelay);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.saveShowPcIconIfNeccessary(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label188;
      }
      ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramFromServiceMsg.vecFriendInfo);
      a(13, true, null);
      return;
      i = 30000;
      break;
    }
    label188:
    a(13, false, null);
  }
  
  private void a(List<LastLoginInfo> paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        i = paramList.size();
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, i);
      }
    }
    else
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = ((FriendsManager)localObject1).c();
      if ((paramList == null) || (localObject2 == null)) {
        break label339;
      }
      localArrayList = new ArrayList(((List)localObject2).size());
      if (paramList.size() != 0) {
        break label192;
      }
      paramList = ((List)localObject2).iterator();
      label106:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label359;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label192:
    label339:
    label354:
    label359:
    for (int i = 1;; i = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        i = 1;
      }
      if (i == 0) {
        break label106;
      }
      localArrayList.add(localObject2);
      break label106;
      i = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((FriendsManager)localObject1).e(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label354;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (i = 1;; i = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          i = 1;
        }
        if (i == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return ("friendlist.GetLastLoginInfoReq".equals(paramString)) || ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ("friendlist.GetLastLoginInfoReq".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
    }
    while (!"friendlist.GetSimpleOnlineFriendInfoReq".equals(paramToServiceMsg)) {
      return;
    }
    if (paramObject != null)
    {
      a(paramFromServiceMsg, paramObject);
      return;
    }
    a(13, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.FriendListReceiver
 * JD-Core Version:    0.7.0.1
 */