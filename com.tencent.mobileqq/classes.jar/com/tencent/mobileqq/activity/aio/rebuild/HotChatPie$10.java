package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class HotChatPie$10
  implements Runnable
{
  HotChatPie$10(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.b + "Q.hotchat.aio_post_red_point", 2, "send_oidb_0x8c9_2");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1105933138L));
      localTroopHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.10
 * JD-Core Version:    0.7.0.1
 */