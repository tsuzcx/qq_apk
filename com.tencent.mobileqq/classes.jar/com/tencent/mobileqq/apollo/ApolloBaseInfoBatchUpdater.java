package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;

public class ApolloBaseInfoBatchUpdater
{
  private IApolloDaoManagerService a;
  private ArrayList<ApolloBaseInfo> b;
  
  public ApolloBaseInfoBatchUpdater(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.b = new ArrayList(paramInt);
    this.a = ((IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all"));
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveInBatch size=");
      localStringBuilder.append(this.b.size());
      QLog.i("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, localStringBuilder.toString());
    }
    this.a.bulkSaveOrUpdateApolloBaseInfos(this.b);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    ApolloBaseInfo localApolloBaseInfo = this.a.getApolloBaseInfo(paramFriends.uin);
    if (localApolloBaseInfo == null)
    {
      paramFriendInfo = new StringBuilder();
      paramFriendInfo.append("apolloBaseInfo return null uin: ");
      paramFriendInfo.append(paramFriends.uin);
      QLog.e("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, paramFriendInfo.toString());
      return;
    }
    if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime) || (localApolloBaseInfo.cmshow3dFlag != paramFriendInfo.cCentiShow3DFlag))
    {
      localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
      localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
      localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
      localApolloBaseInfo.apolloSignStr = "";
      localApolloBaseInfo.cmshow3dFlag = paramFriendInfo.cCentiShow3DFlag;
      localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
      this.b.add(localApolloBaseInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBaseInfoBatchUpdater
 * JD-Core Version:    0.7.0.1
 */