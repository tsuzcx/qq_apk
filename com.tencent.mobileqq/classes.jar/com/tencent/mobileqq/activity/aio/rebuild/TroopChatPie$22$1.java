package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import aejm;
import android.os.Message;
import azkm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import mqq.os.MqqHandler;

public class TroopChatPie$22$1
  implements Runnable
{
  public TroopChatPie$22$1(aejm paramaejm) {}
  
  public void run()
  {
    if (aejb.e(this.a.a)) {
      return;
    }
    azkm.c(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    azkm.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Message localMessage = aejb.h(this.a.a).obtainMessage(29);
    localMessage.arg1 = 2;
    aejb.i(this.a.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.22.1
 * JD-Core Version:    0.7.0.1
 */