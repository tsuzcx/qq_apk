package com.tencent.mobileqq.activity.aio;

import admh;
import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class ForwardUtils$1
  implements Runnable
{
  ForwardUtils$1(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    admh.a(this.val$app, this.val$activity, this.val$sessionInfo, this.val$forwardFilePath, this.val$forwardImageOrgServerpath, this.val$forwardImageOrgUin, this.val$forwardImageOrgItemId, this.val$forwardImageOrgUinType, this.val$forwardTaskKey, this.val$forwardID);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate start!");
    }
    Message localMessage = new Message();
    localMessage.what = 57;
    if (this.val$uihandler != null) {
      this.val$uihandler.sendMessage(localMessage);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate end!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.1
 * JD-Core Version:    0.7.0.1
 */