package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MobileUnityBannerProcessor$1
  implements View.OnClickListener
{
  MobileUnityBannerProcessor$1(MobileUnityBannerProcessor paramMobileUnityBannerProcessor, PhoneUnityBannerData paramPhoneUnityBannerData) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(MobileUnityBannerProcessor.a(this.b).getAppRuntime(), "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      Intent localIntent;
      if (URLUtil.isValidUrl(this.a.a))
      {
        localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("url", this.a.a);
        localIntent.putExtra("hideRightButton", true);
        localBaseActivity.startActivity(localIntent);
      }
      else
      {
        localIntent = new Intent(localBaseActivity, PhoneUnityBindInfoActivity.class);
        localIntent.putExtra("kSrouce", 0);
        localBaseActivity.startActivity(localIntent);
      }
    }
    BannerManager.a().a(MobileUnityBannerProcessor.a, 0);
    ReportController.a(MobileUnityBannerProcessor.b(this.b).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */