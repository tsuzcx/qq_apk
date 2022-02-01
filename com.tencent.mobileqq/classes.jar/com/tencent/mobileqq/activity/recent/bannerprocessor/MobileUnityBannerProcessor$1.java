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
    ReportController.b(MobileUnityBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorMobileUnityBannerProcessor).getAppRuntime(), "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent;
    if (localBaseActivity != null)
    {
      if (!URLUtil.isValidUrl(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData.a)) {
        break label150;
      }
      localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneUnityBannerData.a);
      localIntent.putExtra("hideRightButton", true);
      localBaseActivity.startActivity(localIntent);
    }
    for (;;)
    {
      BannerManager.a().a(9, 0);
      ReportController.a(MobileUnityBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorMobileUnityBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label150:
      localIntent = new Intent(localBaseActivity, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      localBaseActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */