package com.tencent.mobileqq.app;

import anca;
import android.os.Bundle;
import bfkq;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

public class TroopHandler$7
  implements Runnable
{
  public TroopHandler$7(anca paramanca, String paramString) {}
  
  public void run()
  {
    Object localObject = (bfkq)this.this$0.app.getManager(234);
    if (NetConnInfoCenter.getServerTime() < ((bfkq)localObject).d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllGameOnlineMemberList, too frequency");
      }
      localObject = ((bfkq)localObject).c(this.a);
      this.this$0.notifyUI(102, true, new Object[] { this.a, localObject });
      return;
    }
    try
    {
      localObject = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject).group_id.set(Long.valueOf(this.a).longValue());
      ((oidb_0xa2a.ReqBody)localObject).is_private.set(TroopInfo.isQidianPrivateTroop(this.this$0.app, this.a));
      TroopInfo localTroopInfo = ((TroopManager)this.this$0.app.getManager(52)).c(this.a);
      if (localTroopInfo != null)
      {
        ((oidb_0xa2a.ReqBody)localObject).hok_appid.set((int)localTroopInfo.hlGuildAppid);
        ((oidb_0xa2a.ReqBody)localObject).hok_type.set((int)localTroopInfo.hlGuildSubType);
      }
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_6", 2602, 6, ((oidb_0xa2a.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", this.a);
      this.this$0.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("TroopHandler", 1, "getAllGameOnlineMemberList, e=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.7
 * JD-Core Version:    0.7.0.1
 */