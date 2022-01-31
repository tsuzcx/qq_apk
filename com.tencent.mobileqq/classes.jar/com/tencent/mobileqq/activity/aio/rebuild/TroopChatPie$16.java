package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import android.os.Handler;
import android.os.Message;
import azjh;
import azjn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopChatPie$16
  implements Runnable
{
  public TroopChatPie$16(aejb paramaejb, boolean paramBoolean) {}
  
  public void run()
  {
    azjn localazjn = ((azjh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a);
    Message localMessage = this.this$0.b.obtainMessage(2);
    localMessage.obj = localazjn;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.16
 * JD-Core Version:    0.7.0.1
 */