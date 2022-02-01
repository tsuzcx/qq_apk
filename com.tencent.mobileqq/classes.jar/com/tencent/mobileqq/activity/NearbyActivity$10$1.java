package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class NearbyActivity$10$1
  implements DialogInterface.OnClickListener
{
  NearbyActivity$10$1(NearbyActivity.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth onClick exit");
    this.a.a.finish();
    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      MineFragment.a(this.a.a.app);
    }
    new ReportTask(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_clk").e(this.a.a.app.getCurrentAccountUin()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.10.1
 * JD-Core Version:    0.7.0.1
 */