package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel.OnStatusChangeByUserListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import mqq.app.AppRuntime;

class OnlineStatusChatLayoutHandler$2$1
  implements IAccountPanel.OnStatusChangeByUserListener
{
  OnlineStatusChatLayoutHandler$2$1(OnlineStatusChatLayoutHandler.2 param2, IAccountPanel paramIAccountPanel, AppRuntime paramAppRuntime) {}
  
  public void a(String paramString)
  {
    if (!this.a.isShowing()) {
      return;
    }
    ReportHelperKt.a("0X800BBE0", 0, String.valueOf(3), paramString);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new OnlineStatusChatLayoutHandler.2.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler.2.1
 * JD-Core Version:    0.7.0.1
 */