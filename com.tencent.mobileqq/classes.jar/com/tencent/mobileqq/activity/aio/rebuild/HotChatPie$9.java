package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class HotChatPie$9
  implements Runnable
{
  HotChatPie$9(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    ITroopRedDotHandler localITroopRedDotHandler = (ITroopRedDotHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER);
    if (localITroopRedDotHandler != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.this$0.b);
        ((StringBuilder)localObject).append("Q.hotchat.aio_post_red_point");
        QLog.d(((StringBuilder)localObject).toString(), 2, "send_oidb_0x8c9_2");
      }
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(1105933138L));
      localITroopRedDotHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (List)localObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.9
 * JD-Core Version:    0.7.0.1
 */