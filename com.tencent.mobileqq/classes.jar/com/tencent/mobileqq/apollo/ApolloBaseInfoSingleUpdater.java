package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;

public class ApolloBaseInfoSingleUpdater
{
  private QQAppInterface a;
  
  public ApolloBaseInfoSingleUpdater(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramFriends.uin);
    if (paramFriends == null) {
      return;
    }
    Object localObject = (IApolloDaoManagerService)this.a.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfo(paramFriends.uin);
    if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime))
    {
      localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
      localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
      localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
      localApolloBaseInfo.apolloSignStr = "";
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetFriendDetailInfo, update apollo info uin=");
        ((StringBuilder)localObject).append(paramFriends.uin);
        ((StringBuilder)localObject).append("apollo status: ");
        ((StringBuilder)localObject).append(paramFriendInfo.cApolloFlag);
        ((StringBuilder)localObject).append(", apollo svr TS: ");
        ((StringBuilder)localObject).append(paramFriendInfo.uApolloTimestamp);
        ((StringBuilder)localObject).append(", sign TS: ");
        ((StringBuilder)localObject).append(paramFriendInfo.uApolloSignTime);
        QLog.d("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBaseInfoSingleUpdater
 * JD-Core Version:    0.7.0.1
 */