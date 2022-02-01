package com.tencent.biz.pubaccount.readinjoy.engine;

import aean;
import antf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;

class KandianMergeManager$20
  implements Runnable
{
  KandianMergeManager$20(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    KandianMergeManager.a(this.this$0).a().a(antf.aA, 7220, false, false);
    if (this.a.extInt == 2)
    {
      KandianMergeManager.a(this.this$0).a().b(antf.aA, 7220, this.a.uniseq);
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
        localSessionInfo.jdField_a_of_type_JavaLangString = antf.az;
        localSessionInfo.jdField_a_of_type_Int = 1008;
        aean.a(KandianMergeManager.a(this.this$0), localSessionInfo);
        return;
      }
    } while (this.a.extInt != 5);
    KandianMergeManager.a(this.this$0).a().b(antf.aA, 7220, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.20
 * JD-Core Version:    0.7.0.1
 */