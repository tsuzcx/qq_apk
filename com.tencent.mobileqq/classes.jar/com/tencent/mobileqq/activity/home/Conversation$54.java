package com.tencent.mobileqq.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class Conversation$54
  extends BroadcastReceiver
{
  Conversation$54(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      paramContext = Message.obtain();
      paramContext.what = 2002;
      paramContext.getData().putString("pcLoginInfo", paramIntent.getStringExtra("loginInfo"));
      this.a.y.b(LoginDevicesBannerProcessor.a, paramContext);
      paramContext = Message.obtain();
      paramContext.what = 2003;
      paramContext.getData().putString("pcLoginInfo", paramIntent.getStringExtra("loginInfo"));
      this.a.y.b(PCOnlineBannerProcessor.a, paramContext);
      paramContext = Message.obtain();
      paramContext.what = 2001;
      paramContext.getData().putLong("loginDevAppid", paramIntent.getLongExtra("subappid", 1L));
      this.a.y.b(LoginDevicesBannerProcessor.a, paramContext);
      paramContext = Message.obtain();
      paramContext.what = 2002;
      paramContext.getData().putLong("loginAppType", paramIntent.getLongExtra("subappid", 1L));
      this.a.y.b(PCOnlineBannerProcessor.a, paramContext);
      this.a.y.a(LoginDevicesBannerProcessor.a, 2, null);
      return;
    }
    this.a.y.b(LoginDevicesBannerProcessor.a, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.54
 * JD-Core Version:    0.7.0.1
 */