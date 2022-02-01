package com.tencent.biz.pubaccount.util.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;

final class PublicAccountUtilImpl$15
  implements Runnable
{
  PublicAccountUtilImpl$15(QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(AppConstants.NEW_KANDIAN_UIN, -3006);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.b;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(this.b);
      localObject = ((StringBuilder)localObject).toString();
    }
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForStructing))) {
      localObject = PublicAccountUtilImpl.access$500((MessageForStructing)localMessageRecord, (String)localObject, null, null, this.c);
    } else {
      localObject = PublicAccountUtilImpl.access$600(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, null, null, this.c);
    }
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.15
 * JD-Core Version:    0.7.0.1
 */