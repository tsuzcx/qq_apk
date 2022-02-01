package com.tencent.mobileqq.activity.aio.core;

import bcef;
import bfdz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Iterator;
import java.util.List;

class TroopChatPie$2
  implements Runnable
{
  TroopChatPie$2(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
    Object localObject = localTroopManager.b(this.this$0.sessionInfo.curFriendUin);
    long l;
    TroopMemberInfo localTroopMemberInfo;
    if (localObject != null)
    {
      l = NetConnInfoCenter.getServerTime();
      localObject = ((List)localObject).iterator();
      l += 2592000L;
      if (((Iterator)localObject).hasNext())
      {
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject).next();
        if ((localTroopMemberInfo.mUniqueTitleExpire > 0) && (localTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() < 259200L) && (!localTroopManager.b(this.this$0.sessionInfo.curFriendUin, localTroopMemberInfo.memberuin)))
        {
          ((bfdz)this.this$0.app.getManager(81)).a(this.this$0.sessionInfo.curFriendUin, this.this$0.a(localTroopMemberInfo), NetConnInfoCenter.getServerTime(), localTroopMemberInfo.mUniqueTitleExpire, 0, 1);
          localTroopManager.a(this.this$0.sessionInfo.curFriendUin, localTroopMemberInfo.memberuin, true);
          bcef.b(this.this$0.app, "P_CliOper", "Grp_manage", "", "grp_aio", "exp_expire", 0, 0, this.this$0.sessionInfo.curFriendUin, "", "", "");
        }
      }
    }
    for (;;)
    {
      break;
      if ((localTroopMemberInfo.mUniqueTitleExpire != 0) && (localTroopMemberInfo.mUniqueTitleExpire != -1) && (localTroopMemberInfo.mUniqueTitleExpire < l))
      {
        l = localTroopMemberInfo.mUniqueTitleExpire;
        continue;
        localTroopManager.a(this.this$0.sessionInfo.curFriendUin, l);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.2
 * JD-Core Version:    0.7.0.1
 */