package com.tencent.mobileqq.activity.aio.helper;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopNotificationAIOHelper$3
  implements Runnable
{
  TroopNotificationAIOHelper$3(TroopNotificationAIOHelper paramTroopNotificationAIOHelper) {}
  
  public void run()
  {
    if (TroopNotificationAIOHelper.a(this.this$0).aY) {
      return;
    }
    Object localObject = (TroopInfoManager)TroopNotificationAIOHelper.a(this.this$0).d.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    if (localObject != null) {
      ((TroopInfoManager)localObject).a(Long.valueOf(Long.parseLong(TroopNotificationAIOHelper.a(this.this$0).aE().b)), true).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = TroopNotificationAIOHelper.a(this.this$0).j().obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopNotificationAIOHelper.a(this.this$0).j().sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.3
 * JD-Core Version:    0.7.0.1
 */