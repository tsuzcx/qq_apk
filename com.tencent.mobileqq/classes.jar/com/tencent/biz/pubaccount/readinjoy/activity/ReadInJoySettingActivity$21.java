package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoySettingActivity$21
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$21(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = ReadInJoyHelper.a();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800AFEB", "0X800AFEB", 0, 0, str2, str1, "", RIJTransMergeKanDianReport.a(), false);
      ReadInJoyHelper.a((QQAppInterface)this.a.getAppInterface(), paramBoolean, new ReadInJoySettingActivity.TroopProtocolObserver(this.a, paramBoolean));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.21
 * JD-Core Version:    0.7.0.1
 */