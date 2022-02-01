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
    Object localObject = new Intent(ContactBannerProcessor.a(this.a), GuideBindPhoneActivity.class);
    ((Intent)localObject).putExtra("fromKeyForContactBind", 4);
    ContactBannerProcessor.b(this.a).startActivity((Intent)localObject);
    localObject = ContactBannerProcessor.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_bind_info");
    localStringBuilder.append(ContactBannerProcessor.c(this.a).getAppRuntime().getAccount());
    ((QBaseActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    BannerManager.a().a(ContactBannerProcessor.a, 0);
    ContactBannerProcessor.e(this.a).removeMessages(1000);
    ReportController.a(ContactBannerProcessor.f(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 13, 0, "", "", "", "");
    ReportController.b(ContactBannerProcessor.g(this.a).getAppRuntime(), "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */