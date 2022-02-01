package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class WeishiManager$1
  implements Runnable
{
  WeishiManager$1(WeishiManager paramWeishiManager) {}
  
  public void run()
  {
    if (WeishiManager.a(this.this$0) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = AppConstants.WEISHI_UIN;
    localSessionInfo.a = 1008;
    ChatActivityFacade.a(WeishiManager.a(this.this$0), localSessionInfo);
    WeishiManager.a(this.this$0).getMessageFacade().a(AppConstants.WEISHI_UIN, 1008, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */