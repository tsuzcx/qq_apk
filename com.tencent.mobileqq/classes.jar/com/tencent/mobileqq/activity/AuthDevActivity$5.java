package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class AuthDevActivity$5
  implements ActionSheet.OnButtonClickListener
{
  AuthDevActivity$5(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(this.f))
      {
        paramView = this.f;
        QQToast.makeText(paramView, paramView.getString(2131889169), 0).show(this.f.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
        }
        ReportController.b(AuthDevActivity.access$1600(this.f), "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
        if (AuthDevActivity.access$1300(this.f).delAuthDev(AuthDevActivity.access$1700(this.f), this.a, this.b, this.c, this.d, this.e)) {
          AuthDevActivity.access$1400(this.f);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
        }
      }
    }
    if ((AuthDevActivity.access$1800(this.f) != null) && (AuthDevActivity.access$1800(this.f).isShowing()) && (!this.f.isFinishing()))
    {
      AuthDevActivity.access$1800(this.f).dismiss();
      AuthDevActivity.access$1800(this.f).cancel();
      AuthDevActivity.access$1802(this.f, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.5
 * JD-Core Version:    0.7.0.1
 */