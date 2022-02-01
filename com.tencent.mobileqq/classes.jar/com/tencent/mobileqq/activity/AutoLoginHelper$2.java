package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

class AutoLoginHelper$2
  extends AccountObserver
{
  AutoLoginHelper$2(AutoLoginHelper paramAutoLoginHelper) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramString4);
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), AutoLoginHelper.b(this.a), paramString2, paramString1 }));
    }
    paramString1 = this.a;
    paramString1.f = false;
    paramString1.j();
    if (AutoLoginHelper.a(this.a) != null)
    {
      paramString1 = new Intent(AutoLoginHelper.a(this.a), LoginActivity.class);
      paramString1.putExtra("uin", AutoLoginHelper.b(this.a));
      paramString1.putExtra("tab_index", 0);
      paramString1.addFlags(131072);
      AutoLoginHelper.a(this.a).startActivity(paramString1);
      AutoLoginHelper.a(this.a).finish();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super.onLoginSuccess(paramString1, paramString2, paramArrayOfByte);
    paramString1 = this.a;
    paramString1.f = false;
    paramString1 = AutoLoginHelper.c(paramString1);
    paramString2 = AutoLoginHelper.b(this.a);
    AutoLoginHelper.a(this.a);
    ReportController.a(paramString1, "dc00898", "", paramString2, "0X800BC97", "0X800BC97", RegisterNewBaseActivity.sEntrance, 0, "", "", this.a.a, "");
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  protected void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onLoginTimeout ");
    }
    paramString = this.a;
    paramString.f = false;
    paramString.j();
    AutoLoginHelper.a(this.a).handler.post(new AutoLoginHelper.2.1(this));
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    this.a.f = false;
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.2
 * JD-Core Version:    0.7.0.1
 */