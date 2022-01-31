package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import android.os.Message;
import arom;
import ayok;
import azkm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class TroopChatPie$27
  implements Runnable
{
  public TroopChatPie$27(aejb paramaejb) {}
  
  public void run()
  {
    if (aejb.f(this.this$0)) {
      return;
    }
    Object localObject = (arom)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (localObject != null) {
      ((arom)localObject).a(Long.valueOf(Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), true).a();
    }
    azkm.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject = aejb.k(this.this$0).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    aejb.l(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.27
 * JD-Core Version:    0.7.0.1
 */