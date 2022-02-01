package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

class SubLoginActivity$8
  extends SubAccountBindObserver
{
  SubLoginActivity$8(SubLoginActivity paramSubLoginActivity) {}
  
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
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.b);
        ((StringBuilder)localObject).append(" subAccount=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject).append(" errType=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
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
      ((SubLoginActivity)localObject).showQQToastSuccess(((SubLoginActivity)localObject).getString(2131719305));
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      SubAccountAssistantForward.b(this.a.app);
      SubAccountAssistantForward.a(this.a.app);
      this.a.finish();
    }
    else
    {
      if (paramSubAccountBackProtocData == null) {
        return;
      }
      switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
      {
      default: 
        localObject = this.a;
        ((SubLoginActivity)localObject).showQQToast(((SubLoginActivity)localObject).getString(2131719296));
        break;
      case 1004: 
        String str = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.a.getString(2131719298);
        }
        this.a.showQQToast((String)localObject);
        this.a.runOnUiThread(new SubLoginActivity.8.1(this));
        SubLoginActivity.a(this.a, null);
        SubAccountAssistantForward.a(this.a.app, 300L);
        break;
      case 1003: 
        localObject = this.a;
        ((SubLoginActivity)localObject).showQQToast(((SubLoginActivity)localObject).getString(2131719297));
        break;
      case 1002: 
        SubAccountControllUtil.a(this.a.app, this.a);
      }
    }
    if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("...errorType = ");
      ((StringBuilder)localObject).append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
      QLog.d("Q.subaccount.SubLoginActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.8
 * JD-Core Version:    0.7.0.1
 */