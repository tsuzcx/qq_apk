package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import java.util.List;

class TroopMemberListActivity$2
  implements Runnable
{
  TroopMemberListActivity$2(TroopMemberListActivity paramTroopMemberListActivity, IFriendDataService paramIFriendDataService) {}
  
  public void run()
  {
    Object localObject1 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.app, this.this$0.mTroopUin, this.this$0.mActionMemberUin);
    ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.app, this.this$0.mTroopUin, this.this$0.mActionMemberUin);
    if ((localObject1 != null) && (this.a != null))
    {
      ??? = this.this$0;
      ???.removeItem(???.mActionMemberUin);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.convertTroopMemberInfo((TroopMemberInfo)localObject1, this.a);
        this.this$0.mListData.add(localObject1);
        this.this$0.mHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.2
 * JD-Core Version:    0.7.0.1
 */