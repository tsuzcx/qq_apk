package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  ChatHistoryTroopMemberFragment$41$2(ChatHistoryTroopMemberFragment.41 param41, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.b.a.bc.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).f(this.b.a.w);
    if (localTroopInfo == null) {
      return;
    }
    if (StringUtil.isEmpty(localTroopInfo.troopowneruin)) {
      return;
    }
    localTroopInfo.Administrator = "";
    Object localObject2 = this.a;
    int j = 0;
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((List)localObject2).size();
    }
    while (j < i)
    {
      localObject2 = (oidb_0x899.memberlist)this.a.get(j);
      if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()))
      {
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!localTroopInfo.troopowneruin.equals(((String)localObject2).trim())))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localTroopInfo.Administrator);
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("|");
          localTroopInfo.Administrator = localStringBuilder.toString();
        }
      }
      j += 1;
    }
    ((TroopManager)localObject1).b(localTroopInfo);
    localObject1 = this.b.a.bn.obtainMessage();
    ((Message)localObject1).what = 11;
    ((Message)localObject1).obj = localTroopInfo;
    this.b.a.bn.sendMessage((Message)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.BaseFragment", 2, localTroopInfo.Administrator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */