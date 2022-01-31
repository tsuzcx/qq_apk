package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentInteractAndFollowItem
  extends RecentMsgBoxItem
{
  public RecentInteractAndFollowItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);
    if ((localObject1 instanceof MessageForInteractAndFollow)) {}
    for (localObject1 = (MessageForInteractAndFollow)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, "messageForInteractAndFollow == null");
        return;
      }
      ((MessageForInteractAndFollow)localObject1).parse();
      if (((MessageForInteractAndFollow)localObject1).type == 1)
      {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131438782);
        label84:
        this.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_Long = ((MessageForInteractAndFollow)localObject1).timeStamp;
        Object localObject2 = paramQQAppInterface.a();
        if (localObject2 == null) {
          break label300;
        }
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject2).a(((MessageForInteractAndFollow)localObject1).frienduin, ((MessageForInteractAndFollow)localObject1).istroop);
        label125:
        localObject2 = a();
        ((MsgSummary)localObject2).b = ((MessageForInteractAndFollow)localObject1).context;
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        if (!AppSetting.b) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_c_of_type_Int != 0) {
          break label308;
        }
      }
      for (;;)
      {
        if (this.jdField_d_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
        return;
        if (((MessageForInteractAndFollow)localObject1).type == 2)
        {
          this.jdField_b_of_type_JavaLangString = paramContext.getString(2131438783);
          break label84;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.msg_box.RecentInteractAndFollowItem", 2, "RecentInteractAndFollowItem, type  =" + ((MessageForInteractAndFollow)localObject1).type);
        return;
        label300:
        this.jdField_c_of_type_Int = 0;
        break label125;
        label308:
        if (this.jdField_c_of_type_Int == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.jdField_c_of_type_Int == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.jdField_c_of_type_Int > 0) {
          paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem
 * JD-Core Version:    0.7.0.1
 */