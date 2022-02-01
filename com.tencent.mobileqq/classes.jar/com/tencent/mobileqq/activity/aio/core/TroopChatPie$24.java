package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import awzf;
import bfhz;
import bgll;
import bglm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$24
  implements Runnable
{
  TroopChatPie$24(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (this.this$0.hasDestory) {}
    do
    {
      return;
      localObject = bglm.a(this.this$0.app, this.this$0.sessionInfo.curFriendUin);
    } while ((localObject == null) || (((bgll)localObject).a.isEmpty()));
    Object localObject = (awzf)this.this$0.app.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    if (localObject != null) {
      ((awzf)localObject).a(Long.valueOf(Long.parseLong(this.this$0.sessionInfo.curFriendUin)), true).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "handleTroopNotificationMsg. sendMessage = MSG_SHOW_TROOP_FEEDS");
    }
    localObject = this.this$0.uiHandler.obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    this.this$0.uiHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.24
 * JD-Core Version:    0.7.0.1
 */