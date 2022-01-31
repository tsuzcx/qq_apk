package com.tencent.mobileqq.activity.aio.item;

import aebw;
import axqw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;

class StructingMsgItemBuilder$5
  implements Runnable
{
  StructingMsgItemBuilder$5(StructingMsgItemBuilder paramStructingMsgItemBuilder, aebw paramaebw) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg getView report.........");
    }
    String str2 = "";
    String str1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        str2 = this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
      }
    }
    for (;;)
    {
      PortalManager localPortalManager = (PortalManager)this.this$0.a.getManager(79);
      if (localPortalManager != null) {}
      for (int j = localPortalManager.a();; j = -1)
      {
        axqw.b(this.this$0.a, "CliOper", "", "", "0X8004FF9", "0X8004FF9", 0, 0, "" + j, "" + i, "" + str1, str2);
        return;
        i = 2;
        break;
      }
      str1 = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */