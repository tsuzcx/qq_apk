package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import uuc;

public final class PublicAccountUtil$18
  implements Runnable
{
  public PublicAccountUtil$18(QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMsgForMsgTab(AppConstants.NEW_KANDIAN_UIN, -3006);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.b;
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForStructing))) {
        break label108;
      }
    }
    label108:
    for (Object localObject = uuc.a((MessageForStructing)localMessageRecord, (String)localObject, null, null, this.c);; localObject = uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, null, null, this.c))
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.addMessage((MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      }
      return;
      localObject = this.jdField_a_of_type_JavaLangString + ": " + this.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.18
 * JD-Core Version:    0.7.0.1
 */