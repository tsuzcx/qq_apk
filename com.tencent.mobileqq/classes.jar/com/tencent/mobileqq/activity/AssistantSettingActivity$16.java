package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class AssistantSettingActivity$16
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$16(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    label43:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      i = 1;
      ReadInJoyHelper.d(i);
      ReadInJoyHelper.a(paramBoolean);
      ReadInJoyHelper.a(true);
      if (!paramBoolean) {
        break label122;
      }
      QQToast.a(this.a.getBaseContext(), 2, 2131718387, 2000).a();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label145;
      }
      str1 = "0X8008236";
      label70:
      if (!paramBoolean) {
        break label152;
      }
    }
    label145:
    label152:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label122:
      QQToast.a(this.a.getBaseContext(), 2, 2131718385, 2000).a();
      break label43;
      str1 = "0X8008235";
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */