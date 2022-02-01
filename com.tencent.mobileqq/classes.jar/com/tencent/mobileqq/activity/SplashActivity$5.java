package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;

class SplashActivity$5
  implements Runnable
{
  SplashActivity$5(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    long l = SpaceLowNoticeActiviy.a(this.this$0.app, "conf_space_low_shreshold", 104857600L);
    if (SpaceLowNoticeActiviy.a(SpaceLowNoticeActiviy.a(this.this$0.app, "conf_space_check_interval", 259200000L)))
    {
      if (SdCardUtil.getAvailableExternalMemorySize(this.this$0) + SdCardUtil.getAvailableInternalMemorySize() < l)
      {
        QLog.i("SplashActivity", 1, "qqclean conf did notice");
        SpaceLowNoticeActiviy.a(this.this$0);
        ReportController.b(this.this$0.app, "dc00898", "", "", "0X8007545", "0X8007545", 0, 0, this.this$0.app.getCurrentAccountUin(), "", "", "");
        return;
      }
      QLog.i("SplashActivity", 1, "qqclean conf not need notice");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.5
 * JD-Core Version:    0.7.0.1
 */