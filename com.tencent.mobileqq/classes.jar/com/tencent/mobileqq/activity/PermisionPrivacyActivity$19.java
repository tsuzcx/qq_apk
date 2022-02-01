package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermisionPrivacyActivity$19
  implements View.OnClickListener
{
  PermisionPrivacyActivity$19(PermisionPrivacyActivity paramPermisionPrivacyActivity, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    String str = IndividuationUrlHelper.a("gameIconSetupH5Url");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), QQBrowserActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), str, -1L, localIntent, false, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app, "CliOper", "", "", "Setting_tab", "0X8009C07", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.19
 * JD-Core Version:    0.7.0.1
 */