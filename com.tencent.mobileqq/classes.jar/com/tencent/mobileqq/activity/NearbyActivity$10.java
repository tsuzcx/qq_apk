package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class NearbyActivity$10
  extends NearbyObserver
{
  NearbyActivity$10(NearbyActivity paramNearbyActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.d("nearby.check.auth", 1, "onCheckNearbyUserAuth isSuccess=" + paramBoolean + ", checkRet=" + paramInt + ", checkMsg=" + paramString + ", isFinishing=" + this.a.isFinishing() + ", isStopHeartBeat=" + this.a.c);
    if ((paramBoolean) && (paramInt != 0)) {
      if (!this.a.isFinishing()) {}
    }
    while ((this.a.isFinishing()) || (this.a.c))
    {
      do
      {
        return;
        try
        {
          QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
          localQQCustomDialog.setCancelable(false);
          String str = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str = HardCodeUtil.a(2131707108);
          }
          localQQCustomDialog.setMessage(str);
          localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131707109), new NearbyActivity.10.1(this));
          localQQCustomDialog.show();
          new ReportTask(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_exp").e(this.a.a.getCurrentAccountUin()).a();
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.d("nearby.NearbyActivity", 2, "onCheckNearbyUserAuth exp:" + paramString.toString());
      return;
    }
    this.a.e();
  }
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.heart_beat", 2, "onNearbyHeartBeat:isSucc=" + paramBoolean + ", cmd=" + paramString + ", interval=" + paramLong);
    }
    if ("OidbSvc.0xafc_1".equals(paramString))
    {
      if (paramBoolean) {
        this.a.o = paramLong;
      }
      if (!this.a.c)
      {
        this.a.b.removeMessages(1000);
        this.a.b.sendEmptyMessageDelayed(1000, this.a.o);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.10
 * JD-Core Version:    0.7.0.1
 */