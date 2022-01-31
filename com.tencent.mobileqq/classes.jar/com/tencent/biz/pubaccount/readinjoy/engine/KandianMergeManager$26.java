package com.tencent.biz.pubaccount.readinjoy.engine;

import acex;
import aljq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class KandianMergeManager$26
  implements Runnable
{
  KandianMergeManager$26(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = aljq.az;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    acex.a(KandianMergeManager.a(this.this$0), localSessionInfo);
    KandianMergeManager.a(this.this$0).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.26
 * JD-Core Version:    0.7.0.1
 */