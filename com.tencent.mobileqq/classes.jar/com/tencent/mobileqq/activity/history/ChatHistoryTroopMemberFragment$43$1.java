package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import mqq.os.MqqHandler;

class ChatHistoryTroopMemberFragment$43$1
  implements Runnable
{
  ChatHistoryTroopMemberFragment$43$1(ChatHistoryTroopMemberFragment.43 param43, String paramString) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.b.a.bc.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopMemberInfo localTroopMemberInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.b.a.bc, this.b.a.w, this.a);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.b.a.a(localTroopMemberInfo, (FriendsManager)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.43.1.1(this, (ChatHistoryTroopMemberFragment.ATroopMember)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.43.1
 * JD-Core Version:    0.7.0.1
 */