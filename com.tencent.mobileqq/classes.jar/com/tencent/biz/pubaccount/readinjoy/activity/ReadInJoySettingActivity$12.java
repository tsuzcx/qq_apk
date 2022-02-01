package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$12
  extends PublicAccountObserver
{
  ReadInJoySettingActivity$12(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onSetPublicAccountSubscribeStatus(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramLong != 2171946401L) {
      return;
    }
    Object localObject = this.a;
    ((ReadInJoySettingActivity)localObject).jdField_a_of_type_Int -= 1;
    if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    boolean bool;
    if (paramInt == this.a.b)
    {
      bool = ReadInJoySettingActivity.a(this.a);
      if (!paramBoolean) {
        break label222;
      }
      localObject = ReadInJoySettingActivity.a(this.a);
      if (bool) {
        break label178;
      }
      paramBoolean = true;
      ((Switch)localObject).setChecked(paramBoolean);
      if (!bool) {
        break label183;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      label157:
      ReadInJoySettingActivity.a(this.a).a(bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      label178:
      paramBoolean = false;
      break;
      label183:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      break label157;
      label222:
      QQToast.a(this.a.getApplicationContext(), 2131699735, 0).a();
      this.a.c = true;
      ReadInJoySettingActivity.a(this.a).setChecked(bool);
      QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.12
 * JD-Core Version:    0.7.0.1
 */