package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SetPwdBannerProcessor$1
  implements View.OnClickListener
{
  SetPwdBannerProcessor$1(SetPwdBannerProcessor paramSetPwdBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (!SetPwdBannerProcessor.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SetPwdBannerProcessor.a(this.a, false);
      new Handler().postDelayed(new SetPwdBannerProcessor.1.1(this), 1000L);
      QQAppInterface localQQAppInterface = (QQAppInterface)SetPwdBannerProcessor.a(this.a).getAppRuntime();
      PwdSetUtil.a(localQQAppInterface.getCurrentAccountUin(), SetPwdBannerProcessor.b(this.a), localQQAppInterface);
      PwdSetUtil.a(localQQAppInterface);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new SetPwdBannerProcessor.1.2(this), 1000L);
      ReportController.a(SetPwdBannerProcessor.c(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 18, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */