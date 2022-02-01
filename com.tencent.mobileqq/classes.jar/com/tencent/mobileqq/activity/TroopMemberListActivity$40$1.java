package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberListActivity$40$1
  implements Runnable
{
  TroopMemberListActivity$40$1(TroopMemberListActivity.40 param40, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (ITroopInfoService)this.b.a.app.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject1).findTroopInfo(this.b.a.mTroopUin);
    if (localTroopInfo == null) {
      return;
    }
    Object localObject2 = this.a;
    int i;
    if (localObject2 == null) {
      i = 0;
    } else {
      i = ((List)localObject2).size();
    }
    if (i == 1)
    {
      localObject2 = (oidb_0x899.memberlist)this.a.get(0);
      if (localObject2 != null)
      {
        if (!((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()) {
          return;
        }
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim()))) {
          localTroopInfo.troopowneruin = ((String)localObject2).trim();
        }
      }
      else
      {
        return;
      }
    }
    ((ITroopInfoService)localObject1).saveTroopInfo(localTroopInfo);
    localObject1 = (ITroopMemberListHandler)this.b.a.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
    if (localObject1 != null) {
      try
      {
        ((ITroopMemberListHandler)localObject1).a(Long.parseLong(this.b.a.mTroopUin), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.1
 * JD-Core Version:    0.7.0.1
 */