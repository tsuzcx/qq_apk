package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$6
  implements Runnable
{
  TroopChatPie$6(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.this$0.ae) && (!this.a) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == 3) && ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTroopAssistTipsBar.a())))
      {
        this.this$0.ae = true;
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(new TroopChatPie.6.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.6
 * JD-Core Version:    0.7.0.1
 */