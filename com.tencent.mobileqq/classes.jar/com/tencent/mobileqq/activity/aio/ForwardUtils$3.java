package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

final class ForwardUtils$3
  implements Runnable
{
  ForwardUtils$3(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    ForwardUtils.a("ForwardUtils", "[@]call instantUpdate start!");
    Message localMessage = new Message();
    localMessage.what = 57;
    MqqHandler localMqqHandler = this.k;
    if (localMqqHandler != null) {
      localMqqHandler.sendMessage(localMessage);
    }
    ForwardUtils.a("ForwardUtils", "[@]call instantUpdate end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.3
 * JD-Core Version:    0.7.0.1
 */