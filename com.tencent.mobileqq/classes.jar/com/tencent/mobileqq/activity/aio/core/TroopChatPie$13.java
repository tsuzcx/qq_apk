package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;

class TroopChatPie$13
  implements Runnable
{
  TroopChatPie$13(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    SelfGagInfo localSelfGagInfo = ((TroopGagMgr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a);
    Message localMessage = this.this$0.b.obtainMessage(2);
    localMessage.obj = localSelfGagInfo;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.13
 * JD-Core Version:    0.7.0.1
 */