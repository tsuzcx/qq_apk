package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

class TroopHandler$5
  implements Runnable
{
  TroopHandler$5(TroopHandler paramTroopHandler, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (TroopOnlineMemberManager)TroopHandler.a(this.this$0).getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
    Object localObject1;
    if ((((TroopOnlineMemberManager)localObject2).a(this.a) != 3) && (NetConnInfoCenter.getServerTime() < ((TroopOnlineMemberManager)localObject2).c(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllOnlineMemberList, too frequency");
      }
      localObject1 = ((TroopOnlineMemberManager)localObject2).b(this.a);
      this.this$0.notifyUI(TroopNotificationConstants.aX, true, new Object[] { this.a, localObject1 });
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = (TroopManager)TroopHandler.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER);
        if (((TroopOnlineMemberManager)localObject2).a(this.a) == 3)
        {
          i = 4;
          localObject2 = new oidb_0xa2a.ReqBody();
          ((oidb_0xa2a.ReqBody)localObject2).group_id.set(Long.valueOf(this.a).longValue());
          ((oidb_0xa2a.ReqBody)localObject2).is_private.set(((TroopManager)localObject1).n(this.a));
          localObject1 = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_1", 2602, i, ((oidb_0xa2a.ReqBody)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putString("troopUin", this.a);
          this.this$0.sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("TroopHandler", 1, "getAllOnlineMemberList, e=" + localException.toString());
        return;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.5
 * JD-Core Version:    0.7.0.1
 */