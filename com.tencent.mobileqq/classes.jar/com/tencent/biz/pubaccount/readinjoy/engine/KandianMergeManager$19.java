package com.tencent.biz.pubaccount.readinjoy.engine;

import acvv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;

class KandianMergeManager$19
  implements Runnable
{
  KandianMergeManager$19(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.curType = 1008;
    acvv.a(KandianMergeManager.a(this.this$0), localSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.19
 * JD-Core Version:    0.7.0.1
 */