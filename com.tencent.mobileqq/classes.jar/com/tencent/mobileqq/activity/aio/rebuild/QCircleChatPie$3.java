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
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, null, 500);
    if (localObject != null) {
      QCircleChatPie.a(this.this$0, ((List)localObject).size());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QCircleChatPie.b(this.this$0, (MessageRecord)((List)localObject).get(0));
      QCircleChatPie.a(this.this$0, (MessageRecord)((List)localObject).get(((List)localObject).size() - 1));
    }
    StringBuilder localStringBuilder;
    if ((QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (List)localObject)) && (!TextUtils.isEmpty(QCircleChatPie.a(this.this$0))))
    {
      localObject = this.this$0;
      QCircleChatPie.a((QCircleChatPie)localObject, QCircleChatUtil.a(((QCircleChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.this$0), QCircleChatPie.a(this.this$0)));
      localObject = this.this$0.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFuelTips:");
      localStringBuilder.append(QCircleChatPie.a(this.this$0));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    localObject = this.this$0;
    QCircleChatPie.a((QCircleChatPie)localObject, ((QCircleChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (!QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QLog.d(this.this$0.b, 2, "showIceBreakMessage");
      localObject = this.this$0;
      QCircleChatPie.a((QCircleChatPie)localObject, QCircleChatUtil.a(((QCircleChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.this$0), QCircleChatPie.b(this.this$0)));
      if (QCircleChatPie.a(this.this$0) != null) {
        QCircleChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = this.this$0.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAllMsgCount ");
      localStringBuilder.append(QCircleChatPie.b(this.this$0));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.this$0.e(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.3
 * JD-Core Version:    0.7.0.1
 */