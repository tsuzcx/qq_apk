package com.tencent.biz.pubaccount.readinjoy.engine;

import acex;
import aljq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;

class KandianMergeManager$19
  implements Runnable
{
  KandianMergeManager$19(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    KandianMergeManager.a(this.this$0).a().a(aljq.aA, 7220, false, false);
    if (this.a.extInt == 2)
    {
      this.a.isValid = false;
      if (KandianMergeManager.a(this.this$0).get() > 0) {
        this.this$0.c(2);
      }
    }
    do
    {
      return;
      if (this.a.extInt == 1)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = aljq.az;
        localSessionInfo.jdField_a_of_type_Int = 1008;
        acex.a(KandianMergeManager.a(this.this$0), localSessionInfo);
        return;
      }
    } while (this.a.extInt != 5);
    this.a.isValid = false;
    KandianMergeManager.a(this.this$0).a().b(aljq.aA, 7220, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.19
 * JD-Core Version:    0.7.0.1
 */