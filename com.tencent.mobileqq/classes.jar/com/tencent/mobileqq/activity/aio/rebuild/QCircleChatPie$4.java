package com.tencent.mobileqq.activity.aio.rebuild;

import aifl;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import vhk;

public class QCircleChatPie$4
  implements Runnable
{
  public QCircleChatPie$4(aifl paramaifl) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, null, 500);
    if (localList != null) {
      aifl.a(this.this$0, localList.size());
    }
    if ((localList != null) && (localList.size() > 0))
    {
      aifl.b(this.this$0, (MessageRecord)localList.get(0));
      aifl.a(this.this$0, (MessageRecord)localList.get(localList.size() - 1));
    }
    if ((vhk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localList)) && (!TextUtils.isEmpty(aifl.a(this.this$0))))
    {
      aifl.a(this.this$0, vhk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aifl.a(this.this$0), aifl.a(this.this$0)));
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "showFuelTips:" + aifl.a(this.this$0));
    }
    aifl.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (!vhk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "showIceBreakMessage");
      aifl.a(this.this$0, vhk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, aifl.a(this.this$0), aifl.b(this.this$0)));
      if (aifl.a(this.this$0) != null) {
        vhk.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "mAllMsgCount " + aifl.b(this.this$0));
    }
    this.this$0.f(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4
 * JD-Core Version:    0.7.0.1
 */