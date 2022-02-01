package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopMemberFragment$2
  implements Runnable
{
  ChatHistoryTroopMemberFragment$2(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, Intent paramIntent, FriendsManager paramFriendsManager, TroopManager paramTroopManager) {}
  
  public void run()
  {
    ??? = this.a;
    boolean bool2 = false;
    int i;
    if (??? != null)
    {
      i = ((Intent)???).getIntExtra("memberOperationFlag", 0);
      ??? = this.a.getStringExtra("memberOperateUin");
    }
    else
    {
      ??? = "";
      i = 0;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", optUin=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i & 0x1) != 0)
    {
      this.this$0.d((String)???);
    }
    else if ((i & 0x2) != 0)
    {
      localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.bc, this.this$0.w, (String)???);
      if ((localObject2 != null) && (this.b != null))
      {
        this.this$0.d((String)???);
        synchronized (this.this$0)
        {
          localObject2 = this.this$0.a((TroopMemberInfo)localObject2, this.b);
          this.this$0.J.add(localObject2);
        }
      }
    }
    if ((i & 0x4) != 0)
    {
      ??? = this.c;
      if (??? != null)
      {
        ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.this$0;
        localChatHistoryTroopMemberFragment.ai = ((TroopManager)???).f(localChatHistoryTroopMemberFragment.w);
        ??? = this.this$0;
        boolean bool1;
        if ((((ChatHistoryTroopMemberFragment)???).ai != null) && (this.this$0.ai.isHomeworkTroop())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((ChatHistoryTroopMemberFragment)???).u = bool1;
        if (this.this$0.ai != null)
        {
          if (this.this$0.ai.troopowneruin != null)
          {
            ??? = this.this$0;
            ((ChatHistoryTroopMemberFragment)???).C = ((ChatHistoryTroopMemberFragment)???).ai.troopowneruin;
          }
          if (this.this$0.ai.Administrator != null)
          {
            ??? = this.this$0;
            ((ChatHistoryTroopMemberFragment)???).D = ((ChatHistoryTroopMemberFragment)???).ai.Administrator;
          }
          ??? = this.this$0;
          if ((((ChatHistoryTroopMemberFragment)???).ai.troopowneruin == null) || (!this.this$0.ai.troopowneruin.equals(this.this$0.getBaseActivity().app.getCurrentAccountUin())))
          {
            bool1 = bool2;
            if (this.this$0.D != null)
            {
              bool1 = bool2;
              if (!this.this$0.D.contains(this.this$0.getBaseActivity().app.getCurrentAccountUin())) {}
            }
          }
          else
          {
            bool1 = true;
          }
          ((ChatHistoryTroopMemberFragment)???).t = bool1;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:");
            ((StringBuilder)???).append(this.this$0.D);
            ((StringBuilder)???).append(" owner:");
            ((StringBuilder)???).append(this.this$0.C);
            QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)???).toString());
          }
        }
      }
    }
    if ((i != 0) && (this.this$0.K != null)) {
      this.this$0.bn.sendEmptyMessage(9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */