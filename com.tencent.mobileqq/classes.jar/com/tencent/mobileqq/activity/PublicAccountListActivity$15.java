package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountListActivity$15
  implements View.OnClickListener
{
  PublicAccountListActivity$15(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
      continue;
      PublicAccountSearchActivity.a(this.a);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
      Object localObject1 = (RedTouchManager)this.a.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      Object localObject2 = ((RedTouchManager)localObject1).a("101000.101001");
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
        ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      ((RedTouchManager)localObject1).b("101000.101001");
      continue;
      localObject1 = (String)paramView.getTag(-1);
      localObject2 = (String)paramView.getTag(-2);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PublicAccountListActivity", 2, "onClick - uin = " + (String)localObject1 + ", name = " + (String)localObject2);
        }
      }
      else
      {
        CrmUtils.a(this.a.app, this.a, (String)localObject2, (String)localObject1, "IvrEnterpriseDetailEngineFalse");
        continue;
        PublicAccountSearchActivity.a(this.a, (String)this.a.d.getTag());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
        continue;
        PublicAccountSearchActivity.a(this.a, (String)this.a.d.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.15
 * JD-Core Version:    0.7.0.1
 */