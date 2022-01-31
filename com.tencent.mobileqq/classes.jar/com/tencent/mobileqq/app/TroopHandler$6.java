package com.tencent.mobileqq.app;

import akhq;
import android.os.Bundle;
import batb;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

public class TroopHandler$6
  implements Runnable
{
  public TroopHandler$6(akhq paramakhq, String paramString) {}
  
  public void run()
  {
    Object localObject = (batb)this.this$0.app.getManager(234);
    if ((((batb)localObject).a(this.a) != 3) && (NetConnInfoCenter.getServerTime() < ((batb)localObject).c(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllOnlineMemberList, too frequency");
      }
      localObject = ((batb)localObject).b(this.a);
      this.this$0.notifyUI(101, true, new Object[] { this.a, localObject });
      return;
    }
    for (;;)
    {
      try
      {
        if (((batb)localObject).a(this.a) == 3)
        {
          i = 4;
          localObject = new oidb_0xa2a.ReqBody();
          ((oidb_0xa2a.ReqBody)localObject).group_id.set(Long.valueOf(this.a).longValue());
          ((oidb_0xa2a.ReqBody)localObject).is_private.set(TroopInfo.isQidianPrivateTroop(this.this$0.app, this.a));
          localObject = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_1", 2602, i, ((oidb_0xa2a.ReqBody)localObject).toByteArray());
          ((ToServiceMsg)localObject).extraData.putString("troopUin", this.a);
          this.this$0.sendPbReq((ToServiceMsg)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.6
 * JD-Core Version:    0.7.0.1
 */