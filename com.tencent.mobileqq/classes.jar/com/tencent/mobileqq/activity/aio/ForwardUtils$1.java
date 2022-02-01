package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class ForwardUtils$1
  implements Runnable
{
  ForwardUtils$1(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.d, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate start!");
    }
    Message localMessage = new Message();
    localMessage.what = 57;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate end!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.1
 * JD-Core Version:    0.7.0.1
 */