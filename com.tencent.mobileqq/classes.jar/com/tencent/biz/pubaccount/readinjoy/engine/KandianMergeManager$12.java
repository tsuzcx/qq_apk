package com.tencent.biz.pubaccount.readinjoy.engine;

import ajed;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import obz;

class KandianMergeManager$12
  implements Runnable
{
  KandianMergeManager$12(KandianMergeManager paramKandianMergeManager, QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(ajed.az, 7220);
    if (localMessageRecord != null) {}
    for (localMessageRecord = KandianMergeManager.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);; localMessageRecord = KandianMergeManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int))
    {
      if (localMessageRecord != null)
      {
        obz.a(localMessageRecord);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord, KandianMergeManager.a(this.this$0).c());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.12
 * JD-Core Version:    0.7.0.1
 */