package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QLinkTransingBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public QLinkTransingBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131561022, null);
    paramBanner.setOnClickListener(new QLinkTransingBannerProcessor.1(this));
    paramBanner.findViewById(2131374481).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    View localView = paramBanner.a.findViewById(2131374481);
    paramMessage = (TextView)paramBanner.a.findViewById(2131374482);
    if ((this.a != null) && (this.a.getAppRuntime() != null))
    {
      int i = ((QQAppInterface)this.a.getAppRuntime()).getQQProxyForQlink().a();
      if (i != 0)
      {
        localView.setVisibility(0);
        int j = ((QQAppInterface)this.a.getAppRuntime()).getQQProxyForQlink().a().mMode;
        paramBanner = HardCodeUtil.a(2131700997);
        if (1 == j) {
          paramBanner = HardCodeUtil.a(2131701007);
        }
        for (;;)
        {
          paramMessage.setText(this.a.getString(2131698384) + paramBanner + i + this.a.getString(2131698385));
          ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
          return;
          if (2 == j) {
            paramBanner = HardCodeUtil.a(2131700996);
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  public void b()
  {
    int j = 0;
    if (((QQAppInterface)this.a.getAppRuntime()).getQQProxyForQlink().a() != 0) {}
    for (int i = 1;; i = 0)
    {
      BannerManager localBannerManager = BannerManager.a();
      if (i != 0) {
        j = 2;
      }
      localBannerManager.a(43, j);
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor
 * JD-Core Version:    0.7.0.1
 */