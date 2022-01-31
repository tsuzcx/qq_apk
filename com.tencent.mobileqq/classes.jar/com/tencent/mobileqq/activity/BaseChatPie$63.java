package com.tencent.mobileqq.activity;

import acex;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$63
  implements Runnable
{
  BaseChatPie$63(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = acex.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
      if (QLog.isColorLevel()) {
        QLog.i("BabyQReportCookie", 2, "now enter the aio!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.63
 * JD-Core Version:    0.7.0.1
 */