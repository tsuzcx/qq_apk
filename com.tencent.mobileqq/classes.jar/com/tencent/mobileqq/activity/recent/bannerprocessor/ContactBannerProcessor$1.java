package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class ContactBannerProcessor$1
  implements View.OnClickListener
{
  ContactBannerProcessor$1(ContactBannerProcessor paramContactBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ContactBannerProcessor.a(this.a), GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", 4);
    ContactBannerProcessor.b(this.a).startActivity(localIntent);
    ContactBannerProcessor.d(this.a).getSharedPreferences("contact_bind_info" + ContactBannerProcessor.c(this.a).getAppRuntime().getAccount(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    BannerManager.a().a(18, 0);
    ContactBannerProcessor.a(this.a).removeMessages(1000);
    ReportController.a(ContactBannerProcessor.e(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 13, 0, "", "", "", "");
    ReportController.b(ContactBannerProcessor.f(this.a).getAppRuntime(), "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */