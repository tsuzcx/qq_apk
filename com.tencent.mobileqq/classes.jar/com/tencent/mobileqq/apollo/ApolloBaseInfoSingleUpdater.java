package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;

public class ApolloBaseInfoSingleUpdater
{
  QQAppInterface a;
  
  public ApolloBaseInfoSingleUpdater(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramFriends.uin);
    if (paramFriends != null)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.getRuntimeService(IApolloManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo = localIApolloManagerService.getApolloBaseInfo(paramFriends.uin);
      if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime))
      {
        localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
        localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
        localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
        localApolloBaseInfo.apolloSignStr = "";
        localIApolloManagerService.saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "handleGetFriendDetailInfo, update apollo info uin=" + paramFriends.uin + "apollo status: " + paramFriendInfo.cApolloFlag + ", apollo svr TS: " + paramFriendInfo.uApolloTimestamp + ", sign TS: " + paramFriendInfo.uApolloSignTime);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBaseInfoSingleUpdater
 * JD-Core Version:    0.7.0.1
 */