package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;

class FriendChatPie$19
  extends TeamWorkObserver
{
  FriendChatPie$19(FriendChatPie paramFriendChatPie) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onGetUserAuthDocsGrayTipsInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_MqqOsMqqHandler, paramBoolean, paramArrayOfObject);
  }
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onSetUserAuthDocsGrayTipsInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_MqqOsMqqHandler, paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */