package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class WeishiManager$2
  implements Runnable
{
  WeishiManager$2(WeishiManager paramWeishiManager, QQMessageFacade paramQQMessageFacade, String paramString, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(AppConstants.WEISHI_UIN, 1008);
    if (localMessageRecord != null) {}
    for (localMessageRecord = WeishiManager.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);; localMessageRecord = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long))
    {
      if (localMessageRecord != null) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord, WeishiManager.a(this.this$0).getCurrentUin());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2
 * JD-Core Version:    0.7.0.1
 */