package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
public class NetNeedSignOnBannerProcessor
  extends BaseBannerProcessor
{
  public NetNeedSignOnBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsText(this.a.getString(2131694458));
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130838388));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage.obj instanceof String)) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "https://qq.com")
    {
      if (paramBanner.a.getVisibility() != 0) {
        paramBanner.a.setVisibility(0);
      }
      paramBanner.a.setOnClickListener(new NetNeedSignOnBannerProcessor.1(this, paramMessage));
      ReportController.a(this.a.getAppRuntime(), "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor
 * JD-Core Version:    0.7.0.1
 */