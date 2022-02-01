package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountListActivity$4
  implements View.OnTouchListener
{
  PublicAccountListActivity$4(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573C", "0X800573C", 0, 0, "", "", "", "", false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.4
 * JD-Core Version:    0.7.0.1
 */