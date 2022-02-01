package com.tencent.biz.pubaccount.readinjoy.engine;

import admh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class KandianMergeManager$28
  implements Runnable
{
  KandianMergeManager$28(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.curType = 1008;
    admh.a(KandianMergeManager.a(this.this$0), localSessionInfo);
    KandianMergeManager.a(this.this$0).getMessageFacade().setReaded(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.28
 * JD-Core Version:    0.7.0.1
 */