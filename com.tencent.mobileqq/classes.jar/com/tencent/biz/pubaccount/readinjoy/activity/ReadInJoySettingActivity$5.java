package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoySettingActivity$5
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$5(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      QQToast.a(this.a.getBaseContext(), 2, 2131718387, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718386);
      if (!paramBoolean) {
        break label173;
      }
      i = 1;
      ReadInJoyHelper.d(i);
      ReadInJoyHelper.a(paramBoolean);
      ReadInJoyHelper.a(true);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localQQAppInterface = this.a.a;
      if (!paramBoolean) {
        break label178;
      }
      str1 = "0X8008236";
      label91:
      if (!paramBoolean) {
        break label185;
      }
    }
    label173:
    label178:
    label185:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      QQToast.a(this.a.getBaseContext(), 2, 2131718385, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718389);
      break;
      i = 0;
      break label51;
      str1 = "0X8008235";
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.5
 * JD-Core Version:    0.7.0.1
 */