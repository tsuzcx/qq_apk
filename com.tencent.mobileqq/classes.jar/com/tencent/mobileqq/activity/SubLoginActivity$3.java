package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

class SubLoginActivity$3
  extends SubAccountBindObserver
{
  SubLoginActivity$3(SubLoginActivity paramSubLoginActivity) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SubLoginActivity.onBindSubAccount() isSucc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" isBindFromThis=");
      ((StringBuilder)localObject).append(this.a.a);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      if (paramSubAccountBackProtocData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SubLoginActivity.onBindSubAccount() mainAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append(" subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.d);
        ((StringBuilder)localObject).append(" errType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.a);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (!this.a.a) {
      return;
    }
    this.a.a = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
    }
    this.a.hideJuhua();
    if (paramBoolean)
    {
      localObject = this.a;
      ((SubLoginActivity)localObject).showQQToastSuccess(((SubLoginActivity)localObject).getString(2131916857));
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      SubAccountAssistantForward.b(this.a.app);
      SubAccountAssistantForward.a(this.a.app);
      SubLoginActivity.a(this.a);
      this.a.finish();
    }
    else
    {
      if (paramSubAccountBackProtocData == null) {
        return;
      }
      switch (paramSubAccountBackProtocData.a)
      {
      default: 
        localObject = this.a;
        ((SubLoginActivity)localObject).showQQToast(((SubLoginActivity)localObject).getString(2131916848));
        break;
      case 1004: 
        String str = paramSubAccountBackProtocData.b;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.a.getString(2131916850);
        }
        this.a.showQQToast((String)localObject);
        SubAccountAssistantForward.a(this.a.app, 300L);
        break;
      case 1003: 
        localObject = this.a;
        ((SubLoginActivity)localObject).showQQToast(((SubLoginActivity)localObject).getString(2131916849));
        break;
      case 1002: 
        SubAccountControllUtil.a(this.a.app, this.a);
      }
    }
    if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
      ((StringBuilder)localObject).append("...errorType = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.a);
      QLog.d("Q.subaccount.SubLoginActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.3
 * JD-Core Version:    0.7.0.1
 */