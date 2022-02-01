package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.mobileqq.utils.QQUtils;
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
    if ((ProcessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())))
    {
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.frienduin))) {
          localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Boolean);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      CUOpenCardGuideMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, "qav");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.2
 * JD-Core Version:    0.7.0.1
 */