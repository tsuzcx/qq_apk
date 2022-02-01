package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.os.MqqHandler;

class TroopMemberListActivity$42$1
  implements Runnable
{
  TroopMemberListActivity$42$1(TroopMemberListActivity.42 param42, String paramString) {}
  
  public void run()
  {
    Object localObject = (IFriendDataService)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.app.getRuntimeService(IFriendDataService.class, "");
    TroopMemberInfo localTroopMemberInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.mTroopUin, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.convertTroopMemberInfo(localTroopMemberInfo, (IFriendDataService)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.42.1.1(this, (TroopMemberListActivity.ATroopMember)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42.1
 * JD-Core Version:    0.7.0.1
 */