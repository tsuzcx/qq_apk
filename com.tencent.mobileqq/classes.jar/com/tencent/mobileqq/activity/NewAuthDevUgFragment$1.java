package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.login.authdev.AuthDevUgReporter;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class NewAuthDevUgFragment$1
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  NewAuthDevUgFragment$1(NewAuthDevUgFragment paramNewAuthDevUgFragment) {}
  
  public void onReceive(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = this.a.a();
    int i = 1;
    if (bool)
    {
      QLog.e("NewAuthDevUgFragment", 1, "onReceive getActivity is null or activity is finish");
      return;
    }
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onReceive, type is ", Integer.valueOf(paramInt1), ", ret is ", Integer.valueOf(paramInt2), "data == null ? ", Boolean.valueOf(bool) });
    if ((paramInt1 == 1003) && (paramInt2 == 239))
    {
      NewAuthDevUgFragment.a(this.a, 0);
      NewAuthDevUgFragment.a(this.a, paramObject);
      return;
    }
    String str = "V_VERIFY_TOKEN_ERROR";
    if (paramInt1 == 1004)
    {
      if (paramInt2 != 160)
      {
        if (paramInt2 != 253)
        {
          if (paramInt2 != 241)
          {
            if (paramInt2 != 242)
            {
              NewAuthDevUgFragment.a(this.a);
              NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "");
              NewAuthDevUgFragment.b(this.a);
              GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 3, NewAuthDevUgFragment.f(this.a));
              return;
            }
            NewAuthDevUgFragment.g(this.a);
            if (NewAuthDevUgFragment.h(this.a) > 5)
            {
              NewAuthDevUgFragment.a(this.a);
              NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "redirect time out");
              NewAuthDevUgFragment.b(this.a);
              GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 3, NewAuthDevUgFragment.f(this.a));
              return;
            }
            QLog.d("NewAuthDevUgFragment", 1, "VerifyDevLockObserver redirect");
            NewAuthDevUgFragment.a(this.a, paramObject);
            return;
          }
          NewAuthDevUgFragment.a(this.a);
          NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "not match");
          NewAuthDevUgFragment.c(this.a);
          GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 5, NewAuthDevUgFragment.f(this.a));
          AuthDevUgReporter.a().a(NewAuthDevUgFragment.e(this.a), "0X800B663");
          return;
        }
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "pre check not match");
        NewAuthDevUgFragment.b(this.a);
        GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 5, NewAuthDevUgFragment.f(this.a));
        AuthDevUgReporter.a().a(NewAuthDevUgFragment.e(this.a), "0X800B664");
        return;
      }
      NewAuthDevUgFragment.a(this.a);
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "need sms");
      NewAuthDevUgFragment.b(this.a);
      return;
    }
    NewAuthDevUgFragment.a(this.a);
    if (paramInt1 == 1003) {
      paramInt1 = i;
    } else {
      paramInt1 = 0;
    }
    paramObject = str;
    if (paramInt1 != 0) {
      paramObject = "V_GET_GATEWAY_URL_ERROR";
    }
    NewAuthDevUgFragment.a(this.a, paramObject, paramInt2, "");
    NewAuthDevUgFragment.b(this.a);
    GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 3, NewAuthDevUgFragment.f(this.a));
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onVerifyClose getActivity is null or activity is finish");
      return;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onVerifyClose ret : ", Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      NewAuthDevUgFragment.a(this.a, "V_RET_SUCCESS", paramInt2, "");
      NewAuthDevUgFragment.i(this.a);
      NewAuthDevUgFragment.j(this.a).postDelayed(new NewAuthDevUgFragment.1.1(this), 800L);
      if (NewAuthDevUgFragment.k(this.a)) {
        LoginUtils.a(NewAuthDevUgFragment.e(this.a));
      }
      GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 4, NewAuthDevUgFragment.f(this.a));
      ReportController.a(NewAuthDevUgFragment.e(this.a), "dc00898", "", NewAuthDevUgFragment.f(this.a), "0X800AEFB", "0X800AEFB", 0, 0, "", "", "", "");
      AuthDevUgReporter.a().a(NewAuthDevUgFragment.e(this.a), "0X800B662");
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onVerifyClose error, ret : ", Integer.valueOf(paramInt2) });
    NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, paramErrMsg.getMessage());
    NewAuthDevUgFragment.b(this.a);
    GatewayUtil.a(NewAuthDevUgFragment.d(this.a), NewAuthDevUgFragment.e(this.a), 3, NewAuthDevUgFragment.f(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.1
 * JD-Core Version:    0.7.0.1
 */