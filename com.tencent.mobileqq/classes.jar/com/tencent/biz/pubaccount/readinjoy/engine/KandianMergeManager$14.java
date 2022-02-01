package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class KandianMergeManager$14
  implements Runnable
{
  KandianMergeManager$14(KandianMergeManager paramKandianMergeManager, QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localMessageRecord != null) {}
    for (localMessageRecord = KandianMergeManager.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);; localMessageRecord = KandianMergeManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int))
    {
      if (localMessageRecord != null)
      {
        RIJKanDianFolderStatus.a(localMessageRecord);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord, KandianMergeManager.a(this.this$0).getCurrentUin());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.14
 * JD-Core Version:    0.7.0.1
 */