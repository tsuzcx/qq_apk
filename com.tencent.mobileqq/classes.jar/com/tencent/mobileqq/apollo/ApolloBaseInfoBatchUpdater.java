package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;

public class ApolloBaseInfoBatchUpdater
{
  IApolloManagerService jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService;
  ArrayList<ApolloBaseInfo> jdField_a_of_type_JavaUtilArrayList;
  
  public ApolloBaseInfoBatchUpdater(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all"));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "saveInBatch size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.bulkSaveOrUpdateApolloBaseInfos(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    ApolloBaseInfo localApolloBaseInfo = this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.getApolloBaseInfo(paramFriends.uin);
    if (localApolloBaseInfo != null) {
      if ((localApolloBaseInfo.apolloStatus != paramFriendInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != paramFriendInfo.uApolloTimestamp) || (localApolloBaseInfo.apolloSignValidTS != paramFriendInfo.uApolloSignTime) || (localApolloBaseInfo.cmshow3dFlag != paramFriendInfo.cCentiShow3DFlag))
      {
        localApolloBaseInfo.apolloStatus = paramFriendInfo.cApolloFlag;
        localApolloBaseInfo.apolloServerTS = paramFriendInfo.uApolloTimestamp;
        localApolloBaseInfo.apolloSignValidTS = paramFriendInfo.uApolloSignTime;
        localApolloBaseInfo.apolloSignStr = "";
        localApolloBaseInfo.cmshow3dFlag = paramFriendInfo.cCentiShow3DFlag;
        localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilArrayList.add(localApolloBaseInfo);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("Q.contacttab.friend.ApolloBaseInfoBatchUpdater", 2, "apolloBaseInfo return null uin: " + paramFriends.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBaseInfoBatchUpdater
 * JD-Core Version:    0.7.0.1
 */