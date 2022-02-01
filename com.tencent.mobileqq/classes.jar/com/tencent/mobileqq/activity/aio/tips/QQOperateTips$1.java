package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QQOperateTips$1
  implements Runnable
{
  QQOperateTips$1(QQOperateTips paramQQOperateTips) {}
  
  public void run()
  {
    Object localObject1 = QQOperateTips.a(this.this$0).getMessageFacade().b(QQOperateTips.a(this.this$0).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.this$0).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (QQOperateTips.a(this.this$0).jdField_a_of_type_Int == 0) {
          QQOperateTips.a(this.this$0, ((ChatMessage)localObject2).time);
        } else if (QQOperateTips.a(this.this$0).jdField_a_of_type_Int == 3000) {
          QQOperateTips.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        }
        QQOperateTips.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      int i;
      if (QQOperateTips.a(this.this$0).getConversationFacade().a(QQOperateTips.a(this.this$0).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.this$0).jdField_a_of_type_Int) > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = j;
        while (i > 0)
        {
          j = i - 1;
          localObject2 = (ChatMessage)((List)localObject1).get(j);
          if ((localObject2 != null) && (((ChatMessage)localObject2).isread)) {
            break;
          }
          QQOperateTips.a(this.this$0, j);
          i -= 1;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" from aio open .. unreadMsg index = ");
      ((StringBuilder)localObject2).append(QQOperateTips.a(this.this$0));
      QLog.d("QQOperateVoIP", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = QQOperateManager.a(QQOperateTips.a(this.this$0));
    if (localObject2 != null)
    {
      localObject1 = ((QQOperateManager)localObject2).a(QQOperateTips.a(this.this$0).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.this$0).jdField_a_of_type_Int, QQOperateTips.a(this.this$0), (List)localObject1, true, QQOperateTips.a(this.this$0));
      if (((QQOperationRequestInfo)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((QQOperationRequestInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((QQOperateManager)localObject2).a(QQOperateTips.a(this.this$0).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.this$0).jdField_a_of_type_Int, (ArrayList)localObject1, QQOperateTips.a(this.this$0));
      }
    }
    QQOperateTips.a(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */