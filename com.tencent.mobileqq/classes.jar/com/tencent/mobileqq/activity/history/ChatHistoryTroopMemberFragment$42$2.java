package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.os.MqqHandler;

class ChatHistoryTroopMemberFragment$42$2
  implements Runnable
{
  ChatHistoryTroopMemberFragment$42$2(ChatHistoryTroopMemberFragment.42 param42, String paramString) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$42.a.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopMemberInfo localTroopMemberInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$42.a.b, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$42.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$42.a.a(localTroopMemberInfo, (FriendsManager)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.42.2.1(this, (ChatHistoryTroopMemberFragment.ATroopMember)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.42.2
 * JD-Core Version:    0.7.0.1
 */