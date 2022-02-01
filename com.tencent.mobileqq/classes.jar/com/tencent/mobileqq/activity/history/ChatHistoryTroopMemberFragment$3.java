package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import java.util.List;

class ChatHistoryTroopMemberFragment$3
  implements Runnable
{
  ChatHistoryTroopMemberFragment$3(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    Object localObject1 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.getBaseActivity().app, this.this$0.w, this.this$0.bB);
    ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.getBaseActivity().app, this.this$0.w, this.this$0.bB);
    if ((localObject1 != null) && (this.a != null))
    {
      ??? = this.this$0;
      ???.d(???.bB);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.a((TroopMemberInfo)localObject1, this.a);
        this.this$0.J.add(localObject1);
        this.this$0.bn.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */