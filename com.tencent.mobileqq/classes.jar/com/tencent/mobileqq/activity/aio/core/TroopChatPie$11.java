package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;

class TroopChatPie$11
  implements Runnable
{
  TroopChatPie$11(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    SelfGagInfo localSelfGagInfo = ((TroopGagMgr)this.this$0.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.ah.b, this.a);
    Message localMessage = this.this$0.bX.obtainMessage(2);
    localMessage.obj = localSelfGagInfo;
    this.this$0.bX.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.11
 * JD-Core Version:    0.7.0.1
 */