package com.tencent.mobileqq.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurityDetectBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class Conversation$54
  extends BroadcastReceiver
{
  Conversation$54(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("wording");
    int i = paramIntent.getIntExtra("timetowait", 360000);
    this.a.a.a(SecurityDetectBannerProcessor.a, 2, null);
    this.a.a().getHandler(Conversation.class).postDelayed(new Conversation.54.1(this), i);
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "showBanner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.54
 * JD-Core Version:    0.7.0.1
 */