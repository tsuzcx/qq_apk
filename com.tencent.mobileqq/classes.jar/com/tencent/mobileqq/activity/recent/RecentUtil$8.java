package com.tencent.mobileqq.activity.recent;

import awqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import mxu;
import mxw;
import myn;

public final class RecentUtil$8
  implements Runnable
{
  public RecentUtil$8(QQAppInterface paramQQAppInterface, String paramString, int paramInt, mxu parammxu) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localMessage = localQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    if (localMessage != null)
    {
      if ("false".equals(localMessage.getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        localMessage.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessage.frienduin, localMessage.msgtype, localMessage.uniseq, "extStr", localMessage.extStr);
        if (this.jdField_a_of_type_Mxu.a != null) {
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Mxu.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_Mxu.a.c, "", myn.a(), this.jdField_a_of_type_Mxu.a.b);
        }
      }
      if (this.jdField_a_of_type_Mxu.a != null) {
        awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Mxu.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_Mxu.a.c, "", "", this.jdField_a_of_type_Mxu.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.8
 * JD-Core Version:    0.7.0.1
 */