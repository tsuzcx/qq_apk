package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import plv;

public class WeishiManager$2
  implements Runnable
{
  public WeishiManager$2(plv paramplv, QQMessageFacade paramQQMessageFacade, String paramString, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMsgForMsgTab(AppConstants.WEISHI_UIN, 1008);
    if (localMessageRecord != null) {}
    for (localMessageRecord = plv.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);; localMessageRecord = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long))
    {
      if (localMessageRecord != null) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.addMessage(localMessageRecord, plv.a(this.this$0).getCurrentUin());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2
 * JD-Core Version:    0.7.0.1
 */