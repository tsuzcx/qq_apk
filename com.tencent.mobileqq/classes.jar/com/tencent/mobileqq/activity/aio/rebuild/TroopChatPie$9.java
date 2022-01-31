package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import aeog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopChatPie$9
  implements Runnable
{
  public TroopChatPie$9(aejb paramaejb, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.this$0.aj) && (!this.a) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == 3) && ((this.this$0.jdField_a_of_type_Aeog == null) || (!this.this$0.jdField_a_of_type_Aeog.a())))
      {
        this.this$0.aj = true;
        aejb.a(this.this$0).post(new TroopChatPie.9.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.9
 * JD-Core Version:    0.7.0.1
 */