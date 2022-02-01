package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;

class KandianMergeManager$19
  implements Runnable
{
  KandianMergeManager$19(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(KandianMergeManager.a(this.this$0), localSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.19
 * JD-Core Version:    0.7.0.1
 */