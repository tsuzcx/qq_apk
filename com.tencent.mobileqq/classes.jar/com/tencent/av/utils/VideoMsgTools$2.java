package com.tencent.av.utils;

import android.text.TextUtils;
import aseg;
import bbjc;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

final class VideoMsgTools$2
  implements Runnable
{
  VideoMsgTools$2(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, String paramString1, String paramString2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((!QQAppInterface.isAppOnForeground(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (bbjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        aseg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, "qav");
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addMessage end");
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))) {
        ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.2
 * JD-Core Version:    0.7.0.1
 */