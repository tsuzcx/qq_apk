package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
public class NetNeedSignOnBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.k;
  
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
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.f.getString(2131892103));
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839452));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.arg1 != 0))
    {
      if ((paramMessage.obj instanceof String)) {
        paramMessage = String.valueOf(paramMessage.obj);
      } else {
        paramMessage = "https://qq.com";
      }
      if (paramBanner.c.getVisibility() != 0) {
        paramBanner.c.setVisibility(0);
      }
      paramBanner.c.setOnClickListener(new NetNeedSignOnBannerProcessor.1(this, paramMessage));
      ReportController.a(this.f.getAppRuntime(), "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
    }
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor
 * JD-Core Version:    0.7.0.1
 */