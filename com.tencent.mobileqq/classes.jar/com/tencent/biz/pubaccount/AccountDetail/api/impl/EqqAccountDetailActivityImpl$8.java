package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$8
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$8(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.a.m)) && (!TextUtils.isEmpty(this.a.l)))
    {
      paramView = new Intent(this.c, QQMapActivity.class);
      paramView.putExtra("lat", this.a.m);
      paramView.putExtra("lon", this.a.l);
      if (!TextUtils.isEmpty(this.b)) {
        paramView.putExtra("loc", this.b);
      }
      this.c.startActivity(paramView);
      ReportController.b(this.c.app, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.c.uin, "", "", "");
      this.c.reportItemEvent(this.a.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c.TAG, 2, "buildMapItemForEqq no lat or lng");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */