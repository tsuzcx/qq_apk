package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.oidb_0xc36.ReqBody;

class FriendListHandler$3
  implements Runnable
{
  FriendListHandler$3(FriendListHandler paramFriendListHandler, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend|uin = " + this.val$uin);
    }
    ((MayknowRecommendManager)this.this$0.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b(this.val$uin);
    this.this$0.notifyUI(93, true, this.val$uin);
    try
    {
      Object localObject = new oidb_0xc36.ReqBody();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Long.valueOf(Long.parseLong(this.val$uin)));
      ((oidb_0xc36.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
      localObject = this.this$0.makeOIDBPkg("OidbSvc.0xc36_0", 3126, 0, ((oidb_0xc36.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", this.val$uin);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.3
 * JD-Core Version:    0.7.0.1
 */