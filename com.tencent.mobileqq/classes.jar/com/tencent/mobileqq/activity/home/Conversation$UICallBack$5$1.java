package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;

class Conversation$UICallBack$5$1
  implements Runnable
{
  Conversation$UICallBack$5$1(Conversation.UICallBack.5 param5, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.b.a.a.A.obtainMessage();
    localMessage.obj = this.a;
    this.b.a.a.y.a(TimUpgradeBannerProcessor.a, 2, localMessage);
    ReportController.b(this.b.a.a.aF, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.5.1
 * JD-Core Version:    0.7.0.1
 */