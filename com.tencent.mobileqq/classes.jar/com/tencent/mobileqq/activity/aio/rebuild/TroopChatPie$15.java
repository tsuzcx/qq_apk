package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;
import baky;
import bale;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class TroopChatPie$15
  implements Runnable
{
  TroopChatPie$15(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    bale localbale = ((baky)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a);
    Message localMessage = this.this$0.b.obtainMessage(2);
    localMessage.obj = localbale;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.15
 * JD-Core Version:    0.7.0.1
 */