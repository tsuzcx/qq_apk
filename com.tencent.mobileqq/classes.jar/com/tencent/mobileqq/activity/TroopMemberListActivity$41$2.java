package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.os.MqqHandler;

class TroopMemberListActivity$41$2
  implements Runnable
{
  TroopMemberListActivity$41$2(TroopMemberListActivity.41 param41, String paramString) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopMemberInfo localTroopMemberInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$41.a.a(localTroopMemberInfo, (FriendsManager)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.41.2.1(this, (TroopMemberListActivity.ATroopMember)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.41.2
 * JD-Core Version:    0.7.0.1
 */