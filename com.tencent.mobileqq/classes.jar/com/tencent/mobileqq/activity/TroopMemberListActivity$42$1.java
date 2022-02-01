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
    Object localObject = (IFriendDataService)this.b.a.app.getRuntimeService(IFriendDataService.class, "");
    TroopMemberInfo localTroopMemberInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.b.a.app, this.b.a.mTroopUin, this.a);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.b.a.convertTroopMemberInfo(localTroopMemberInfo, (IFriendDataService)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.42.1.1(this, (TroopMemberListActivity.ATroopMember)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42.1
 * JD-Core Version:    0.7.0.1
 */