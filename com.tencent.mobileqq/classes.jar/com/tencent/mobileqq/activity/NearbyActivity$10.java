package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class NearbyActivity$10
  extends NearbyObserver
{
  NearbyActivity$10(NearbyActivity paramNearbyActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCheckNearbyUserAuth isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", checkRet=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", checkMsg=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", isFinishing=");
    ((StringBuilder)localObject).append(this.a.isFinishing());
    ((StringBuilder)localObject).append(", isStopHeartBeat=");
    ((StringBuilder)localObject).append(this.a.isStopHeartBeat);
    QLog.d("nearby.check.auth", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramInt != 0))
    {
      if (this.a.isFinishing()) {
        return;
      }
      try
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
        localQQCustomDialog.setCancelable(false);
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = HardCodeUtil.a(2131707133);
        }
        localQQCustomDialog.setMessage((CharSequence)localObject);
        localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131707134), new NearbyActivity.10.1(this));
        localQQCustomDialog.show();
        new ReportTask(null).a("dc00899").b("grp_lbs").c("home").d("year_pop_exp").e(this.a.app.getCurrentAccountUin()).a();
        return;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckNearbyUserAuth exp:");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.d("nearby.NearbyActivity", 2, ((StringBuilder)localObject).toString());
    }
    else if ((!this.a.isFinishing()) && (!this.a.isStopHeartBeat))
    {
      this.a.notifyServerEnterNearby();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNearbyHeartBeat:isSucc=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", cmd=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", interval=");
      localStringBuilder.append(paramLong);
      QLog.d("nearby.heart_beat", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0xafc_1".equals(paramString))
    {
      if (paramBoolean) {
        this.a.mHeartBeatInterval = paramLong;
      }
      if (!this.a.isStopHeartBeat)
      {
        this.a.mHeartBeatHandler.removeMessages(1000);
        this.a.mHeartBeatHandler.sendEmptyMessageDelayed(1000, this.a.mHeartBeatInterval);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.10
 * JD-Core Version:    0.7.0.1
 */