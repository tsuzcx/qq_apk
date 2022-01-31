package com.tencent.biz.pubaccount.readinjoy.engine;

import aael;
import ajed;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

class KandianMergeManager$25
  implements Runnable
{
  KandianMergeManager$25(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = ajed.ay;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    aael.a(KandianMergeManager.a(this.this$0), localSessionInfo);
    KandianMergeManager.a(this.this$0).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.25
 * JD-Core Version:    0.7.0.1
 */