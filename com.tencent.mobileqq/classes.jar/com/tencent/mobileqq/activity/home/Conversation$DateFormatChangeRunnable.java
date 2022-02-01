package com.tencent.mobileqq.activity.home;

import android.provider.Settings.System;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import mqq.os.MqqHandler;

class Conversation$DateFormatChangeRunnable
  implements Runnable
{
  private Conversation$DateFormatChangeRunnable(Conversation paramConversation) {}
  
  public void run()
  {
    Object localObject = Settings.System.getString(this.this$0.P().getContentResolver(), "date_format");
    if ((this.this$0.t != null) && (TimeManager.a().a((String)localObject)) && (this.this$0.C)) {
      this.this$0.a(1014, 0L, false);
    }
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).onTimeFormatChange(this.this$0.s(), (String)localObject);
    if (this.this$0.aF != null)
    {
      localObject = this.this$0.s().getHandler(TroopAssistantActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.DateFormatChangeRunnable
 * JD-Core Version:    0.7.0.1
 */