package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountListActivity$15
  implements View.OnClickListener
{
  PublicAccountListActivity$15(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131377072: 
      localObject1 = this.a;
      PublicAccountSearchActivity.a((Activity)localObject1, (String)((PublicAccountListActivity)localObject1).d.getTag());
      break;
    case 2131373226: 
      localObject1 = this.a;
      PublicAccountSearchActivity.a((Activity)localObject1, (String)((PublicAccountListActivity)localObject1).d.getTag());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573D", "0X800573D", 0, 0, "", "", "", "", false);
      break;
    case 2131369233: 
      PublicAccountSearchActivity.a(this.a);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 0, "", "", "", "", false);
      localObject1 = (IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "");
      localObject2 = ((IRedTouchManager)localObject1).getAppInfoByPath("101000.101001");
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
        ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      ((IRedTouchManager)localObject1).onRedTouchItemClick("101000.101001");
      break;
    case 2131369202: 
      this.a.finish();
      break;
    case 2131364234: 
      localObject1 = (String)paramView.getTag(-1);
      localObject2 = (String)paramView.getTag(-2);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        CrmUtils.a(this.a.app, this.a, (String)localObject2, (String)localObject1, "IvrEnterpriseDetailEngineFalse");
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick - uin = ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", name = ");
        localStringBuilder.append((String)localObject2);
        QLog.w("PublicAccountListActivity", 2, localStringBuilder.toString());
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.15
 * JD-Core Version:    0.7.0.1
 */