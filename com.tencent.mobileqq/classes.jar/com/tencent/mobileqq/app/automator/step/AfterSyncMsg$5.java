package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

class AfterSyncMsg$5
  implements Runnable
{
  AfterSyncMsg$5(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    int i = 1;
    String str;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    if (this.this$0.a.a.getApplication() != null)
    {
      str = this.this$0.a.a.getCurrentUin();
      boolean bool = SettingCloneUtil.readValue(this.this$0.a.a.getApplication().getApplicationContext(), str, null, "qqsetting_lock_screen_whenexit_key", true);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (!bool) {
        break label102;
      }
    }
    for (;;)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str, "0X80096F0", "0X80096F0", 0, 0, String.valueOf(i), "", "", "", false);
      return;
      label102:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.5
 * JD-Core Version:    0.7.0.1
 */