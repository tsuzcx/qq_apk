package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class EqqAccountDetailActivityImpl$1
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$1(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, String paramString, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.c.jumpWebView(this.a);
    if ((this.b.b != null) && (this.b.b.contains(HardCodeUtil.a(2131902213))))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.c.app, "P_CliOper", "Pb_account_lifeservice", this.c.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
      return;
    }
    this.c.reportItemEvent(this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */