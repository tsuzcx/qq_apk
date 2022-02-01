package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
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
  public static final int a = BannerTypeCollections.P;
  
  public QLinkTransingBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131627209, null);
    paramBanner.setOnClickListener(new QLinkTransingBannerProcessor.1(this));
    paramBanner.findViewById(2131442085).setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    Object localObject = paramBanner.c.findViewById(2131442085);
    paramMessage = (TextView)paramBanner.c.findViewById(2131442086);
    if ((this.f != null) && (this.f.getAppRuntime() != null))
    {
      int i = ((QQAppInterface)this.f.getAppRuntime()).getQQProxyForQlink().h();
      if (i != 0)
      {
        ((View)localObject).setVisibility(0);
        int j = ((QQAppInterface)this.f.getAppRuntime()).getQQProxyForQlink().a().mMode;
        paramBanner = HardCodeUtil.a(2131899157);
        if (1 == j) {
          paramBanner = HardCodeUtil.a(2131899167);
        } else if (2 == j) {
          paramBanner = HardCodeUtil.a(2131899156);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f.getString(2131896373));
        ((StringBuilder)localObject).append(paramBanner);
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(this.f.getString(2131896374));
        paramMessage.setText(((StringBuilder)localObject).toString());
        ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EE1", "0X8009EE1", 3, 0, "", "", "", "");
        return;
      }
      ((View)localObject).setVisibility(8);
      return;
    }
    ((View)localObject).setVisibility(8);
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return a;
  }
  
  public void d()
  {
    int i = ((QQAppInterface)this.f.getAppRuntime()).getQQProxyForQlink().h();
    int j = 0;
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    BannerManager localBannerManager = BannerManager.a();
    int k = a;
    if (i != 0) {
      j = 2;
    }
    localBannerManager.a(k, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor
 * JD-Core Version:    0.7.0.1
 */