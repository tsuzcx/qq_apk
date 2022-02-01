package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class MobileUnityBannerProcessor
  extends BaseBannerProcessor
{
  public MobileUnityBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.a, 2131561119, null);
    paramBanner.findViewById(2131374641).setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(9, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage == null) || (!(paramMessage.obj instanceof PhoneUnityBannerData))) {
      return;
    }
    ReportController.b(this.a.getAppRuntime(), "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramBanner.a.findViewById(2131374641).setVisibility(0);
    paramMessage = (PhoneUnityBannerData)paramMessage.obj;
    ((TextView)paramBanner.a.findViewById(2131363474)).setText(paramMessage.b);
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 5, 0, "", "", "", "");
    paramBanner.a.setOnClickListener(new MobileUnityBannerProcessor.1(this, paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor
 * JD-Core Version:    0.7.0.1
 */