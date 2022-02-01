package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class RegisterSendUpSms$2
  extends AccountObserver
{
  RegisterSendUpSms$2(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, "onRegisterQuerySmsStatResp isSuccess=" + paramBoolean + ", code=" + paramInt1 + ", uin=" + paramString1 + ", nick=" + paramString2 + ", faceUrl=" + paramString3 + ", errmsg=" + paramString4);
    }
    RegisterSendUpSms.a(this.a);
    if (paramInt1 == 4)
    {
      QLog.d("RegisterSendUpSms", 1, "not receive sms");
      RegisterSendUpSms.a(this.a, 4);
      paramArrayOfByte = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramArrayOfByte = this.a.getString(2131716965);
      }
      QQToast.a(this.a, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 0)
    {
      RegisterSendUpSms.a(this.a, paramString1);
      RegisterSendUpSms.b(this.a, paramString5);
      RegisterSendUpSms.a(this.a, 3);
      QQToast.a(this.a, this.a.getString(2131713320), 0).b(this.a.getTitleBarHeight());
      RegisterSendUpSms.b(this.a);
      ReportController.a(RegisterSendUpSms.a(this.a), "dc00898", "", "", "0X800B4BB", "0X800B4BB", 0, 0, "", "", "", "");
      ReportController.a(null, "dc00898", "", "", "0X800B8DC", "0X800B8DC", 0, 0, "", "", RegisterOverseaHelper.a().a(), "");
      return;
    }
    RegisterSendUpSms.a(this.a, 4);
    paramString1 = paramString4;
    if (paramInt1 == -1)
    {
      paramString1 = paramString4;
      if (paramArrayOfByte == null) {}
    }
    try
    {
      paramString1 = new String(paramArrayOfByte, "utf-8");
      paramArrayOfByte = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramArrayOfByte = this.a.getString(2131716965);
      }
      QQToast.a(this.a, paramArrayOfByte.trim(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("RegisterSendUpSms", 1, new Object[] { "strPromptInfo to string error : ", paramArrayOfByte.getMessage() });
        paramString1 = paramString4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms.2
 * JD-Core Version:    0.7.0.1
 */