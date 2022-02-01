package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

class TroopHandler$6
  implements Runnable
{
  TroopHandler$6(TroopHandler paramTroopHandler, String paramString) {}
  
  public void run()
  {
    Object localObject1 = (TroopOnlineMemberManager)TroopHandler.a(this.this$0).getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
    if (NetConnInfoCenter.getServerTime() < ((TroopOnlineMemberManager)localObject1).d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllGameOnlineMemberList, too frequency");
      }
      localObject1 = ((TroopOnlineMemberManager)localObject1).c(this.a);
      this.this$0.notifyUI(TroopNotificationConstants.aY, true, new Object[] { this.a, localObject1 });
      return;
    }
    try
    {
      Object localObject2 = (TroopManager)TroopHandler.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject1).group_id.set(Long.valueOf(this.a).longValue());
      ((oidb_0xa2a.ReqBody)localObject1).is_private.set(((TroopManager)localObject2).n(this.a));
      localObject2 = ((TroopManager)localObject2).c(this.a);
      if (localObject2 != null)
      {
        ((oidb_0xa2a.ReqBody)localObject1).hok_appid.set((int)((TroopInfo)localObject2).hlGuildAppid);
        ((oidb_0xa2a.ReqBody)localObject1).hok_type.set((int)((TroopInfo)localObject2).hlGuildSubType);
      }
      localObject1 = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_6", 2602, 6, ((oidb_0xa2a.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", this.a);
      this.this$0.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("TroopHandler", 1, "getAllGameOnlineMemberList, e=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.6
 * JD-Core Version:    0.7.0.1
 */