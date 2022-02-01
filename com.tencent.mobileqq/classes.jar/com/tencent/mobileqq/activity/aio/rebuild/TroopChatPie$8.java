package com.tencent.mobileqq.activity.aio.rebuild;

import aimo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$8
  implements Runnable
{
  TroopChatPie$8(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.this$0.ai) && (!this.a) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == 3) && ((this.this$0.jdField_a_of_type_Aimo == null) || (!this.this$0.jdField_a_of_type_Aimo.a())))
      {
        this.this$0.ai = true;
        TroopChatPie.a(this.this$0).post(new TroopChatPie.8.1(this));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(localInterruptedException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */