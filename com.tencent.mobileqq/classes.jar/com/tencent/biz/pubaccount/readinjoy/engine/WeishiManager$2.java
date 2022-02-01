package com.tencent.biz.pubaccount.readinjoy.engine;

import antf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import pgj;

public class WeishiManager$2
  implements Runnable
{
  public WeishiManager$2(pgj parampgj, QQMessageFacade paramQQMessageFacade, String paramString, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(antf.aP, 1008);
    if (localMessageRecord != null) {}
    for (localMessageRecord = pgj.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);; localMessageRecord = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long))
    {
      if (localMessageRecord != null) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord, pgj.a(this.this$0).c());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2
 * JD-Core Version:    0.7.0.1
 */