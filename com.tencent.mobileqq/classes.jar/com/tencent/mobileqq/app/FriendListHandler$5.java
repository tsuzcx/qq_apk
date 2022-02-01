package com.tencent.mobileqq.app;

import android.os.Bundle;
import anpk;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xc36.ReqBody;

class FriendListHandler$5
  implements Runnable
{
  FriendListHandler$5(FriendListHandler paramFriendListHandler, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend|uin = " + this.a);
    }
    ((anpk)this.this$0.mApp.getManager(159)).b(this.a);
    this.this$0.notifyUI(93, true, this.a);
    try
    {
      Object localObject = new oidb_0xc36.ReqBody();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Long.valueOf(Long.parseLong(this.a)));
      ((oidb_0xc36.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0xc36_0", 3126, 0, ((oidb_0xc36.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", this.a);
      this.this$0.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.5
 * JD-Core Version:    0.7.0.1
 */