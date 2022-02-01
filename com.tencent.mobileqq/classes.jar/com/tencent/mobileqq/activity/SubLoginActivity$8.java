package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

class SubLoginActivity$8
  extends SubAccountBindObserver
{
  SubLoginActivity$8(SubLoginActivity paramSubLoginActivity) {}
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if (!this.a.a) {}
    label428:
    for (;;)
    {
      return;
      this.a.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.e();
      if (paramBoolean)
      {
        this.a.c(this.a.getString(2131719586));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        SubAccountAssistantForward.b(this.a.app);
        SubAccountAssistantForward.a(this.a.app);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramSubAccountBackProtocData == null) || (!QLog.isColorLevel())) {
          break label428;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + "...errorType = " + paramSubAccountBackProtocData.jdField_a_of_type_Int);
        return;
        if (paramSubAccountBackProtocData == null) {
          break;
        }
        switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
        {
        default: 
          this.a.b(this.a.getString(2131719577));
          break;
        case 1002: 
          SubAccountControll.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.b(this.a.getString(2131719578));
          break;
        case 1004: 
          String str2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = this.a.getString(2131719579);
          }
          this.a.b(str1);
          this.a.runOnUiThread(new SubLoginActivity.8.1(this));
          SubLoginActivity.a(this.a, null);
          SubAccountAssistantForward.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.8
 * JD-Core Version:    0.7.0.1
 */