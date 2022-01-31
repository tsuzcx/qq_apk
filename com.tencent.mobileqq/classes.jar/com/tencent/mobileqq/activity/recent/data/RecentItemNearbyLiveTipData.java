package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNearbyLiveTipData
  extends RecentMsgBoxItem
{
  public MessageForNearbyLiveTip a;
  
  public RecentItemNearbyLiveTipData(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.a();
    ConversationFacade localConversationFacade = paramQQAppInterface.a();
    if (localObject != null) {}
    for (localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop);; localObject = null)
    {
      MsgSummary localMsgSummary = a();
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.nearby.tag_nearby_live_tip", 2, "RecentItemNearbyLiveTipData, msg = null");
        return;
      }
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject).time;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip = ((MessageForNearbyLiveTip)paramQQAppInterface.a().a(((QQMessageFacade.Message)localObject).senderuin, ((QQMessageFacade.Message)localObject).istroop, ((QQMessageFacade.Message)localObject).uniseq));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.nearby.tag_nearby_live_tip", 2, "RecentItemNearbyLiveTipData, nearbyLiveTipMsg = null");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.parse();
      this.b = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.nickName;
      localMsgSummary.b = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.msg;
      if (localConversationFacade != null)
      {
        this.jdField_c_of_type_Int = localConversationFacade.a(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (!AppSetting.b) {
          break;
        }
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.b);
        if (this.jdField_c_of_type_Int != 0) {
          break label288;
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
        this.jdField_c_of_type_Int = 0;
        break;
        label288:
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData
 * JD-Core Version:    0.7.0.1
 */