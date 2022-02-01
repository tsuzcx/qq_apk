package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;

class TroopChatPie$29
  extends TeamWorkObserver
{
  TroopChatPie$29(TroopChatPie paramTroopChatPie) {}
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onGetGroupAuthDocsGrayTipsInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_MqqOsMqqHandler, paramBoolean, paramArrayOfObject);
  }
  
  public void d(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).onSetGroupAuthDocsGrayTipsInfo(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_MqqOsMqqHandler, paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.29
 * JD-Core Version:    0.7.0.1
 */