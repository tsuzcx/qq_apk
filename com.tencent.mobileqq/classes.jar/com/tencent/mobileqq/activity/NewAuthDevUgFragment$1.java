package com.tencent.mobileqq.activity;

import android.widget.TextView;
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
    int i = 1;
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onReceive getActivity is null or activity is finish");
      return;
    }
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onReceive, type is ", Integer.valueOf(paramInt1), ", ret is ", Integer.valueOf(paramInt2), "data == null ? ", Boolean.valueOf(bool) });
      if ((paramInt1 != 1003) || (paramInt2 != 239)) {
        break;
      }
      NewAuthDevUgFragment.a(this.a, 0);
      NewAuthDevUgFragment.a(this.a, paramObject);
      return;
    }
    if (paramInt1 == 1004)
    {
      switch (paramInt2)
      {
      default: 
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "");
        NewAuthDevUgFragment.b(this.a);
        GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 3, NewAuthDevUgFragment.a(this.a));
        return;
      case 160: 
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "need sms");
        NewAuthDevUgFragment.b(this.a);
        return;
      case 241: 
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "not match");
        NewAuthDevUgFragment.c(this.a);
        GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 5, NewAuthDevUgFragment.a(this.a));
        ReportController.a(NewAuthDevUgFragment.a(this.a), "dc00898", "", NewAuthDevUgFragment.a(this.a), "0X800B663", "0X800B663", NewAuthDevUgFragment.a(this.a), 0, "", "", "", "");
        return;
      case 253: 
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "pre check not match");
        NewAuthDevUgFragment.b(this.a);
        GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 5, NewAuthDevUgFragment.a(this.a));
        ReportController.a(NewAuthDevUgFragment.a(this.a), "dc00898", "", NewAuthDevUgFragment.a(this.a), "0X800B664", "0X800B664", NewAuthDevUgFragment.a(this.a), 0, "", "", "", "");
        return;
      }
      NewAuthDevUgFragment.b(this.a);
      if (NewAuthDevUgFragment.c(this.a) > 5)
      {
        NewAuthDevUgFragment.a(this.a);
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, "redirect time out");
        NewAuthDevUgFragment.b(this.a);
        GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 3, NewAuthDevUgFragment.a(this.a));
        return;
      }
      QLog.d("NewAuthDevUgFragment", 1, "VerifyDevLockObserver redirect");
      NewAuthDevUgFragment.a(this.a, paramObject);
      return;
    }
    NewAuthDevUgFragment.a(this.a);
    if (paramInt1 == 1003)
    {
      paramInt1 = i;
      if (paramInt1 == 0) {
        break label590;
      }
    }
    label590:
    for (paramObject = "V_GET_GATEWAY_URL_ERROR";; paramObject = "V_VERIFY_TOKEN_ERROR")
    {
      NewAuthDevUgFragment.a(this.a, paramObject, paramInt2, "");
      NewAuthDevUgFragment.b(this.a);
      GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 3, NewAuthDevUgFragment.a(this.a));
      return;
      paramInt1 = 0;
      break;
    }
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
      NewAuthDevUgFragment.d(this.a);
      NewAuthDevUgFragment.a(this.a).postDelayed(new NewAuthDevUgFragment.1.1(this), 800L);
      if (NewAuthDevUgFragment.a(this.a)) {
        LoginUtils.a(NewAuthDevUgFragment.a(this.a));
      }
      GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 4, NewAuthDevUgFragment.a(this.a));
      ReportController.a(NewAuthDevUgFragment.a(this.a), "dc00898", "", NewAuthDevUgFragment.a(this.a), "0X800AEFB", "0X800AEFB", 0, 0, "", "", "", "");
      ReportController.a(NewAuthDevUgFragment.a(this.a), "dc00898", "", NewAuthDevUgFragment.a(this.a), "0X800B662", "0X800B662", NewAuthDevUgFragment.a(this.a), 0, "", "", "", "");
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onVerifyClose error, ret : ", Integer.valueOf(paramInt2) });
    NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, paramErrMsg.getMessage());
    NewAuthDevUgFragment.b(this.a);
    GatewayUtil.a(NewAuthDevUgFragment.a(this.a), NewAuthDevUgFragment.a(this.a), 3, NewAuthDevUgFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.1
 * JD-Core Version:    0.7.0.1
 */