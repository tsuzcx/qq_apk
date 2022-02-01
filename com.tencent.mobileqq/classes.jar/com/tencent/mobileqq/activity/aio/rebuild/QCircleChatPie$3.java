package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QCircleChatPie$3
  implements Runnable
{
  QCircleChatPie$3(QCircleChatPie paramQCircleChatPie) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, null, 500);
    if (localList != null) {
      QCircleChatPie.a(this.this$0, localList.size());
    }
    if ((localList != null) && (localList.size() > 0))
    {
      QCircleChatPie.b(this.this$0, (MessageRecord)localList.get(0));
      QCircleChatPie.a(this.this$0, (MessageRecord)localList.get(localList.size() - 1));
    }
    if ((QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localList)) && (!TextUtils.isEmpty(QCircleChatPie.a(this.this$0))))
    {
      QCircleChatPie.a(this.this$0, QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.this$0), QCircleChatPie.a(this.this$0)));
      QLog.d(this.this$0.b, 2, "showFuelTips:" + QCircleChatPie.a(this.this$0));
    }
    QCircleChatPie.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (!QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.d(this.this$0.b, 2, "showIceBreakMessage");
      QCircleChatPie.a(this.this$0, QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.this$0), QCircleChatPie.b(this.this$0)));
      if (QCircleChatPie.a(this.this$0) != null) {
        QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "mAllMsgCount " + QCircleChatPie.b(this.this$0));
    }
    this.this$0.g(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.3
 * JD-Core Version:    0.7.0.1
 */