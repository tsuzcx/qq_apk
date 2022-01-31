package com.tencent.biz.pubaccount.util;

import aljq;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import syb;

public final class PublicAccountUtil$18
  implements Runnable
{
  public PublicAccountUtil$18(QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(aljq.az, -3006);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.b;
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForStructing))) {
        break label108;
      }
    }
    label108:
    for (Object localObject = syb.a((MessageForStructing)localMessageRecord, (String)localObject, null, null, this.c);; localObject = syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, null, null, this.c))
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      return;
      localObject = this.jdField_a_of_type_JavaLangString + ": " + this.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.18
 * JD-Core Version:    0.7.0.1
 */